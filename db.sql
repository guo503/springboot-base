CREATE TABLE `user` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(60) DEFAULT '' COMMENT '姓名',
  `phone` varchar(60) DEFAULT '' COMMENT '手机号',
  `is_del` tinyint(4) unsigned DEFAULT '0' COMMENT '是否删除，0未删除，1已删除，默认0',
  `creator` varchar(255) DEFAULT 'system' COMMENT '创建人姓名',
  `updater` varchar(255) DEFAULT 'system' COMMENT '修改人姓名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
  `version` int(11) unsigned DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

insert into `user`(`name`,phone) values ('guos','18557521085');