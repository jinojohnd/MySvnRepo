-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: spring-security-tutorial
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `role`
--
CREATE SCHEMA `findb`;

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(254) NOT NULL,
  `last_name` varchar(254) NOT NULL,
  `name` varchar(254) NOT NULL,
  `password` varchar(254) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `tbl_user_role`
--

DROP TABLE IF EXISTS `tbl_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `tbl_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_employee` (
  `emp_id` int(15) NOT NULL AUTO_INCREMENT,
  `emp_no` varchar(254) NOT NULL,
  `active` varchar(1)NOT NULL,
  `email` varchar(254) NOT NULL,
  `emp_nm` varchar(254),
  `mobile` varchar(25),
  `manager_id` int(15) NOT NULL,
  `project_code` varchar(25),
  `project_name` varchar(254),
  `dob` date NOT NULL,
  `passport_no` varchar(254),
  `passport_issue_date` date,
  `passport_expiry_date` date,
  `tax_id` varchar(35), /*Refer to PAN*/
  `uid` varchar(35), /*Refer to Aadhar*/  
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `tbl_forex`;
CREATE TABLE `tbl_forex` (
  `forex_id` int(15) NOT NULL AUTO_INCREMENT,
  `emp_type` varchar(35) NOT NULL,
  `emp_nm` varchar(35)NOT NULL,
  `mother_nm` varchar(35) NOT NULL,
  `email` varchar(254)NOT NULL,
  `mobile` varchar(25) NOT NULL,
  `manager_nm` varchar(35)NOT NULL,
  `forex_card` int(15),
  `purpose_of_trip` varchar(254)NOT NULL,
  `billable` varchar(35) NOT NULL,
  `proj_code` varchar(35)NOT NULL,
  `proj_nm` varchar(254) NOT NULL,
  `opp_num` varchar(254)NOT NULL,
  `client_nm` varchar(35) NOT NULL,
  `dob_dt` date NOT NULL,
  `add_line_1` varchar(254) NOT NULL,
  `add_line_2` varchar(254)NOT NULL,
  `add_line_3` varchar(254) NOT NULL,
  `passport_num` varchar(35)NOT NULL,
  `passport_iss_dt` date NOT NULL,
  `passport_exp_dt` date NOT NULL,
  `city` varchar(254) NOT NULL,
  `uid` varchar(254)NOT NULL,
  `request_type` varchar(35) NOT NULL,
  `amt_in_cash` decimal(13,4) NOT NULL,
  `amt_on_card` decimal(13,4) NOT NULL,
  `total_amt` decimal(13,4) NOT NULL,
  `comments` varchar(254), 
  PRIMARY KEY (`forex_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tbl_itinerary`;
CREATE TABLE `tbl_itinerary` (
  `itinerary_id` int(15) NOT NULL AUTO_INCREMENT,
  `forex_id` int(15) NOT NULL,
  `departure_dt` date NOT NULL,
  `return_dt` date NOT NULL,
  `food_days` int (15)NOT NULL,
  `food_amt_per_day` decimal(13,4) NOT NULL,
  `food_total_amt` decimal(13,4) NOT NULL,
  `food_cur` varchar(3),
  `local_conveyance_days` int(15) NOT NULL,
  `local_conveyance_per_day` decimal(13,4) NOT NULL,
  `local_conveyance_total_amt` decimal(13,4) NOT NULL,
  `local_conveyance_cur` varchar(3) NOT NULL,
  `dest_city` varchar(254)NOT NULL,
  `hotel_days` int(15) NOT NULL,
  `hotel_per_day` decimal(13,4) NOT NULL,
  `hotel_total_amt` decimal(13,4) NOT NULL,
  `hotel_cur` varchar(3)NOT NULL,
  `dest_country` varchar(254) NOT NULL,
  `othr_days` int(15) NOT NULL,
  `othr_per_day` decimal(13,4) NOT NULL,
  `othr_total_amt` decimal(13,4) NOT NULL,
  `othr_cur` varchar(3) NOT NULL,
  PRIMARY KEY (`itinerary_id`),
  CONSTRAINT FK_ForexID FOREIGN KEY (forex_id)
  REFERENCES tbl_forex(`forex_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;