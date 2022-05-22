/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : weblogs

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 14/04/2022 12:54:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dw_pvs_everyhour_oneday
-- ----------------------------
DROP TABLE IF EXISTS `dw_pvs_everyhour_oneday`;
CREATE TABLE `dw_pvs_everyhour_oneday`  (
  `month` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月份',
  `day` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日期',
  `hour` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小时',
  `pvs` int(11) NULL DEFAULT NULL COMMENT '每天浏览量'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dw_pvs_everyhour_oneday
-- ----------------------------
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 07', 13);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 08', 11);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 09', 14);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 10', 3);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 11', 2);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 12', 4);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 13', 5);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 14', 1);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 15', 2);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 16', 1);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 17', 4);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 19', 1);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 22', 1);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '18', ' 23', 1);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '19', ' 00', 4);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '19', ' 02', 2);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '19', ' 03', 5);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '19', ' 04', 1);
INSERT INTO `dw_pvs_everyhour_oneday` VALUES ('09', '19', ' 05', 1);