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
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
	<!--[if lt IE 9]><link rel="stylesheet" href="css/lt-ie-9.css" media="all" /><![endif]-->
	<script type="text/javascript">
	  document.onkeydown = function(){
	     if(window.event && window.event.keyCode == 116){ // Capture and remap F5
	         window.event.keyCode = 505;
	     }
	     if(window.event && window.event.keyCode == 505){ // New action for F5
	         return false;  // Must return false or the browser will refresh anyway
	    }
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
		<h1>QUẢN LÝ NGÀNH HỌC</h1>
		<c:forEach items="${lsMessage}" var="message">
		<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
	</c:forEach>
	<br />

	<c:if test="${showTable == null}">
	<h2 class="form-headline">Quản lý các ngành học</h2>
	<form action="Nganh.do" name="searchform" id="searchform" method="post">
		<table align="center" class="searchbox">
			<tr>
				<td>
					Mã ngành
				</td>
				<td>
					<input type="text" name="manganh" value="${manganh}" />
				</td>
				<td colspan="2" valign="middle" align="center">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Tìm kiếm" />
				</td>
			</tr>
			<tr>
				<td>
					Tên ngành
				</td>
				<td>
					<input type="text" name="tennganh" value="${tennganh}" />
				</td>
			</tr>
		</table>
	</form>
	<div class="list-wrapper">
	<h2>Danh sách ngành học</h2>
	<form action="NganhProcess.do" method="post">
		<input type="hidden" value="add" name="ref" />
		<table align="center" class="list-result">
			<tr>
				<th>
					MÃ NGÀNH
				</th>
				<th>
					TÊN NGÀNH
				</th>
			</tr>
			<c:forEach items="${lsData}" var="nganh">
				<tr>
					<td>
						<a href="NganhDetail.do?id=${nganh.nganhId}" ><c:out value="${nganh.maNganh}" /></a>
					</td>
					<td>
						<c:out value="${nganh.tenNganh}" />
					</td>
				</tr>
			</c:forEach>
		</table>

		<div class="paging" align="center">
			<c:if test="${totalPage > 1}">
					<c:set var="i" value="1" />
					<c:forEach items="${lsPage}" var="curPage">
						<c:if test="${curPage > 1 && i == 1}">
							<a href='/QuanLySinhVien/Nganh.do?page=<c:out value="${curPage - range}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&laquo;</a>
						</c:if>
						<c:choose>
							<c:when test="${page == curPage}">
								<a><c:out value="${curPage}" /></a>
							</c:when>
							<c:otherwise>
								<a href='/QuanLySinhVien/Nganh.do?page=<c:out value="${curPage}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'><c:out value="${curPage}" /></a>
							</c:otherwise>
						</c:choose>
						<c:if test="${curPage < totalPage && i == (fn:length(lsPage))}">
							<a href='/QuanLySinhVien/Nganh.do?page=<c:out value="${curPage + 1}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&raquo;</a>
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
			</table>
		</div>
		</div>
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