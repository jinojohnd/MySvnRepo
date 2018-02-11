
use financedb;

/*Script for User Role*/
insert into tbl_employee (`emp_no`, `active`, `email`, `emp_nm`, `mobile`, `manager_id`, `manager_nm`,`project_code`, `project_name`, `dob`, `passport_no`, `passport_issue_date`, `passport_expiry_date`, `tax_id`, `uid`, `emp_role`,`sun_employee_id`,`id`,`er`,`region`,`transaction_prefix`,`third_party`,`export_to_open_air`,`login_access`)
values('E11325', 'A', 'jino.devasia@misys.com', 'Jino John Devasia', '9985558843', 'E11425', 'Manager 1', 'GMS', 'GMS Cloud', '1988-06-25','J413321', '2013-06-22', '2022-07-23', 'ERTY2345', 'ABF45RT','', '8763476','71045','710598-IN1 C George, Merin','India','IN1','NO','YES','YES');

insert into tbl_employee (`emp_no`, `active`, `email`, `emp_nm`, `mobile`, `manager_id`, `manager_nm`, `project_code`, `project_name`, `dob`, `passport_no`, `passport_issue_date`, `passport_expiry_date`, `tax_id`, `uid`, `emp_role`,`sun_employee_id`,`id`,`er`,`region`,`transaction_prefix`,`third_party`,`export_to_open_air`,`login_access`)
values('E11425', 'A', 'sapna.m@misys.com', 'Sapna', '9985553333', 'E11525', 'Director 1', 'GMS', 'GMS Cloud', '1978-01-21','A4SAF321', '2001-04-21', '2020-07-26', 'BGH23567', 'ZSERBF5RT', 'MANAGER', '8763476','719874','710598-IN1 C George, Merin','India','IN1','NO','YES','YES');

insert into tbl_employee (`emp_no`, `active`, `email`, `emp_nm`, `mobile`, `manager_id`, `manager_nm`, `project_code`, `project_name`, `dob`, `passport_no`, `passport_issue_date`, `passport_expiry_date`, `tax_id`, `uid`, `emp_role`,`sun_employee_id`,`id`,`er`,`region`,`transaction_prefix`,`third_party`,`export_to_open_air`,`login_access`)
values('E11625', 'A', 'anand.dhage@misys.com', 'Anand Dhage', '9985558843', 'E11725', 'Fin Manager 1', 'Finance', 'Finance Team', '1994-06-11','WEFT6413321', '2016-07-15', '2021-01-11', 'E123SAWE5', 'WERG3455RT', 'FINANCE', '8763476','700954','710598-IN1 C George, Merin','India','IN1','NO','YES','YES');

insert into tbl_employee (`emp_no`, `active`, `email`, `emp_nm`, `mobile`, `manager_id`, `manager_nm`, `project_code`, `project_name`, `dob`, `passport_no`, `passport_issue_date`, `passport_expiry_date`, `tax_id`, `uid`, `emp_role`,`sun_employee_id`,`id`,`er`,`region`,`transaction_prefix`,`third_party`,`export_to_open_air`,`login_access`)
values('E11725', 'A', 'dheeraj.s@misys.com', 'Dheeraj S', '9985558843', 'E11726', 'Fin Manager 2', 'Finance', 'Finance Team', '1994-06-11','WEFT6413321', '2016-07-15', '2021-01-11', 'E123SAWE5', 'WERG3455RT', 'FINANCE', '8763476','78754','710598-IN1 C George, Merin','India','IN1','NO','YES','YES');

insert into tbl_employee (`emp_no`, `active`, `email`, `emp_nm`, `mobile`, `manager_id`, `manager_nm`, `project_code`, `project_name`, `dob`, `passport_no`, `passport_issue_date`, `passport_expiry_date`, `tax_id`, `uid`, `emp_role`,`sun_employee_id`,`id`,`er`,`region`,`transaction_prefix`,`third_party`,`export_to_open_air`,`login_access`)
values('E11726', 'A', 'Patrick.s@misys.com', 'Patrick', '9985558843', 'E11000', 'Fin Approver', 'Finance', 'Finance Team', '1994-06-11','WEFT6413321', '2016-07-15', '2021-01-11', 'E123SAWE5', 'WERG3455RT', 'FINANCE', '8763476','71057','710598-IN1 C , Merin','India','IN1','NO','YES','YES');


/*Script for User Role*/
INSERT INTO `tbl_user`
(`user_id`,
`active`,
`email`,
`last_name`,
`name`,
`password`)
VALUES (1, 'Y', 'jino.devasia@misys.com','devasia','jino','$2a$10$MY/ShrPo4NlbYNESei1Wme9hyyD8sD4uCZlvhqyWi1bUfB.xQhdei');

INSERT INTO `tbl_user`
(`user_id`,
`active`,
`email`,
`last_name`,
`name`,
`password`)
VALUES (2, 'Y', 'sapna.m@misys.com','m','sapna','$2a$10$MY/ShrPo4NlbYNESei1Wme9hyyD8sD4uCZlvhqyWi1bUfB.xQhdei');

INSERT INTO `tbl_user`
(`user_id`,
`active`,
`email`,
`last_name`,
`name`,
`password`)
VALUES (3, 'Y', 'anand.dhage@misys.com','dhage','anand','$2a$10$MY/ShrPo4NlbYNESei1Wme9hyyD8sD4uCZlvhqyWi1bUfB.xQhdei');

INSERT INTO `tbl_user`
(`user_id`,
`active`,
`email`,
`last_name`,
`name`,
`password`)
VALUES (4, 'Y', 'dheeraj.s@misys.com','s','dheeraj','$2a$10$MY/ShrPo4NlbYNESei1Wme9hyyD8sD4uCZlvhqyWi1bUfB.xQhdei');

INSERT INTO `tbl_user`
(`user_id`,
`active`,
`email`,
`last_name`,
`name`,
`password`)
VALUES (5, 'Y', 'patrick.s@misys.com','s','patrick','$2a$10$MY/ShrPo4NlbYNESei1Wme9hyyD8sD4uCZlvhqyWi1bUfB.xQhdei');



/*Script for User Role*/
INSERT INTO tbl_Role VALUES (1,'ADMIN');
INSERT INTO tbl_Role VALUES (2,'ROLE_EMP_USER');
INSERT INTO tbl_Role VALUES (3,'ROLE_EMP_MGR');
INSERT INTO tbl_Role VALUES (4,'ROLE_FIN_USR');
INSERT INTO tbl_Role VALUES (5,'ROLE_FIN_MGR');
INSERT INTO tbl_Role VALUES (6,'ROLE_APPROVER');


/*Script for User Role*/
INSERT INTO `tbl_user_role`
(`user_id`,
`role_id`,`role_name`)
VALUES (1,2,'ROLE_EMP_USER');

INSERT INTO `tbl_user_role`
(`user_id`,
`role_id`,`role_name`)
VALUES (2,2,'ROLE_EMP_USER');

INSERT INTO `tbl_user_role`
(`user_id`,
`role_id`,`role_name`)
VALUES (3,2,'ROLE_EMP_USER');

INSERT INTO `tbl_user_role`
(`user_id`,
`role_id`,`role_name`)
VALUES (4,2,'ROLE_EMP_USER');

INSERT INTO `tbl_user_role`
(`user_id`,
`role_id`,`role_name`)
VALUES (5,2,'ROLE_EMP_USER');

INSERT INTO `tbl_user_role`
(`user_id`,
`role_id`,`role_name`)
VALUES (2,3,'ROLE_EMP_MGR');

INSERT INTO `tbl_user_role`
(`user_id`,
`role_id`,`role_name`)
VALUES (3,4,'ROLE_FIN_USR');

INSERT INTO `tbl_user_role`
(`user_id`,
`role_id`,`role_name`)
VALUES (4,5,'ROLE_FIN_MGR');

INSERT INTO `tbl_user_role`
(`user_id`,
`role_id`,`role_name`)
VALUES (5,6,'ROLE_APPROVER');



/*Script for User Role*/

Insert into tbl_holidays() VALUES(1,'2018-01-01','New Year');
Insert into tbl_holidays() VALUES(2,'2018-01-26','Republic Day');
Insert into tbl_holidays() VALUES(3,'2018-01-30','Bangalore Bandh');