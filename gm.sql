/*
SQLyog Job Agent v12.09 (64 bit) Copyright(c) Webyog Inc. All Rights Reserved.


MySQL - 5.5.40 : Database - goodsmanage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`goodsmanage` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `goodsmanage`;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `place` varchar(20) NOT NULL,
  `number` int(10) NOT NULL,
  `price` float NOT NULL,
  `category` varchar(20) NOT NULL,
  KEY `number` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods` values (1,'手机','北京',1215,10001,'手机'),(2,'平板','上海',1109,2222,'电脑'),(3,'笔记本电脑','香港',2976,3333,'电脑'),(4,'摄像头','江苏',3984,200,'电子产品'),(7,'surface pro 4','American',1229,3333,'电脑'),(9,'水杯','上海',86,123,'日用品'),(28,'水壶','上海',23,123,'日用品'),(29,'音响','上海',123,123,'电子产品'),(30,'台灯','上海',122,123,'日用品'),(31,'钢笔','中国',1101,123,'日用品'),(34,'鼠标','123123',111,22,'电子产品'),(44,'显示器','广东',1123,123,'电子产品'),(94,'纸','重庆',100,20,'日用品'),(129,'毛笔','海南',100,5,'日用品'),(130,'牙刷','1',1,1,'日用品'),(133,'大屏手机','北京',1219,1000,'电脑'),(139,'11','123',123,123,'电子产品'),(141,'1231313','1231231',1233123,12312300,'电脑'),(143,'无线电','天津',100,200,'日用品'),(144,'无线电1','天津',100,200,'手机'),(145,'无线电12','天津',100,200,'电子产品');

/*Table structure for table `levellink` */

DROP TABLE IF EXISTS `levellink`;

CREATE TABLE `levellink` (
  `level` varchar(20) NOT NULL,
  `level_name` varchar(20) NOT NULL,
  PRIMARY KEY (`level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `levellink` */

insert  into `levellink` values ('1','guests'),('2','users'),('3','admins');

/*Table structure for table `orderlink` */

DROP TABLE IF EXISTS `orderlink`;

CREATE TABLE `orderlink` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderlink` */

insert  into `orderlink` values (1,'手机'),(2,'平板'),(3,'笔记本电脑'),(4,'摄像头'),(5,'ipad'),(7,'surface pro 4'),(9,'水杯'),(28,'水壶'),(29,'音响'),(30,'台灯'),(31,'钢笔'),(34,'鼠标'),(36,'8849手机'),(37,'笔'),(38,'路由器'),(39,'air'),(40,'bbb'),(44,'显示器'),(45,'1'),(46,'2'),(47,'3'),(48,'4'),(49,'6'),(50,'1'),(51,'1'),(52,'2'),(53,'3'),(54,'4'),(55,'5'),(57,'7'),(58,'111'),(59,'1233'),(60,'444'),(61,'555'),(62,'1'),(63,'2'),(64,'123'),(67,'777'),(68,'888'),(69,'12345'),(70,'123114'),(71,'12312421'),(72,'1235'),(73,'154125'),(74,'121245'),(75,'6666'),(76,'9'),(77,'123444'),(78,'555555'),(79,'3121232'),(80,'998'),(81,'124123'),(83,'512312'),(84,'0'),(85,'qwe'),(86,'000'),(87,'12124124'),(88,'745'),(89,'r'),(90,'yh'),(91,'ij'),(92,'kl'),(93,'768'),(94,'纸'),(95,'999'),(96,'123'),(97,'333'),(98,'555'),(99,'1'),(100,'手机手机'),(122,'12313'),(129,'毛笔'),(130,'牙刷'),(131,'12312312'),(133,'大屏手机'),(134,'444'),(135,'123'),(136,'4445'),(137,'123'),(138,'1231'),(139,'11'),(140,'钢笔1'),(141,'1231313'),(142,'12'),(143,'无线电'),(144,'无线电1'),(145,'无线电12'),(146,'圆珠笔');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goods_id` int(10) NOT NULL,
  `count` int(10) NOT NULL,
  `total` float NOT NULL,
  `date` datetime DEFAULT NULL,
  `category` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders` values (5,36,1,8848,'2020-06-09 16:00:00','手机'),(9,1,1,8848,'2020-06-04 16:35:16','手机'),(10,2,1,2222,'2020-06-04 12:35:15','电脑'),(11,30,1,123,'2020-06-04 12:35:14','日用品'),(12,28,1,123,'2020-06-04 12:35:08','日用品'),(14,3,1,3333,'2020-06-04 12:36:00','电脑'),(15,3,1,3333,'2020-06-04 12:36:15','电脑'),(17,3,1,3333,'2020-06-04 12:36:25','电脑'),(20,29,1,123,'2020-06-04 12:38:07','电子配件'),(21,29,1,123,'2020-06-04 12:38:41','电子配件'),(25,4,1,4444,'2020-06-04 12:39:35','电子配件'),(34,9,1,123,'2020-06-04 12:49:17','日用品'),(39,4,5,1000,'2020-06-04 21:46:02','电子配件'),(40,7,1,3333,'2020-06-04 21:46:11','电脑'),(42,4,1,200,'2020-06-04 21:48:23','电子配件'),(43,2,1,2222,'2020-06-04 21:50:02','电脑'),(45,9,1,123,'2020-06-04 21:54:47','日用品'),(46,3,1,3333,'2020-06-05 09:36:19','电脑'),(47,37,1,1,'2020-06-05 09:40:07','日用品'),(52,3,1,3333,'2020-06-09 15:06:25','电脑'),(53,3,1,3333,'2020-06-09 15:06:26','电脑'),(54,3,1,3333,'2020-06-09 15:06:27','电脑'),(55,3,1,3333,'2020-06-09 15:06:35','电脑'),(56,3,1,3333,'2020-06-09 15:06:36','电脑'),(57,3,1,3333,'2020-06-09 15:06:37','电脑'),(58,3,1,3333,'2020-06-09 15:06:37','电脑'),(63,31,10,1230,'2020-06-09 15:10:27','日用品'),(64,4,10,2000,'2020-06-09 15:11:07','电子产品'),(66,3,1,3333,'2020-06-10 09:47:31','电脑'),(69,7,1,3333,'2020-06-10 13:48:29','电脑'),(70,1,1,1000,'2020-06-10 14:42:09','手机'),(72,1,1,1000,'2020-06-10 15:52:33','手机'),(74,30,1,123,'2020-06-10 15:53:05','日用品'),(75,1,1,1000,'2020-06-10 15:58:59','手机'),(76,34,1,22,'2020-06-11 14:46:31','电子产品'),(79,1,1,1000,'2020-06-11 19:59:21','手机'),(81,34,1,22,'2020-06-12 09:43:07','电子产品'),(82,1,1,1000,'2020-06-12 09:43:55','手机'),(84,1,1,1000,'2020-06-12 14:18:32','手机'),(85,1,1,1000,'2020-06-14 12:31:54','手机'),(86,1,1,1000,'2020-06-15 08:44:49','手机');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `level` varchar(20) NOT NULL,
  `kan` int(2) NOT NULL,
  `gai` int(2) NOT NULL,
  `shan` int(2) NOT NULL,
  PRIMARY KEY (`level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission` values ('1',1,0,0),('2',1,1,0),('3',1,1,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(20) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `position` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `level` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user` values (1,'Ao','123','张三','实习','1234',1),(2,'admin','123','李四','经理','12345',3),(3,'user','123','王五','员工','1234567',2),(4,'Rex','123','陈六','员工','12345667',2),(6,'alpha1','123','飞','实习','123123',1),(7,'guest123','123','陈五','实习','123123123',1),(9,'guest','123','李思思','员工','123456',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
