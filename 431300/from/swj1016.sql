/*
SQLyog Enterprise - MySQL GUI v6.55 RC2
MySQL - 5.7.23-0ubuntu0.16.04.1-log : Database - bdc_front_swj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `FC002` */

CREATE TABLE `FC002` (
  `LSH` varchar(100) DEFAULT NULL COMMENT '流水号（税务系统业务主表）',
  `DJZ_QS` decimal(10,0) DEFAULT NULL COMMENT '契税',
  `DJZ_YYS` decimal(10,0) DEFAULT NULL COMMENT '营业税',
  `DJZ_CJS` decimal(10,0) DEFAULT NULL COMMENT '城市维护建设税',
  `DJZ_DFJYS` decimal(10,0) DEFAULT NULL COMMENT '教育费附加、地方教育附加',
  `DJZ_GRSDS` decimal(10,0) DEFAULT NULL COMMENT '个人所得税',
  `DJZ_YHS` decimal(10,0) DEFAULT NULL COMMENT '印花税',
  `DJZ_TDZZS` decimal(10,0) DEFAULT NULL COMMENT '土地增值税',
  `FPHM` varchar(50) DEFAULT NULL COMMENT '发票号码',
  `QSSPHM` varchar(50) DEFAULT NULL COMMENT '契税税票号码',
  `DFGSSPHM` varchar(50) DEFAULT NULL COMMENT '地方各税税票号码',
  `UPDATETIME` date DEFAULT NULL COMMENT '更新日期',
  `PGID` varchar(21) DEFAULT NULL COMMENT '评估业务号',
  `PGJG` int(11) DEFAULT NULL COMMENT '评估结果',
  `MS_SIGN` int(11) DEFAULT NULL COMMENT '免税标识(0正常，1免税)',
  `MS_ZCYJ` varchar(50) DEFAULT NULL COMMENT '政策依据',
  `YWH` varchar(50) DEFAULT NULL COMMENT '业务号（依赖于不动产系统生成）',
  `FCJLSH` varchar(50) DEFAULT NULL COMMENT '房产局流水号（房产局产系统提供）',
  `BDCDYH` varchar(50) DEFAULT NULL COMMENT '不动产单元号',
  `YBDCQZH` varchar(50) DEFAULT NULL COMMENT '不动产权证号（原）',
  `WQHTH` varchar(50) DEFAULT NULL COMMENT '网签合同号（税务暂无法提供此信息）',
  `DZNSPZH` varchar(100) DEFAULT NULL COMMENT '电子纳税凭证号（税务暂无法提供此信息）',
  `WSPZH` varchar(100) DEFAULT NULL COMMENT '完税凭证号（税务暂无法提供此信息）',
  `WSZH` varchar(100) DEFAULT NULL COMMENT '完税字号（税务暂无法提供此信息）',
  `JSJE` decimal(10,0) DEFAULT NULL COMMENT '计税金额（税务暂无法提供此信息）',
  `WSJE` decimal(10,0) DEFAULT NULL COMMENT '完税金额（税务暂无法提供此信息）',
  `WSSJ` date DEFAULT NULL COMMENT '完税时间（税务暂无法提供此信息）',
  `QQLSH` varchar(64) NOT NULL COMMENT '请求流水号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `FC002` */

insert  into `FC002`(`LSH`,`DJZ_QS`,`DJZ_YYS`,`DJZ_CJS`,`DJZ_DFJYS`,`DJZ_GRSDS`,`DJZ_YHS`,`DJZ_TDZZS`,`FPHM`,`QSSPHM`,`DFGSSPHM`,`UPDATETIME`,`PGID`,`PGJG`,`MS_SIGN`,`MS_ZCYJ`,`YWH`,`FCJLSH`,`BDCDYH`,`YBDCQZH`,`WQHTH`,`DZNSPZH`,`WSPZH`,`WSZH`,`JSJE`,`WSJE`,`WSSJ`,`QQLSH`) values ('201404210476','3554','1','1','1','1','178','1',NULL,'675589.0','675588.0','2014-04-29','FC1404290842580191856',177700,0,NULL,NULL,NULL,'431302006002GB00133F00010005','431302002029GB00061F00000008',NULL,NULL,NULL,NULL,NULL,NULL,'2018-10-11','3001'),('201404230314','2200','5500','385','275','1100','0','0',NULL,NULL,NULL,'2014-04-29',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'');

/*Table structure for table `F_UPFILES_1` */

CREATE TABLE `F_UPFILES_1` (
  `ID` int(11) DEFAULT NULL,
  `CASENO` varchar(36) DEFAULT NULL,
  `MATERIALID` int(11) DEFAULT NULL,
  `MATERIALNAME` text,
  `FILENO` int(11) DEFAULT NULL,
  `FILENAME` varchar(100) NOT NULL,
  `FILESIZE` varchar(50) DEFAULT NULL,
  `FILEPATH` varchar(200) NOT NULL,
  `UPFILETIME` datetime NOT NULL,
  `FILECONTENT` longblob,
  `REMARK` varchar(100) DEFAULT NULL,
  `USERID` int(11) DEFAULT NULL,
  `UPTYPE` varchar(100) DEFAULT NULL,
  `FTPKEYNAME` varchar(50) DEFAULT NULL,
  `HDFS_ADDRESS` varchar(256) DEFAULT NULL,
  `qqlsh` varchar(64) NOT NULL,
  `DEPT` varchar(32) DEFAULT '3' COMMENT '1.不动产中心  2.房产局 3.税务局'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `F_UPFILES_1` */

/*Table structure for table `sys_cmd` */

CREATE TABLE `sys_cmd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) DEFAULT NULL COMMENT '命令码',
  `name` varchar(256) DEFAULT NULL COMMENT '命令名称',
  `rds_api_url` varchar(256) DEFAULT NULL COMMENT '请求的RDS接口url',
  `memo` varchar(512) DEFAULT NULL COMMENT '备注',
  `rds_api_user` varchar(64) DEFAULT NULL COMMENT '请求rds接口用户(预留)',
  `request_config` varchar(5120) DEFAULT NULL COMMENT '入参解析配置',
  `response_config` varchar(5120) DEFAULT NULL COMMENT '结果解析配置',
  `type` int(11) DEFAULT '0' COMMENT '0:第三方系统发起，1:前置机发起',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='指令表';

/*Data for the table `sys_cmd` */

insert  into `sys_cmd`(`id`,`code`,`name`,`rds_api_url`,`memo`,`rds_api_user`,`request_config`,`response_config`,`type`) values (18,'300101','完成缴税','http://172.18.3.43:8016/bdc/register/taxComplete',NULL,NULL,NULL,NULL,0);

/*Table structure for table `sys_cmd_request` */

CREATE TABLE `sys_cmd_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cmd_code` varchar(11) DEFAULT NULL COMMENT '指令id',
  `create_time` datetime DEFAULT NULL,
  `resolve_state` int(11) DEFAULT '0' COMMENT '0:前置机未处理，1：前置机处理成功，-1：前置机处理失败，99：前置机处理中，10：三方系统处理成功，11：三方系统处理中，12：三方系统处理失败',
  `resolve_time` datetime DEFAULT NULL COMMENT '处理完成时间',
  `send_resolve_time` datetime DEFAULT NULL COMMENT '第三方系统处理完成时间',
  `data_id` varchar(128) DEFAULT NULL COMMENT '数据入口主键（三方系统写入）',
  `fail_msg` varchar(512) DEFAULT NULL COMMENT '失败原因',
  `type` int(11) DEFAULT '0' COMMENT '0:非文件请求，1：文件请求',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='指令请求表';

/*Data for the table `sys_cmd_request` */

/*Table structure for table `sys_cmd_response` */

CREATE TABLE `sys_cmd_response` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qqlsh` varchar(32) DEFAULT NULL COMMENT '请求流水号',
  `content` mediumtext COMMENT '响应结果',
  `biz_code` varchar(64) DEFAULT NULL COMMENT '业务号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_cmd_response` */

/*Table structure for table `sys_receive_msg` */

CREATE TABLE `sys_receive_msg` (
  `cmd_code` varchar(32) DEFAULT NULL COMMENT '消息命令代码',
  `cmd_name` varchar(256) DEFAULT NULL COMMENT '消息命令名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_receive_msg` */

insert  into `sys_receive_msg`(`cmd_code`,`cmd_name`) values ('100201','不动产协税信息'),('200101','房产局协税信息');

/*Table structure for table `sys_request_sql_para` */

CREATE TABLE `sys_request_sql_para` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `config_id` int(11) DEFAULT NULL COMMENT '配置id',
  `table_name` varchar(128) DEFAULT NULL COMMENT '表名',
  `field_name` varchar(64) DEFAULT NULL COMMENT '字段名',
  `order_seq` int(11) DEFAULT NULL COMMENT '排序位置',
  `para_name` varchar(64) DEFAULT NULL COMMENT '参数名称',
  `data_id_flag` int(11) DEFAULT '0' COMMENT '是否业务数据主键，1：是，0：不是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='请求查询sql参数值定义';

/*Data for the table `sys_request_sql_para` */

insert  into `sys_request_sql_para`(`id`,`config_id`,`table_name`,`field_name`,`order_seq`,`para_name`,`data_id_flag`) values (43,45,'FC002',NULL,1,'qqlsh',1);

/*Table structure for table `sys_request_table_config` */

CREATE TABLE `sys_request_table_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cmd_id` int(11) DEFAULT NULL COMMENT '命令id',
  `table_name` varchar(128) DEFAULT NULL COMMENT '表名称',
  `json_field` varchar(64) DEFAULT NULL COMMENT 'json字段名称',
  `main_table` int(11) DEFAULT '0' COMMENT '是否是主表。1：是，0：不是',
  `json_list` int(11) DEFAULT '0' COMMENT '是否是数组，1：是，0：不是',
  `select_sql` mediumtext COMMENT 'sql查询语句',
  `order_seq` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='请求的表与json字段的配置';

/*Data for the table `sys_request_table_config` */

insert  into `sys_request_table_config`(`id`,`cmd_id`,`table_name`,`json_field`,`main_table`,`json_list`,`select_sql`,`order_seq`,`parent_id`) values (45,18,'FC002',NULL,1,0,'SELECT 300101 AS cmdCode,e.`wqhth` AS netSignNo,e.`ywh` AS ywh,e.`dznspzh` AS electronicTaxNo,e.`bdcdyh` AS bdcdyh, e.fphm AS fphm,e.qssphm AS qssphm,e.dfgssphm AS dfgssphm,e.ms_sign AS msSign,e.djz_qs AS djzQs,e.djz_yys AS djzYys,e.djz_cjs AS djzCjs,e.djz_dfjys AS djzDfjys,e.djz_grsds AS djzGrsds,e.djz_yhs AS djzYhs,e.djz_tdzzs AS djzTdzzs,e.updatetime AS updateTime,e.lsh ,e.pgid AS pgid,e.pgjg AS pgjg,e.ms_zcyj AS msZcyj,e.fcjlsh,e.ybdcqzh,e.wqhth,e.dznspzh,e.wspzh,e.wszh,e.jsje,e.wsje,e.wssj FROM FC002 e WHERE e.qqlsh=#{qqlsh}',1,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
