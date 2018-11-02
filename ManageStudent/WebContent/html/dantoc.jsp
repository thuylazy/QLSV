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
	<script>
		function redirect(dmName) {
			window.location.href = "ListDM.do?name=" + dmName;
		}
	</script>
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
	<!--[if lt IE 9]><link rel="stylesheet" href="css/lt-ie-9.css" media="all" /><![endif]-->
</head>
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

			<c:if test="${showTable == null}">
			<h2 class="form-headline">Quản lý các dân tộc</h2>
			<form action="DanToc.do" name="searchform" id="searchform" method="post">
				<table align="center" class="searchbox">
					<tr>
						<td>
							ID
						</td>
						<td>
							<input type="text" name="dantocid" value="${dantocid}" />
						</td>
						<td colspan="2" valign="middle" align="center">
							<input type="submit" name="btnSubmit" id="btnSubmit" value="Tìm kiếm" />
						</td>
					</tr>
					<tr>
						<td>
							Tên dân tộc
						</td>
						<td>
							<input type="text" name="tendantoc" value="${tendantoc}" />
						</td>
					</tr>
				</table>
			</form>
		<div class="list-wrapper">
		<h2>Danh sách các dân tộc</h2>
			<form action="DanTocProcess.do" method="post">
		<input type="hidden" name="ref" value="add" />
		<table align="center" class="list-result">
			<tr>
				<th>
					ID
				</th>
				<th>
					TÊN DÂN TỘC
				</th>
			</tr>
			<c:forEach items="${lsData}" var="danToc">
				<tr>
					<td align="right">
						<a href="DanTocDetail.do?id=${danToc.danTocId}" ><c:out value="${danToc.danTocId}" /></a>
					</td>
					<td align="left">
						<c:out value="${danToc.tenDanToc}" />
					</td>
				</tr>
			</c:forEach>
		</table>

		<div class="paging" align="center">
			<c:if test="${totalPage > 1}">
					<c:set var="i" value="1" />
					<c:forEach items="${lsPage}" var="curPage">
						<c:if test="${curPage > 1 && i == 1}">
							<a href='/QuanLySinhVien/DanToc.do?page=<c:out value="${curPage - range}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&laquo;</a>
						</c:if>
						<c:choose>
							<c:when test="${page == curPage}">
								<a><c:out value="${curPage}" /></a>
							</c:when>
							<c:otherwise>
								<a href='/QuanLySinhVien/DanToc.do?page=<c:out value="${curPage}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'><c:out value="${curPage}" /></a>
							</c:otherwise>
						</c:choose>
						<c:if test="${curPage < totalPage && i == (fn:length(lsPage))}">
							<a href='/QuanLySinhVien/DanToc.do?page=<c:out value="${curPage + 1}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&raquo;</a>
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
	</c:if>
	</form>
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