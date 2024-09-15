/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.9 : Database - weapon_detection
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`weapon_detection` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `weapon_detection`;

/*Table structure for table `attendance` */

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`attendance_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `attendance` */

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` int(11) DEFAULT NULL,
  `branch_name` varchar(20) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `place` varchar(20) DEFAULT NULL,
  `latitude` varchar(1000) DEFAULT NULL,
  `longitude` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `branch` */

insert  into `branch`(`branch_id`,`login_id`,`branch_name`,`phone_number`,`email`,`place`,`latitude`,`longitude`) values 
(4,19,'SBI Thrissur','9895642358','sbitcr@gmail.com','thrissur','9.988293036447752','9.988293036447752'),
(5,44,'SBI palakkad','9946956286','sbipkd@dfmdn','palakkad','9.988293036447752','76.28811836242676');

/*Table structure for table `complaint` */

DROP TABLE IF EXISTS `complaint`;

CREATE TABLE `complaint` (
  `complaint_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) DEFAULT NULL,
  `complaint` varchar(50) DEFAULT NULL,
  `reply` varchar(50) DEFAULT NULL,
  `date` int(11) DEFAULT NULL,
  PRIMARY KEY (`complaint_id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `complaint` */

/*Table structure for table `complaints` */

DROP TABLE IF EXISTS `complaints`;

CREATE TABLE `complaints` (
  `complaint_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) DEFAULT NULL,
  `complaint_details` varchar(200) DEFAULT NULL,
  `reply` varchar(50) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`complaint_id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `complaints` */

/*Table structure for table `designation` */

DROP TABLE IF EXISTS `designation`;

CREATE TABLE `designation` (
  `designation_id` int(11) NOT NULL AUTO_INCREMENT,
  `designation_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`designation_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `designation` */

insert  into `designation`(`designation_id`,`designation_name`) values 
(16,'Staff'),
(9,'Branch'),
(14,'maintenance'),
(13,'police');

/*Table structure for table `emergency` */

DROP TABLE IF EXISTS `emergency`;

CREATE TABLE `emergency` (
  `emergency_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `emergency` varchar(50) DEFAULT NULL,
  `latitude` varchar(20) DEFAULT NULL,
  `longitude` varchar(20) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`emergency_id`)
) ENGINE=MyISAM AUTO_INCREMENT=110 DEFAULT CHARSET=latin1;

/*Data for the table `emergency` */

insert  into `emergency`(`emergency_id`,`user_id`,`emergency`,`latitude`,`longitude`,`status`) values 
(1,4,'Weaponn/Violenecedetect','0','0','sendsms'),
(2,4,'Weaponn/Violenecedetect','0','0','sendsms'),
(3,4,'jvhv','10.522522522522522','76.21869171841422','sendsms'),
(4,4,'Weaponn/Violenecedetect','0','0','pending'),
(5,4,'Weaponn/Violenecedetect','0','0','pending'),
(6,4,'Weaponn/Violenecedetect','0','0','pending'),
(7,4,'Weaponn/Violenecedetect','0','0','pending'),
(8,4,'Weaponn/Violenecedetect','0','0','pending'),
(9,4,'Weaponn/Violenecedetect','0','0','pending'),
(10,4,'Weaponn/Violenecedetect','0','0','pending'),
(11,4,'Weaponn/Violenecedetect','0','0','pending'),
(12,4,'Weaponn/Violenecedetect','0','0','pending'),
(13,4,'Weaponn/Violenecedetect','0','0','pending'),
(14,4,'Weaponn/Violenecedetect','0','0','pending'),
(15,4,'Weaponn/Violenecedetect','0','0','pending'),
(16,4,'Weaponn/Violenecedetect','0','0','pending'),
(17,4,'Weaponn/Violenecedetect','0','0','pending'),
(18,4,'Weaponn/Violenecedetect','0','0','pending'),
(19,4,'Weaponn/Violenecedetect','0','0','pending'),
(20,4,'Weaponn/Violenecedetect','0','0','pending'),
(21,4,'Weaponn/Violenecedetect','0','0','pending'),
(22,4,'Weaponn/Violenecedetect','0','0','pending'),
(23,4,'Weaponn/Violenecedetect','0','0','pending'),
(24,4,'Weaponn/Violenecedetect','0','0','pending'),
(25,4,'Weaponn/Violenecedetect','0','0','pending'),
(26,4,'Weaponn/Violenecedetect','0','0','pending'),
(27,4,'Weaponn/Violenecedetect','0','0','pending'),
(28,4,'Weaponn/Violenecedetect','0','0','pending'),
(29,4,'Weaponn/Violenecedetect','0','0','pending'),
(30,4,'Weaponn/Violenecedetect','0','0','pending'),
(31,4,'Weaponn/Violenecedetect','0','0','pending'),
(32,4,'Weaponn/Violenecedetect','0','0','pending'),
(33,4,'Weaponn/Violenecedetect','0','0','pending'),
(34,4,'Weaponn/Violenecedetect','0','0','pending'),
(35,4,'Weaponn/Violenecedetect','0','0','pending'),
(36,4,'Weaponn/Violenecedetect','0','0','pending'),
(37,4,'Weaponn/Violenecedetect','0','0','pending'),
(38,4,'Weaponn/Violenecedetect','0','0','pending'),
(39,4,'Weaponn/Violenecedetect','0','0','pending'),
(40,4,'Weaponn/Violenecedetect','0','0','pending'),
(41,4,'Weaponn/Violenecedetect','0','0','pending'),
(42,4,'Weaponn/Violenecedetect','0','0','pending'),
(43,4,'Weaponn/Violenecedetect','0','0','pending'),
(44,4,'Weaponn/Violenecedetect','0','0','pending'),
(45,4,'Weaponn/Violenecedetect','0','0','pending'),
(46,4,'Weaponn/Violenecedetect','0','0','pending'),
(47,4,'Weaponn/Violenecedetect','0','0','pending'),
(48,4,'Weaponn/Violenecedetect','0','0','pending'),
(49,4,'Weaponn/Violenecedetect','0','0','pending'),
(50,4,'Weaponn/Violenecedetect','0','0','pending'),
(51,5,'Weaponn/Violenecedetect','0','0','pending'),
(52,5,'Weaponn/Violenecedetect','0','0','pending'),
(53,5,'Weaponn/Violenecedetect','0','0','pending'),
(54,5,'Weaponn/Violenecedetect','0','0','pending'),
(55,5,'Weaponn/Violenecedetect','0','0','pending'),
(56,5,'Weaponn/Violenecedetect','0','0','pending'),
(57,5,'Weaponn/Violenecedetect','0','0','pending'),
(58,5,'Weaponn/Violenecedetect','0','0','pending'),
(59,5,'Weaponn/Violenecedetect','0','0','pending'),
(60,5,'Weaponn/Violenecedetect','0','0','pending'),
(61,5,'Weaponn/Violenecedetect','0','0','pending'),
(62,5,'Weaponn/Violenecedetect','0','0','pending'),
(63,5,'Weaponn/Violenecedetect','0','0','pending'),
(64,5,'Weaponn/Violenecedetect','0','0','pending'),
(65,5,'Weaponn/Violenecedetect','0','0','pending'),
(66,5,'Weaponn/Violenecedetect','0','0','pending'),
(67,5,'Weaponn/Violenecedetect','0','0','pending'),
(68,5,'Weaponn/Violenecedetect','0','0','pending'),
(69,5,'Weaponn/Violenecedetect','0','0','pending'),
(70,5,'Weaponn/Violenecedetect','0','0','pending'),
(71,5,'Weaponn/Violenecedetect','0','0','pending'),
(72,5,'Weaponn/Violenecedetect','0','0','pending'),
(73,5,'Weaponn/Violenecedetect','0','0','pending'),
(74,5,'Weaponn/Violenecedetect','0','0','pending'),
(75,5,'Weaponn/Violenecedetect','0','0','pending'),
(76,5,'Weaponn/Violenecedetect','0','0','pending'),
(77,5,'Weaponn/Violenecedetect','0','0','pending'),
(78,5,'Weaponn/Violenecedetect','0','0','pending'),
(79,5,'Weaponn/Violenecedetect','0','0','pending'),
(80,5,'Weaponn/Violenecedetect','0','0','pending'),
(81,4,'Weaponn/Violenecedetect','0','0','pending'),
(82,5,'Weaponn/Violenecedetect','0','0','pending'),
(83,5,'Weaponn/Violenecedetect','0','0','pending'),
(84,5,'Weaponn/Violenecedetect','0','0','pending'),
(85,5,'Weaponn/Violenecedetect','0','0','pending'),
(86,5,'Weaponn/Violenecedetect','0','0','pending'),
(87,5,'Weaponn/Violenecedetect','0','0','pending'),
(88,4,'Weaponn/Violenecedetect','0','0','pending'),
(89,4,'Weaponn/Violenecedetect','0','0','pending'),
(90,4,'Weaponn/Violenecedetect','0','0','pending'),
(91,4,'Weaponn/Violenecedetect','0','0','pending'),
(92,4,'Weaponn/Violenecedetect','0','0','pending'),
(93,4,'Weaponn/Violenecedetect','0','0','pending'),
(94,4,'Weaponn/Violenecedetect','0','0','pending'),
(95,4,'Weaponn/Violenecedetect','0','0','pending'),
(96,4,'Weaponn/Violenecedetect','0','0','pending'),
(97,4,'Weaponn/Violenecedetect','0','0','pending'),
(98,4,'Weaponn/Violenecedetect','0','0','pending'),
(99,4,'Weaponn/Violenecedetect','0','0','pending'),
(100,4,'Weaponn/Violenecedetect','0','0','pending'),
(101,4,'Weaponn/Violenecedetect','0','0','pending'),
(102,4,'Weaponn/Violenecedetect','0','0','pending'),
(103,4,'Weaponn/Violenecedetect','0','0','pending'),
(104,4,'Weaponn/Violenecedetect','0','0','pending'),
(105,4,'Weaponn/Violenecedetect','0','0','pending'),
(106,4,'Weaponn/Violenecedetect','0','0','pending'),
(107,4,'Weaponn/Violenecedetect','0','0','pending'),
(108,4,'Weaponn/Violenecedetect','0','0','pending'),
(109,4,'Weaponn/Violenecedetect','0','0','pending');

/*Table structure for table `images` */

DROP TABLE IF EXISTS `images`;

CREATE TABLE `images` (
  `img_id` int(10) NOT NULL AUTO_INCREMENT,
  `images` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`img_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `images` */

insert  into `images`(`img_id`,`images`) values 
(1,'static/video30a53483-0547-451f-8c45-9cc2e13f9c6b5e8da860a7c3a578a27dabbf431e43ca.png'),
(2,'static/4619d40c-c135-48c5-b10a-68fec7681041eden-kiritsuke-close.jpg'),
(3,'static/8f2088e6-74b3-4674-983b-7299016afe1cvideo.mp4'),
(4,'static/28d2594f-b784-45f1-b15a-3911a7b77ab3malignant (8).png');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `user_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=MyISAM AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`login_id`,`user_name`,`password`,`user_type`) values 
(1,'admin','admin','admin'),
(19,'br1','br1','branch'),
(44,'mini','1312','branch'),
(69,'milk','2409','maintenance'),
(71,'vichu','6','police'),
(74,'pooja','2425','police');

/*Table structure for table `maintenance` */

DROP TABLE IF EXISTS `maintenance`;

CREATE TABLE `maintenance` (
  `maintenance_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(20) DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `login_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`maintenance_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `maintenance` */

insert  into `maintenance`(`maintenance_id`,`company_name`,`phone_number`,`email`,`login_id`) values 
(12,'pk',5665567,'pk@gmail.com',69);

/*Table structure for table `notification` */

DROP TABLE IF EXISTS `notification`;

CREATE TABLE `notification` (
  `notification_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `notification_details` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `notification` */

/*Table structure for table `police` */

DROP TABLE IF EXISTS `police`;

CREATE TABLE `police` (
  `police_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` int(11) DEFAULT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `place` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`police_id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*Data for the table `police` */

insert  into `police`(`police_id`,`login_id`,`first_name`,`last_name`,`phone_number`,`email`,`place`) values 
(6,74,'POOJA','RAGAVU','9065431240','pooja@gmail','THRISSUR'),
(4,71,'VARUN','KUMAR','9087563217','varun@gmail.com','PALAKKAD');

/*Table structure for table `request` */

DROP TABLE IF EXISTS `request`;

CREATE TABLE `request` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `request` varchar(1000) DEFAULT NULL,
  `video_audio` varchar(1000) DEFAULT NULL,
  `out` varchar(1000) DEFAULT NULL,
  `status` varchar(1000) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`request_id`)
) ENGINE=MyISAM AUTO_INCREMENT=109 DEFAULT CHARSET=latin1;

/*Data for the table `request` */

insert  into `request`(`request_id`,`user_id`,`request`,`video_audio`,`out`,`status`,`type`) values 
(1,4,'request','static/video/47d9e088-e652-4ac6-b1db-5b5fc05c03a0.png','0','Forward To Police','Video'),
(2,4,'request','static/video/5f68213e-0497-41e4-b5af-e448ce12c5fe.png','0','Forward To Police','Video'),
(3,4,'request','static/video/35eb0935-b4d1-46ed-940a-af7f53bfec43.png','0','Forward To Police','Video'),
(4,4,'request','static/video/b138c74c-2c15-47d3-b366-12f1eabe28e0.png','0','Forward To Police','Video'),
(5,4,'request','static/video/8a27c4c6-7e0a-4e1d-bee5-ed2a1e100d3a.png','0','Forward To Police','Video'),
(6,4,'request','static/video/232720ba-9bf5-4c6d-824a-eed9e2dd29fb.png','0','Forward To Police','Video'),
(7,4,'request','static/video/402e44c1-8730-4b32-927d-5d77596bd59f.png','0','Forward To Police','Video'),
(8,4,'request','static/video/2e1da1a6-03cb-40ce-b407-3c682aba3856.png','0','Forward To Police','Video'),
(9,4,'request','static/video/bfccb7bd-b03c-49ae-b95b-bb22fbb9e0b7.png','0','Forward To Police','Video'),
(10,4,'request','static/video/1b30e178-48a9-4526-bc81-1e416a8db15e.png','0','Forward To Police','Video'),
(11,4,'request','static/video/f772432c-a9eb-4d2e-a230-6a14c69c0f92.png','0','Forward To Police','Video'),
(12,4,'request','static/video/f382709b-8157-4f90-bc58-5d56da036732.png','0','Forward To Police','Video'),
(13,4,'request','static/video/2ad49a46-eab2-484b-9b00-00eb89bdf5df.png','0','Forward To Police','Video'),
(14,4,'request','static/video/1c2e0556-d26f-488c-9151-5e4059aa8a76.png','0','Forward To Police','Video'),
(15,4,'request','static/video/172e6259-adc9-4f32-bba6-b64755fb9d24.png','0','Forward To Police','Video'),
(16,4,'request','static/video/f97f9b6e-b031-4e7e-9ca2-ea6f2d962dea.png','0','Forward To Police','Video'),
(17,4,'request','static/video/7082d673-0367-478e-a505-7ecb8f9f3547.png','0','Forward To Police','Video'),
(18,4,'request','static/video/58f1b7ed-fe52-45b8-b98a-4c69a6c9dd15.png','0','Forward To Police','Video'),
(19,4,'request','static/video/2bb4d282-4cf2-40dd-b43e-5fdd1f2f0037.png','0','Forward To Police','Video'),
(20,4,'request','static/video/136b02b3-d3fa-463c-bff9-1263b4c07600.png','0','Forward To Police','Video'),
(21,4,'request','static/video/1b0db983-0d70-417e-a2e7-fec37db4411c.png','0','Forward To Police','Video'),
(22,4,'request','static/video/5f45e3d3-58c0-41c2-8908-3cd048f255b6.png','0','Forward To Police','Video'),
(23,4,'request','static/video/e448a5b4-9774-4d12-b442-b734aadfb7f6.png','0','Forward To Police','Video'),
(24,4,'request','static/video/ac2b8bcd-16cd-4a84-9471-1eae97591709.png','0','Forward To Police','Video'),
(25,4,'request','static/video/a4fbdeae-7c85-4430-82df-4188def0d2a7.png','0','Forward To Police','Video'),
(26,4,'request','static/video/98ce2179-3fea-4845-87ca-05233c445025.png','0','Forward To Police','Video'),
(27,4,'request','static/video/1f675f35-1593-4cf3-a0fb-1f54db56f44b.png','0','Forward To Police','Video'),
(28,4,'request','static/video/9a8852de-8b81-42d3-ac97-0fcd49333de1.png','0','Forward To Police','Video'),
(29,4,'request','static/video/4274be9c-6bcc-4f54-9b7e-80750840aa43.png','0','Forward To Police','Video'),
(30,4,'request','static/video/94a42e38-26db-440e-b2a0-ae19422e958d.png','0','Forward To Police','Video'),
(31,4,'request','static/video/61f2f437-c1b2-4386-9a76-a52390ef609d.png','0','Forward To Police','Video'),
(32,4,'request','static/video/cb4944ed-854c-4bb1-a8aa-237200aec937.png','0','Forward To Police','Video'),
(33,4,'request','static/video/f898e548-f50f-4633-800e-9e31a8165bbc.png','0','Forward To Police','Video'),
(34,4,'request','static/video/1d26f9d0-3296-47ca-b21f-042d7e6f7bbd.png','0','Forward To Police','Video'),
(35,4,'request','static/video/265f2db3-8f21-4263-b5e4-b161b68b6eb1.png','0','Forward To Police','Video'),
(36,4,'request','static/video/1a845172-ee61-4fe0-9f07-386cea8d4148.png','0','Forward To Police','Video'),
(37,4,'request','static/video/8dbfadd8-ed45-4866-bd5b-57d53c2841c8.png','0','Forward To Police','Video'),
(38,4,'request','static/video/0d510f32-53e5-4613-84be-854154c75aaa.png','0','Forward To Police','Video'),
(39,4,'request','static/video/a48d799b-0f1a-428d-85a0-74128227a61f.png','0','Forward To Police','Video'),
(40,4,'request','static/video/5d8000f8-5c8a-46b1-9d7a-4e6b53639f24.png','0','Forward To Police','Video'),
(41,4,'request','static/video/a563de47-b346-46db-b933-526e1ae45261.png','0','Forward To Police','Video'),
(42,4,'request','static/video/db8c09db-5782-4933-b374-5f8509685488.png','0','Forward To Police','Video'),
(43,4,'request','static/video/e16d7afa-9ab1-435f-bd26-29185e65e5d9.png','0','Forward To Police','Video'),
(44,4,'request','static/video/88db2cc7-bb05-4e30-9f9c-83c2feee648d.png','0','Forward To Police','Video'),
(45,4,'request','static/video/15296ce6-a0f1-4887-a6de-89eeea31a33d.png','0','Forward To Police','Video'),
(46,4,'request','static/video/279706ee-c512-4a4b-ad77-2b20f6a88bfb.png','0','Forward To Police','Video'),
(47,4,'request','static/video/40dab917-bedc-429f-899d-1189fa73b3f7.png','0','Forward To Police','Video'),
(48,4,'request','static/video/33913d4c-52d2-40b8-b2cc-f02484fbea9f.png','0','Forward To Police','Video'),
(49,4,'request','static/video/df13db2c-7aa9-429a-98c5-f7441c13e9b0.png','0','Forward To Police','Video'),
(50,5,'request','static/video/1b97b615-493c-4890-a67f-7fffb1178b7d.png','0','Forward To Police','Video'),
(51,5,'request','static/video/055cceb5-e7eb-4ac6-9067-81e54f6efd08.png','0','Forward To Police','Video'),
(52,5,'request','static/video/736c6999-6d93-4cdb-911f-2228cf0a23ec.png','0','Forward To Police','Video'),
(53,5,'request','static/video/bff8536b-43cd-41e3-a855-6804bc05b2cb.png','0','Forward To Police','Video'),
(54,5,'request','static/video/c7a34b0c-dd6b-4258-a5c6-17f661c78fa5.png','0','Forward To Police','Video'),
(55,5,'request','static/video/8769b9a4-8c09-4d16-87ef-b19fd06dfd60.png','0','Forward To Police','Video'),
(56,5,'request','static/video/da46d1e9-f382-4057-8992-d608ae7a69b8.png','0','Forward To Police','Video'),
(57,5,'request','static/video/ca19bbf6-0999-4f6c-b803-4b34519c863e.png','0','Forward To Police','Video'),
(58,5,'request','static/video/6bf4302f-1df1-45be-95ed-a824efcd96d6.png','0','Forward To Police','Video'),
(59,5,'request','static/video/d4bf6bb7-8a2e-4e09-961a-e41459d23957.png','0','Forward To Police','Video'),
(60,5,'request','static/video/6c335228-f081-44c9-ad50-29d70a0b2c29.png','0','Forward To Police','Video'),
(61,5,'request','static/video/55842835-272e-4137-8548-d78bf5286b82.png','0','Forward To Police','Video'),
(62,5,'request','static/video/8546d9a9-120e-4d71-9fc8-4af7c58eb511.png','0','Forward To Police','Video'),
(63,5,'request','static/video/a51284be-1b80-4858-b01d-24d341c3649b.png','0','Forward To Police','Video'),
(64,5,'request','static/video/eccd4501-4a4a-408f-abd8-d0511846c558.png','0','Forward To Police','Video'),
(65,5,'request','static/video/7bd19967-1f4a-49de-8504-1ed13105e994.png','0','Forward To Police','Video'),
(66,5,'request','static/video/4e2245a3-f873-41b3-b695-09620986687e.png','0','Forward To Police','Video'),
(67,5,'request','static/video/fba52abd-afb5-43a7-abfe-c5167730581f.png','0','Forward To Police','Video'),
(68,5,'request','static/video/b2c8b350-3e86-4cc8-8afb-0434b2edb15b.png','0','Forward To Police','Video'),
(69,5,'request','static/video/b26d4584-a91a-4555-a8b0-201c12648ba7.png','0','Forward To Police','Video'),
(70,5,'request','static/video/257b71ad-cb65-4634-a170-1b2f930d6593.png','0','Forward To Police','Video'),
(71,5,'request','static/video/81becdf7-7a4b-47db-96c5-03f3a49f661c.png','0','Forward To Police','Video'),
(72,5,'request','static/video/1c7c1130-d241-43e0-83fc-2fbec99d8f10.png','0','Forward To Police','Video'),
(73,5,'request','static/video/850cc4a9-17cc-42b9-87c5-286673f5b38c.png','0','Forward To Police','Video'),
(74,5,'request','static/video/e6f17bd7-9ac8-4ef5-93cf-0982e6ac2acb.png','0','Forward To Police','Video'),
(75,5,'request','static/video/3ff29697-7dec-48f5-b13b-d06675adae58.png','0','Forward To Police','Video'),
(76,5,'request','static/video/fd096cdd-8d49-41fe-a2f7-c37749db667a.png','0','Forward To Police','Video'),
(77,5,'request','static/video/7129d80b-6bef-4bb0-8e2e-8d369db76660.png','0','Forward To Police','Video'),
(78,5,'request','static/video/7975c15f-296d-44e6-9c5f-ed32b0a67d9e.png','0','Forward To Police','Video'),
(79,5,'request','static/video/1f326e5b-a71e-4d29-a9a9-afe0ceabd56a.png','0','Forward To Police','Video'),
(80,4,'request','static/video/b9432586-de46-465b-bd95-090c5d601782.png','0','Forward To Police','Video'),
(81,5,'request','static/video/90d78c8d-3744-4be8-8181-c3d71ac787f2.png','0','Forward To Police','Video'),
(82,5,'request','static/video/2524552e-5fd9-49be-96a8-586ec9e36d16.png','0','Forward To Police','Video'),
(83,5,'request','static/video/aff7a02e-492d-46af-850d-ba5c382b8e52.png','0','Forward To Police','Video'),
(84,5,'request','static/video/96b8b06c-e197-4a6a-b5e7-463bc10b46e0.png','0','Forward To Police','Video'),
(85,5,'request','static/video/37cc814c-0285-411f-95ac-6abe0fadceda.png','0','Forward To Police','Video'),
(86,5,'request','static/video/767e69f7-d5c7-4b0f-a49f-17b4607f09ea.png','0','Forward To Police','Video'),
(87,4,'request','static/video/3d6136c7-c03f-49c4-8ee6-6b89abec8f73.png','0','Forward To Police','Video'),
(88,4,'request','static/video/2e2438df-ebdc-46f3-9f15-054db50c5ccb.png','0','Forward To Police','Video'),
(89,4,'request','static/video/98c96fd7-2b60-48ae-a103-8f27a92a5513.png','0','Forward To Police','Video'),
(90,4,'request','static/video/8e140540-4839-481a-a29d-7388f5350be9.png','0','Forward To Police','Video'),
(91,4,'request','static/video/6625579c-8b5b-413b-915d-347cd0203f8f.png','0','Forward To Police','Video'),
(92,4,'request','static/video/77cd7afb-7e68-402c-9edc-ab2871908d50.png','0','Forward To Police','Video'),
(93,4,'request','static/video/fd1445f1-ef8d-48bd-8d5b-dfc35f3d6d77.png','0','Forward To Police','Video'),
(94,4,'request','static/video/3b22b64d-5d5c-4520-9899-b56b66bb4b87.png','0','Forward To Police','Video'),
(95,4,'request','static/video/3f104c14-0b2d-4e8b-9816-05bcd4585543.png','0','Forward To Police','Video'),
(96,4,'request','static/video/ea4eaa7a-83b8-4a17-9440-6fecb0a9df5e.png','0','Forward To Police','Video'),
(97,4,'request','static/video/881909b7-5ab6-4298-b1c7-29faeae8872b.png','0','Forward To Police','Video'),
(98,4,'request','static/video/d6617476-6bd0-44ff-a998-934a90415192.png','0','Forward To Police','Video'),
(99,4,'request','static/video/3e8ae8fb-6b46-472f-a733-69ee2b6ddf61.png','0','Forward To Police','Video'),
(100,4,'request','static/video/258a91d6-47c4-4fc9-b974-592dfc26819c.png','0','Forward To Police','Video'),
(101,4,'request','static/video/5df26269-b896-42c3-a09c-c094c18cf713.png','0','Forward To Police','Video'),
(102,4,'request','static/video/65cd6fe7-5770-4911-96ce-8349b1398ced.png','0','Forward To Police','Video'),
(103,4,'request','static/video/78bade58-2216-4255-afa6-1b623ddf227e.png','0','Forward To Police','Video'),
(104,4,'request','static/video/42a41ec5-42f9-4aa5-be74-8cdcc8b4511e.png','0','Forward To Police','Video'),
(105,4,'request','static/video/5137f4cb-92a6-4300-918d-2676f12e4092.png','0','Forward To Police','Video'),
(106,4,'request','static/video/37aacf91-f391-4235-aacb-12086b771419.png','0','Forward To Police','Video'),
(107,4,'request','static/video/b55efbd9-eec0-49e0-9da1-9ffb7b1bd444.png','0','Forward To Police','Video'),
(108,4,'request','static/video/3485e7d8-6557-420f-ac06-35f3619d4ebc.png','0','Forward To Police','Video');

/*Table structure for table `sendcomplaint` */

DROP TABLE IF EXISTS `sendcomplaint`;

CREATE TABLE `sendcomplaint` (
  `complaint_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) DEFAULT NULL,
  `complaint` varchar(50) DEFAULT NULL,
  `reply` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`complaint_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `sendcomplaint` */

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` int(11) DEFAULT NULL,
  `designation_id` int(11) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `staff` */

insert  into `staff`(`staff_id`,`login_id`,`designation_id`,`branch_id`,`first_name`,`last_name`,`dob`,`phone_number`,`email`) values 
(3,14,8,4,'ammu','km','2023-03-29','4556467892','anu@gmail.com');

/*Table structure for table `staffsendcomplaint` */

DROP TABLE IF EXISTS `staffsendcomplaint`;

CREATE TABLE `staffsendcomplaint` (
  `complaint_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) DEFAULT NULL,
  `complaint_details` varchar(200) DEFAULT NULL,
  `reply` varchar(200) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`complaint_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `staffsendcomplaint` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
