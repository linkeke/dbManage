/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.17 : Database - demoba
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demoba` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `demoba`;

/*Table structure for table `t_advice` */

DROP TABLE IF EXISTS `t_advice`;

CREATE TABLE `t_advice` (
  `n_advice_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '意见反馈ID',
  `c_advice_content` varchar(500) DEFAULT NULL COMMENT '意见反馈内容',
  `t_create_time` datetime DEFAULT NULL,
  `n_create_id` bigint(20) DEFAULT NULL COMMENT '创建人员ID',
  PRIMARY KEY (`n_advice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_advice` */

/*Table structure for table `t_article` */

DROP TABLE IF EXISTS `t_article`;

CREATE TABLE `t_article` (
  `n_article_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_article_title` varchar(500) DEFAULT NULL COMMENT '文章标题',
  `c_article_content` longtext COMMENT '文章内容，json',
  `c_content_html` longtext COMMENT '文章内容，html',
  `c_article_tag` varchar(100) DEFAULT NULL COMMENT '文章标签',
  `c_article_imgs` varchar(2000) DEFAULT NULL COMMENT '文章图片#分割',
  `t_create_time` datetime DEFAULT NULL COMMENT '发布时间',
  `t_update_time` datetime DEFAULT NULL,
  `n_create_id` bigint(20) DEFAULT NULL COMMENT '发布人员ID',
  `n_article_type` int(11) DEFAULT '1' COMMENT '1用户文章2学校文章3系统文章4机构文章',
  `n_top` int(1) DEFAULT '0' COMMENT '置顶操作',
  `n_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`n_article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_article` */

insert  into `t_article`(`n_article_id`,`c_article_title`,`c_article_content`,`c_content_html`,`c_article_tag`,`c_article_imgs`,`t_create_time`,`t_update_time`,`n_create_id`,`n_article_type`,`n_top`,`n_status`) values (4,'为什么要这么孤独呢1','[{\"imgUrl\":\"http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/fe2b4fe2f9844e67b169ccb0ab7e4f31.jpg\"},{\"content\":\"理想中的男友又高又帅，他只比我高一点 也不怎么帅，要是搁以前早分手了，但这个只能带他去健身房 帮他搭配衣服，有什么办法，他以后是我老公。\"},{\"content\":\" 五十八天前，我爱上了一个来自安徽铜陵的姑娘。她是一个无比优秀，有魅力的那一款女生。那天，我和她漫步在湖边，感觉身边的她，就是我一直在寻找的另一半，默契、健谈是我和她第一次约会最大的感受，那一刻，生活中全部的烦恼都已经抛在脑后，我只知道，我深深的被她吸引了1。五十一天前是情人节，真的很高兴她答应了和我约会，我总是想带她熟悉这座城市，希望她会喜欢上这里的一切，包括我。虽然只是准备了一盒巧克力，但是这是我第一次这么用心的去包装一份礼物，就连丝带蝴蝶结的长度都考量过，小心翼翼的把自己的一份心意送给她，意外的收获了她的拥抱，那晚，星星真的很亮2。\"},{\"imgUrl\":\"http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/2aedd776ae6c46f69920d64ae0628c0f.jpg\"}]','<p><br></p><p><img src=\"http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/fe2b4fe2f9844e67b169ccb0ab7e4f31.jpg\" alt=\"undefined\"></p><p><span>理想中的男友又高又帅，他只比我高一点 也不怎么帅，要是搁以前早分手了，但这个只能带他去健身房 帮他搭配衣服，有什么办法，他以后是我老公。</span></p><div><div>&nbsp;五十八天前，我爱上了一个来自安徽铜陵的姑娘。她是一个无比优秀，有魅力的那一款女生。那天，我和她漫步在湖边，感觉身边的她，就是我一直在寻找的另一半，默契、健谈是我和她第一次约会最大的感受，那一刻，生活中全部的烦恼都已经抛在脑后，我只知道，我深深的被她吸引了1。</div><br><p><img src=\"http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/2aedd776ae6c46f69920d64ae0628c0f.jpg\" alt=\"undefined\"></p><div><div>五十一天前是情人节，真的很高兴她答应了和我约会，我总是想带她熟悉这座城市，希望她会喜欢上这里的一切，包括我。虽然只是准备了一盒巧克力，但是这是我第一次这么用心的去包装一份礼物，就连丝带蝴蝶结的长度都考量过，小心翼翼的把自己的一份心意送给她，意外的收获了她的拥抱，那晚，星星真的很亮2。</div><br><br></div></div>',NULL,'http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/fe2b4fe2f9844e67b169ccb0ab7e4f31.jpg#http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/2aedd776ae6c46f69920d64ae0628c0f.jpg','2017-09-15 15:26:20','2017-09-15 15:27:03',NULL,1,0,NULL),(5,'上班的人怎样自学英语？','[{\"content\":\"擦，碰上一个很适合我的问题，怒答！就是依靠下班时间，先把词汇背个十遍八遍的啊我当时想到自学英语时候2012年3月，已经毕业快五年了（2007年7月毕业），期间工作都用不到英语。我利用业余时间，把考研词汇背了二十遍，时间花费大概七个月，没办法，刚开始嘛。。。反正有时候一天才背20个单词，就这样。当然，第一遍背完之后，再背就容易多了，一遍比一遍快。最后一遍也就是我一天就能解决。后来就开始做中口真题，后来复习了大概五个月，笔试过了（2013年4月）。后来，口试没过（就考了一次）。今年九月份（2014年9月）去考了高级口译笔试，应该也没过，因为我只是去试试。在这之前我已经背了专八词汇8遍，BBC听了五个月了。这些都是在我的业余时间学的，中午休息一个小时可以听一篇五分钟的BBC，精听，约花费30分钟。五点下班以后花费二到三个小时听BBC做高口练习题。自从今年九月份高口笔试受挫之后，我就开始做高口练习题和真题了。我备考时候压根就没做高口复习题和真题。只是听了五个月BBC和背了八遍专八词汇。因为，发觉阅读也很重要，还有翻译。如何练好听力，那就是词汇是基础，然后做阅读，阅读可以促进听力，翻译中，就是试着把译文背下来呗。十一期间，我每天精听两篇五分钟的BBC,做一篇汉译英。上班之后大概每天也是这样。。。由于背了专八词汇，词汇已经基本上没啥问题了。（这是我在《考拉小巫的英语学习日记》里学到的，如果你想让自己在词汇上没有障碍，就背完专八词汇）Ps如果你真的想学英语，一定要有把词汇背下来的毅力，不然那是空谈。我公司有几个老同事，年龄大约35到40岁之间，公司给他们报了几万元的韦博英语，最后都没有提高耶，翻译写邮件还得找我帮忙。。。因为他们私底下都没有认真学，只是每周末去上两节课。。。最后推荐一个听BBC的应用，可可英语，这个是有中英文对照的，可以一句一句听，我觉得超棒。\"},{\"imgUrl\":\"http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/501912466ece49b18912ce0b14430d81.jpg\"},{\"imgUrl\":\"http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/50258cbf3046477786c49fbbac766f83.jpg\"}]','<div><p>擦，碰上一个很适合我的问题，怒答！<br>就是依靠下班时间，先把词汇背个十遍八遍的啊<br>我当时想到自学英语时候2012年3月，已经毕业快五年了（2007年7月毕业），期间工作都用不到英语。我利用业余时间，把考研词汇背了二十遍，时间花费大概七个月，没办法，刚开始嘛。。。反正有时候一天才背20个单词，就这样。当然，第一遍背完之后，再背就容易多了，一遍比一遍快。最后一遍也就是我一天就能解决。<br>后来就开始做中口真题，后来复习了大概五个月，笔试过了（2013年4月）。后来，口试没过（就考了一次）。<br>今年九月份（2014年9月）去考了高级口译笔试，应该也没过，因为我只是去试试。<br>在这之前我已经背了专八词汇8遍，BBC听了五个月了。这些都是在我的业余时间学的，中午休息一个小时可以听一篇五分钟的BBC，精听，约花费30分钟。五点下班以后花费二到三个小时听BBC做高口练习题。<br>自从今年九月份高口笔试受挫之后，我就开始做高口练习题和真题了。<br>我备考时候压根就没做高口复习题和真题。只是听了五个月BBC和背了八遍专八词汇。<br><p>因为，发觉阅读也很重要，还有翻译。</p><p><img src=\"http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/501912466ece49b18912ce0b14430d81.jpg\" alt=\"undefined\"><br></p>如何练好听力，那就是词汇是基础，然后做阅读，阅读可以促进听力，翻译中，就是试着把译文背下来呗。</p><p>十一期间，我每天精听两篇五分钟的BBC,做一篇汉译英。<br>上班之后大概每天也是这样。。。<br>由于背了专八词汇，词汇已经基本上没啥问题了。（这是我在《考拉小巫的英语学习日记》里学到的，如果你想让自己在词汇上没有障碍，就背完专八词汇）</p><p>Ps如果你真的想学英语，一定要有把词汇背下来的毅力，不然那是空谈。</p><p>我公司有几个老同事，年龄大约35到40岁之间，公司给他们报了几万元的韦博英语，最后都没有提高耶，翻译写邮件还得找我帮忙。。。因为他们私底下都没有认真学，只是每周末去上两节课。。。</p><p>最后推荐一个听BBC的应用，可可英语，这个是有中英文对照的，可以一句一句听，我觉得超棒。</p><p><img src=\"http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/50258cbf3046477786c49fbbac766f83.jpg\" alt=\"undefined\"><br></p></div>',NULL,'http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/501912466ece49b18912ce0b14430d81.jpg#http://owl-so.oss-cn-shenzhen.aliyuncs.com/article/50258cbf3046477786c49fbbac766f83.jpg','2017-09-18 14:19:32','2017-09-18 14:19:32',NULL,1,0,NULL);

/*Table structure for table `t_business` */

DROP TABLE IF EXISTS `t_business`;

CREATE TABLE `t_business` (
  `n_business_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '业务咨询主见，自增',
  `c_name` varchar(50) DEFAULT NULL COMMENT '咨询者姓名',
  `c_email` varchar(50) DEFAULT NULL COMMENT '咨询者邮箱',
  `c_contact` varchar(50) DEFAULT NULL COMMENT '公司电话',
  `c_mobile` varchar(50) DEFAULT NULL COMMENT '个人手机',
  `c_company_name` varchar(50) DEFAULT NULL COMMENT '公司名字',
  `c_company_addr` varchar(100) DEFAULT NULL COMMENT '公司地址',
  `c_business_demand` varchar(2000) DEFAULT NULL COMMENT '需求详细说明',
  PRIMARY KEY (`n_business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_business` */

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `n_comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `c_comment_content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `n_comment_type` tinyint(1) DEFAULT NULL COMMENT '评论对象，1文章评论',
  `n_target_id` bigint(20) DEFAULT NULL COMMENT '评论对象ID',
  `n_user_id` bigint(20) DEFAULT NULL COMMENT '评论人员ID,t_user_account表里的n_user_id',
  `t_create_time` datetime DEFAULT NULL COMMENT '评论时间',
  `n_status` tinyint(4) DEFAULT '1' COMMENT '评论状态0无效1有效',
  `n_parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父级评论ID(为0时是顶级评论)',
  `n_top_comment_id` bigint(20) DEFAULT '0' COMMENT '回复评论的顶级评论ID',
  `n_reply_user_id` bigint(20) DEFAULT NULL COMMENT '回复的用户ID',
  `n_is_read` tinyint(1) DEFAULT '0' COMMENT '是否已读0未读，1已读',
  PRIMARY KEY (`n_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_comment` */

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `n_menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `c_menu_icon` varchar(50) DEFAULT NULL COMMENT '菜单Icon',
  `c_menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `c_menu_url` varchar(250) DEFAULT NULL COMMENT '菜单URL',
  `n_menu_level` int(1) DEFAULT NULL COMMENT '菜单级别',
  `n_parent_menu_id` bigint(20) DEFAULT NULL COMMENT '父级菜单ID',
  `n_status` int(1) DEFAULT '1' COMMENT '有效标识0无效1有效',
  `t_create_time` datetime DEFAULT NULL,
  `t_update_time` datetime DEFAULT NULL,
  `n_create_by` bigint(20) DEFAULT NULL,
  `n_update_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`n_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_menu` */

insert  into `t_menu`(`n_menu_id`,`c_menu_icon`,`c_menu_name`,`c_menu_url`,`n_menu_level`,`n_parent_menu_id`,`n_status`,`t_create_time`,`t_update_time`,`n_create_by`,`n_update_by`) values (0,NULL,'后台管理系统','',0,-1,1,'2017-03-14 22:03:50','2017-03-14 22:03:53',0,0),(2,'fa-home','用户管理','',1,0,1,NULL,NULL,NULL,NULL),(3,'fa-users','文章管理','',1,0,1,NULL,NULL,NULL,NULL),(6,'fa-phone','商务管理','',1,0,1,NULL,NULL,NULL,NULL),(8,'fa-user','系统管理','',1,0,1,NULL,NULL,NULL,NULL),(21,NULL,'用户管理','userListPage',2,2,1,NULL,NULL,NULL,NULL),(31,NULL,'文章管理','articleListPage',2,3,1,NULL,NULL,NULL,NULL),(32,NULL,'文章评论','commentListPage',2,3,1,NULL,NULL,NULL,NULL),(33,NULL,'文章标签','tagListPage',2,3,1,NULL,NULL,NULL,NULL),(34,NULL,'敏感词管理','sensitiveListPage',2,3,1,NULL,NULL,NULL,NULL),(51,NULL,'系统用户管理','adminListPage',2,8,1,NULL,NULL,NULL,NULL),(52,NULL,'角色管理','groupPage',2,8,1,NULL,NULL,NULL,NULL),(61,NULL,'咨询管理','businessPage',2,6,1,NULL,NULL,NULL,NULL);

/*Table structure for table `t_menu_permission` */

DROP TABLE IF EXISTS `t_menu_permission`;

CREATE TABLE `t_menu_permission` (
  `n_menu_permission_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单权限ID',
  `n_menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `n_permission_id` bigint(20) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`n_menu_permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_menu_permission` */

insert  into `t_menu_permission`(`n_menu_permission_id`,`n_menu_id`,`n_permission_id`) values (64,21,1),(65,21,2),(66,31,3),(67,31,4),(68,32,5),(69,33,6),(70,33,7),(71,33,8),(72,33,9),(73,33,10),(74,34,11),(75,34,12),(76,34,13),(77,41,18),(78,42,14),(79,42,15),(80,42,16),(81,42,17),(82,43,19),(83,51,24),(84,51,25),(85,51,26),(86,51,27),(87,52,20),(88,52,21),(89,52,22),(90,52,23),(91,43,2);

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `n_permission_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `c_permission_name` varchar(200) DEFAULT NULL COMMENT '权限名称',
  `c_permission_url` varchar(200) DEFAULT NULL COMMENT '权限链接',
  `t_create_time` datetime DEFAULT NULL,
  `t_update_time` datetime DEFAULT NULL,
  `n_create_by` bigint(20) DEFAULT NULL,
  `n_update_by` bigint(20) DEFAULT NULL,
  `n_status` tinyint(1) DEFAULT '1' COMMENT '有效状态：0无效，1有效',
  PRIMARY KEY (`n_permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_permission` */

insert  into `t_permission`(`n_permission_id`,`c_permission_name`,`c_permission_url`,`t_create_time`,`t_update_time`,`n_create_by`,`n_update_by`,`n_status`) values (1,'查询用户列表','/userList',NULL,NULL,NULL,NULL,1),(2,'审核用户','/verifyUser',NULL,NULL,NULL,NULL,1),(3,'文章列表','/articleList',NULL,NULL,NULL,NULL,1),(4,'审核文章','/verifyArticle',NULL,NULL,NULL,NULL,1),(5,'查询评论列表','/commentList',NULL,NULL,NULL,NULL,1),(6,'查询标签','/tagList',NULL,NULL,NULL,NULL,1),(7,'添加标签','/addTag',NULL,NULL,NULL,NULL,1),(8,'修改标签','/updateTag',NULL,NULL,NULL,NULL,1),(9,'删除标签','/deleteTag',NULL,NULL,NULL,NULL,1),(10,'验证标签','/verifyTag',NULL,NULL,NULL,NULL,1),(11,'查询敏感词','/sensitiveList',NULL,NULL,NULL,NULL,1),(12,'新增敏感词','/insertSensitive',NULL,NULL,NULL,NULL,1),(13,'删除敏感词','/deleteSensitive',NULL,NULL,NULL,NULL,1),(14,'查询课程类别','/courseTypeList',NULL,NULL,NULL,NULL,1),(15,'添加课程类别','/addCourseType',NULL,NULL,NULL,NULL,1),(16,'修改课程类别','/updateCourseType',NULL,NULL,NULL,NULL,1),(17,'删除课程类别','/deleteCourseType',NULL,NULL,NULL,NULL,1),(18,'查询课堂列表','/courseList',NULL,NULL,NULL,NULL,1),(19,'查询课堂认证人员列表','/authUserList',NULL,NULL,NULL,NULL,1),(20,'查询群组','/system/groupList',NULL,NULL,NULL,NULL,1),(21,'添加群组','/system/addGroup',NULL,NULL,NULL,NULL,1),(22,'修改群组','/system/modifyGroup',NULL,NULL,NULL,NULL,1),(23,'删除群组','/system/delGroup',NULL,NULL,NULL,NULL,1),(24,'查询系统用户','/system/adminList',NULL,NULL,NULL,NULL,1),(25,'添加系统用户','/system/addAdmin',NULL,NULL,NULL,NULL,1),(26,'修改系统用户','/system/modifyAdmin',NULL,NULL,NULL,NULL,1),(27,'删除系统用户','/system/delAdmin',NULL,NULL,NULL,NULL,1);

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `n_product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_product_name` varchar(200) DEFAULT NULL COMMENT '产品名称',
  `n_product_type_id` bigint(20) NOT NULL COMMENT '产品类型ID',
  `n_market_price` decimal(8,2) DEFAULT NULL COMMENT '市场价（元）',
  `n_discount_rate` float DEFAULT NULL COMMENT '产品折扣率',
  `n_member_price` float DEFAULT NULL COMMENT '产品折扣价',
  `c_product_unit` decimal(8,2) DEFAULT NULL COMMENT '产品计量单位',
  `n_sales_count` bigint(20) DEFAULT NULL COMMENT '产品销售数量',
  `c_product_pic` varchar(200) DEFAULT NULL COMMENT '产品图片路径',
  `c_product_desc` varchar(200) DEFAULT NULL COMMENT '产品描述',
  `n_attention_rate` int(11) DEFAULT '0' COMMENT '关注度',
  `n_new_type` int(2) DEFAULT '0' COMMENT '1代表新品，2代表推介产品',
  `t_create_time` datetime DEFAULT NULL,
  `t_update_time` datetime DEFAULT NULL,
  `n_create_by` bigint(20) DEFAULT NULL,
  `n_update_by` bigint(20) DEFAULT NULL,
  `n_status` tinyint(1) DEFAULT '1' COMMENT '有效状态：0无效，1有效',
  PRIMARY KEY (`n_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_product` */

/*Table structure for table `t_producttype` */

DROP TABLE IF EXISTS `t_producttype`;

CREATE TABLE `t_producttype` (
  `n_product_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_type_name` varchar(200) DEFAULT NULL COMMENT '产品类别名称',
  `n_index` int(11) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`n_product_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_producttype` */

insert  into `t_producttype`(`n_product_type_id`,`c_type_name`,`n_index`) values (1,'水果茶',1),(2,'奶茶',2),(3,'奶盖茶',3),(4,'咖啡',4);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `n_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `n_role_code` int(11) DEFAULT NULL COMMENT '角色编码',
  `c_role_name` varchar(200) DEFAULT NULL COMMENT '角色名称',
  `n_system_role` tinyint(1) DEFAULT '0' COMMENT '是否为系统角色，0不是，1是',
  `t_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `n_status` tinyint(1) DEFAULT '1' COMMENT '是否有效，0无效1有效',
  `n_create_by` bigint(20) DEFAULT NULL COMMENT '创建人员ID',
  `n_update_by` bigint(20) DEFAULT NULL COMMENT '修改人员ID',
  `c_role_desc` varchar(200) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`n_role_id`),
  UNIQUE KEY `n_role_code` (`n_role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_role` */

insert  into `t_role`(`n_role_id`,`n_role_code`,`c_role_name`,`n_system_role`,`t_create_time`,`t_update_time`,`n_status`,`n_create_by`,`n_update_by`,`c_role_desc`) values (1,1,'超级管理员',1,'2017-03-16 22:08:47','2017-03-16 22:08:50',1,1,1,'拥有系统最高权限'),(106,3,'文章管理员',0,'2017-03-18 09:46:28','2017-03-18 09:46:28',1,1,1,'只能操作文章模块'),(108,4,'系统管理员',0,'2017-09-13 11:29:22','2017-09-13 11:29:22',1,1,1,'操作系统管理模块人员');

/*Table structure for table `t_role_menu` */

DROP TABLE IF EXISTS `t_role_menu`;

CREATE TABLE `t_role_menu` (
  `n_role_menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色菜单关系ID',
  `n_role_code` bigint(20) DEFAULT NULL COMMENT '角色Code',
  `n_menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `n_status` int(1) DEFAULT '1' COMMENT '有效标识0无效1有效',
  `t_create_time` datetime DEFAULT NULL,
  `t_update_time` datetime DEFAULT NULL,
  `n_create_by` bigint(20) DEFAULT NULL,
  `n_update_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`n_role_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=419 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_role_menu` */

insert  into `t_role_menu`(`n_role_menu_id`,`n_role_code`,`n_menu_id`,`n_status`,`t_create_time`,`t_update_time`,`n_create_by`,`n_update_by`) values (1,1,2,1,NULL,NULL,NULL,NULL),(2,1,3,1,NULL,NULL,NULL,NULL),(4,1,5,1,NULL,NULL,NULL,NULL),(5,1,21,1,NULL,NULL,NULL,NULL),(6,1,31,1,NULL,NULL,NULL,NULL),(7,1,32,1,NULL,NULL,NULL,NULL),(8,1,33,1,NULL,NULL,NULL,NULL),(9,1,34,1,NULL,NULL,NULL,NULL),(10,1,6,1,NULL,NULL,NULL,NULL),(13,1,51,1,NULL,NULL,NULL,NULL),(14,1,52,1,NULL,NULL,NULL,NULL),(15,1,61,1,NULL,NULL,NULL,NULL),(16,1,8,1,NULL,NULL,NULL,NULL),(377,1,0,1,NULL,NULL,NULL,NULL),(390,3,0,1,'2017-09-13 11:28:03','2017-09-13 11:28:03',1,1),(391,3,3,1,'2017-09-13 11:28:03','2017-09-13 11:28:03',1,1),(392,3,31,1,'2017-09-13 11:28:03','2017-09-13 11:28:03',1,1),(393,3,32,1,'2017-09-13 11:28:03','2017-09-13 11:28:03',1,1),(394,3,33,1,'2017-09-13 11:28:03','2017-09-13 11:28:03',1,1),(395,3,34,1,'2017-09-13 11:28:03','2017-09-13 11:28:03',1,1),(415,4,0,1,'2017-09-13 15:54:56','2017-09-13 15:54:56',1,1),(416,4,5,1,'2017-09-13 15:54:56','2017-09-13 15:54:56',1,1),(417,4,51,1,'2017-09-13 15:54:56','2017-09-13 15:54:56',1,1),(418,4,52,1,'2017-09-13 15:54:56','2017-09-13 15:54:56',1,1);

/*Table structure for table `t_role_permission` */

DROP TABLE IF EXISTS `t_role_permission`;

CREATE TABLE `t_role_permission` (
  `n_role_permission` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `n_role_code` bigint(20) DEFAULT NULL COMMENT '角色编码',
  `n_permission_id` bigint(20) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`n_role_permission`)
) ENGINE=InnoDB AUTO_INCREMENT=397 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_role_permission` */

insert  into `t_role_permission`(`n_role_permission`,`n_role_code`,`n_permission_id`) values (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,1,12),(13,1,13),(14,1,14),(15,1,15),(16,1,16),(17,1,17),(18,1,18),(19,1,19),(20,1,20),(21,1,21),(22,1,22),(23,1,23),(24,1,24),(25,1,25),(26,1,26),(27,1,27),(338,3,3),(339,3,4),(340,3,5),(341,3,6),(342,3,7),(343,3,8),(344,3,9),(345,3,10),(346,3,11),(347,3,12),(348,3,13),(389,4,24),(390,4,25),(391,4,26),(392,4,27),(393,4,20),(394,4,21),(395,4,22),(396,4,23);

/*Table structure for table `t_system_user` */

DROP TABLE IF EXISTS `t_system_user`;

CREATE TABLE `t_system_user` (
  `n_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_user_name` varchar(50) DEFAULT NULL COMMENT '登录名',
  `c_user_pwd` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `c_realname` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `n_create_id` bigint(20) DEFAULT NULL,
  `t_create_time` datetime DEFAULT NULL,
  `n_update_id` bigint(20) DEFAULT NULL,
  `t_update_time` datetime DEFAULT NULL,
  `n_status` int(1) DEFAULT '1',
  PRIMARY KEY (`n_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_system_user` */

insert  into `t_system_user`(`n_user_id`,`c_user_name`,`c_user_pwd`,`c_realname`,`n_create_id`,`t_create_time`,`n_update_id`,`t_update_time`,`n_status`) values (1,'admin','29qmFzvQlguR/SaQUKCj0A==',NULL,1,'2017-08-09 14:36:36',1,'2017-08-09 14:36:36',1),(3,'gg','r+BDyRnnto2AXftT9xLdUw==',NULL,NULL,NULL,NULL,NULL,1);

/*Table structure for table `t_user_account` */

DROP TABLE IF EXISTS `t_user_account`;

CREATE TABLE `t_user_account` (
  `n_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户基本信息表主键',
  `c_user_account` varchar(50) NOT NULL COMMENT '用户帐号',
  `c_user_password` varchar(32) DEFAULT NULL COMMENT '用户密码（密码不能明文存储）',
  `c_user_realname` varchar(50) DEFAULT '' COMMENT '用户真实姓名',
  `c_user_portrait` varchar(200) DEFAULT '' COMMENT '用户头像',
  `c_mobile_phone` varchar(15) DEFAULT NULL COMMENT '用户手机号',
  `c_user_email` varchar(30) DEFAULT '' COMMENT '电子邮箱',
  `c_user_company` varchar(100) DEFAULT '' COMMENT '用户公司名称',
  `c_user_position` varchar(100) DEFAULT '' COMMENT '用户职位',
  `c_user_addr` varchar(100) DEFAULT '' COMMENT '用户地址',
  `n_user_type` tinyint(1) NOT NULL COMMENT '用户类型：1游神，2美女管家',
  `c_user_introduce` varchar(500) DEFAULT NULL COMMENT '用户简介',
  `n_iscomplete` tinyint(1) DEFAULT '0' COMMENT '是否完善资料：0、未完善 1、已完善',
  `t_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `c_wechat_id` varchar(200) DEFAULT NULL COMMENT '微信id',
  `c_sex` varchar(1) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  PRIMARY KEY (`n_user_id`),
  UNIQUE KEY `帐号` (`c_user_account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_account` */

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `n_user_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `n_user_id` bigint(20) DEFAULT NULL COMMENT '系统用户ID',
  `n_role_code` bigint(20) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`n_user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`n_user_role_id`,`n_user_id`,`n_role_code`) values (1,1,1),(5,3,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
