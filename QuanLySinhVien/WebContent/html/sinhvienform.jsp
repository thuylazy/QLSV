<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<title>Hệ thống quản lý sinh viên</title>
	<link rel="stylesheet" href="css/style.css" media="all" />
	<script src="js/jquery.ajaxfileupload.js"></script>
	<script>
		function redirect(dmName) {
			window.location.href = "ListDM.do?name=" + dmName;
		}
	</script>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
	<link href="css/jquery.datepick.css" rel="stylesheet">
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/jquery.plugin.js"></script>
	<script src="js/jquery.datepick.js"></script>
	<script>
	$(function() {
		$('#popupDatepicker').datepick();
		$('#popupDatepicker2').datepick();
		//$('#inlineDatepicker').datepick({onSelect: showDate});
	});

	function showDate(date) {
		alert('The date chosen is ' + date);
	}

	$(document).ready(function(){
		$('#fileUpload').ajaxfileupload({
			'action': 'UploadFile.do',
			'onComplete': function(response) {
				$('#upload').hide();
				alert("File SAVED!!");
			},
			'onStart': function() {
				$('#upload').show();
			}
		});
	});

	function imagepreview(input) {
		if (input.files && input.files[0]) {
			var filerdr = new FileReader();

			filerdr.onload = function(e) {
				$('#imageUpload').attr('src', e.target.result);
			}
			filerdr.readAsDataURL(input.files[0]);
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
			<span class="icon"><img src="./images/icon/qlsv.png"></span>
			<hgroup>
				<h1>QUẢN LÝ SINH VIÊN</h1>
				<h2>Quản lý các thông tin của sinh viên</h2>
			</hgroup>
		</header>
		<div class="content cycle">
<h1>QUẢN LÝ THÔNG TIN SINH VIÊN</h1>
<c:forEach items="${lsMessage}" var="message">
		<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
	</c:forEach>
	<br />

	<form action="SinhVienProcess.do?submit=true" method="post" id="searchform-sinhvien">
		<input type="hidden" name="ref" value="${ref}" />
		<input type="hidden" name="id" value="${id}" />
		<table align="center" class="add-sinhvien">
			<tr>
				<td class="pick-image" colspan="2">
					<span>Ảnh sinh viên</span>
					<div>
						<input id="fileUpload" onchange="imagepreview(this)" type="file" name="anhsinhvien" value="" />
					</div>
					<div>
					<c:choose>
						<c:when test="${sinhvien.anhSinhVien eq 'img' || sinhvien.anhSinhVien eq '' || sinhvien.anhSinhVien == null}">
							<img id="imageUpload" src="./images/no_img.png" alt=""/>
						</c:when>
						<c:otherwise>
							<img id="imageUpload" src="${sinhvien.anhSinhVien}" alt=""/>
						</c:otherwise>
					</c:choose>
					</div>
				</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>
					Mã sinh viên
					<input type="text" name="masinhvien" value="${sinhvien.maSinhVien}" />
				</td>
				<td>
					Họ đệm
					<input type="text" name="hodem" value="${sinhvien.hoDem}" />
				</td>
				<td>
					Tên
					<input type="text" name="ten" value="${sinhvien.ten}" />
				</td>
				<td>
					Ngày sinh
					<fmt:formatDate var="ngaysinh" value="${sinhvien.ngaySinh}" pattern="yyyy-MM-dd" />
					<input type="text" id="popupDatepicker" data-datepick="dateFormat: 'yyyy-mm-dd'" value="${sinhvien.ngaySinh}" name="ngaysinh" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td>
					Giới tính
					<select name="gioitinh">
						<c:choose>
							<c:when test="${sinhvien.gioiTinh eq 1}">
								<option value="-1">
									Chọn giới tính
								</option>
								<option value="1" SELECTED>
									Nam
								</option>
								<option value="0">
									Nữ
								</option>
							</c:when>
							<c:when test="${sinhvien.gioiTinh eq 0}">
								<option value="-1">
									Chọn giới tính
								</option>
								<option value="1">
									Nam
								</option>
								<option value="0" SELECTED>
									Nữ
								</option>
							</c:when>
							<c:otherwise>
								<option value="-1" SELECTED>
									Chọn giới tính
								</option>
								<option value="1">
									Nam
								</option>
								<option value="0">
									Nữ
								</option>
							</c:otherwise>
						</c:choose>
					</select>
				</td>
				<td>
					Số chứng minh thư
					<input type="text" name="cmtnd" value="${sinhvien.cmtnd}" />
				</td>
				<td>
					Số điện thoại
					<input type="text" name="sodienthoai" value="${sinhvien.soDienThoai}" />
				</td>
				<td>
					Nơi sinh
					<input type="text" name="noisinh" value="${sinhvien.noiSinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Quê quán
					<input type="text" name="quequan" value="${sinhvien.queQuan}" />
				</td>
				<td>
					Hộ khẩu thường trú
					<input type="text" name="hokhauthuongtru" value="${sinhvien.hoKhauThuongTru}" />
				</td>
				<td>
					Nơi ở hiện tại
					<input type="text" name="noiohientai" value="${sinhvien.noiOHienTai}" />
				</td>
				<td>
					Chế độ ưu đãi
					<input type="text" name="chedouudai" value="${sinhvien.cheDoUuDai}" />
				</td>
			</tr>
			<tr>
				<td>
					Dân tộc
					<select name="dantoc">
						<option value="-1">
							Chọn dân tộc
						</option>
						<c:forEach items="${lsDanToc}" var="danToc">
							<c:choose>
								<c:when test="${danToc.danTocId == sinhvien.danTocId}">
									<option value="${danToc.danTocId}" SELECTED>
										<c:out value="${danToc.tenDanToc}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${danToc.danTocId}">
										<c:out value="${danToc.tenDanToc}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					Tôn giáo
					<select name="tongiao">
						<option value="-1">
							Chọn tôn giáo
						</option>
						<c:forEach items="${lsTonGiao}" var="tonGiao">
							<c:choose>
								<c:when test="${tonGiao.tonGiaoId == sinhvien.tonGiaoId}">
									<option value="${tonGiao.tonGiaoId}" SELECTED>
										<c:out value="${tonGiao.tenTonGiao}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${tonGiao.tonGiaoId}">
										<c:out value="${tonGiao.tenTonGiao}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					Quốc tịch
					<select name="quoctich">
						<option value="-1">
							Chọn quốc tịch
						</option>
						<c:forEach items="${lsQuocTich}" var="quocTich">
							<c:choose>
								<c:when test="${quocTich.quocTichId == sinhvien.quocTichId}">
									<option value="${quocTich.quocTichId}" SELECTED>
										<c:out value="${quocTich.tenQuocTich}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${quocTich.quocTichId}">
										<c:out value="${quocTich.tenQuocTich}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					Họ tên bố
					<input type="text" name="hotenbo" value="${sinhvien.hoTenBo}" />
				</td>
				<td>
					Nghề nghiệp bố
					<input type="text" name="nghenghiepbo" value="${sinhvien.ngheNghiepBo}" />
				</td>
				<td>
					Họ tên mẹ
					<input type="text" name="hotenme" value="${sinhvien.hoTenMe}" />
				</td>
				<td>
					Nghề nghiệp mẹ
					<input type="text" name="nghenghiepme" value="${sinhvien.ngheNghiepMe}" />
				</td>
			</tr>
			<tr>
				<td>
					Hệ đào tạo
					<select name="hedaotao">
						<option value="-1">
							Chọn hệ đào tạo
						</option>
						<c:forEach items="${lsHdt}" var="heDaoTao">
							<c:choose>
								<c:when test="${heDaoTao.heDtId == heDtId}">
									<option value="${heDaoTao.heDtId}" SELECTED>
										<c:out value="${heDaoTao.tenHeDt}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${heDaoTao.heDtId}">
										<c:out value="${heDaoTao.tenHeDt}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					Tên lớp học
					<select name="lophoc">
						<option value="-1">
							Chọn lớp học
						</option>
						<c:forEach items="${lsLop}" var="lopHoc">
							<c:choose>
								<c:when test="${lopHoc.lopHocId == sinhvien.lopId}">
									<option value="${lopHoc.lopHocId}" SELECTED>
										<c:out value="${lopHoc.tenLopHoc}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${lopHoc.lopHocId}">
										<c:out value="${lopHoc.tenLopHoc}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					Tên khóa học
					<select name="khoahoc">
						<option value="-1">
							Chọn khóa học
						</option>
						<c:forEach items="${lsKhoaHoc}" var="khoaHoc">
							<c:choose>
								<c:when test="${khoaHoc.khoaHocId == sinhvien.khoaHocId}">
									<option value="${khoaHoc.khoaHocId}" SELECTED>
										<c:out value="${khoaHoc.tenKhoaHoc}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${khoaHoc.khoaHocId}">
										<c:out value="${khoaHoc.tenKhoaHoc}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					Ngày nhập học
					<fmt:formatDate var="ngaynhaphoc" value="${sinhvien.ngayNhapHoc}" pattern="yyyy-MM-dd" />
					<input type="text" id="popupDatepicker2" data-datepick="dateFormat: 'yyyy-mm-dd'" value="${sinhvien.ngayNhapHoc}" name="ngaynhaphoc" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 1
					<input type="text" name="diemdauvao1" value="${sinhvien.diemDauVao1}" />
				</td>
				<td>
					Điểm đầu vào 2
					<input type="text" name="diemdauvao2" value="${sinhvien.diemDauVao2}" />
				</td>
				<td>
					Điểm đầu vào 3
					<input type="text" name="diemdauvao3" value="${sinhvien.diemDauVao3}" />
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