<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<p> Welcome back <c:out value="${loginId}" /></p>
	</div>
	<div class="buttons">
		<span class="button">Live</span>
		<span class="button">Help</span>
		<span class="button blue"><a href="/QuanLySinhVien/Logout.do">Đăng xuất</a></span>
	</div>
</section>
</div>
<jsp:include page="left-menu.jsp"></jsp:include>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128200;</span>
			<hgroup>
				<h1>QUẢN LÝ DANH MỤC</h1>
				<h2>Danh sách các danh mục</h2>
			</hgroup>
		</header>
		<div class="content cycle">


			<table align="center">
				<tr>
					<td>
						<input type="button" name="btnQLSV" value="Quản Lý Hồ Sơ Sinh Viên" onclick="redirect('sinhvien')" />
					</td>
					<td>
						<input type="button" name="btnQLCN" value="Quản Lý Chuyên Ngành" onclick="redirect('chuyennganh')" />
					</td>
					<td>
						<input type="button" name="btnQLDT" value="Quản Lý Dân Tộc" onclick="redirect('dantoc')" />
					</td>
					<td>
						<input type="button" name="btnQLHDT" value="Quản Lý Hệ Đào Tạo" onclick="redirect('hedaotao')" />
					</td>
					<td>
						<input type="button" name="btnQLHK" value="Quản Lý Học Kỳ" onclick="redirect('hocky')" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" name="btnQLKH" value="Quản Lý Khóa Học" onclick="redirect('khoahoc')" />
					</td>
					<td>
						<input type="button" name="btnQLLH" value="Quản Lý Lớp Học" onclick="redirect('lophoc')" />
					</td>
					<td>
						<input type="button" name="btnQLMH" value="Quản Lý Môn Học" onclick="redirect('monhoc')" />
					</td>
					<td>
						<input type="button" name="btnQLN" value="Quản Lý Ngành" onclick="redirect('nganh')" />
					</td>
					<td>
						<input type="button" name="btnQLQT" value="Quản Lý Quốc Tịch" onclick="redirect('quoctich')" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" name="btnQLTG" value="Quản Lý Tôn Giáo" onclick="redirect('tongiao')" />
					</td>
				</tr>
			</table>


		</div>
		</div>
	</section>

	<!--
	<div class="widget-container">
		<section class="widget small">
			<header>
				<span class="icon">&#59168;</span>
				<hgroup>
					<h1>Latest comments</h1>
					<h2>What they're saying</h2>
				</hgroup>
				<aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox" /></li>
							<li><label>Option b</label><input type="checkbox" checked="checked" /></li>
							<li><label>Option c</label><input type="checkbox" /></li>
						</ul>
					</span>
				</aside>
			</header>
			<div class="content no-padding timeline">
				<div class="tl-post comments">
					<span class="icon">&#59168;</span>
					<p>
						<a href="#">John Doe says:</a> Lorem ipsum dolor sit amet, consecteteur adipiscing elit sed diam nonummy.
						<span class="reply"><input type="text" value="Respond to comment..."/></span>
					</p>
				</div>
				<div class="tl-post comments">
					<span class="icon">&#59168;</span>
					<p>
						<a href="#">John Doe says:</a> Lorem ipsum dolor sit amet, consecteteur adipiscing elit sed diam nonummy.
						<span class="reply"><input type="text" value="Respond to comment..."/></span>
					</p>
				</div>
				<span class="show-more"><a	 href="#">More</a></span>
			</div>
		</section>

		<section class="widget 	small">
			<header>
				<span class="icon">&#128319;</span>
				<hgroup>
					<h1>Quick Post</h1>
					<h2>Speed things up</h2>
				</hgroup>
				<aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox" /></li>
							<li><label>Option b</label><input type="checkbox" checked="checked" /></li>
							<li><label>Option c</label><input type="checkbox" /></li>
						</ul>
					</span>
				</aside>
			</header>
			<div class="content">
				<div class="field-wrap">
					<input type="text" value="Title"/>
				</div>
				<div class="field-wrap">
					<textarea id="quick_post" rows="5"></textarea>
				</div>
				<button type="submit" class="green">Post</button> <button type="submit" class="">Preview</button>
			</div>
		</section>
	</div>

	<div class="widget-container">
		<section class="widget small">
			<header>
				<span class="icon">&#128318;</span>
				<hgroup>
					<h1>Website figures</h1>
					<h2>Facts &amp; figures</h2>
				</hgroup>
				<aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox" /></li>
							<li><label>Option b</label><input type="checkbox" checked="checked" /></li>
							<li><label>Option c</label><input type="checkbox" /></li>
						</ul>
					</span>
				</aside>
			</header>
			<div class="content">
				<section class="stats-wrapper">
					<div class="stats">
						<p><span>64</span></p>
						<p>Pages</p>
					</div>
					<div class="stats">
						<p><span>362</span></p>
						<p>Comments</p>
					</div>
				</section>
				<section class="stats-wrapper">
					<div class="stats">
						<p><span>7</span></p>
						<p>Users</p>
					</div>
					<div class="stats">
						<p><span>927</span></p>
						<p>Assets</p>
					</div>
				</section>
			</div>
		</section>

		<section class="widget small">
			<header>
				<span class="icon">&#128363;</span>
				<hgroup>
					<h1>Timeline</h1>
					<h2>Insiders news</h2>
				</hgroup>
				<aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox" /></li>
							<li><label>Option b</label><input type="checkbox" checked="checked" /></li>
							<li><label>Option c</label><input type="checkbox" /></li>
						</ul>
					</span>
				</aside>
			</header>
			<div class="content no-padding timeline">
				<div class="tl-post">
					<span class="icon">&#128206;</span>
					<p><a href="#">John Doe</a> attached an image to a blog post.</p>
				</div>
				<div class="tl-post">
					<span class="icon">&#59172;</span>
					<p><a href="#">John Doe</a> added his location.</p>
				</div>
				<div class="tl-post">
					<span class="icon">&#59170;</span>
					<p><a href="#">John Doe</a> edited his profile.</p>
				</div>
				<div class="tl-post">
					<span class="icon">&#9993;</span>
					<p><a href="#">John Doe</a> has sent you  private message.</p>
				</div>
				<div class="pie graph-area"></div>
			</div>
		</section>
	</div>
	-->
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