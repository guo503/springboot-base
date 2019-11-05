

SET FOREIGN_KEY_CHECKS=0;

drop table if exists sys_user;
drop table if exists sys_menu;
drop table if exists sys_role;
drop table if exists sys_role_menu;
drop table if exists sys_user_role;


CREATE TABLE `sys_menu` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort_no` int(64) NOT NULL COMMENT '排序',
  `href` varchar(2000) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `is_show` tinyint(4) unsigned DEFAULT '0' COMMENT '是否在菜单中显示: 0不显示 1显示',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `is_del` tinyint(4) unsigned DEFAULT '0' COMMENT '是否删除，0未删除，1已删除，默认0',
  `creator` varchar(255) DEFAULT 'system' COMMENT '创建人姓名',
  `updater` varchar(255) DEFAULT 'system' COMMENT '修改人姓名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
  `versions` int(11) unsigned DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  KEY `idx_parentId` (`parent_id`),
  KEY `idx_isDel` (`is_del`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';



CREATE TABLE `sys_role` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  `en_name` varchar(20) DEFAULT NULL COMMENT '英文名称',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围',
  `role_type` int(2) DEFAULT NULL COMMENT '角色类型',
  `is_sys` tinyint(4) unsigned DEFAULT '0' COMMENT '是否系统数据 0否 1是 默认0',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `is_use` tinyint(4) unsigned DEFAULT '1' COMMENT '是否启用 0 不启用 1启用',
  `is_del` tinyint(4) unsigned DEFAULT '0' COMMENT '是否删除,0未删除 1已删除 默认0',
  `creator` varchar(255) DEFAULT 'system' COMMENT '创建人姓名',
  `updater` varchar(255) DEFAULT 'system' COMMENT '修改人姓名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
  `versions` int(11) unsigned DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  KEY `idx_isDel` (`is_del`),
  KEY `idx_enName` (`en_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';


CREATE TABLE `sys_role_menu` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` int(64) NOT NULL COMMENT '角色编号',
  `menu_id` int(64) NOT NULL COMMENT '菜单编号',
  `is_del` tinyint(4) unsigned DEFAULT '0' COMMENT '是否删除，0未删除，1已删除，默认0',
  `creator` varchar(255) DEFAULT 'system' COMMENT '创建人姓名',
  `updater` varchar(255) DEFAULT 'system' COMMENT '修改人姓名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
  `versions` int(11) unsigned DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色-菜单';


CREATE TABLE `sys_user` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `login_name` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role_id` int(64) NOT NULL COMMENT '角色id',
  `no` varchar(20) DEFAULT NULL COMMENT '工号',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `photo` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `is_use` tinyint(4) unsigned DEFAULT '1' COMMENT '是否可登录 0否 1是 默认1',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `is_del` tinyint(4) unsigned DEFAULT '0' COMMENT '是否删除，0未删除 1已删除 默认0',
  `creator` varchar(255) DEFAULT 'system' COMMENT '创建人姓名',
  `updater` varchar(255) DEFAULT 'system' COMMENT '修改人姓名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
  `versions` int(11) unsigned DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  KEY `idx_loginName` (`login_name`),
  KEY `idx_updateTime` (`update_time`),
  KEY `idx_isDel` (`is_del`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


CREATE TABLE `sys_user_role` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(64) NOT NULL COMMENT '用户编号',
  `role_id` int(64) NOT NULL COMMENT '角色编号',
  `is_del` tinyint(4) unsigned DEFAULT '0' COMMENT '是否删除，0未删除，1已删除，默认0',
  `creator` varchar(255) DEFAULT 'system' COMMENT '创建人姓名',
  `updater` varchar(255) DEFAULT 'system' COMMENT '修改人姓名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
  `versions` int(11) unsigned DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户-角色';


INSERT INTO sys_menu(parent_id, parent_ids, name, sort_no, permission, remarks)
	VALUES(0,'0','测试', 1, 'sys:user:view', '1');

INSERT INTO sys_role(name, en_name,is_sys, remarks)
	VALUES('admin', 'admin', 1, '1');

INSERT INTO sys_role_menu(role_id, menu_id)
	VALUES(1,1);

INSERT INTO sys_user(login_name, `password`, role_id,name,mobile, remarks)
	VALUES('admin', 'e10adc3949ba59abbe56e057f20f883e', 1, 'admin', '13866666666', '1');

INSERT INTO sys_user_role(user_id, role_id)
	VALUES(1,1);


