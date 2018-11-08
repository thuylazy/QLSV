/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : hssv

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2014-09-11 23:27:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chuyennganh
-- ----------------------------
DROP TABLE IF EXISTS `chuyennganh`;
CREATE TABLE `chuyennganh` (
  `chuyennganh_id` bigint(20) unsigned NOT NULL auto_increment,
  `ma_cn` varchar(45) NOT NULL default '',
  `ten_cn` varchar(45) NOT NULL default '',
  `nganh_id` bigint(20) unsigned NOT NULL default '0',
  PRIMARY KEY  (`chuyennganh_id`),
  KEY `FK_nganh` (`nganh_id`),
  CONSTRAINT `FK_nganh` FOREIGN KEY (`nganh_id`) REFERENCES `nganh` (`nganh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chuyennganh
-- ----------------------------
INSERT INTO `chuyennganh` VALUES ('1', 'BT002', 'Thợ xây móng', '2');
INSERT INTO `chuyennganh` VALUES ('2', 'CNTT', 'Công nghệ phần mềm', '1');
INSERT INTO `chuyennganh` VALUES ('3', 'SS06', 'Trồng người', '3');

-- ----------------------------
-- Table structure for dantoc
-- ----------------------------
DROP TABLE IF EXISTS `dantoc`;
CREATE TABLE `dantoc` (
  `dantoc_id` bigint(20) unsigned NOT NULL auto_increment,
  `tendantoc` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`dantoc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dantoc
-- ----------------------------
INSERT INTO `dantoc` VALUES ('1', 'Kinh khủng');
INSERT INTO `dantoc` VALUES ('2', 'Tày');
INSERT INTO `dantoc` VALUES ('3', 'Mường');

-- ----------------------------
-- Table structure for diem
-- ----------------------------
DROP TABLE IF EXISTS `diem`;
CREATE TABLE `diem` (
  `diem_id` bigint(20) unsigned NOT NULL auto_increment,
  `monhoc_id` bigint(20) unsigned NOT NULL default '0',
  `lanthi` varchar(45) NOT NULL default '',
  `diemthi` float NOT NULL default '0',
  `diemchuyencan` float NOT NULL default '0',
  `diemgiuaky` float NOT NULL default '0',
  `hocky_id` bigint(20) unsigned NOT NULL default '0',
  `sinhvien_id` bigint(20) unsigned NOT NULL default '0',
  PRIMARY KEY  (`diem_id`),
  KEY `FK_hocky` (`hocky_id`),
  KEY `FK_monhoc` (`monhoc_id`),
  KEY `FK_sinhvien` (`sinhvien_id`),
  CONSTRAINT `FK_hocky` FOREIGN KEY (`hocky_id`) REFERENCES `hocky` (`hocky_id`),
  CONSTRAINT `FK_monhoc` FOREIGN KEY (`monhoc_id`) REFERENCES `monhoc` (`monhoc_id`),
  CONSTRAINT `FK_sinhvien` FOREIGN KEY (`sinhvien_id`) REFERENCES `dmsinhvien` (`sinhvien_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diem
-- ----------------------------
INSERT INTO `diem` VALUES ('1', '1', '1', '6', '8', '8', '2', '1');
INSERT INTO `diem` VALUES ('2', '2', '3', '10', '10', '5', '3', '2');

-- ----------------------------
-- Table structure for dmsinhvien
-- ----------------------------
DROP TABLE IF EXISTS `dmsinhvien`;
CREATE TABLE `dmsinhvien` (
  `sinhvien_id` bigint(20) unsigned NOT NULL auto_increment,
  `masv` varchar(45) NOT NULL default '',
  `hodem` varchar(45) NOT NULL default '',
  `ten` varchar(45) NOT NULL default '',
  `ngaysinh` datetime default NULL,
  `gioitinh` bit(1) NOT NULL default '\0',
  `cmtnd` varchar(45) NOT NULL default '',
  `sodthoai` varchar(45) NOT NULL default '',
  `noisinh` varchar(45) NOT NULL default '',
  `quequan` varchar(45) NOT NULL default '',
  `hokhauthuongtru` varchar(200) NOT NULL default '',
  `noiohientai` varchar(200) NOT NULL default '',
  `chedouudai` varchar(100) NOT NULL default '',
  `dantoc_id` bigint(20) unsigned NOT NULL default '0',
  `tongiao_id` bigint(20) unsigned NOT NULL default '0',
  `quoctich_id` bigint(20) unsigned NOT NULL default '0',
  `hotenbo` varchar(45) NOT NULL default '',
  `nghenghiepbo` varchar(45) NOT NULL default '',
  `hotenme` varchar(45) NOT NULL default '',
  `nghenghiepme` varchar(45) NOT NULL default '',
  `hedt_id` bigint(20) unsigned NOT NULL default '0',
  `lop_id` bigint(20) unsigned NOT NULL default '0',
  `khoahoc_id` bigint(20) unsigned NOT NULL default '0',
  `ngaynhaphoc` datetime NOT NULL default '0000-00-00 00:00:00',
  `diemdauvao1` float NOT NULL default '0',
  `diemdauvao2` float default NULL,
  `diemdauvao3` float NOT NULL default '0',
  `anhsinhvien` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`sinhvien_id`),
  KEY `FK_dantoc` (`dantoc_id`),
  KEY `FK_tongiao` (`tongiao_id`),
  KEY `FK_quoctich` (`quoctich_id`),
  KEY `FK_hedt` (`hedt_id`),
  KEY `FK_lophoc` (`lop_id`),
  KEY `FK_khoahoc` (`khoahoc_id`),
  CONSTRAINT `FK_dantoc` FOREIGN KEY (`dantoc_id`) REFERENCES `dantoc` (`dantoc_id`),
  CONSTRAINT `FK_hedt` FOREIGN KEY (`hedt_id`) REFERENCES `hedaotao` (`hedt_id`),
  CONSTRAINT `FK_khoahoc` FOREIGN KEY (`khoahoc_id`) REFERENCES `khoahoc` (`khoahoc_id`),
  CONSTRAINT `FK_lophoc` FOREIGN KEY (`lop_id`) REFERENCES `lophoc` (`lop_id`),
  CONSTRAINT `FK_quoctich` FOREIGN KEY (`quoctich_id`) REFERENCES `quoctich` (`quoctich_id`),
  CONSTRAINT `FK_tongiao` FOREIGN KEY (`tongiao_id`) REFERENCES `tongiao` (`tongiao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 3072 kB; (`hedt_id`) REFER `hssv/hedaotao`(`hed';

-- ----------------------------
-- Records of dmsinhvien
-- ----------------------------
INSERT INTO `dmsinhvien` VALUES ('1', 'K1', 'Mai Thanh', 'Toán', '1991-10-10 00:00:00', '\0', '121564', '46546456', 'Hà Nội', 'Hà Nội', 'Số 1 Bưởi', 'Số 1 Bưởi da xanh', '4/4', '1', '1', '1', 'Nguyễn Nguyên Tử', 'Giáo sư', 'Nguyễn Mai Giang', 'Bác sỹ', '1', '1', '1', '2014-09-09 23:24:36', '6', '7', '8', 'img1');
INSERT INTO `dmsinhvien` VALUES ('2', 'K2', 'Đào Công', 'Trình', '1991-10-11 00:00:00', '', '1231231', '54654564', 'Thái Bình', 'Thái Bình', 'Số 1 Nam Đồng', 'Số 1 Đông Sắt', 'Thương binh 5/5', '2', '2', '2', 'Đào Thế Nào', 'Công Trình Sư', 'Nguyễn Thu Cuối', 'Quét lá vàng', '2', '2', '2', '2010-10-10 00:00:00', '0', null, '0', '');

-- ----------------------------
-- Table structure for hedaotao
-- ----------------------------
DROP TABLE IF EXISTS `hedaotao`;
CREATE TABLE `hedaotao` (
  `hedt_id` bigint(20) unsigned NOT NULL auto_increment,
  `mahedt` varchar(45) NOT NULL default '',
  `ten_hedt` varchar(100) NOT NULL default '',
  PRIMARY KEY  (`hedt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hedaotao
-- ----------------------------
INSERT INTO `hedaotao` VALUES ('1', 'K01', 'Đại Học');
INSERT INTO `hedaotao` VALUES ('2', 'K02', 'Cao Học');
INSERT INTO `hedaotao` VALUES ('3', 'K03', 'Trung Cấp');

-- ----------------------------
-- Table structure for hocky
-- ----------------------------
DROP TABLE IF EXISTS `hocky`;
CREATE TABLE `hocky` (
  `hocky_id` bigint(20) unsigned NOT NULL auto_increment,
  `tenhocky` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`hocky_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hocky
-- ----------------------------
INSERT INTO `hocky` VALUES ('1', 'Học kỳ 1');
INSERT INTO `hocky` VALUES ('2', 'Học kỳ 2');
INSERT INTO `hocky` VALUES ('3', 'Học kỳ 3');

-- ----------------------------
-- Table structure for khoahoc
-- ----------------------------
DROP TABLE IF EXISTS `khoahoc`;
CREATE TABLE `khoahoc` (
  `khoahoc_id` bigint(20) unsigned NOT NULL auto_increment,
  `tenkhoahoc` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`khoahoc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of khoahoc
-- ----------------------------
INSERT INTO `khoahoc` VALUES ('1', 'K1');
INSERT INTO `khoahoc` VALUES ('2', 'K2');
INSERT INTO `khoahoc` VALUES ('3', 'K3');

-- ----------------------------
-- Table structure for log_diem
-- ----------------------------
DROP TABLE IF EXISTS `log_diem`;
CREATE TABLE `log_diem` (
  `diem_id` bigint(20) unsigned NOT NULL,
  `monhoc_id` bigint(20) unsigned NOT NULL default '0',
  `lanthi` varchar(45) NOT NULL default '',
  `diemthi` float NOT NULL default '0',
  `diemchuyencan` float NOT NULL default '0',
  `diemgiuaky` float NOT NULL default '0',
  `hocky_id` bigint(20) unsigned NOT NULL default '0',
  `sinhvien_id` bigint(20) unsigned NOT NULL default '0',
  `action` varchar(255) default NULL,
  `time` datetime default NULL,
  `log_id` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 11264 kB; (`hocky_id`) REFER `hssv/hocky`(`hock';

-- ----------------------------
-- Records of log_diem
-- ----------------------------

-- ----------------------------
-- Table structure for log_dmsinhvien
-- ----------------------------
DROP TABLE IF EXISTS `log_dmsinhvien`;
CREATE TABLE `log_dmsinhvien` (
  `sinhvien_id` bigint(20) unsigned NOT NULL,
  `masv` varchar(45) NOT NULL default '',
  `hodem` varchar(45) NOT NULL default '',
  `ten` varchar(45) NOT NULL default '',
  `ngaysinh` datetime default NULL,
  `gioitinh` bit(1) NOT NULL default '\0',
  `cmtnd` varchar(45) NOT NULL default '',
  `sodthoai` varchar(45) NOT NULL default '',
  `noisinh` varchar(45) NOT NULL default '',
  `quequan` varchar(45) NOT NULL default '',
  `hokhauthuongtru` varchar(200) NOT NULL default '',
  `noiohientai` varchar(200) NOT NULL default '',
  `chedouudai` varchar(100) NOT NULL default '',
  `dantoc_id` bigint(20) unsigned NOT NULL default '0',
  `tongiao_id` bigint(20) unsigned NOT NULL default '0',
  `quoctich_id` bigint(20) unsigned NOT NULL default '0',
  `hotenbo` varchar(45) NOT NULL default '',
  `nghenghiepbo` varchar(45) NOT NULL default '',
  `hotenme` varchar(45) NOT NULL default '',
  `nghenghiepme` varchar(45) NOT NULL default '',
  `hedt_id` bigint(20) unsigned NOT NULL default '0',
  `lop_id` bigint(20) unsigned NOT NULL default '0',
  `khoahoc_id` bigint(20) unsigned NOT NULL default '0',
  `ngaynhaphoc` datetime NOT NULL default '0000-00-00 00:00:00',
  `diemdauvao1` float NOT NULL default '0',
  `diemdauvao2` float default NULL,
  `diemdauvao3` float NOT NULL default '0',
  `anhsinhvien` varchar(45) NOT NULL default '',
  `log_id` int(11) NOT NULL auto_increment,
  `action` varchar(255) default NULL,
  `time` datetime default NULL,
  PRIMARY KEY  (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 3072 kB; (`hedt_id`) REFER `hssv/hedaotao`(`hed';

-- ----------------------------
-- Records of log_dmsinhvien
-- ----------------------------
INSERT INTO `log_dmsinhvien` VALUES ('1', 'K1', 'Mai Thanh', 'Toán', '0000-00-00 00:00:00', '\0', '121564', '46546456', 'Hà Nội', 'Hà Nội', 'Số 1 Bưởi', 'Số 1 Bưởi da xanh', '4/4', '1', '1', '1', 'Nguyễn Nguyên Tử', 'Giáo sư', 'Nguyễn Mai Giang', 'Bác sỹ', '1', '1', '1', '0000-00-00 00:00:00', '6', '7', '8', 'img1', '3', 'insert', '2014-09-11 23:22:14');
INSERT INTO `log_dmsinhvien` VALUES ('2', 'K2', 'Đào Công', 'Trình', '1991-10-11 00:00:00', '', '1231231', '54654564', 'Thái Bình', 'Thái Bình', 'Số 1 Nam Đồng', 'Số 1 Đông Sắt', 'Thương binh 5/5', '2', '2', '2', 'Đào Thế Nào', 'Công Trình Sư', 'Nguyễn Thu Cuối', 'Quét lá vàng', '2', '2', '2', '2010-10-10 00:00:00', '0', null, '0', '', '4', 'insert', '2014-09-11 23:24:32');
INSERT INTO `log_dmsinhvien` VALUES ('1', 'K1', 'Mai Thanh', 'Toán', '0000-00-00 00:00:00', '\0', '121564', '46546456', 'Hà Nội', 'Hà Nội', 'Số 1 Bưởi', 'Số 1 Bưởi da xanh', '4/4', '1', '1', '1', 'Nguyễn Nguyên Tử', 'Giáo sư', 'Nguyễn Mai Giang', 'Bác sỹ', '1', '1', '1', '0000-00-00 00:00:00', '6', '7', '8', 'img1', '5', 'update', '2014-09-11 23:24:41');
INSERT INTO `log_dmsinhvien` VALUES ('1', 'K1', 'Mai Thanh', 'Toán', '0000-00-00 00:00:00', '\0', '121564', '46546456', 'Hà Nội', 'Hà Nội', 'Số 1 Bưởi', 'Số 1 Bưởi da xanh', '4/4', '1', '1', '1', 'Nguyễn Nguyên Tử', 'Giáo sư', 'Nguyễn Mai Giang', 'Bác sỹ', '1', '1', '1', '2014-09-09 23:24:36', '6', '7', '8', 'img1', '6', 'update', '2014-09-11 23:24:57');

-- ----------------------------
-- Table structure for lophoc
-- ----------------------------
DROP TABLE IF EXISTS `lophoc`;
CREATE TABLE `lophoc` (
  `lop_id` bigint(20) unsigned NOT NULL auto_increment,
  `tenlop` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`lop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lophoc
-- ----------------------------
INSERT INTO `lophoc` VALUES ('1', 'K16SE');
INSERT INTO `lophoc` VALUES ('2', 'BT16');
INSERT INTO `lophoc` VALUES ('3', 'SS202');

-- ----------------------------
-- Table structure for monhoc
-- ----------------------------
DROP TABLE IF EXISTS `monhoc`;
CREATE TABLE `monhoc` (
  `monhoc_id` bigint(20) unsigned NOT NULL auto_increment,
  `tenmonhoc` varchar(45) NOT NULL default '',
  `sotrinh` varchar(45) NOT NULL default '',
  `hesoChuyenCan` float NOT NULL default '0',
  `hesoGiuaKy` float NOT NULL default '0',
  `hesoHocKy` float NOT NULL default '0',
  `tinhtrang` int(10) unsigned NOT NULL default '0',
  `chuyennganh_id` bigint(20) unsigned NOT NULL default '0',
  `songaynghi` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`monhoc_id`),
  KEY `FK_chuyennganh` (`chuyennganh_id`),
  CONSTRAINT `FK_chuyennganh` FOREIGN KEY (`chuyennganh_id`) REFERENCES `chuyennganh` (`chuyennganh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monhoc
-- ----------------------------
INSERT INTO `monhoc` VALUES ('1', 'Đổ bê tông', '3000', '96', '2', '2', '1', '1', '1');
INSERT INTO `monhoc` VALUES ('2', 'Lập trình nâng cao', '20', '10', '20', '70', '1', '2', '5');
INSERT INTO `monhoc` VALUES ('3', 'Lập trình tự nhiên', '3', '10', '30', '60', '0', '3', '3');

-- ----------------------------
-- Table structure for nganh
-- ----------------------------
DROP TABLE IF EXISTS `nganh`;
CREATE TABLE `nganh` (
  `nganh_id` bigint(20) unsigned NOT NULL auto_increment,
  `manganh` varchar(45) NOT NULL default '',
  `tennganh` varchar(45) NOT NULL default '',
  `ghichu` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`nganh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nganh
-- ----------------------------
INSERT INTO `nganh` VALUES ('1', 'CNTT', 'Công nghệ thông tin', 'Ngành làm ra tiền');
INSERT INTO `nganh` VALUES ('2', 'TCV', 'Trung cấp vữa', 'Ngành xây dựng');
INSERT INTO `nganh` VALUES ('3', 'SKSS', 'Sức khỏe sinh sản', 'Ngành trồng người');

-- ----------------------------
-- Table structure for quoctich
-- ----------------------------
DROP TABLE IF EXISTS `quoctich`;
CREATE TABLE `quoctich` (
  `quoctich_id` bigint(20) unsigned NOT NULL auto_increment,
  `tenquoctich` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`quoctich_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quoctich
-- ----------------------------
INSERT INTO `quoctich` VALUES ('1', 'Việt Nam');
INSERT INTO `quoctich` VALUES ('2', 'Việt Trì');
INSERT INTO `quoctich` VALUES ('3', 'Việt Bắc');

-- ----------------------------
-- Table structure for tongiao
-- ----------------------------
DROP TABLE IF EXISTS `tongiao`;
CREATE TABLE `tongiao` (
  `tongiao_id` bigint(20) unsigned NOT NULL auto_increment,
  `tentongiao` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`tongiao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tongiao
-- ----------------------------
INSERT INTO `tongiao` VALUES ('1', 'Đạo phật');
INSERT INTO `tongiao` VALUES ('2', 'Đạo thiên chúa');
INSERT INTO `tongiao` VALUES ('3', 'Đạo Hindu');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL default '',
  `password` varchar(45) NOT NULL default '',
  `hovaten` varchar(255) NOT NULL default '',
  `diachi` varchar(255) default NULL,
  `sodienthoai` varchar(255) default NULL,
  `ngaysinh` date default NULL,
  `socmt` varchar(255) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'Nguyễn Đức Nhanh', 'So 2A bưởi', '0231654', '1988-10-10', '05646516');
INSERT INTO `user` VALUES ('2', 'bdmin', 'bdmin', 'Nguyễn Khuyến', '1 Nam Đồng', '165465465', '1962-10-10', '41564564');
INSERT INTO `user` VALUES ('3', 'cdmin', 'cmin', 'Đào Công Sự', '3 Đồng Xuân', '465454566', '1955-10-10', '549465465');
DROP TRIGGER IF EXISTS `addUser`;
DELIMITER ;;
CREATE TRIGGER `addUser` AFTER INSERT ON `dmsinhvien` FOR EACH ROW begin
insert into log_dmsinhvien (sinhvien_id,masv,hodem,ten,ngaysinh,gioitinh,cmtnd,sodthoai,noisinh,quequan,hokhauthuongtru,noiohientai,chedouudai,dantoc_id,tongiao_id,quoctich_id,hotenbo,nghenghiepbo,hotenme,nghenghiepme,hedt_id,lop_id,khoahoc_id,ngaynhaphoc,diemdauvao1,diemdauvao2,diemdauvao3,anhsinhvien,`action`,`time`)
values (new.sinhvien_id,new.masv,new.hodem,new.ten,new.ngaysinh,new.gioitinh,new.cmtnd,new.sodthoai,new.noisinh,new.quequan,new.hokhauthuongtru,new.noiohientai,new.chedouudai,new.dantoc_id,new.tongiao_id,new.quoctich_id,new.hotenbo,new.nghenghiepbo,new.hotenme,new.nghenghiepme,new.hedt_id,new.lop_id,new.khoahoc_id,new.ngaynhaphoc,new.diemdauvao1,new.diemdauvao2,new.diemdauvao3,new.anhsinhvien,'insert',now());
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `updateUser`;
DELIMITER ;;
CREATE TRIGGER `updateUser` BEFORE UPDATE ON `dmsinhvien` FOR EACH ROW begin
insert into log_dmsinhvien (sinhvien_id,masv,hodem,ten,ngaysinh,gioitinh,cmtnd,sodthoai,noisinh,quequan,hokhauthuongtru,noiohientai,chedouudai,dantoc_id,tongiao_id,quoctich_id,hotenbo,nghenghiepbo,hotenme,nghenghiepme,hedt_id,lop_id,khoahoc_id,ngaynhaphoc,diemdauvao1,diemdauvao2,diemdauvao3,anhsinhvien,`action`,`time`)
values (old.sinhvien_id,old.masv,old.hodem,old.ten,old.ngaysinh,old.gioitinh,old.cmtnd,old.sodthoai,old.noisinh,old.quequan,old.hokhauthuongtru,old.noiohientai,old.chedouudai,old.dantoc_id,old.tongiao_id,old.quoctich_id,old.hotenbo,old.nghenghiepbo,old.hotenme,old.nghenghiepme,old.hedt_id,old.lop_id,old.khoahoc_id,old.ngaynhaphoc,old.diemdauvao1,old.diemdauvao2,old.diemdauvao3,old.anhsinhvien,'update',now());
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `deleteUser`;
DELIMITER ;;
CREATE TRIGGER `deleteUser` BEFORE DELETE ON `dmsinhvien` FOR EACH ROW begin
insert into log_dmsinhvien (sinhvien_id,masv,hodem,ten,ngaysinh,gioitinh,cmtnd,sodthoai,noisinh,quequan,hokhauthuongtru,noiohientai,chedouudai,dantoc_id,tongiao_id,quoctich_id,hotenbo,nghenghiepbo,hotenme,nghenghiepme,hedt_id,lop_id,khoahoc_id,ngaynhaphoc,diemdauvao1,diemdauvao2,diemdauvao3,anhsinhvien,`action`,`time`)
values (old.sinhvien_id,old.masv,old.hodem,old.ten,old.ngaysinh,old.gioitinh,old.cmtnd,old.sodthoai,old.noisinh,old.quequan,old.hokhauthuongtru,old.noiohientai,old.chedouudai,old.dantoc_id,old.tongiao_id,old.quoctich_id,old.hotenbo,old.nghenghiepbo,old.hotenme,old.nghenghiepme,old.hedt_id,old.lop_id,old.khoahoc_id,old.ngaynhaphoc,old.diemdauvao1,old.diemdauvao2,old.diemdauvao3,old.anhsinhvien,'delete',now());
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `addUserDiem`;
DELIMITER ;;
CREATE TRIGGER `addUserDiem` AFTER INSERT ON `log_diem` FOR EACH ROW begin
insert into log_diem (diem_id,monhoc_id,lanthi,diemthi,diemchuyencan,diemgiuaky,hocky_id,sinhvien_id,`action`,`time`)
values (new.diem_id,new.monhoc_id,new.lanthi,new.diemthi,new.diemchuyencan,new.diemgiuaky,new.hocky_id,new.sinhvien_id,`insert`,now());
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `updateUserDiem`;
DELIMITER ;;
CREATE TRIGGER `updateUserDiem` BEFORE UPDATE ON `log_diem` FOR EACH ROW begin
insert into log_diem (diem_id,monhoc_id,lanthi,diemthi,diemchuyencan,diemgiuaky,hocky_id,sinhvien_id,`action`,`time`)
values (old.diem_id,old.monhoc_id,old.lanthi,old.diemthi,old.diemchuyencan,old.diemgiuaky,old.hocky_id,old.sinhvien_id,`update`,now());
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `deleteUserDiem`;
DELIMITER ;;
CREATE TRIGGER `deleteUserDiem` BEFORE DELETE ON `log_diem` FOR EACH ROW begin
insert into log_diem (diem_id,monhoc_id,lanthi,diemthi,diemchuyencan,diemgiuaky,hocky_id,sinhvien_id,`action`,`time`)
values (old.diem_id,old.monhoc_id,old.lanthi,old.diemthi,old.diemchuyencan,old.diemgiuaky,old.hocky_id,old.sinhvien_id,`delete`,now());
end
;;
DELIMITER ;
