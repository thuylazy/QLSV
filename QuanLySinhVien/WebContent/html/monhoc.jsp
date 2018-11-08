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
			<span class="icon"><img src="./images/icon/qlmh.png"></span>
			<hgroup>
				<h1>QUẢN LÝ MÔN HỌC</h1>
				<h2>Quản lý các môn học</h2>
			</hgroup>
		</header>
		<div class="content cycle">
		<h1>QUẢN LÝ MÔN HỌC</h1>
		<c:forEach items="${lsMessage}" var="message">
		<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
	</c:forEach>
	<br />

	<c:if test="${showTable == null}">
	<h2 class="form-headline">Quản lý các môn học</h2>
	<form action="MonHoc.do" name="searchform" id="searchform" method="post">
		<table align="center" class="searchbox">
			<tr>
				<td>
					ID
				</td>
				<td>
					<input type="text" name="monhocid" value="${monhocid}" />
				</td>
				<td colspan="4" valign="middle" align="center">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Tìm kiếm" />
				</td>
			</tr>
			<tr>
				<td>
					Tên môn học
				</td>
				<td>
					<input type="text" name="tenmonhoc" value="${tenmonhoc}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên chuyên ngành
				</td>
				<td>
					<input type="text" name="tenchuyennganh" value="${tenchuyennganh}" />
				</td>
			</tr>
			<tr>
				<td>
					Số trình
				</td>
				<td>
					<input type="text" name="sotrinh" value="${sotrinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Hệ số chuyên cần
				</td>
				<td>
					<input type="text" name="hesochuyencan" value="${hesochuyencan}" />
				</td>
			</tr>
			<tr>
				<td>
					Hệ số giữa kỳ
				</td>
				<td>
					<input type="text" name="hesogiuaky" value="${hesogiuaky}" />
				</td>
			</tr>
			<tr>
				<td>
					Hệ số học kỳ
				</td>
				<td>
					<input type="text" name="hesohocky" value="${hesohocky}" />
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
								<c:when test="${chuyenNganh.chuyenNganhId == chuyennganhid}">
									<option value="${chuyennganh.chuyenNganhId}" SELECTED>
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
		</table>
	</form>

	<div class="list-wrapper">
	<h2>Danh sách lớp học</h2>
	<form action="MonHocProcess.do" method="post">
		<input type="hidden" name="ref" value="add" />
		<table align="center" class="list-result">
			<tr>
				<th>
					ID
				</th>
				<th>
					TÊN MÔN HỌC
				</th>
				<th>
					CHUYÊN NGÀNH
				</th>
			</tr>
			<c:forEach items="${lsData}" var="monHoc">
				<tr>
					<td>
						<a href="MonHocDetail.do?id=${monHoc.monHocId}" ><c:out value="${monHoc.monHocId}" /></a>
					</td>
					<td>
						<c:out value="${monHoc.tenMonHoc}" />
					</td>
					<td>
						<c:forEach items="${lsChuyenNganh}" var="chuyenNganh">
							<c:if test="${monHoc.chuyenNganhId == chuyenNganh.chuyenNganhId}">
								<c:out value="${chuyenNganh.tenChuyenNganh}" />
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>

		<div class="paging" align="center">
			<c:if test="${totalPage > 1}">
					<c:set var="i" value="1" />
					<c:forEach items="${lsPage}" var="curPage">
						<c:if test="${curPage > 1 && i == 1}">
							<a href='/QuanLySinhVien/MonHoc.do?page=<c:out value="${curPage - range}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&laquo;</a>
						</c:if>
						<c:choose>
							<c:when test="${page == curPage}">
								<a><c:out value="${curPage}" /></a>
							</c:when>
							<c:otherwise>
								<a href='/QuanLySinhVien/MonHoc.do?page=<c:out value="${curPage}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'><c:out value="${curPage}" /></a>
							</c:otherwise>
						</c:choose>
						<c:if test="${curPage < totalPage && i == (fn:length(lsPage))}">
							<a href='/QuanLySinhVien/MonHoc.do?page=<c:out value="${curPage + 1}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&raquo;</a>
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
		</div>.

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