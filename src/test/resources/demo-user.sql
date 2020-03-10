/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-06-23 14:25:27
*/
--
--  docker run -itd --name mysql_as -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql
--


-- ----------------------------
-- create database
-- ----------------------------
show databases ;
create database agricultural_system;
use agricultural_system;


-- ----------------------------
-- Table structure for user
-- ----------------------------

DROP TABLE IF EXISTS `user`;


CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `username` varchar(255) NOT NULL,
                        `password` varchar(255) NOT NULL,
                        `reg_time` datetime NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for types
-- ----------------------------


DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
                        `tid` int(11) NOT NULL AUTO_INCREMENT,
                        `type_name` varchar(255) NOT NULL,
                        `describe` varchar(255) NOT NULL,
                        `type_time` datetime  NOT NULL,
                        PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for product
-- ----------------------------

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                         `pid` int(11) NOT NULL AUTO_INCREMENT,
                         `product_name` varchar(255) NOT NULL,
                         `tid` int(11) NOT NULL,
                         `url` varchar(255) NOT NULL ,
                         `type_time` datetime  NOT NULL,
                         PRIMARY KEY (`pid`),
                         FOREIGN KEY (`tid`) REFERENCES types(tid)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for news
-- ----------------------------


DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
                           `nid` int(11) NOT NULL AUTO_INCREMENT,
                           `news_title` varchar(255) NOT NULL,
                           `url` varchar(255) NOT NULL ,
                           `type_time` datetime  NOT NULL,
                           PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for contact
-- ----------------------------

DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
                        `cid` int(11) NOT NULL AUTO_INCREMENT,
                        `company_name` varchar(255) NOT NULL,
                        `contacts` varchar(255) NOT NULL ,
                        `address` varchar(255) NOT NULL ,
                        `phone` varchar(11) NOT NULL ,
                        `telephone` varchar(12) NOT NULL ,
                        `fax` varchar(255) NOT NULL ,
                        `e_mail` varchar(255) NOT NULL ,
                        `zip_code` varchar(255) NOT NULL ,
                        `qq` varchar(255) NOT NULL ,
                        PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for introduce
-- ----------------------------

DROP TABLE IF EXISTS `introduce`;
CREATE TABLE `introduce` (
                        `iid` int(11) NOT NULL AUTO_INCREMENT,
                        `company_name` varchar(255) NOT NULL,
                        `contacts` varchar(255) NOT NULL,
                        `management_model` varchar(255) NOT NULL,
                        `company_introduce` varchar(255) NOT NULL,
                        `logo` varchar(255) NOT NULL ,
                        PRIMARY KEY (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for product (update)
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                           `pid` int(11) NOT NULL AUTO_INCREMENT,
                           `product_name` varchar(255) NOT NULL,
                           `url` varchar(255) NOT NULL ,
                           `type_time` datetime  NOT NULL,
                           PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product_types
-- ----------------------------
DROP TABLE IF EXISTS `product_types`;
CREATE TABLE `product_types` (
                           `pid` int(11) NOT NULL,
                           `tid` int(11) NOT NULL ,
                           FOREIGN KEY (`tid`) REFERENCES types(tid),
                           FOREIGN KEY (`pid`) REFERENCES product(pid)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `company_message`;
CREATE TABLE `company_message` (
                             `cmid` int(11) NOT NULL AUTO_INCREMENT,
                             `company_name` varchar(255) NOT NULL,
                             `contacts` varchar(255) NOT NULL,
                             PRIMARY KEY (`cmid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `contact_cm`;
CREATE TABLE `contact_cm` (
                                 `cid` int(11) NOT NULL,
                                 `cmid` int(11) NOT NULL ,
                                 FOREIGN KEY (`cid`) REFERENCES contact(cid),
                                 FOREIGN KEY (`cmid`) REFERENCES company_message(cmid)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `introduce_cm`;
CREATE TABLE `introduce_cm` (
                              `iid` int(11) NOT NULL,
                              `cmid` int(11) NOT NULL ,
                              FOREIGN KEY (`iid`) REFERENCES introduce(iid),
                              FOREIGN KEY (`cmid`) REFERENCES company_message(cmid)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

------

DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
                        `cid` int(11) NOT NULL AUTO_INCREMENT,
                        `address` varchar(255) NOT NULL ,
                        `phone` varchar(11) NOT NULL ,
                        `telephone` varchar(12) NOT NULL ,
                        `fax` varchar(255) NOT NULL ,
                        `e_mail` varchar(255) NOT NULL ,
                        `zip_code` varchar(255) NOT NULL ,
                        `qq` varchar(255) NOT NULL ,
                        PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `introduce`;
CREATE TABLE `introduce` (
                        `iid` int(11) NOT NULL AUTO_INCREMENT,
                        `management_model` varchar(255) NOT NULL,
                        `company_introduce` varchar(255) NOT NULL,
                        `logo` varchar(255) NOT NULL ,
                        PRIMARY KEY (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;