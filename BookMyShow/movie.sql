DROP DATABASE IF EXISTS BookMyShow;

CREATE DATABASE `BookMyShow`;
USE BookMyShow;



DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL ,
  `email` varchar(55) NOT NULL ,
  `mobileNo` BigInt(15) NOT NULL,
  `password` varchar(20) NOT NULL ,
  PRIMARY KEY (`id`)
) ;

insert into user (name,email,mobileNo,password) values ("rahul","rahul@gmail.com", 9661713931,"rahul123");

DROP TABLE IF EXISTS `myShow`;

DROP TABLE IF EXISTS `runningMovie`;
CREATE TABLE `runningMovie` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(80) DEFAULT NULL,
  `genere` varchar(55) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `director` varchar(50) DEFAULT NULL,
  `startDate` varchar(50) DEFAULT NULL,
  `endDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
insert into runningMovie (title, genere, duration, director,startDate, endDate) values ('padhmawat', 'epic',122,'manikandan', '20181121','20181231');



CREATE TABLE `myShow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mId` int(11) unsigned  NOT NULL,
  `screen` int(11) DEFAULT NULL,
  `slot` int(11) DEFAULT NULL,
  `booked` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
   FOREIGN KEY (mid) REFERENCES `runningMovie`(`id`) ON DELETE CASCADE
) ;

INSERT INTO myShow (mId, screen, slot, booked) VALUES (1,1,1,1),(1,2,2,2),(1,3,3,1);


