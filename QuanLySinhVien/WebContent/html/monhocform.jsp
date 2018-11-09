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
			<span class="icon"><img src="./images/icon/qlmh.png"></span>
			<hgroup>
				<h1>QUẢN LÝ MÔN HỌC</h1>
				<h2>Quản lý các môn học</h2>
			</hgroup>
		</header>
		<div class="content cycle">
		<h1>THÊM MỚI MÔN HỌC</h1>
			<c:forEach items="${lsMessage}" var="message">
				<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
			</c:forEach>
			<br />

			<form action="MonHocProcess.do?submit=true" method="post">
				<input type="hidden" name="ref" value="${ref}" />
				<input type="hidden" name="id" value="${id}" />
				<table align="center" class="searchbox">
					<tr>
						<td>
							Tên môn học
						</td>
						<td>
							<input type="text" name="tenmonhoc" value="${monhoc.tenMonHoc}" />
						</td>
					</tr>
					<tr>
						<td>
							Số trình
						</td>
						<td>
							<input type="text" name="sotrinh" value="${monhoc.soTrinh}" />
						</td>
					</tr>
					<tr>
						<td>
							Hệ số chuyên cần
						</td>
						<td>
							<c:choose>
								<c:when test="${monhoc.heSoChuyenCan > 0}">
									<input type="text" name="hesochuyencan" value="${monhoc.heSoChuyenCan}" />
								</c:when>
								<c:otherwise>
									<input type="text" name="hesochuyencan" value="" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td>
							Hệ số giữa kỳ
						</td>
						<td>
							<c:choose>
								<c:when test="${monhoc.heSoGiuaKy > 0}">
									<input type="text" name="hesogiuaky" value="${monhoc.heSoGiuaKy}" />
								</c:when>
								<c:otherwise>
									<input type="text" name="hesogiuaky" value="" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td>
							Hệ số học kỳ
						</td>
						<td>
							<c:choose>
								<c:when test="${monhoc.heSoHocKy > 0}">
									<input type="text" name="hesohocky" value="${monhoc.heSoHocKy}" />
								</c:when>
								<c:otherwise>
									<input type="text" name="hesohocky" value="" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td>
							Chuyên ngành
						</td>
						<td>
							<select name="chuyennganhid">
								<option value="-1">
									Chọn chuyên ngành
								</option>
								<c:forEach items="${lsChuyenNganh}" var="chuyenNganh">
									<c:choose>
										<c:when test="${chuyenNganh.chuyenNganhId == monhoc.chuyenNganhId}">
											<option value="${chuyenNganh.chuyenNganhId}" SELECTED>
												<c:out value="${chuyenNganh.tenChuyenNganh}" />
											</option>
										</c:when>
										<c:otherwise>
											<option value="${chuyenNganh.chuyenNganhId}">
												<c:out value="${chuyenNganh.tenChuyenNganh}" />
											</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
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