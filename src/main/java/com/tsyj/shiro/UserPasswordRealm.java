package com.tsyj.shiro;

import com.tsyj.model.SysUser;
import com.tsyj.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户密码登录realm
 */
@Slf4j
public class UserPasswordRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;


    @Override
    public String getName() {
        return LoginType.USER_PASSWORD.getType();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        if (token instanceof UserToken) {
            return ((UserToken) token).getLoginType() == LoginType.USER_PASSWORD;
        } else {
            return false;
        }
    }

    @Override
    public void setAuthorizationCacheName(String authorizationCacheName) {
        super.setAuthorizationCacheName(authorizationCacheName);
    }

    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        log.info("---------------- 用户密码登录 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        // 从数据库获取对应用户名密码的用户
        SysUser userQuery = new SysUser();
        userQuery.setName(name);
        SysUser user = sysUserService.getOne(userQuery);
        if (user != null) {
            // 用户为禁用状态
            if (user.getIsUse() != 1) {
                throw new DisabledAccountException();
            }
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user, //用户
                    user.getPassword(), //密码
                    getName()  //realm name
            );
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
