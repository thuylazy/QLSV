<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<title>Retina Dashboard</title>
	<link rel="stylesheet" href="css/style.css" media="all" />
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
	<!--[if lt IE 9]><link rel="stylesheet" href="css/lt-ie-9.css" media="all" /><![endif]-->
</head>
<script>
	function onDelete() {
		document.getElementsByName('ref')[0].value = "delete";
		document.getElementById('form').action = "KhoaHocProcess.do?submit=true";
		document.getElementById('form').submit();
	}
</script>
<body>
<div class="testing">
<header class="main">
	<h1><strong>Retina</strong> Dashboard</h1>
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
			<span class="icon"><img src="./images/icon/qlkh.png"></span>
			<hgroup>
				<h1>QUẢN LÝ KHÓA HỌC</h1>
				<h2>Quản lý các khóa học</h2>
			</hgroup>
		</header>
		<div class="content cycle">
		<h1>QUẢN LÝ KHÓA HỌC</h1>
			<form action="KhoaHocProcess.do" method="post" id="form">
				<input type="hidden" name="id" value="${id}" />
				<input type="hidden" value="update" name="ref" />
				<table align="center" class="searchbox mar30-0">
					<tr>
						<td>
							ID
						</td>
						<td class="td-result">
							<c:out value="${khoahoc.khoaHocId}" />
						</td>
					</tr>
					<tr>
						<td>
							Tên khóa học
						</td>
						<td class="td-result">
							<c:out value="${khoahoc.tenKhoaHoc}" />
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
							<input type="button" value="Trở về" name="btnBack" onclick="window.location.href='KhoaHoc.do';" />
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