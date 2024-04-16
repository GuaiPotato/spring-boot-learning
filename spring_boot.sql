/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : spring_boot

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 09/04/2024 10:00:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for list
-- ----------------------------
DROP TABLE IF EXISTS `list`;
CREATE TABLE `list`  (
  `view_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `followers_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_following` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `banner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `updated` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of list
-- ----------------------------
INSERT INTO `list` VALUES ('23873853', '19', '0', '知乎上的四川', 'https://pic1.zhimg.com/100/v2-a7556006256fbd78267bf95de518ead8_hd.png', '1711336783', '1755552296522809344');
INSERT INTO `list` VALUES ('42950399', '469', '0', '筑梦现代化 共绘新图景', 'https://pic3.zhimg.com/100/v2-177d867d2f8a6c524c435c1293a6c7ea_hd.png', '1710126826', '1747379177022484480');
INSERT INTO `list` VALUES ('17921917', '73', '0', '龙腾九州 福满京华', 'https://pic2.zhimg.com/100/v2-2c6f40ee00546ec179f3a078fee98995_hd.png', '1708674232', '1735694700215025664');
INSERT INTO `list` VALUES ('3396490', '44', '0', '聚焦2024河南两会', 'https://pic3.zhimg.com/100/v2-f5683e85a229582bdfa3a46f8221a82e_hd.png', '1706421034', '1734281263714783232');
INSERT INTO `list` VALUES ('43010579', '116', '0', '‘京•彩’新征程之经济展望', 'https://pic3.zhimg.com/100/v2-1f666d7156738412641fde754527a572_hd.png', '1706607879', '1728132030431174656');
INSERT INTO `list` VALUES ('1510254', '73', '0', '2024丨元旦快乐', 'https://pic3.zhimg.com/100/v2-0400467a50c4da522c7d46ff051d830a_hd.png', '1704067304', '1722667261330825216');
INSERT INTO `list` VALUES ('291172083', '132', '0', '见证丨改革开放45周年', 'https://pic1.zhimg.com/100/v2-9eab849ba36d4a6eb496ee0662be3a64_hd.png', '1702620480', '1717590279350284288');
INSERT INTO `list` VALUES ('444', '114', '0', '大咖聊网安', 'https://pic2.zhimg.com/100/v2-264c0641465123df00873b5ce64f9539_hd.png', '1701424282', '1713612084858806274');
INSERT INTO `list` VALUES ('232189944', '7', '0', '向科学要答案', 'https://pic3.zhimg.com/100/v2-62e6250c565a270e76fa6f37ef52d326_hd.png', '1710221969', '1713143889211383808');
INSERT INTO `list` VALUES ('38530407', '771', '0', '品好书｜读懂优秀文化', 'https://pic3.zhimg.com/100/v2-a29c52831db46bff1d425012a3511446_hd.png', '1698672097', '1700933764044173312');

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `author` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作者',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `content` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 105 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES (103, 'dezckd', 'Spring Boot JPA 1', 'Spring Boot JPA 1');
INSERT INTO `t_article` VALUES (104, 'tyler', 'Spring Boot MyBatis', 'Spring Boot MyBatis');

-- ----------------------------
-- Table structure for t_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz`  (
  `clazz_id` int NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `clazz_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `teacher_id` int NOT NULL COMMENT '班级管理老师的id',
  PRIMARY KEY (`clazz_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
INSERT INTO `t_clazz` VALUES (1, '后端开发班', 1);
INSERT INTO `t_clazz` VALUES (2, '前端开发班', 2);

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course`  (
  `course_id` int NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES (20001, '后端工程化开发');
INSERT INTO `t_course` VALUES (20002, '前端工程化开发');

-- ----------------------------
-- Table structure for t_course_student
-- ----------------------------
DROP TABLE IF EXISTS `t_course_student`;
CREATE TABLE `t_course_student`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_id` int NOT NULL COMMENT '课程id',
  `student_id` int NOT NULL COMMENT '学生id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_course_student
-- ----------------------------
INSERT INTO `t_course_student` VALUES (1, 20001, 1001);
INSERT INTO `t_course_student` VALUES (2, 20001, 1002);
INSERT INTO `t_course_student` VALUES (3, 20001, 1003);
INSERT INTO `t_course_student` VALUES (4, 20001, 1004);
INSERT INTO `t_course_student` VALUES (5, 20001, 1005);
INSERT INTO `t_course_student` VALUES (6, 20001, 1006);
INSERT INTO `t_course_student` VALUES (7, 20001, 1007);
INSERT INTO `t_course_student` VALUES (8, 20001, 1008);
INSERT INTO `t_course_student` VALUES (9, 20002, 1001);
INSERT INTO `t_course_student` VALUES (10, 20002, 1002);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `student_id` int NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `clazz_id` int NOT NULL COMMENT '学生所属班级的id',
  `student_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `hometown` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生籍贯',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8017 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, 1, '1', '1', '1111-11-11');
INSERT INTO `t_student` VALUES (1001, 1, '1', '1', '1111-11-11');
INSERT INTO `t_student` VALUES (1002, 1, '李智康', '江苏无锡', '2000-02-18');
INSERT INTO `t_student` VALUES (1003, 1, '张智康', '江苏常州', '2000-03-18');
INSERT INTO `t_student` VALUES (1004, 1, '王智康', '江苏南京', '2000-04-18');
INSERT INTO `t_student` VALUES (1005, 1, '孙志康', '江苏徐州', '2001-05-18');
INSERT INTO `t_student` VALUES (1006, 2, '周志康', '江苏泰州', '2001-06-18');
INSERT INTO `t_student` VALUES (1007, 2, '郭志康', '江苏扬州', '2001-07-18');
INSERT INTO `t_student` VALUES (1008, 2, '陈志康', '江苏盐城', '2001-08-18');
INSERT INTO `t_student` VALUES (1010, 10, 'tyler', '南京', '1111-11-11');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `teacher_id` int NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `teacher_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `clazz_id` int NOT NULL COMMENT '教师管理的班级id',
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (1, '许老师', 1);
INSERT INTO `t_teacher` VALUES (2, '张老师', 2);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` bigint NOT NULL,
  `section_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1700934332091437056, '中国传统文化');
INSERT INTO `tag` VALUES (1700934389817622528, '中国近现代革命史');
INSERT INTO `tag` VALUES (1700934443966107648, '北京红色历史文化');
INSERT INTO `tag` VALUES (1700934497342816256, '「一轴三带」历史文化');
INSERT INTO `tag` VALUES (1700934550413328384, '北京都城之源');
INSERT INTO `tag` VALUES (1713144535260196864, '向科学要答案');
INSERT INTO `tag` VALUES (1713958450277752832, '聚焦网络安全 畅聊数字科技');
INSERT INTO `tag` VALUES (1717591164016771073, '改革影响丨45周年成绩单');
INSERT INTO `tag` VALUES (1717591239623585792, '岁月如梭丨改革开放的重要意义');
INSERT INTO `tag` VALUES (1717598858803105792, '中国速度丨外国人眼中的改革开放');
INSERT INTO `tag` VALUES (1717598953867198464, '向未来出发丨新时代的风貌');
INSERT INTO `tag` VALUES (1722674154770313216, '收获 2023');
INSERT INTO `tag` VALUES (1722684105983209472, ' 期待 2024');
INSERT INTO `tag` VALUES (1722687175496466432, '难忘 2023');
INSERT INTO `tag` VALUES (1722689810790268928, '元旦典故');
INSERT INTO `tag` VALUES (1728134303655964673, '政策解读');
INSERT INTO `tag` VALUES (1728134372400721921, '经济新增长');
INSERT INTO `tag` VALUES (1728134440893489153, '经济新闻');
INSERT INTO `tag` VALUES (1728134505032916992, '京城观察');
INSERT INTO `tag` VALUES (1734283305841434624, '“链”上河南造');
INSERT INTO `tag` VALUES (1734283388213645312, '两会财经访谈');
INSERT INTO `tag` VALUES (1734283452038561792, '河南出圈记');
INSERT INTO `tag` VALUES (1734686492570742785, '河南两会声音');
INSERT INTO `tag` VALUES (1734905810058846208, '解读政府工作报告');
INSERT INTO `tag` VALUES (1735701045710450688, '团圆乐事');
INSERT INTO `tag` VALUES (1735701146944172032, '祈福迎祥');
INSERT INTO `tag` VALUES (1735701461890318336, '春满人间');
INSERT INTO `tag` VALUES (1735701519196844032, '年货大集');
INSERT INTO `tag` VALUES (1744041440827588608, '元宵喜乐');
INSERT INTO `tag` VALUES (1747379762920583170, '两会声音');
INSERT INTO `tag` VALUES (1747379943917490177, '两会热议');
INSERT INTO `tag` VALUES (1747384072702447616, '两会科普');
INSERT INTO `tag` VALUES (1747393101021171713, '两会热词');
INSERT INTO `tag` VALUES (1747672587361173504, '聚焦两会');
INSERT INTO `tag` VALUES (1748319114500956160, '政府工作报告');
INSERT INTO `tag` VALUES (1755552490500956160, '四川生活');
INSERT INTO `tag` VALUES (1755552592808419328, '四川过春节');
INSERT INTO `tag` VALUES (1755552637028974592, '四川过春天');
INSERT INTO `tag` VALUES (1755552696822992897, '四川过夏天');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint NULL DEFAULT 0 COMMENT '1、删除 0、未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'test用户名', '10002', '女', NULL, '2024-04-01 21:17:24', 0);
INSERT INTO `user` VALUES (3, '张三丰', '10003', '男', NULL, NULL, 1);
INSERT INTO `user` VALUES (5, '王三', '10007', '男', '2024-04-01 14:32:34', NULL, 0);
INSERT INTO `user` VALUES (6, '王四', '10005', '男', NULL, NULL, 0);
INSERT INTO `user` VALUES (7, '王五', '10006', '男', NULL, NULL, 0);
INSERT INTO `user` VALUES (12, '李57', '1002147483647', '女', '2024-04-01 21:16:09', '2024-04-01 21:16:09', 1);

-- ----------------------------
-- Table structure for zhihu
-- ----------------------------
DROP TABLE IF EXISTS `zhihu`;
CREATE TABLE `zhihu`  (
  `id` bigint NOT NULL,
  `view_count` bigint NULL DEFAULT NULL,
  `followers_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_following` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `banner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `updated` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhihu
-- ----------------------------
INSERT INTO `zhihu` VALUES (1700933764044173312, 38521679, '767', '1', '品好书｜读懂优秀文化', 'https://pic3.zhimg.com/100/v2-a29c52831db46bff1d425012a3511446_hd.png', '1698672097');
INSERT INTO `zhihu` VALUES (1713143889211383808, 232030673, '4', '0', '向科学要答案', 'https://pic3.zhimg.com/100/v2-62e6250c565a270e76fa6f37ef52d326_hd.png', '1710221969');
INSERT INTO `zhihu` VALUES (1713612084858806274, 441, '114', '0', '大咖聊网安', 'https://pic2.zhimg.com/100/v2-264c0641465123df00873b5ce64f9539_hd.png', '1701424282');
INSERT INTO `zhihu` VALUES (1717590279350284288, 290846574, '132', '1', '见证丨改革开放45周年', 'https://pic1.zhimg.com/100/v2-9eab849ba36d4a6eb496ee0662be3a64_hd.png', '1702620480');
INSERT INTO `zhihu` VALUES (1722667261330825216, 1509215, '72', '0', '2024丨元旦快乐', 'https://pic3.zhimg.com/100/v2-0400467a50c4da522c7d46ff051d830a_hd.png', '1704067304');
INSERT INTO `zhihu` VALUES (1728132030431174656, 43003103, '116', '0', '‘京•彩’新征程之经济展望', 'https://pic3.zhimg.com/100/v2-1f666d7156738412641fde754527a572_hd.png', '1706607879');
INSERT INTO `zhihu` VALUES (1734281263714783232, 3396055, '40', '1', '聚焦2024河南两会', 'https://pic3.zhimg.com/100/v2-f5683e85a229582bdfa3a46f8221a82e_hd.png', '1706421034');
INSERT INTO `zhihu` VALUES (1735694700215025664, 17920454, '70', '0', '龙腾九州 福满京华', 'https://pic2.zhimg.com/100/v2-2c6f40ee00546ec179f3a078fee98995_hd.png', '1708674232');
INSERT INTO `zhihu` VALUES (1747379177022484480, 42467668, '459', '0', '筑梦现代化 共绘新图景', 'https://pic3.zhimg.com/100/v2-177d867d2f8a6c524c435c1293a6c7ea_hd.png', '1710126826');
INSERT INTO `zhihu` VALUES (1755552296522809344, 23614755, '1', '0', '知乎上的四川', 'https://pic1.zhimg.com/100/v2-a7556006256fbd78267bf95de518ead8_hd.png', '1711336783');

SET FOREIGN_KEY_CHECKS = 1;
