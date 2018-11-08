<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<title>Hệ thống quản lý sinh viên</title>
	<link rel="stylesheet" href="css/style.css" media="all" />
	<script>
		function redirect(dmName) {
			window.location.href = "ListDM.do?name=" + dmName;
		}
	</script>
	<script>
	function onDelete() {
		document.getElementsByName('ref')[0].value = "delete";
		document.getElementById('form').action = "SinhVienProcess.do?submit=true";
		document.getElementById('form').submit();
	}
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
		<p><img src="./images/uiface2.png" alt="" height="40" width="40" /> Welcome back <c:out value="${loginId}" /></p>
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
		<h1>THÔNG TIN CHI TIẾT SINH VIÊN</h1>
		<form action="SinhVienProcess.do" method="post" id="form">
		<input type="hidden" name="id" value="${id}" />
		<input type="hidden" name="ref" value="update" />
		<table align="center" class="sv-details">
			<tr class="anh-sinhvien">
				<td>
					Ảnh sinh viên
				</td>
				<td>
					<img src="${sinhvien.anhSinhVien}">
				</td>
			</tr>
			<tr>
				<td>
					Mã sinh viên
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.maSinhVien}" />
				</td>
				<td>
					Họ đệm
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.hoDem}" />
				</td>
				<td>
					Tên
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.ten}" />
				</td>
				<td>
					Ngày sinh
				</td>
				<td class="td-result">
					<fmt:formatDate var="ngaysinh" value="${sinhvien.ngaySinh}" pattern="yyyy-MM-dd" />
					<c:out value="${sinhvien.ngaySinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Giới tính
				</td>
				<td class="td-result">
					<c:choose>
						<c:when test="${sinhvien.gioiTinh eq 1}">
							Nam
						</c:when>
						<c:otherwise>
							Nữ
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					Số chứng minh thư
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.cmtnd}" />
				</td>
				<td>
					Số điện thoại
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.soDienThoai}" />
				</td>
				<td>
					Nơi sinh
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.noiSinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Quê quán
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.queQuan}" />
				</td>
				<td>
					Hộ khẩu thường trú
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.hoKhauThuongTru}" />
				</td>
				<td>
					Nơi ở hiện tại
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.noiOHienTai}" />
				</td>
				<td>
					Chế độ ưu đãi
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.cheDoUuDai}" />
				</td>
			</tr>
			<tr>
				<td>
					Dân tộc
				</td>
				<td class="td-result">
						<c:forEach items="${lsDanToc}" var="danToc">
								<c:if test="${danToc.danTocId == sinhvien.danTocId}">
										<c:out value="${danToc.tenDanToc}" />
								</c:if>
						</c:forEach>
				</td>
				<td>
					Tôn giáo
				</td>
				<td class="td-result">
						<c:forEach items="${lsTonGiao}" var="tonGiao">
								<c:if test="${tonGiao.tonGiaoId == sinhvien.tonGiaoId}">
										<c:out value="${tonGiao.tenTonGiao}" />
								</c:if>
						</c:forEach>
				</td>
				<td>
					Quốc tịch
				</td>
				<td class="td-result">
						<c:forEach items="${lsQuocTich}" var="quocTich">
								<c:if test="${quocTich.quocTichId == sinhvien.quocTichId}">
										<c:out value="${quocTich.tenQuocTich}" />
								</c:if>
						</c:forEach>
				</td>
				<td>
					Họ tên bố
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.hoTenBo}" />
				</td>
			</tr>
			<tr>
				<td>
					Nghề nghiệp bố
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.ngheNghiepBo}" />
				</td>
				<td>
					Họ tên mẹ
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.hoTenMe}" />
				</td>
				<td>
					Nghề nghiệp mẹ
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.ngheNghiepMe}" />
				</td>
				<td>
					Hệ đào tạo
				</td>
				<td class="td-result">
						<c:forEach items="${lsHdt}" var="heDaoTao">
								<c:if test="${heDaoTao.heDtId == sinhvien.heDtId}">
										<c:out value="${heDaoTao.tenHeDt}" />
								</c:if>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<td>
					Tên lớp học
				</td>
				<td class="td-result">
						<c:forEach items="${lsLop}" var="lopHoc">
								<c:if test="${lopHoc.lopHocId == sinhvien.lopId}">
										<c:out value="${lopHoc.tenLopHoc}" />
								</c:if>
						</c:forEach>
				</td>
				<td>
					Tên khóa học
				</td>
				<td class="td-result">
						<c:forEach items="${lsKhoaHoc}" var="khoaHoc">
								<c:if test="${khoaHoc.khoaHocId == sinhvien.khoaHocId}">
										<c:out value="${khoaHoc.tenKhoaHoc}" />
								</c:if>
						</c:forEach>
				</td>
				<td>
					Ngày nhập học
				</td>
				<td class="td-result">
					<fmt:formatDate var="ngaynhaphoc" value="${sinhvien.ngayNhapHoc}" pattern="yyyy-MM-dd" />
					<c:out value="${sinhvien.ngayNhapHoc}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 1
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.diemDauVao1}" />
				</td>
				<td>
					Điểm đầu vào 2
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.diemDauVao2}" />
				</td>
				<td>
					Điểm đầu vào 3
				</td>
				<td class="td-result">
					<c:out value="${sinhvien.diemDauVao3}" />
				</td>
				<td>
					<a href="Diem.do?svid=${sinhvien.sinhVienId}">QUẢN LÝ ĐIỂM SINH VIÊN</a>
				</td>
			</tr>
		</table>
		<div class="btn">
			<table align="center">
				<tr>
					<td>
						<input type="submit" value="Chỉnh Sửa" name="btnUpdate" />
					</td>
					<td>
						<input type="button" value="Xóa" name="btnDelete" onclick="onDelete();" />
					</td>
					<td>
						<input type="button" value="Trở về" name="btnBack" onclick="window.location.href='SinhVien.do';" />
					</td>
				</tr>
			</table>
		</div>

	</form>
		</div>

	</section>
</section>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
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