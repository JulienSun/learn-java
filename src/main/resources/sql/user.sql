drop table if exists user;
create table `user` (
                        `id` int not null auto_increment COMMENT '主键',
                        `username` varchar(32) default '' COMMENT '用户姓名',
                        `password` varchar(100) DEFAULT '' COMMENT '密码',
                        PRIMARY key(`id`)
);

insert into user VALUES ("1", "root", "$2a$10$2pTVv0xsQ8Q4yIvN9NdNmurfo7Q2.kCYfKUh2zth2dJQWxo6KMDRS");
insert into user VALUES ("2", "admin", "$2a$10$2pTVv0xsQ8Q4yIvN9NdNmurfo7Q2.kCYfKUh2zth2dJQWxo6KMDRS");
insert into user VALUES ("3", "user", "$2a$10$2pTVv0xsQ8Q4yIvN9NdNmurfo7Q2.kCYfKUh2zth2dJQWxo6KMDRS");


DROP TABLE IF EXISTS role;
create table `role` (
                        `id` int not null auto_increment,
                        `name` varchar(32) default null,
                        `nameZh` varchar(32) default null,
                        PRIMARY key(`id`)
);

insert into role values ('1', 'ROLE_dba', '数据库管理员');
insert into role values ('2', 'ROLE_admin', '系统管理员');
insert into role values ('3', 'ROLE_user', '用户');

drop table if exists user_role;
CREATE TABLE `user_role`(
                            `id` INT NOT NULL auto_increment,
                            `uid` int default null,
                            `rid` int default null,
                            PRIMARY key (`id`)
);


insert into user_role values ('1', '1', '1');
insert into user_role values ('2', '1', '2');
insert into user_role values ('3', '2', '2');
insert into user_role values ('4', '3', '3');
set FOREIGN_KEY_CHECKS = 1;


delete from user where id in (4, 5);
