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
	function onDelete() {
		document.getElementsByName('ref')[0].value = "delete";
		document.getElementById('form').action = "LopHocProcess.do?submit=true";
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
		<p>Welcome back <c:out value="${loginId}" /></p>
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
			<span class="icon"><img src="./images/icon/qllh.png"></span>
			<hgroup>
				<h1>QUẢN LÝ LỚP HỌC</h1>
				<h2>Danh sách các lớp học</h2>
			</hgroup>
		</header>
		<div class="content cycle">
		<h1>THÔNG TIN CHI TIẾT LỚP HỌC</h1>
			<form action="LopHocProcess.do" method="post" id="form">
				<input type="hidden" name="id" value="${id}" />
				<input type="hidden" name="ref" value="update" />
				<table align="center" class="searchbox mar30-0">
					<tr>
						<td>
							ID
						</td>
						<td class="td-result">
							<c:out value="${lophoc.lopHocId}" />
						</td>
					</tr>
					<tr>
						<td>
							Tên lớp học
						</td>
						<td class="td-result">
							<c:out value="${lophoc.tenLopHoc}" />
						</td>
					</tr>
					<tr class="btn">
						<td>
							<input type="submit" value="Chỉnh Sửa" name="btnUpdate" />
						</td>
						<td>
							<input type="button" value="Xóa" name="btnDelete" onclick="onDelete();" />
						</td>
						<td>
							<input type="button" value="Trở về" name="btnBack" onclick="window.location.href='ChuyenNganh.do';" />
						</td>
					</tr>
				</table>
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