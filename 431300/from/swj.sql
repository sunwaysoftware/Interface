/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.23 : Database - bdc_front
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bdc_front` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bdc_front`;

/*Table structure for table `FC001` */

DROP TABLE IF EXISTS `FC001`;

CREATE TABLE `FC001` (
  `SN` varchar(100) NOT NULL COMMENT '（房产局产系统提供）',
  `SLID` varchar(50) DEFAULT NULL COMMENT '房产受理号',
  `SSQY` varchar(50) DEFAULT NULL COMMENT '所属区域',
  `FCZH` varchar(100) DEFAULT NULL COMMENT '房产证号',
  `ZRF_NAME` varchar(250) DEFAULT NULL COMMENT '转让方名称',
  `ZRF_ID` varchar(50) DEFAULT NULL COMMENT '转让方证件号',
  `ZRF_ZJLX` varchar(50) DEFAULT NULL COMMENT '转让方证件类型(基于不动产中心的枚举)',
  `ZRF_TEL` varchar(20) DEFAULT NULL COMMENT '转让方联系电话',
  `CSF_NAME` varchar(250) DEFAULT NULL COMMENT '承受方姓名',
  `CSF_ID` varchar(50) DEFAULT NULL COMMENT '承受方证件号',
  `CSF_ZJLX` varchar(50) DEFAULT NULL COMMENT '承受方证件类型(基于不动产中心的枚举)',
  `CSF_TEL` varchar(20) DEFAULT NULL COMMENT '承受方联系电话',
  `CLH` varchar(50) DEFAULT NULL COMMENT '测量号',
  `GHYT` varchar(50) DEFAULT NULL COMMENT '规划用途',
  `LFDZ` varchar(200) DEFAULT NULL COMMENT '楼房地址',
  `DYFH` varchar(50) DEFAULT NULL COMMENT '单元房号',
  `ZLC` int(11) DEFAULT NULL COMMENT '总楼层',
  `SZLC` int(11) DEFAULT NULL COMMENT '所在楼层',
  `JZJG` varchar(50) DEFAULT NULL COMMENT '建筑结构',
  `FWLX` varchar(50) DEFAULT NULL COMMENT '房屋类型',
  `JYLX` varchar(50) DEFAULT NULL COMMENT '交易类型（用于区分一手房、二手房交易，取得方式）',
  `JZMJ` double DEFAULT NULL COMMENT '建筑面积',
  `HTZJ` decimal(10,0) DEFAULT NULL COMMENT '合同总价',
  `FZRQ` date DEFAULT NULL COMMENT '发证日期',
  `JCNF` varchar(4) DEFAULT NULL COMMENT '建成年份',
  `JYSJ` date DEFAULT NULL COMMENT '交易时间',
  `SFSYFC` varchar(50) DEFAULT NULL COMMENT '是否私有房产',
  `CX` varchar(50) DEFAULT NULL COMMENT '朝向',
  `DF` varchar(50) DEFAULT NULL COMMENT '端房',
  `UPDATETIME` date DEFAULT NULL COMMENT '更新时间',
  `JG` varchar(50) DEFAULT NULL COMMENT '景观(保留)',
  `ZX` varchar(50) DEFAULT NULL COMMENT '装修(保留)',
  `CG` double DEFAULT NULL COMMENT '层高',
  `QSWSRQ` date DEFAULT NULL COMMENT '契税完税日期',
  `QSWSJS` double DEFAULT NULL COMMENT '契税完税基数',
  `DEL_SIGN` int(11) DEFAULT NULL COMMENT '撤销标识(0正常，1撤销)',
  `DEL_TIME` date DEFAULT NULL COMMENT '撤销时间',
  `DEL_CZR` varchar(50) DEFAULT NULL COMMENT '撤销操作人',
  `STATUS` int(11) DEFAULT NULL COMMENT '流程状态:0:未完税1:已读取4:房产登簿5:超期（异常）6:退回房产（异常）7:业务中止（异常）',
  `REMARKS` varchar(200) DEFAULT NULL COMMENT '备注（存储退回信息）',
  `STATUS_SE` int(11) DEFAULT NULL COMMENT '税额状态:0:未完税1:已完税2:退税',
  `STATUS_ZZ` int(11) DEFAULT NULL COMMENT '终止状态（0正常，1终止）',
  `kzzd` varchar(50) DEFAULT NULL COMMENT '扩展字段（用于后续信息扩展，以Jason格式存储)',
  `QDFS` varchar(10) DEFAULT NULL COMMENT '取得方式（转让、继承、捐赠）',
  `CSF_FCTS` int(11) DEFAULT NULL COMMENT '承受方房产套数',
  `ZRF_FCTS` int(11) DEFAULT NULL COMMENT '转让方房产套数',
  `zlbh` varchar(50) DEFAULT NULL COMMENT '指令编号',
  `ywh` varchar(50) DEFAULT NULL COMMENT '业务号（不动产系统提供）',
  `bdcdyh` varchar(50) DEFAULT NULL COMMENT '不动产单元号',
  `bdcqzh` varchar(50) DEFAULT NULL COMMENT '不动产权证号',
  `sync_state` int(11) DEFAULT '0' COMMENT '同步状态，0：初始，1：成功，-1：失败，99：正在同步',
  `sync_result` varchar(1024) DEFAULT NULL COMMENT '同步结果',
  PRIMARY KEY (`SN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `FC002`;

CREATE TABLE `FC002` (
  `lsh` varchar(100) NOT NULL COMMENT '流水号（税务系统业务主表）',
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
  `kzzd` varchar(50) DEFAULT NULL COMMENT '扩展字段（用于后续信息扩展，以Jason格式存储）',
  `zlbm` varchar(50) DEFAULT NULL COMMENT '指令编号',
  `ywh` varchar(50) DEFAULT NULL COMMENT '业务号（依赖于不动产系统生成）',
  `fcjlsh` varchar(50) DEFAULT NULL COMMENT '房产局流水号（房产局产系统提供）',
  `bdcdyh` varchar(50) DEFAULT NULL COMMENT '不动产单元号',
  `ybdcqzh` varchar(50) DEFAULT NULL COMMENT '不动产权证号（原）',
  `wqhth` varchar(50) DEFAULT NULL COMMENT '网签合同号（税务暂无法提供此信息）',
  `dznspzh` varchar(100) DEFAULT NULL COMMENT '电子纳税凭证号（税务暂无法提供此信息）',
  `wspzh` varchar(100) DEFAULT NULL COMMENT '完税凭证号（税务暂无法提供此信息）',
  `wszh` varchar(100) DEFAULT NULL COMMENT '完税字号（税务暂无法提供此信息）',
  `jsje` decimal(10,0) DEFAULT NULL COMMENT '计税金额（税务暂无法提供此信息）',
  `wsje` decimal(10,0) DEFAULT NULL COMMENT '完税金额（税务暂无法提供此信息）',
  `wssj` date DEFAULT NULL COMMENT '完税时间（税务暂无法提供此信息）',
  PRIMARY KEY (`lsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_cmd_request`;

CREATE TABLE `sys_cmd_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cmd_code` varchar(11) DEFAULT NULL COMMENT '指令id',
  `create_time` datetime DEFAULT NULL,
  `resolve_state` int(11) DEFAULT '0' COMMENT '0:前置机未处理，1：前置机处理成功，-1：前置机处理失败，99：前置机处理中，10：三方系统处理成功，11：三方系统处理中，12：三方系统处理失败',
  `resolve_time` datetime DEFAULT NULL COMMENT '处理完成时间',
  `third_resolve_time` datetime DEFAULT NULL COMMENT '第三方系统处理完成时间',
  `data_id` varchar(128) DEFAULT NULL COMMENT '数据入口主键（三方系统写入）',
  `fail_msg` varchar(512) DEFAULT NULL COMMENT '失败原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='指令请求表';
