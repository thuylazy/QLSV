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
			document.getElementById('form').action = "NganhProcess.do?submit=true";
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
			<span class="icon"><img src="./images/icon/qln.png"></span>
			<hgroup>
				<h1>QUẢN LÝ NGÀNH HỌC</h1>
				<h2>Quản lý các ngành học</h2>
			</hgroup>
		</header>
		<div class="content cycle">
		<h1>CHI TIẾT NGÀNH HỌC</h1>
			<form action="NganhProcess.do" method="post" id="form">
				<input type="hidden" value="update" name="ref" />
				<input type="hidden" value="${id}" name="id" />
				<table align="center" class="searchbox mar30-0">
					<tr>
						<td>
							Mã ngành
						</td>
						<td class="td-result">
							<c:out value="${nganh.maNganh}" />
						</td>
					</tr>
					<tr>
						<td>
							Tên ngành
						</td>
						<td class="td-result">
							<c:out value="${nganh.tenNganh}" />
						</td>
					</tr>
					<tr>
						<td>
							Ghi Chú
						</td>
						<td class="td-result">
							<c:out value="${nganh.ghiChu}" />
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
							<input type="button" value="Trở về" name="btnBack" onclick="window.location.href='Nganh.do';" />
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