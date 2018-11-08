
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chuyennganh
-- ----------------------------
DROP TABLE IF EXISTS `chuyennganh`;
CREATE TABLE `chuyennganh` (
  `chuyennganh_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ma_cn` varchar(45) NOT NULL DEFAULT '',
  `ten_cn` varchar(45) NOT NULL DEFAULT '',
  `nganh_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`chuyennganh_id`),
  KEY `FK_nganh` (`nganh_id`),
  CONSTRAINT `FK_nganh` FOREIGN KEY (`nganh_id`) REFERENCES `nganh` (`nganh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chuyennganh
-- ----------------------------
INSERT INTO `chuyennganh` VALUES ('1', 'IT1', 'Công nghệ phần mềm', '1');
INSERT INTO `chuyennganh` VALUES ('2', 'IT2', 'Hệ thống thông tin', '2');
INSERT INTO `chuyennganh` VALUES ('3', 'IT3', 'Quản trị hệ thống', '3');
INSERT INTO `chuyennganh` VALUES ('4', 'SET1', 'Viễn thông', '4');
INSERT INTO `chuyennganh` VALUES ('5', 'SET2', 'Điện tử', '5');

-- ----------------------------
-- Table structure for dantoc
-- ----------------------------
DROP TABLE IF EXISTS `dantoc`;
CREATE TABLE `dantoc` (
  `dantoc_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tendantoc` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`dantoc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dantoc
-- ----------------------------
INSERT INTO `dantoc` VALUES ('1', 'Kinh');
INSERT INTO `dantoc` VALUES ('2', 'Tày');
INSERT INTO `dantoc` VALUES ('3', 'Mường');

-- ----------------------------
-- Table structure for diem
-- ----------------------------
DROP TABLE IF EXISTS `diem`;
CREATE TABLE `diem` (
  `diem_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `monhoc_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `lanthi` varchar(45) NOT NULL DEFAULT '',
  `diemthi` float NOT NULL DEFAULT '0',
  `diemchuyencan` float NOT NULL DEFAULT '0',
  `diemgiuaky` float NOT NULL DEFAULT '0',
  `hocky_id` bigint(20) unsigned NOT NULL,
  `sinhvien_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`diem_id`),
  KEY `FK_monhoc` (`monhoc_id`),
  KEY `FK_sinhvien` (`sinhvien_id`),
  KEY `FK_hocky` (`hocky_id`),
  CONSTRAINT `FK_hocky` FOREIGN KEY (`hocky_id`) REFERENCES `hocky` (`hocky_id`),
  CONSTRAINT `FK_monhoc` FOREIGN KEY (`monhoc_id`) REFERENCES `monhoc` (`monhoc_id`),
  CONSTRAINT `FK_sinhvien` FOREIGN KEY (`sinhvien_id`) REFERENCES `dmsinhvien` (`sinhvien_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dmsinhvien
-- ----------------------------
DROP TABLE IF EXISTS `dmsinhvien`;
CREATE TABLE `dmsinhvien` (
  `sinhvien_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `masv` varchar(45) NOT NULL DEFAULT '',
  `hodem` varchar(45) NOT NULL DEFAULT '',
  `ten` varchar(45) NOT NULL DEFAULT '',
  `ngaysinh` datetime DEFAULT NULL,
  `gioitinh` bit(1) NOT NULL DEFAULT b'0',
  `cmtnd` varchar(45) NOT NULL DEFAULT '',
  `sodthoai` varchar(45) NOT NULL DEFAULT '',
  `noisinh` varchar(45) NOT NULL DEFAULT '',
  `quequan` varchar(45) NOT NULL DEFAULT '',
  `hokhauthuongtru` varchar(200) NOT NULL DEFAULT '',
  `noiohientai` varchar(200) NOT NULL DEFAULT '',
  `chedouudai` varchar(100) NOT NULL DEFAULT '',
  `dantoc_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `tongiao_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `hotenbo` varchar(45) NOT NULL DEFAULT '',
  `nghenghiepbo` varchar(45) NOT NULL DEFAULT '',
  `hotenme` varchar(45) NOT NULL DEFAULT '',
  `nghenghiepme` varchar(45) NOT NULL DEFAULT '',
  `lop_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `chuyennganh_id` bigint(20) unsigned DEFAULT NULL,
  `khoahoc_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `ngaynhaphoc` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `diemdauvao1` float NOT NULL DEFAULT '0',
  `diemdauvao2` float DEFAULT NULL,
  `diemdauvao3` float NOT NULL DEFAULT '0',
  `anhsinhvien` varchar(45) NOT NULL DEFAULT '',
  `delete_flg` bit(1) NOT NULL,
  PRIMARY KEY (`sinhvien_id`),
  KEY `FK_dantoc` (`dantoc_id`),
  KEY `FK_tongiao` (`tongiao_id`),
  KEY `FK_lophoc` (`lop_id`),
  KEY `FK_khoahoc` (`khoahoc_id`),
  KEY `FK_chuyennganh_sinhvien` (`chuyennganh_id`),
  CONSTRAINT `FK_chuyennganh_sinhvien` FOREIGN KEY (`chuyennganh_id`) REFERENCES `chuyennganh` (`chuyennganh_id`),
  CONSTRAINT `FK_dantoc` FOREIGN KEY (`dantoc_id`) REFERENCES `dantoc` (`dantoc_id`),
  CONSTRAINT `FK_khoahoc` FOREIGN KEY (`khoahoc_id`) REFERENCES `khoahoc` (`khoahoc_id`),
  CONSTRAINT `FK_lophoc` FOREIGN KEY (`lop_id`) REFERENCES `lophoc` (`lop_id`),
  CONSTRAINT `FK_tongiao` FOREIGN KEY (`tongiao_id`) REFERENCES `tongiao` (`tongiao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for hocky
-- ----------------------------
DROP TABLE IF EXISTS `hocky`;
CREATE TABLE `hocky` (
  `hocky_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenhocky` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`hocky_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hocky
-- ----------------------------
INSERT INTO `hocky` VALUES ('1', 'Học kỳ I');
INSERT INTO `hocky` VALUES ('2', 'Học kỳ II');
INSERT INTO `hocky` VALUES ('3', 'Học kỳ III');

-- ----------------------------
-- Table structure for khoahoc
-- ----------------------------
DROP TABLE IF EXISTS `khoahoc`;
CREATE TABLE `khoahoc` (
  `khoahoc_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenkhoahoc` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`khoahoc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of khoahoc
-- ----------------------------
INSERT INTO `khoahoc` VALUES ('1', 'K63');
INSERT INTO `khoahoc` VALUES ('2', 'K62');
INSERT INTO `khoahoc` VALUES ('3', 'K61');
INSERT INTO `khoahoc` VALUES ('4', 'K60');
INSERT INTO `khoahoc` VALUES ('5', 'K59');


-- ----------------------------
-- Table structure for lophoc
-- ----------------------------
DROP TABLE IF EXISTS `lophoc`;
CREATE TABLE `lophoc` (
  `lop_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenlop` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`lop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lophoc
-- ----------------------------
INSERT INTO `lophoc` VALUES ('1', 'CNĐT1');
INSERT INTO `lophoc` VALUES ('2', 'CNĐT2');
INSERT INTO `lophoc` VALUES ('3', 'CNTT1');
INSERT INTO `lophoc` VALUES ('4', 'CNTT2');

-- ----------------------------
-- Table structure for monhoc
-- ----------------------------
DROP TABLE IF EXISTS `monhoc`;
CREATE TABLE `monhoc` (
  `monhoc_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenmonhoc` varchar(45) NOT NULL DEFAULT '',
  `sotrinh` varchar(45) NOT NULL DEFAULT '',
  `hesoChuyenCan` float NOT NULL DEFAULT '0',
  `hesoGiuaKy` float NOT NULL DEFAULT '0',
  `hesoHocKy` float NOT NULL DEFAULT '0',
  `chuyennganh_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `songaynghi` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`monhoc_id`),
  KEY `FK_chuyennganh` (`chuyennganh_id`),
  CONSTRAINT `FK_chuyennganh` FOREIGN KEY (`chuyennganh_id`) REFERENCES `chuyennganh` (`chuyennganh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monhoc
-- ----------------------------
INSERT INTO `monhoc` VALUES ('1', 'Lập trình nâng cao', '5', '10', '20', '70', '1', '5');
INSERT INTO `monhoc` VALUES ('2', 'Cấu trúc dữ liệu', '5', '10', '20', '70', '2', '5');
INSERT INTO `monhoc` VALUES ('3', 'Toán cao cấp', '3', '10', '30', '60', '3', '3');
INSERT INTO `monhoc` VALUES ('4', 'Vật lý', '4', '10', '30', '60', '4', '5');
INSERT INTO `monhoc` VALUES ('5', 'Tiếng Anh', '6', '10', '20', '70', '5', '4');
INSERT INTO `monhoc` VALUES ('6', 'Đường lối CM', '3', '10', '20', '70', '6', '2');

-- ----------------------------
-- Table structure for nganh
-- ----------------------------
DROP TABLE IF EXISTS `nganh`;
CREATE TABLE `nganh` (
  `nganh_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `manganh` varchar(45) NOT NULL DEFAULT '',
  `tennganh` varchar(45) NOT NULL DEFAULT '',
  `ghichu` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`nganh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nganh
-- ----------------------------
INSERT INTO `nganh` VALUES ('1', 'IT', 'Công nghệ thông tin', '');
INSERT INTO `nganh` VALUES ('2', 'SET', 'Điện tử - Viễn thông', '');


-- ----------------------------
-- Table structure for tongiao
-- ----------------------------
DROP TABLE IF EXISTS `tongiao`;
CREATE TABLE `tongiao` (
  `tongiao_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tentongiao` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`tongiao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tongiao
-- ----------------------------
INSERT INTO `tongiao` VALUES ('1', 'Không');
INSERT INTO `tongiao` VALUES ('2', 'Đạo Phật');
INSERT INTO `tongiao` VALUES ('3', 'Đạo Thiên Chúa');
INSERT INTO `tongiao` VALUES ('4', 'Đạo Hồi');
INSERT INTO `tongiao` VALUES ('5', 'Đạo Hindu');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL DEFAULT '',
  `hovaten` varchar(255) NOT NULL DEFAULT '',
  `diachi` varchar(255) DEFAULT NULL,
  `sodienthoai` varchar(255) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `socmt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'Nguyễn Thị Thùy', '283 Khương Trung', '919445462', '1988-08-05', '164608972');
INSERT INTO `user` VALUES ('2', 'bdmin', 'bdmin', 'Nguyễn Minh Anh', '72 Nguyễn An Ninh', '1659757383', '1995-02-07', '722772272');

