<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
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
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
	<!--[if lt IE 9]><link rel="stylesheet" href="css/lt-ie-9.css" media="all" /><![endif]-->
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
	<h1><strong>Hệ thống</strong>Quản lý sinh viên</h1>
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
			<span class="icon"><img src="./images/icon/qlcn.png"></span>
			<hgroup>
				<h1>QUẢN LÝ CHUYÊN NGÀNH </h1>
				<h2>Danh sách các ngành học </h2>
			</hgroup>
		</header>
		<div class="content cycle">
		<h1>THÔNG TIN CHI TIẾT CHUYÊN NGÀNH </h1>
		<form action="ChuyenNganhProcess.do" method="post" id="form">
		<input type="hidden" value="update" name="ref" />
		<input type="hidden" value="${chuyennganh.chuyenNganhId}" name="id" />
		<table align="center" class="searchbox mar30-0">
			<tr>
				<td>
					Mã Chuyên Ngành:
				</td>
				<td colspan="2" class="td-result">
					<c:out value="${chuyennganh.maChuyenNganh}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên Chuyên Ngành:
				</td>
				<td colspan="2" class="td-result">
					<c:out value="${chuyennganh.tenChuyenNganh}" />
				</td>
			</tr>
			<tr>
				<td>
					Ngành:
				</td>
				<td colspan="2" class="td-result">
					<c:forEach items="${lsNganh}" var="nganh">
						<c:if test="${nganh.nganhId == chuyennganh.nganhId}">
							<c:out value="${nganh.tenNganh}" />
						</c:if>
					</c:forEach>
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