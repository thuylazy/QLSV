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
			document.getElementById('form').action = "DanTocProcess.do?submit=true";
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
			<span class="icon"><img src="./images/icon/qldt.png"></span>
			<hgroup>
				<h1>QUẢN LÝ DÂN TỘC</h1>
				<h2>Danh sách các dân tộc</h2>
			</hgroup>
		</header>
		<div class="content cycle">
		<h1>QUẢN LÝ DÂN TỘC</h1>
			<c:forEach items="${lsMessage}" var="message">
		<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
	</c:forEach>
	<br />

	<form action="DanTocProcess.do?submit=true" method="post">
		<input type="hidden" value="${ref}" name="ref" />
		<input type="hidden" value="${id}" name="id" />
		<table align="center">
			<tr>
				<td>
					Tên dân tộc
				</td>
				<td>
					<input type="text" name="tendantoc" value="${dantoc.tenDanToc}" />
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="middle" align="center">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Submit" />
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