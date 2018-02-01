use financedb;

INSERT INTO tbl_Role VALUES (1,'ADMIN');

INSERT INTO `financedb`.`tbl_user`
(`user_id`,
`active`,
`email`,
`last_name`,
`name`,
`password`)
VALUES (7, 1, 'userfortest@gmail.com','test','user','$2a$10$MY/ShrPo4NlbYNESei1Wme9hyyD8sD4uCZlvhqyWi1bUfB.xQhdei');

INSERT INTO `financedb`.`tbl_user_role`
(`user_id`,
`role_id`)
VALUES (7,1);