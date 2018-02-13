CREATE SCHEMA `financedb`;

DROP TABLE IF EXISTS `tbl_itinerary`;
DROP TABLE IF EXISTS `tbl_forex_details`;
DROP TABLE IF EXISTS `tbl_forex`;
DROP TABLE IF EXISTS `tbl_user_role`;
DROP TABLE IF EXISTS `tbl_role`;
DROP TABLE IF EXISTS `tbl_user`;
DROP TABLE IF EXISTS `tbl_employee`;
DROP TABLE IF EXISTS `tbl_country_cur`;
DROP TABLE IF EXISTS `tbl_holidays`;
DROP TABLE IF EXISTS `tbl_file_attachments`;

CREATE TABLE `tbl_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(254) NOT NULL,
  `role_description` varchar(254) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` varchar(1) NOT NULL,
  `email` varchar(254) NOT NULL,
  `last_name` varchar(254) NOT NULL,
  `name` varchar(254) NOT NULL,
  `password` varchar(254) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



CREATE TABLE `tbl_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `role_name` varchar(254) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


		CREATE TABLE `tbl_employee` (
	  `emp_id` int(15) NOT NULL AUTO_INCREMENT,
	  `emp_no` varchar(254) NOT NULL,
	  `active` varchar(1)NOT NULL,
	  `email` varchar(254) NOT NULL,
	  `emp_nm` varchar(254),
	  `mobile` varchar(25),
	  `manager_id` varchar(50) NOT NULL,  
	  `manager_nm` varchar(50) NOT NULL,
	  `project_code` varchar(25),
	  `project_name` varchar(254),
	  `dob` date NOT NULL,
	  `passport_no` varchar(254),
	  `passport_issue_date` date,
	  `passport_expiry_date` date,
	  `tax_id` varchar(35), /*Refer to PAN*/
	  `uid` varchar(35), /*Refer to Aadhar*/ 
	  `emp_role` varchar(50), 
	  `sun_employee_id` varchar(255) NOT NULL,
	  `old_id` varchar(255),
	  `id` varchar(255) NOT NULL,
	  `er` varchar(255) NOT NULL,
	  `old_er` varchar(255),
	  `cost_center` varchar(255),
	  `product` varchar(255),
	  `region` varchar(255) NOT NULL,
	  `transaction_prefix` varchar(255) NOT NULL,
	  `third_party` varchar(3) NOT NULL,
	  `export_to_open_air` varchar(3) NOT NULL,
	  `job_title` varchar(255),
	  `oa_department` varchar(255),
	  `expense_currency` varchar(3),
	  `login_access` varchar(3)  NOT NULL,
	  `job_level` varchar(2),
	  `cc` varchar(3),
	  `termination_date` date,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `tbl_forex` (
  `forex_id` int(15) NOT NULL AUTO_INCREMENT,
  `emp_type` varchar(35) NOT NULL,
  `emp_nm` varchar(35)NOT NULL,
  `mother_nm` varchar(35) NOT NULL,
  `email` varchar(254)NOT NULL,
  `mobile` varchar(25) NOT NULL,
  `manager_nm` varchar(35)NOT NULL,
  `forex_card` varchar(20)NOT NULL,
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
  `comments` varchar(254),
  `creation_dt` date NOT NULL,
  `status` varchar (20) NOT NULL,
  `input_user_mail` varchar(254)NOT NULL,  
  PRIMARY KEY (`forex_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `tbl_itinerary` (
  `itinerary_id` int(15) NOT NULL AUTO_INCREMENT,
  `forex_id` int(15) NOT NULL,
  `departure_dt` date NOT NULL,
  `return_dt` date NOT NULL,
  `food_days` int (15)NOT NULL,
  `food_per_day` decimal(13,2) NOT NULL,
  `food_total_amt` decimal(13,2) NOT NULL,
  `food_cur` varchar(3),
  `local_conveyance_days` int(15) NOT NULL,
  `local_conveyance_per_day` decimal(13,2) NOT NULL,
  `local_conveyance_total_amt` decimal(13,2) NOT NULL,
  `local_conveyance_cur` varchar(3) NOT NULL,
  `dest_city` varchar(254)NOT NULL,
  `hotel_days` int(15) NOT NULL,
  `hotel_per_day` decimal(13,2) NOT NULL,
  `hotel_total_amt` decimal(13,2) NOT NULL,
  `hotel_cur` varchar(3)NOT NULL,
  `dest_country` varchar(254) NOT NULL,
  `othr_days` int(15) NOT NULL,
  `othr_per_day` decimal(13,2) NOT NULL,
  `othr_total_amt` decimal(13,2) NOT NULL,
  `othr_cur` varchar(3) NOT NULL,
  `itr_total_amt` decimal(13,2) NOT NULL,
  `amt_in_cash` decimal(13,2) NOT NULL,
  `amt_on_card` decimal(13,2) NOT NULL,
  `itr_cur` varchar(3) NOT NULL,
  PRIMARY KEY (`itinerary_id`),
  CONSTRAINT FK_ForexID FOREIGN KEY (forex_id)
  REFERENCES tbl_forex(`forex_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `tbl_country_cur` (
	`id` int(15) NOT NULL AUTO_INCREMENT,
	`country_name` varchar(255),
    `currency_name` varchar(255),
    `currency_code` varchar(3),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_holidays` (
	`holiday_id` int(15) NOT NULL AUTO_INCREMENT,
	`date` date NOT NULL,
    `description` varchar(255),
    PRIMARY KEY (`holiday_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_forex_details` (
  `forex_dtls_id` int(15) NOT NULL AUTO_INCREMENT,
  `forex_id` int(15) NOT NULL,
  `amt_in_cash` decimal(13,2) NOT NULL,
  `amt_on_card` decimal(13,2) NOT NULL,
  `total_amt` decimal(13,2) NOT NULL,
  `currency` varchar(3),
  PRIMARY KEY (`forex_dtls_id`),
  CONSTRAINT FK_Forex_Dtls FOREIGN KEY (forex_id)
  REFERENCES tbl_forex(`forex_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_file_attachments` (
	`file_id` int(15) NOT NULL AUTO_INCREMENT,
	`forex_id` int(15) NOT NULL,
	`file_name` varchar(50) NOT NULL,
    `file_type` varchar(5) NOT NULL,
    `file_content` longblob NOT NULL,
    PRIMARY KEY (`file_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
