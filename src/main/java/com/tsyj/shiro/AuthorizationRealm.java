package com.tsyj.shiro;


import com.tsyj.model.*;
import com.tsyj.page.Page;
import com.tsyj.service.SysMenuService;
import com.tsyj.service.SysRoleMenuService;
import com.tsyj.service.SysRoleService;
import com.tsyj.service.SysUserRoleService;
import lombok.extern.slf4j.Slf4j;
import mybatis.core.entity.Condition;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 统一角色授权控制策略
 */
@Slf4j
public class AuthorizationRealm extends AuthorizingRealm {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("---------------- 执行 Shiro 权限获取 ---------------------");
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (principal instanceof SysUser) {
            SysUser userLogin = (SysUser) principal;
            Condition<SysUserRole> sysUserRoleCondition = new Condition<>();
            sysUserRoleCondition.createCriteria().andEqual(SysUserRole.USER_ID, userLogin.getId());
            sysUserRoleCondition.limit(Page.getMaxRow());
            List<SysUserRole> sysUserRoleList = sysUserRoleService.listByCondition(sysUserRoleCondition);
            if (CollectionUtils.isNotEmpty(sysUserRoleList)) {
                //角色列表
                List<Integer> roleIds = sysUserRoleList.stream().map(SysUserRole::getUserId).distinct().collect(Collectors.toList());
                Map<Integer, SysRole> sysRoleMap = sysRoleService.mapByIds(roleIds);

                Condition<SysRoleMenu> sysRoleMenuCondition = new Condition<>();
                sysRoleMenuCondition.createCriteria().andIn(SysRoleMenu.ROLE_ID, roleIds);
                sysRoleMenuCondition.limit(Page.getMaxRow());
                List<SysRoleMenu> sysRoleMenuList = sysRoleMenuService.listByCondition(sysRoleMenuCondition);
                //菜单列表
                List<Integer> menuIds = sysRoleMenuList.stream().map(SysRoleMenu::getMenuId).distinct().collect(Collectors.toList());
                Map<Integer, SysMenu> sysMenuMap = sysMenuService.mapByIds(menuIds);

                sysRoleMenuList.forEach(a -> {
                    SysRole sysRole = sysRoleMap.get(a.getRoleId());
                    if (sysRole != null) {
                        info.addRole(sysRole.getEnName());
                    }
                    SysMenu sysMenu = sysMenuMap.get(a.getMenuId());
                    if (sysMenu != null) {
                        info.addRole(sysMenu.getPermission());
                    }
                });
            }
        }
        log.info("---------------- 获取到以下权限 ----------------");
        log.info(info.getStringPermissions().toString());
        log.info("---------------- Shiro 权限获取成功 ----------------------");
        return info;
    }

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        return null;
    }
}
