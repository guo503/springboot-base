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


CREATE TABLE `tsyj`.`test_table1` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `str_value` VARCHAR(45) NULL,
 `date_value` DATETIME NULL,
 `double_value` DOUBLE NULL,
 PRIMARY KEY (`id`));


INSERT INTO `tsyj`.`test_table1` (`str_value`, `date_value`, `double_value`) VALUES ('aaa', '2018-05-06 11:22:33', '1.65');
UPDATE `tsyj`.`test_table1` SET `str_value`='bbb', `date_value`='2018-05-09 11:22:33', `double_value`='2.4' WHERE `id`='1';
DELETE FROM `tsyj`.`test_table1` WHERE `id`='1';
