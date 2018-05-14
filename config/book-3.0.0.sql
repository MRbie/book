/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-14 18:43:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book_info`
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_sort_id` int(11) DEFAULT NULL,
  `book_name` varchar(15) DEFAULT NULL,
  `book_author` varchar(15) DEFAULT NULL,
  `book_price` decimal(5,2) DEFAULT NULL,
  `book_type` varchar(15) DEFAULT NULL,
  `book_publish` varchar(15) DEFAULT NULL,
  `book_sum` int(255) DEFAULT NULL,
  `book_mark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `book_sort_id` (`book_sort_id`),
  CONSTRAINT `book_info_ibfk_1` FOREIGN KEY (`book_sort_id`) REFERENCES `book_sort` (`book_sort_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES ('3', '2', 'Java', '别先生', '29.90', '物理类', '科学出版社', '24', null);
INSERT INTO `book_info` VALUES ('4', '2', 'hadoop', '别先生', '26.00', '科学类', '科学出版社', '25', null);

-- ----------------------------
-- Table structure for `book_sort`
-- ----------------------------
DROP TABLE IF EXISTS `book_sort`;
CREATE TABLE `book_sort` (
  `book_sort_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_sort_name` varchar(255) DEFAULT NULL,
  `book_sort_extend` varchar(255) DEFAULT NULL,
  `book_sort_mark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_sort_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_sort
-- ----------------------------
INSERT INTO `book_sort` VALUES ('1', '科学类', '科学类', '科学类');
INSERT INTO `book_sort` VALUES ('2', '物理类', '物理类', '物理类');
INSERT INTO `book_sort` VALUES ('3', '数学类', '数学类', '数学类');

-- ----------------------------
-- Table structure for `user_book`
-- ----------------------------
DROP TABLE IF EXISTS `user_book`;
CREATE TABLE `user_book` (
  `userBookId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `bookId` int(11) DEFAULT NULL,
  `userBookStatus` varchar(255) DEFAULT NULL,
  `userBookDate` datetime DEFAULT NULL,
  PRIMARY KEY (`userBookId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_book
-- ----------------------------
INSERT INTO `user_book` VALUES ('1', '1', '4', '借书', null);
INSERT INTO `user_book` VALUES ('2', '1', '3', '借书', null);
INSERT INTO `user_book` VALUES ('3', '1', '4', '借书', null);
INSERT INTO `user_book` VALUES ('4', '1', '4', '还书', null);
INSERT INTO `user_book` VALUES ('5', '1', '4', '借书', null);
INSERT INTO `user_book` VALUES ('6', '1', '4', '还书', null);
INSERT INTO `user_book` VALUES ('7', '1', '3', '借书', null);
INSERT INTO `user_book` VALUES ('8', '1', '3', '还书', null);
INSERT INTO `user_book` VALUES ('9', '1', '3', '借书', null);
INSERT INTO `user_book` VALUES ('10', '1', '3', '还书', null);
INSERT INTO `user_book` VALUES ('11', '1', '4', '借书', '2018-05-14 18:32:41');
INSERT INTO `user_book` VALUES ('12', '1', '4', '还书', '2018-05-14 18:32:52');
INSERT INTO `user_book` VALUES ('13', '1', '4', '还书', '2018-05-14 18:32:53');
INSERT INTO `user_book` VALUES ('14', '1', '4', '还书', '2018-05-14 18:32:55');
INSERT INTO `user_book` VALUES ('15', '1', '3', '还书', '2018-05-14 18:32:56');
INSERT INTO `user_book` VALUES ('16', '1', '3', '借书', '2018-05-14 18:32:58');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(15) DEFAULT NULL,
  `user_pw` varchar(15) DEFAULT NULL,
  `user_number` varchar(15) DEFAULT NULL,
  `user_name` varchar(10) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_sex` varchar(5) DEFAULT NULL,
  `user_mark` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', '123456', '123456789', '小别同志', '23', '保密', '管理员');
INSERT INTO `user_info` VALUES ('2', '小鱼', '123456', '1415925547', '于得水', '22', '男', null);
INSERT INTO `user_info` VALUES ('3', '小刘', '123456', '1415925548', '刘备', '23', '男', '1');
INSERT INTO `user_info` VALUES ('4', '111', '111', '111', '111', '111', '保密', '管理员');
INSERT INTO `user_info` VALUES ('5', '3333', '3333', '3333', '5555', '22', '保密', '管理员');
