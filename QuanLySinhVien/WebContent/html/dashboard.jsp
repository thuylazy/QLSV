<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
	<title>Hệ thống Quản lý sinh viên</title>
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
		<h1>
			<strong>Hệ thống</strong> Quản lý sinh viên
		</h1>
		<input type="text" value="search" /> </header>
		<section class="user">
		<div class="profile-img">
			<p>
				<img src="./images/uiface2.png" alt="" height="40" width="40" />
				Welcome back
				<c:out value="${loginId}" />
			</p>
		</div>
		<div class="buttons">
			<span class="button">Help</span> <span class="button blue"><a
				href="/QuanLySinhVien/Logout.do">Đăng xuất</a></span>
		</div>
		</section>
	</div>
	<jsp:include page="left-menu.jsp"></jsp:include>

	<section class="content"> <section class="widget">
	<header> <span class="icon"><img
		src="./images/icon/dashboard-icon.png"></span> <hgroup>
	<h1>QUẢN LÝ DANH MỤC</h1>
	<h2>Danh sách các danh mục</h2>
	</hgroup> </header>
	<div class="content cycle">


		<table align="center" class="dashboard-table">
			<tr>
				<td><input type="button" name="btnQLSV"
					value="Quản Lý Hồ Sơ Sinh Viên" onclick="redirect('sinhvien')" />
				</td>
				<td><input type="button" name="btnQLCN"
					value="Quản Lý Chuyên Ngành" onclick="redirect('chuyennganh')" />
				</td>
				<td><input type="button" name="btnQLDT" value="Quản Lý Dân Tộc"
					onclick="redirect('dantoc')" /></td>
				<td><input type="button" name="btnQLHK" value="Quản Lý Học Kỳ"
					onclick="redirect('hocky')" /></td>
				<td><input type="button" name="btnQLKH"
					value="Quản Lý Khóa Học" onclick="redirect('khoahoc')" /></td>
				<td><input type="button" name="btnQLLH" value="Quản Lý Lớp Học"
					onclick="redirect('lophoc')" /></td>
				<td><input type="button" name="btnQLMH" value="Quản Lý Môn Học"
					onclick="redirect('monhoc')" /></td>
				<td><input type="button" name="btnQLN" value="Quản Lý Ngành"
					onclick="redirect('nganh')" /></td>
				<td><input type="button" name="btnQLTG"
					value="Quản Lý Tôn Giáo" onclick="redirect('tongiao')" /></td>
			</tr>
		</table>


	</div>
	</section> </section>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
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
			fx : "scrollHorz",
			timeout : 0,
			slideResize : 0,
			prev : '.left-btn',
			next : '.right-btn'
		});
	</script>
</body>
</html>