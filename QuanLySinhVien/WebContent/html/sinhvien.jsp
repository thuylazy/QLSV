<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<title>Hệ thống quản lý sinh viên</title>
	<link rel="stylesheet" href="css/style.css" media="all" />
	<link href="css/jquery.datepick.css" rel="stylesheet">
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/jquery.plugin.js"></script>
	<script src="js/jquery.datepick.js"></script>
	<script>
		function redirect(dmName) {
			window.location.href = "ListDM.do?name=" + dmName;
		}
		$(function() {
			$('#popupDatepicker').datepick();
		});
	</script>
</head>
<body>
<div class="testing">
<header class="main">
	<h1><strong>Hệ thống</strong> Quản lý sinh viên</h1>
	<input type="text" value="search" />
</header>
<section class="user">
	<div class="profile-img">
		<p> Welcome back <c:out value="${loginId}" /></p>
	</div>
	<div class="buttons">
		<span class="button">Help</span>
		<span class="button blue"><a href="/QuanLySinhVien/Logout.do">Đăng xuất</a></span>
	</div>
</section>
</div>
<jsp:include page="left-menu.jsp"></jsp:include>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon"><img src="./images/icon/qlsv.png"></span>
			<hgroup>
				<h1>QUẢN LÝ SINH VIÊN</h1>
				<h2>Quản lý các thông tin của sinh viên</h2>
			</hgroup>
		</header>
		<div class="content cycle">
		<h1>QUẢN LÝ SINH VIÊN</h1>
<c:forEach items="${lsMessage}" var="message">
		<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
	</c:forEach>
	<br />

	<c:if test="${showTable == null}">
	<h2 class="form-headline"> Tìm kiếm sinh viên</h1>
	<form action="SinhVien.do" name="searchform" id="searchform-sinhvien" method="post">
		<table align="center" class="searchbox">

			<tr>
				<td>
					Mã sinh viên
					<input type="text" name="masv" value="${masv}" />
				</td>
				<td>
					Họ đệm
					<input type="text" name="hodem" value="${hodem}" />
				</td>
				<td>
					Tên
					<input type="text" name="ten" value="${ten}" />
				</td><td>
					Ngày sinh
					<fmt:formatDate var="ngaysinh" value="${ngaysinh}" pattern="yyyy-MM-dd" />
					<input type="text" id="popupDatepicker" data-datepick="dateFormat: 'yyyy-mm-dd'" value="${ngaysinh}" name="ngaysinh" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td>
					Giới tính
					<select name="gioitinh">
						<c:choose>
							<c:when test="${gioitinh eq 0}" >
								<option value="-1">
									Chọn giới tính
								</option>
								<option value="1">
									Nam
								</option>
								<option value="0" SELECTED>
									Nữ
								</option>
							</c:when>
							<c:when test="${gioitinh eq 1}">
								<option value="-1">
									Chọn giới tính
								</option>
								<option value="1" SELECTED>
									Nam
								</option>
								<option value="0">
									Nữ
								</option>
							</c:when>
							<c:otherwise>
								<option value="-1" SELECTED>
									Chọn giới tính
								</option>
								<option value="1">
									Nam
								</option>
								<option value="0">
									Nữ
								</option>
							</c:otherwise>
						</c:choose>
					</select>
				</td>
				<td>
					Số chứng minh thư
					<input type="text" name="socmt" value="${socmt}" />
				</td>
				<td>
					Số điện thoại
					<input type="text" name="sodienthoai" value="${sodienthoai}" />
				</td><td>
					Nơi sinh
					<input type="text" name="noisinh" value="${noisinh}" />
				</td>
			</tr>

			<!--
			<tr>
				<td>
					Hộ khẩu thường trú
				</td>
				<td>
					<input type="text" name="hokhau" value="${hokhau}" />
				</td>
			</tr>
			<tr>
				<td>
					Nơi ở hiện tại
				</td>
				<td>
					<input type="text" name="noiohientai" value="${noiohientai}" />
				</td>
			</tr>
			-->
			<tr>
				<td>
					Quê quán
					<input type="text" name="quequan" value="${quequan}" />
				</td>
				<td>
					Chế độ ưu đãi
					<input type="text" name="chedo" value="${chedo}" />
				</td>
				<td>
					Dân tộc
					<select name="dantoc">
						<option value="-1">
							Chọn dân tộc
						</option>
						<c:forEach items="${lsDanToc}" var="danToc">
							<c:choose>
								<c:when test="${danToc.danTocId == dantocid}">
									<option value="${danToc.danTocId}" SELECTED>
										<c:out value="${danToc.tenDanToc}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${danToc.danTocId}">
										<c:out value="${danToc.tenDanToc}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					Tôn giáo
					<select name="tongiao">
						<option value="-1">
							Chọn tôn giáo
						</option>
						<c:forEach items="${lsTonGiao}" var="tonGiao">
							<c:choose>
								<c:when test="${tonGiao.tonGiaoId == tongiaoid}">
									<option value="${tonGiao.tonGiaoId}" SELECTED>
										<c:out value="${tonGiao.tenTonGiao}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${tonGiao.tonGiaoId}">
										<c:out value="${tonGiao.tenTonGiao}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>

			<!--<tr>
				<td>
					Họ tên bố
				</td>
				<td>
					<input type="text" name="hotenbo" value="${hotenbo}" />
				</td>
			</tr>
			<tr>
				<td>
					Nghề nghiệp bố
				</td>
				<td>
					<input type="text" name="nghenghiepbo" value="${nghenghiepbo}" />
				</td>
			</tr>
			<tr>
				<td>
					Họ tên mẹ
				</td>
				<td>
					<input type="text" name="hotenme" value="${hotenme}" />
				</td>
			</tr>
			<tr>
				<td>
					Nghề nghiệp mẹ
				</td>
				<td>
					<input type="text" name="nghenghiepme" value="${nghenghiepme}" />
				</td>
			</tr>
			-->
			<tr>

				<td>
					Tên lớp học
					<select name="lophoc">
						<option value="-1">
							Chọn lớp học
						</option>
						<c:forEach items="${lsLop}" var="lopHoc">
							<c:choose>
								<c:when test="${lopHoc.lopHocId == lophocid}">
									<option value="${lopHoc.lopHocId}" SELECTED>
										<c:out value="${lopHoc.tenLopHoc}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${lopHoc.lopHocId}">
										<c:out value="${lopHoc.tenLopHoc}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					Tên khóa học
					<select name="khoahoc">
						<option value="-1">
							Chọn khóa học
						</option>
						<c:forEach items="${lsKhoaHoc}" var="khoaHoc">
							<c:choose>
								<c:when test="${khoaHoc.khoaHocId == khoahocid}">
									<option value="${khoaHoc.khoaHocId}" SELECTED>
										<c:out value="${khoaHoc.tenKhoaHoc}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${khoaHoc.khoaHocId}">
										<c:out value="${khoaHoc.tenKhoaHoc}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>

			<!--<tr>
				<td>
					Ngày nhập học
				</td>
				<td>
					<input type="text" name="ngaynhaphoc" value="${ngaynhaphoc}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 1
				</td>
				<td>
					<input type="text" name="diemdauvao1" value="${diemdauvao1}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 2
				</td>
				<td>
					<input type="text" name="diemdauvao2" value="${diemdauvao2}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 3
				</td>
				<td>
					<input type="text" name="diemdauvao3" value="${diemdauvao3}" />
				</td>
			</tr>
			-->

				<td>
					Học kỳ
					<select name="hocky">
						<option value="-1">
							Chọn học kỳ
						</option>
						<c:forEach items="${lsHocKy}" var="hocKy">
							<c:choose>
								<c:when test="${hocKy.hocKyId == hockyid}">
									<option value="${hocKy.hocKyId}" SELECTED>
										<c:out value="${hocKy.tenHocKy}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${hocKy.hocKyId}">
										<c:out value="${hocKy.tenHocKy}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<tr>
				<td colspan="4" valign="middle" align="center">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Tìm kiếm" />
				</td>
				</tr>
			</tr>
		</table>
	</form>
	<div class="list-wrapper">
	<h2>Danh sách kết quả tìm kiếm sinh viên</h2>
	<form action="SinhVienProcess.do" method="post">
		<input type="hidden" name="ref" value="add" />
		<table align="center" class="list-result">
			<thead>
				<th class="header">
					MÃ SINH VIÊN
				</th>
				<th class="header">
					HỌ ĐỆM
				</th>
				<th class="header">
					TÊN
				</th>
				<th class="header">
					NGÀY SINH
				</th>
				<th class="header">
					GIỚI TÍNH
				</th>
				<th class="header">
					LỚP
				</th>
				<th class="header">
					KHÓA HỌC
				</th>
			</thead>
			<c:forEach items="${lsData}" var="sinhVien">
				<tr>
					<td>
						<a href="SinhVienDetail.do?id=${sinhVien.sinhVienId}"><c:out value="${sinhVien.maSinhVien}" /></a>
					</td>
					<td>
						<c:out value="${sinhVien.hoDem}" />
					</td>
					<td>
						<c:out value="${sinhVien.ten}" />
					</td>
					<td>
						<fmt:formatDate pattern="yyyy/MM/dd" value="${sinhVien.ngaySinh}" />
					</td>
					<td>
						<c:choose>
							<c:when test="${sinhVien.gioiTinh eq 1}">
								Nam
							</c:when>
							<c:otherwise>
								Nữ
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:forEach items="${lsLop}" var="lop">
							<c:if test="${sinhVien.lopId == lop.lopHocId}">
								<c:out value="${lop.tenLopHoc}" />
							</c:if>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${lsKhoaHoc}" var="khoaHoc">
							<c:if test="${sinhVien.khoaHocId == khoaHoc.khoaHocId}">
								<c:out value="${khoaHoc.tenKhoaHoc}" />
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>

		<div class="paging">
			<c:if test="${totalPage > 1}">
					<c:set var="i" value="1" />
					<c:forEach items="${lsPage}" var="curPage">
						<c:if test="${curPage > 1 && i == 1}">
							<a href='/QuanLySinhVien/SinhVien.do?page=<c:out value="${curPage - range}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&laquo;</a>
						</c:if>
						<c:choose>
							<c:when test="${page == curPage}">
								<a><c:out value="${curPage}" /></a>
							</c:when>
							<c:otherwise>
								<a href='/QuanLySinhVien/SinhVien.do?page=<c:out value="${curPage}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'><c:out value="${curPage}" /></a>
							</c:otherwise>
						</c:choose>
						<c:if test="${curPage < totalPage && i == (fn:length(lsPage))}">
							<a href='/QuanLySinhVien/SinhVien.do?page=<c:out value="${curPage + 1}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&raquo;</a>
						</c:if>
						<c:set var="i" value="${i + 1}" />
					</c:forEach>
			</c:if>
		</div>

	<div class="btn">
			<table align="center">
				<tr>
					<td>
						<input type="submit" name="btnAdd" value="Thêm" />
					</td>
	</form>
	</c:if>
					<td>
						<input type="button" name="btnBack" value="Trở Về" onclick="window.history.back()" />
					</td>

				</tr>
				<tr>
					<td>
						<select>
						  <option value="volvo">Chọn Thông tin cần xuất</option>
						  <option value="saab">Value</option>
						  <option value="mercedes">Value</option>
						  <option value="audi">Value</option>
						</select>
					</td>
					<td>
						<input type="button" name="btnBack" value="In ra" onclick="window.history.back()" />
					</td>
				</tr>
			</table>
		</div>
		</div>
		</div>
	</section>
</section>
<script src="../js/jquery.wysiwyg.js"></script>
<script src="../js/custom.js"></script>
<script src="../js/cycle.js"></script>
<script src="../js/jquery.checkbox.min.js"></script>
<script src="../js/flot.js"></script>
<script src="../js/flot.resize.js"></script>
<script src="../js/flot-time.js"></script>
<script src="../js/flot-pie.js"></script>
<script src="../js/flot-graphs.js"></script>
<script src="../js/cycle.js"></script>
<script src="../js/jquery.tablesorter.min.js"></script>
<script type="text/javascript">
// Feature slider for graphs
$('.cycle').cycle({
	fx: "scrollHorz",
	timeout: 0,
    slideResize: 0,
    prev:    '.left-btn',
    next:    '.right-btn'
});
</script>
</body>
</html>