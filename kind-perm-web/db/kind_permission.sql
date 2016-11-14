/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.7.11 : Database - kind_permission
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `sql_users` */

CREATE TABLE `sql_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(80) DEFAULT NULL COMMENT '密码',
  `role` varchar(45) DEFAULT NULL COMMENT '角色： develop|test|admin',
  `is_delete` tinyint(4) DEFAULT NULL,
  `db_names` varchar(45) DEFAULT NULL COMMENT '可操作的dbname',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `username_password_index` (`user_name`,`pass_word`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sql_users` */

insert  into `sql_users`(`id`,`user_name`,`pass_word`,`role`,`is_delete`,`db_names`,`modify_time`,`create_time`) values (11,'admin0','1111','1',1,'',NULL,NULL),(12,'admin2','2222','2',2,NULL,NULL,NULL),(13,'admin3','222','1',1,NULL,NULL,NULL),(14,'admin4','111','2',0,NULL,NULL,NULL);

/*Table structure for table `sys_log` */

CREATE TABLE `sys_log` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `oper_code` varchar(64) NOT NULL COMMENT '操作代码',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `os` varchar(64) DEFAULT NULL COMMENT '系统信息',
  `browser` varchar(64) DEFAULT NULL COMMENT '浏览器信息',
  `ip_addr` varchar(32) DEFAULT NULL COMMENT 'ip地址',
  `mac` varchar(32) DEFAULT NULL COMMENT 'mac地址',
  `execute_time` int(10) DEFAULT NULL COMMENT '执行时间',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `request_param` varchar(512) DEFAULT NULL COMMENT '请求参数',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户日志';

/*Data for the table `sys_log` */

insert  into `sys_log`(`id`,`oper_code`,`type`,`os`,`browser`,`ip_addr`,`mac`,`execute_time`,`description`,`request_param`,`create_user`,`create_time`) values (1,'/wheat/order',NULL,'Windows','Chrome','127.0.0.1','B8-AE-ED-93-4C-74',134,NULL,'{}','admin','2016-07-25 14:32:26'),(2,'/system/role',NULL,'Windows','Chrome','127.0.0.1','B8-AE-ED-93-4C-74',273,NULL,'{}','admin','2016-07-25 14:32:34'),(3,'/wheat/order',NULL,'Windows','Chrome','127.0.0.1','B8-AE-ED-93-4C-74',136,NULL,'{}','admin','2016-07-25 15:22:14'),(4,'/wheat/order',NULL,'Windows','Chrome','127.0.0.1','B8-AE-ED-93-4C-74',83,NULL,'{}','admin','2016-07-25 15:22:38'),(5,'/wheat/order',NULL,'Windows','Chrome','127.0.0.1','B8-AE-ED-93-4C-74',148,NULL,'{}','admin','2016-07-25 15:38:05'),(6,'/wheat/order',NULL,'Windows','Chrome','127.0.0.1','B8-AE-ED-93-4C-74',2,NULL,'{}','admin','2016-07-25 15:42:09');

/*Table structure for table `sys_op_log` */

CREATE TABLE `sys_op_log` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sub_system` varchar(16) DEFAULT NULL COMMENT '子系统',
  `module` varchar(32) DEFAULT NULL COMMENT '模块',
  `operation` varchar(32) DEFAULT NULL COMMENT '操作名称',
  `actor` varchar(32) DEFAULT NULL COMMENT '创建者',
  `ip_addr` varchar(32) DEFAULT NULL COMMENT '操作IP',
  `content` varchar(512) DEFAULT NULL COMMENT '详细参数',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

/*Data for the table `sys_op_log` */

insert  into `sys_op_log`(`id`,`sub_system`,`module`,`operation`,`actor`,`ip_addr`,`content`,`description`,`create_time`) values (1,'WHEAT','ORDER_PACKAGE','修改后台订单状态','admin','127.0.0.1','{\"dispStatus\":\"BACK\",\"orderId\":\"1000160517001655\",\"orderStatus\":\"NULLIFY\"}',NULL,'2016-07-27 10:55:51'),(2,'WHEAT','ORDER','修改OMS订单状态','admin','127.0.0.1','{\"orderId\":\"1000160517001655\",\"orderStatus\":\"NULLIFY\"}',NULL,'2016-07-27 10:55:51'),(3,'JOYSEED','ORDER_PACKAGE','修改后台订单状态','admin','127.0.0.1','{\"dispStatus\":\"BACK\",\"orderId\":\"1000160506001921\",\"orderStatus\":\"CANCELLED\"}',NULL,'2016-07-27 10:58:42'),(4,'JOYSEED','ORDER','修改OMS订单状态','admin','127.0.0.1','{\"orderId\":\"1000160506001921\",\"orderStatus\":\"CANCELLED\"}',NULL,'2016-07-27 10:58:42'),(39,'WHEAT','ORDER_PACKAGE','修改后台订单状态','admin','127.0.0.1','ORDER_PACKAGE [orderId=1000160517001396, orderStatus=PAID, dispStatus=INITIAL]','ORDER_PACKAGE [orderId=1000160517001396, orderStatus=PAID, dispStatus=DISTRIBUTED]','2016-07-29 15:21:05'),(40,'WHEAT','ORDER','修改OMS订单状态','admin','127.0.0.1','Order [orderId=1000160517001396, orderStatus=PAID]','Order [orderId=1000160517001396, orderStatus=COMPLETE]','2016-07-29 15:22:33'),(41,'JOYSEED','ORDER_PACKAGE','修改后台订单状态','admin','127.0.0.1','ORDER_PACKAGE [orderId=1000160510000600, orderStatus=RECEIVED, dispStatus=COMPLETE]','ORDER_PACKAGE [orderId=1000160510000600, orderStatus=PAID, dispStatus=INITIAL]','2016-07-29 15:23:36'),(42,'JOYSEED','ORDER','修改OMS订单状态','admin','127.0.0.1','Order [orderId=1000160510000600, orderStatus=RECEIVED]','Order [orderId=1000160510000600, orderStatus=]','2016-07-29 15:23:36'),(43,'JOYSEED','ORDER_PACKAGE','修改后台订单状态','admin','127.0.0.1','ORDER_PACKAGE [orderId=E07030601355907, orderStatus=RECEIVED, dispStatus=COMPLETE]','ORDER_PACKAGE [orderId=E07030601355907, orderStatus=PAID, dispStatus=INITIAL]','2016-07-29 15:24:33');

/*Table structure for table `sys_permission` */

CREATE TABLE `sys_permission` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(12) DEFAULT NULL COMMENT '父节点名称',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `type` varchar(20) DEFAULT NULL COMMENT '类型:菜单or功能',
  `sort_no` int(8) DEFAULT NULL COMMENT '排序',
  `url` varchar(256) DEFAULT NULL COMMENT '菜单URL',
  `perm_code` varchar(50) DEFAULT NULL COMMENT '菜单编码',
  `icon` varchar(256) DEFAULT NULL COMMENT '图标',
  `status` varchar(8) NOT NULL DEFAULT '1' COMMENT '状态:1,有效 0,无效',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `modify_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`id`,`parent_id`,`name`,`type`,`sort_no`,`url`,`perm_code`,`icon`,`status`,`description`,`create_user`,`modify_user`,`modify_time`,`create_time`) values (1,NULL,'系统管理','F',10,'','','icon-standard-cog','1','',NULL,NULL,NULL,NULL),(2,1,'角色管理','F',0,'system/role','','icon-hamburg-my-account','1','',NULL,NULL,NULL,NULL),(3,1,'用户管理','F',0,'system/user','','icon-hamburg-user','1','',NULL,NULL,NULL,NULL),(4,2,'添加','O',NULL,'','sys:role:save','','1','角色添加',NULL,NULL,NULL,NULL),(5,2,'删除','O',NULL,'','sys:role:remove','','1','角色删除',NULL,NULL,NULL,NULL),(6,2,'修改','O',NULL,'','sys:role:change','','1','角色修改',NULL,NULL,NULL,NULL),(7,3,'添加','O',NULL,'','sys:user:save','','1','用户添加',NULL,NULL,NULL,NULL),(8,3,'删除','O',NULL,'','sys:user:remove','','1','用户删除',NULL,NULL,NULL,NULL),(12,1,'权限管理','F',5,'system/permission','','icon-hamburg-login','1','',NULL,NULL,NULL,NULL),(14,15,'数据源监控','F',6,'druid','','icon-hamburg-database','1','',NULL,NULL,NULL,NULL),(15,NULL,'系统监控','F',3,'','','icon-hamburg-graphic','1','',NULL,NULL,NULL,NULL),(16,3,'修改','O',NULL,'','sys:user:change','','1','用户修改',NULL,NULL,NULL,NULL),(25,12,'添加','O',NULL,'','sys:perm:save','','1','菜单添加',NULL,NULL,NULL,NULL),(26,12,'修改','O',NULL,'','sys:perm:change','','1','菜单修改',NULL,NULL,NULL,NULL),(27,12,'删除','O',NULL,'','sys:perm:remove','','1','菜单删除',NULL,NULL,NULL,NULL),(28,2,'查看','O',NULL,'','sys:role:view','','1','角色查看',NULL,NULL,NULL,NULL),(29,3,'查看','O',NULL,'','sys:user:view','','1','用户查看',NULL,NULL,NULL,NULL),(30,12,'查看','O',NULL,'','sys:perm:view','','1','权限查看',NULL,NULL,NULL,NULL),(33,3,'查看用户角色','O',NULL,'','sys:user:roleView','','1','查看用户角色',NULL,NULL,NULL,NULL),(34,2,'保存授权','O',NULL,'','sys:role:permChange','','1','保存修改的角色权限',NULL,NULL,'2016-06-22 16:39:02',NULL),(35,3,'修改用户角色','O',NULL,'','sys:user:roleChange','','1','修改用户拥有的角色',NULL,NULL,NULL,NULL),(36,2,'查看角色权限','O',NULL,'','sys:role:permView','','1','查看角色拥有的权限',NULL,NULL,NULL,NULL),(37,15,'定时任务管理','F',NULL,'system/scheduleJob','','icon-hamburg-full-time','0','定时任务管理，支持集群',NULL,NULL,NULL,NULL),(38,15,'cron表达式生成','F',NULL,'system/scheduleJob/quartzCron','','icon-hamburg-future','0','',NULL,NULL,NULL,NULL),(39,1,'菜单管理','F',4,'system/permission/menu','','icon-hamburg-old-versions','1','',NULL,NULL,NULL,NULL),(40,1,'字典管理','F',6,'system/dict',NULL,'icon-hamburg-address','0','数据字典管理',NULL,NULL,NULL,NULL),(45,39,'修改','O',NULL,'','sys:perm:change',NULL,'1','菜单管理',NULL,NULL,NULL,NULL),(58,39,'添加','O',NULL,'','sys:perm:save',NULL,'1','菜单管理',NULL,NULL,NULL,NULL),(59,39,'删除','O',NULL,'','sys:perm:remove',NULL,'1','菜单管理',NULL,NULL,NULL,NULL),(70,39,'查看','O',NULL,'','sys:perm:menu:view',NULL,'1','菜单管理',NULL,NULL,NULL,NULL),(71,NULL,'开发实例','F',2,'',NULL,'icon-hamburg-basket','1','商店',NULL,NULL,NULL,NULL),(72,71,'地址管理','F',NULL,'template/community',NULL,'icon-hamburg-product','1','商品管理',NULL,NULL,NULL,NULL),(74,1,'区域信息','F',7,'system/area',NULL,'icon-hamburg-world','0','管理行政区划',NULL,NULL,NULL,NULL),(80,2,'导出','O',NULL,'','sys:role:export',NULL,'1','角色导出数据',NULL,NULL,NULL,'2016-06-21 11:10:30'),(81,39,'导出','O',NULL,'','sys:perm:export',NULL,'1','菜单管理',NULL,NULL,NULL,'2016-06-21 11:26:56'),(83,82,'导入','O',NULL,'','joyseed:order:import',NULL,'1','',NULL,NULL,'2016-06-23 10:15:08','2016-06-22 16:53:20'),(84,77,'查看','O',NULL,'','wheat:order:view',NULL,'1','元麦配送员配送计划管理',NULL,NULL,'2016-06-23 10:13:46','2016-06-23 10:13:24'),(85,77,'打印','O',NULL,'','wheat:order:print',NULL,'1','打印',NULL,NULL,NULL,'2016-06-23 10:14:17');

/*Table structure for table `sys_role` */

CREATE TABLE `sys_role` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '角色名称',
  `code` varchar(32) NOT NULL COMMENT '角色code',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `sort_no` int(8) DEFAULT NULL COMMENT '排序',
  `status` int(8) DEFAULT '1' COMMENT '状态',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `modify_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`code`,`description`,`sort_no`,`status`,`create_user`,`modify_user`,`create_time`,`modify_time`) values (1,'超级管理员','admin','超级管理员',0,1,'admin',NULL,'2016-06-15 15:16:00','2016-06-15 15:16:07'),(2,'临时用户','guest','测试',0,1,'admin',NULL,'2016-06-15 15:17:13','2016-06-15 15:17:17');

/*Table structure for table `sys_role_permission` */

CREATE TABLE `sys_role_permission` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(12) DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(12) DEFAULT NULL COMMENT '权限id',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `modify_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`id`,`role_id`,`permission_id`,`create_user`,`modify_user`,`create_time`,`modify_time`) values (1,1,1,NULL,NULL,'2016-06-30 15:07:05',NULL),(2,1,2,NULL,NULL,'2016-06-30 15:07:05',NULL),(3,1,3,NULL,NULL,'2016-06-30 15:07:05',NULL),(4,1,4,NULL,NULL,'2016-06-30 15:07:05',NULL),(5,1,5,NULL,NULL,'2016-06-30 15:07:05',NULL),(6,1,6,NULL,NULL,'2016-06-30 15:07:05',NULL),(7,1,7,NULL,NULL,'2016-06-30 15:07:05',NULL),(8,1,8,NULL,NULL,'2016-06-30 15:07:05',NULL),(9,1,12,NULL,NULL,'2016-06-30 15:07:05',NULL),(10,1,14,NULL,NULL,'2016-06-30 15:07:05',NULL),(11,1,15,NULL,NULL,'2016-06-30 15:07:05',NULL),(12,1,16,NULL,NULL,'2016-06-30 15:07:05',NULL),(13,1,25,NULL,NULL,'2016-06-30 15:07:05',NULL),(14,1,26,NULL,NULL,'2016-06-30 15:07:05',NULL),(15,1,27,NULL,NULL,'2016-06-30 15:07:05',NULL),(16,1,28,NULL,NULL,'2016-06-30 15:07:05',NULL),(17,1,29,NULL,NULL,'2016-06-30 15:07:05',NULL),(18,1,30,NULL,NULL,'2016-06-30 15:07:05',NULL),(19,1,33,NULL,NULL,'2016-06-30 15:07:05',NULL),(20,1,34,NULL,NULL,'2016-06-30 15:07:05',NULL),(21,1,35,NULL,NULL,'2016-06-30 15:07:05',NULL),(22,1,36,NULL,NULL,'2016-06-30 15:07:05',NULL),(23,1,39,NULL,NULL,'2016-06-30 15:07:05',NULL),(24,1,45,NULL,NULL,'2016-06-30 15:07:05',NULL),(25,1,58,NULL,NULL,'2016-06-30 15:07:05',NULL),(26,1,59,NULL,NULL,'2016-06-30 15:07:05',NULL),(27,1,70,NULL,NULL,'2016-06-30 15:07:05',NULL),(28,1,71,NULL,NULL,'2016-06-30 15:07:05',NULL),(29,1,72,NULL,NULL,'2016-06-30 15:07:05',NULL),(30,1,75,NULL,NULL,'2016-06-30 15:07:05',NULL),(31,1,76,NULL,NULL,'2016-06-30 15:07:05',NULL),(32,1,77,NULL,NULL,'2016-06-30 15:07:05',NULL),(33,1,80,NULL,NULL,'2016-06-30 15:07:05',NULL),(34,1,81,NULL,NULL,'2016-06-30 15:07:05',NULL),(35,1,82,NULL,NULL,'2016-06-30 15:07:05',NULL),(36,1,83,NULL,NULL,'2016-06-30 15:07:05',NULL),(37,1,84,NULL,NULL,'2016-06-30 15:07:05',NULL),(38,1,85,NULL,NULL,'2016-06-30 15:07:05',NULL),(101,5,82,NULL,NULL,'2016-06-30 15:52:39',NULL),(102,5,83,NULL,NULL,'2016-06-30 15:52:39',NULL),(103,5,76,NULL,NULL,'2016-06-30 15:52:39',NULL),(104,7,77,NULL,NULL,'2016-06-30 15:53:47',NULL),(105,7,84,NULL,NULL,'2016-06-30 15:53:47',NULL),(106,7,85,NULL,NULL,'2016-06-30 15:53:47',NULL),(107,7,76,NULL,NULL,'2016-06-30 15:53:47',NULL),(108,2,2,NULL,NULL,'2016-07-01 14:36:41',NULL),(109,2,1,NULL,NULL,'2016-07-01 14:36:41',NULL),(110,2,4,NULL,NULL,'2016-07-01 14:36:41',NULL),(111,2,5,NULL,NULL,'2016-07-01 14:36:41',NULL),(112,2,6,NULL,NULL,'2016-07-01 14:36:41',NULL),(113,2,28,NULL,NULL,'2016-07-01 14:36:41',NULL),(114,2,34,NULL,NULL,'2016-07-01 14:36:41',NULL),(115,2,36,NULL,NULL,'2016-07-01 14:36:41',NULL),(116,2,80,NULL,NULL,'2016-07-01 14:36:41',NULL),(117,1,86,NULL,NULL,'2016-07-12 10:23:46',NULL),(118,1,87,NULL,NULL,'2016-07-26 16:21:12',NULL),(119,1,88,NULL,NULL,'2016-08-03 11:02:33',NULL),(120,7,88,NULL,NULL,'2016-08-03 11:02:47',NULL),(121,1,89,NULL,NULL,'2016-08-04 09:44:46',NULL),(122,7,90,NULL,NULL,'2016-08-10 10:36:20',NULL),(123,1,90,NULL,NULL,'2016-08-10 10:37:43',NULL),(124,1,91,NULL,NULL,'2016-08-11 11:52:45',NULL),(125,1,92,NULL,NULL,'2016-08-12 11:48:26',NULL),(126,7,92,NULL,NULL,'2016-08-12 11:48:42',NULL),(127,1,93,NULL,NULL,'2016-08-12 14:05:14',NULL),(128,1,94,NULL,NULL,'2016-08-16 17:53:41',NULL),(129,7,95,NULL,NULL,'2016-08-18 10:41:51',NULL),(130,1,95,NULL,NULL,'2016-08-18 10:41:55',NULL);

/*Table structure for table `sys_user` */

CREATE TABLE `sys_user` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(256) NOT NULL COMMENT '密码',
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `gender` int(8) DEFAULT NULL COMMENT '性别',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `status` int(8) DEFAULT NULL COMMENT '状态',
  `visit_count` int(8) DEFAULT '0' COMMENT '登录次数',
  `last_visit_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `modify_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`name`,`birthday`,`gender`,`email`,`mobile`,`description`,`status`,`visit_count`,`last_visit_time`,`create_user`,`modify_user`,`modify_time`,`create_time`) values (1,'admin','0192023a7bbd73250516f069df18b500','系统管理员','2016-06-12 00:00:00',1,'admin@m.com','13512345678','系统管理员',1,78,'2016-08-18 17:28:23',NULL,NULL,'2016-08-18 17:35:56','2016-06-12 16:39:03'),(3,'david','e10adc3949ba59abbe56e057f20f883e','魏先生','1991-06-05 00:00:00',0,'david@mcake.com','13761142302','测试数据',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `sys_user_role` */

CREATE TABLE `sys_user_role` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(12) NOT NULL COMMENT '用户id',
  `role_id` bigint(12) NOT NULL COMMENT '角色id',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `modify_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `FK_USER_ROL_REFERENCE_ROLE` (`role_id`) USING BTREE,
  KEY `FK_USER_ROL_REFERENCE_USERS` (`user_id`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`,`create_user`,`modify_user`,`modify_time`,`create_time`) values (1,1,1,NULL,NULL,'2016-06-21 13:38:04','2016-06-21 13:38:01');

/*Table structure for table `t_community` */

CREATE TABLE `t_community` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `city_name` varchar(32) DEFAULT NULL COMMENT '城市名称',
  `city_code` varchar(32) DEFAULT NULL COMMENT '城市编码',
  `area_name` varchar(32) DEFAULT NULL COMMENT '区域名称',
  `area_code` varchar(32) DEFAULT NULL COMMENT '区域编码',
  `community` varchar(64) DEFAULT NULL COMMENT '小区名称',
  `company` varchar(64) DEFAULT NULL COMMENT '单位名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10007 DEFAULT CHARSET=utf8;

/*Data for the table `t_community` */

insert  into `t_community`(`id`,`city_name`,`city_code`,`area_name`,`area_code`,`community`,`company`) values (1,'上海','31','闵行','minhang','富丽公寓',''),(2,'上海','31','闵行','minhang','龙柏四季花园',''),(3,'上海','31','闵行','minhang','明申花园',''),(4,'上海','31','闵行','minhang','平吉二村',''),(5,'上海','31','闵行','minhang','万科城花新园',''),(6,'上海','31','闵行','minhang','上海康城（一至四期）',''),(7,'上海','31','闵行','minhang','罗阳七村',''),(8,'上海','31','闵行','minhang','浦江智汇园',''),(9,'上海','31','闵行','minhang','罗阳五村',''),(10,'上海','31','闵行','minhang','西郊庄园',''),(11,'上海','31','闵行','minhang','新时代富嘉花园',''),(12,'上海','31','闵行','minhang','湖山在望',''),(13,'上海','31','闵行','minhang','上海阳城',''),(14,'上海','31','闵行','minhang','上海春城（一至三期）',''),(15,'上海','31','闵行','minhang','流晶逸彩',''),(16,'上海','31','闵行','minhang','虹桥花苑',''),(17,'上海','31','闵行','minhang','华光花园',''),(18,'上海','31','闵行','minhang','静安新城（一区至十二区）',''),(19,'上海','31','闵行','minhang','金都花好悦园（一至五期）',''),(21,'上海','31','闵行','minhang','江南星城（一至二期）',''),(22,'上海','31','闵行','minhang','君莲新城广润苑',''),(23,'上海','31','闵行','minhang','莲浦府邸（一至二期）',''),(24,'上海','31','闵行','minhang','西班牙名园',''),(25,'上海','31','闵行','minhang','君临天下花园',''),(26,'上海','31','闵行','minhang','名都新城（一至四期）',''),(27,'上海','31','闵行','minhang','虹景苑',''),(28,'上海','31','闵行','minhang','朗诗未来街区',''),(29,'上海','31','闵行','minhang','绿城玫瑰园',''),(30,'上海','31','闵行','minhang','九歌上郡',''),(31,'上海','31','闵行','minhang','罗阳三村',''),(32,'上海','31','闵行','minhang','龙柏西郊公寓',''),(33,'上海','31','闵行','minhang','欧风花都',''),(34,'上海','31','闵行','minhang','南方城',''),(35,'上海','31','闵行','minhang','浦江宝邸',''),(36,'上海','31','闵行','minhang','平南三村',''),(37,'上海','31','闵行','minhang','春申景城（二期）',''),(38,'上海','31','闵行','minhang','虹浦新城',''),(39,'上海','31','闵行','minhang','平阳绿家园',''),(40,'上海','31','闵行','minhang','茂盛城市花园（一至三期）',''),(41,'上海','31','闵行','minhang','御涛园',''),(42,'上海','31','闵行','minhang','东苑古龙城一期',''),(43,'上海','31','闵行','minhang','景舒苑（一村至十村）',''),(44,'上海','31','闵行','minhang','万乐城',''),(45,'上海','31','闵行','minhang','好世凤凰城',''),(46,'上海','31','闵行','minhang','好世樱园',''),(47,'上海','31','闵行','minhang','保利茉莉公馆',''),(48,'上海','31','闵行','minhang','新时代花园',''),(49,'上海','31','闵行','minhang','新时代景庭',''),(50,'上海','31','闵行','minhang','金色西郊城',''),(51,'上海','31','闵行','minhang','东苑半岛花园',''),(52,'上海','31','闵行','minhang','银河新都',''),(53,'上海','31','闵行','minhang','万科兰乔圣菲（一至三期）',''),(54,'上海','31','闵行','minhang','万兆家园一二四期',''),(55,'上海','31','闵行','minhang','万源城朗郡',''),(56,'上海','31','闵行','minhang','风度国际',''),(57,'上海','31','闵行','minhang','蓝色港湾博馨苑',''),(58,'上海','31','闵行','minhang','耕读园',''),(59,'上海','31','闵行','minhang','白雪公主',''),(60,'上海','31','闵行','minhang','一品漫城',''),(61,'上海','31','闵行','minhang','新梅花苑',''),(62,'上海','31','闵行','minhang','欣佳宝邸一期',''),(63,'上海','31','闵行','minhang','皇都花园（一至二期）',''),(64,'上海','31','闵行','minhang','银都名墅',''),(65,'上海','31','闵行','minhang','万科魅力之城',''),(66,'上海','31','闵行','minhang','中星红庐',''),(67,'上海','31','闵行','minhang','航华一村一街坊',''),(68,'上海','31','闵行','minhang','瑞和新苑',''),(69,'上海','31','闵行','minhang','西郊庄园马德里',''),(70,'上海','31','闵行','minhang','爱庐世纪新苑',''),(71,'上海','31','闵行','minhang','华侨城十号院',''),(72,'上海','31','闵行','minhang','阳明国际花苑（一至五期）',''),(73,'上海','31','闵行','minhang','嘉富丽苑',''),(74,'上海','31','闵行','minhang','闵行星河湾',''),(75,'上海','31','闵行','minhang','高兴花园',''),(76,'上海','31','闵行','minhang','碧林湾苑（一至三期）',''),(77,'上海','31','闵行','minhang','沁春园一村',''),(78,'上海','31','闵行','minhang','南郊别墅',''),(79,'上海','31','闵行','minhang','水语人家',''),(80,'上海','31','闵行','minhang','大上海国际花园',''),(81,'上海','31','闵行','minhang','东方花园三期（公园&middot;养生豪庭）',''),(82,'上海','31','闵行','minhang','春申景城（一期）',''),(83,'上海','31','闵行','minhang','新明星花园（一至三期）',''),(84,'上海','31','闵行','minhang','金汇华光城',''),(85,'上海','31','闵行','minhang','名都城（二期至三期）',''),(86,'上海','31','闵行','minhang','蔚蓝城市花园',''),(87,'上海','31','闵行','minhang','万科假日风景',''),(88,'上海','31','闵行','minhang','南方新村',''),(89,'上海','31','闵行','minhang','好世鹿鸣苑',''),(90,'上海','31','闵行','minhang','古北新城（一至四期）',''),(91,'上海','31','闵行','minhang','万科朗润园',''),(92,'上海','31','闵行','minhang','平阳四街坊',''),(93,'上海','31','闵行','minhang','春申玫瑰苑',''),(94,'上海','31','闵行','minhang','平吉一村',''),(95,'上海','31','闵行','minhang','万科城市花园（一至五期）',''),(96,'上海','31','闵行','minhang','天籁园',''),(97,'上海','31','闵行','minhang','新浦江城',''),(98,'上海','31','闵行','minhang','梅陇二村',''),(99,'上海','31','闵行','minhang','圣得恒业花园',''),(100,'上海','31','闵行','minhang','莘城公寓',''),(101,'上海','31','闵行','minhang','广海花园（一至三期）',''),(102,'上海','31','闵行','minhang','奥塞花园',''),(103,'上海','31','闵行','minhang','柏林春天（一至二期）',''),(104,'上海','31','闵行','minhang','龙柏香榭苑',''),(105,'上海','31','闵行','minhang','中城绿苑',''),(106,'上海','31','闵行','minhang','金汇鸿锦苑',''),(107,'上海','31','闵行','minhang','江南欣苑',''),(108,'上海','31','闵行','minhang','名都城一期',''),(109,'上海','31','闵行','minhang','望族苑',''),(110,'上海','31','闵行','minhang','华唐苑',''),(111,'上海','31','闵行','minhang','夏朵小城三期',''),(112,'上海','31','闵行','minhang','未名园',''),(113,'上海','31','闵行','minhang','黎明花园',''),(114,'上海','31','闵行','minhang','贵峰苑',''),(115,'上海','31','闵行','minhang','西郊九韵城',''),(116,'上海','31','闵行','minhang','新梅莘苑',''),(117,'上海','31','闵行','minhang','古美西路316弄',''),(118,'上海','31','闵行','minhang','新梅公寓（一至三期）',''),(119,'上海','31','闵行','minhang','绿水家园',''),(120,'上海','31','闵行','minhang','银泰苑',''),(121,'上海','31','闵行','minhang','莲花河畔景苑',''),(122,'上海','31','闵行','minhang','万科时一区',''),(123,'上海','31','闵行','minhang','东兰世茗雅苑',''),(124,'上海','31','闵行','minhang','航华四村一街坊',''),(125,'上海','31','闵行','minhang','龙柏二村',''),(126,'上海','31','闵行','minhang','丽华公寓',''),(127,'上海','31','闵行','minhang','东方花园一期',''),(128,'上海','31','闵行','minhang','日月华城',''),(129,'上海','31','闵行','minhang','莘城苑一期',''),(130,'上海','31','闵行','minhang','丹桂花园',''),(131,'上海','31','闵行','minhang','汇颂南苑',''),(132,'上海','31','闵行','minhang','中祥哥德堡',''),(133,'上海','31','闵行','minhang','航华一村二街坊',''),(134,'上海','31','闵行','minhang','金铭文博水景苑',''),(135,'上海','31','闵行','minhang','春江锦庐',''),(136,'上海','31','闵行','minhang','浦江华侨城（新浦江城二期）',''),(137,'上海','31','闵行','minhang','莲蒲府邸',''),(138,'上海','31','闵行','minhang','万泰花园',''),(139,'上海','31','闵行','minhang','旖和园',''),(140,'上海','31','闵行','minhang','万科七宝国际',''),(141,'上海','31','闵行','minhang','金俊苑',''),(142,'上海','31','闵行','minhang','绿地新干线',''),(143,'上海','31','闵行','minhang','万源城逸郡',''),(144,'上海','31','闵行','minhang','浦江丽都',''),(145,'上海','31','闵行','minhang','浦江世博家园八街坊',''),(146,'上海','31','闵行','minhang','中友嘉园',''),(147,'上海','31','闵行','minhang','招商&middot;雍华府',''),(148,'上海','31','闵行','minhang','凯德林茵湖畔',''),(149,'上海','31','闵行','minhang','春申景城三期',''),(150,'上海','31','闵行','minhang','虹梅新苑',''),(151,'上海','31','闵行','minhang','中梅苑（一至三期）',''),(152,'上海','31','闵行','minhang','金汇花园一街坊',''),(153,'上海','31','闵行','minhang','万源新城',''),(154,'上海','31','闵行','minhang','水清年华',''),(155,'上海','31','闵行','minhang','众众&middot;德尚世嘉',''),(156,'上海','31','闵行','minhang','昆阳小区',''),(157,'上海','31','闵行','minhang','鹤北新村二街坊',''),(158,'上海','31','闵行','minhang','绿地峰尚汇',''),(159,'上海','31','闵行','minhang','蓼花汀花园',''),(160,'上海','31','闵行','minhang','欧香名邸',''),(161,'上海','31','闵行','minhang','虹桥1号',''),(162,'上海','31','闵行','minhang','奥玎宫廷别墅',''),(163,'上海','31','闵行','minhang','虹桥高尔夫别墅',''),(164,'上海','31','闵行','minhang','东方御花园（一至二期）',''),(165,'上海','31','闵行','minhang','浦江颐城晶寓',''),(166,'上海','31','闵行','minhang','合生城邦四街坊',''),(167,'上海','31','闵行','minhang','品家都市星城（一至二期）',''),(168,'上海','31','闵行','minhang','航华二村三街坊',''),(169,'上海','31','闵行','minhang','金色探戈',''),(170,'上海','31','闵行','minhang','浦江世博家园七街坊',''),(171,'上海','31','闵行','minhang','罗阳一村',''),(172,'上海','31','闵行','minhang','平南一村',''),(173,'上海','31','闵行','minhang','夏朵小城二期',''),(174,'上海','31','闵行','minhang','景江苑',''),(175,'上海','31','闵行','minhang','浦江世博家园二街坊',''),(176,'上海','31','闵行','minhang','宝安新苑',''),(177,'上海','31','闵行','minhang','天恒名城',''),(178,'上海','31','闵行','minhang','金硕河畔',''),(179,'上海','31','闵行','minhang','复地北桥城',''),(180,'上海','31','闵行','minhang','万顺水原墅',''),(181,'上海','31','闵行','minhang','万科翡翠别墅',''),(182,'上海','31','闵行','minhang','九歌花园',''),(183,'上海','31','闵行','minhang','梅陇城世纪苑',''),(184,'上海','31','闵行','minhang','都市宜家苑',''),(185,'上海','31','闵行','minhang','飞碟苑',''),(186,'上海','31','闵行','minhang','东方花园二期（四季运动汇）',''),(187,'上海','31','闵行','minhang','马德里洋房',''),(188,'上海','31','闵行','minhang','浦江世博家园四街坊',''),(189,'上海','31','闵行','minhang','新梅广场',''),(190,'上海','31','闵行','minhang','万源城尚郡',''),(191,'上海','31','闵行','minhang','东苑怡和苑',''),(192,'上海','31','闵行','minhang','东苑绿世界花园（一至三期）',''),(193,'上海','31','闵行','minhang','金汇豪庭',''),(194,'上海','31','闵行','minhang','美邻苑',''),(195,'上海','31','闵行','minhang','君莲新城中城苑',''),(196,'上海','31','闵行','minhang','万科花园小城',''),(197,'上海','31','闵行','minhang','金汇丽舍',''),(198,'上海','31','闵行','minhang','丽都城',''),(199,'上海','31','闵行','minhang','龙柏四村',''),(200,'上海','31','闵行','minhang','嘉和花苑（一至四期）','');
