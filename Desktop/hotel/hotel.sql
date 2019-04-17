/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.25-log : Database - hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hotel`;

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_type` int(11) DEFAULT NULL,
  `room_price` decimal(10,0) DEFAULT '0',
  `room_breakfast` int(11) DEFAULT '-1',
  `room_area` decimal(10,0) DEFAULT '0',
  `room_user` int(11) DEFAULT NULL,
  `room_high` int(11) DEFAULT '0',
  PRIMARY KEY (`room_id`),
  KEY `room_user` (`room_user`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`room_user`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `room` */

insert  into `room`(`room_id`,`room_type`,`room_price`,`room_breakfast`,`room_area`,`room_user`,`room_high`) values 
(2,4,1277,1,40,2,28),
(3,1,305,1,40,6,13),
(4,1,385,1,40,6,13),
(5,4,1275,1,52,NULL,48),
(6,2,840,1,40,6,7),
(7,2,850,1,39,NULL,7),
(8,1,299,1,40,NULL,6),
(9,1,209,1,40,NULL,13),
(10,1,261,1,40,NULL,13),
(11,5,580,1,40,6,18),
(12,1,270,1,52,NULL,13),
(13,5,93,0,52,NULL,13),
(14,5,109,0,52,NULL,13),
(15,5,65,1,52,NULL,13),
(16,1,189,1,39,NULL,13),
(17,5,415,1,39,NULL,13),
(18,5,702,1,458,NULL,15),
(19,5,1213,1,868,NULL,6),
(20,5,340,1,78,6,25),
(25,5,599,1,52,NULL,13),
(26,5,486,1,40,NULL,13),
(27,5,585,0,40,NULL,1),
(28,5,636,0,52,NULL,5),
(29,5,1354,1,40,NULL,9),
(30,4,300,1,45,NULL,8),
(31,4,796,1,40,NULL,13),
(32,4,779,1,52,NULL,13),
(33,4,480,1,40,6,13),
(34,1,140,1,40,6,13),
(35,3,38,1,48,NULL,5),
(36,3,59,1,58,NULL,7);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `user_account` varchar(32) CHARACTER SET latin1 DEFAULT NULL,
  `user_phone` varchar(12) CHARACTER SET latin1 DEFAULT NULL,
  `user_identity` int(11) DEFAULT NULL,
  `user_password` varchar(32) CHARACTER SET latin1 DEFAULT NULL,
  `user_idnumber` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_account`,`user_phone`,`user_identity`,`user_password`,`user_idnumber`) values 
(2,'HRZGJ','8632340092b','13509897398',0,'9cbf8a4dcb8e30682b927f352d6559a0','445102199912041936'),
(3,'cyyy','863234009E','13509897398',0,'9cbf8a4dcb8e30682b927f352d6559a0','445102199912041936'),
(5,'yc','863234009c','13509897398',1,'9cbf8a4dcb8e30682b927f352d6559a0','445102199912041936'),
(6,'陈宇','863234009a','13509897398',1,'9cbf8a4dcb8e30682b927f352d6559a0','445102199912041936'),
(7,'huangenima','a123456','13413779543',0,'60bcb86064911b27d385dbb29a5cc0d3','445102199912041936'),
(9,'czz','863234009d','13509897398',0,'9cbf8a4dcb8e30682b927f352d6559a0','445102199912041936'),
(10,'jj','863234009b','13509897398',0,'9cbf8a4dcb8e30682b927f352d6559a0','445102199912041935');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
