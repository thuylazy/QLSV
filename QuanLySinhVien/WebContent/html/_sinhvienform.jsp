<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</script>
</head>
<body>
	<c:forEach items="${lsMessage}" var="message">
		<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
	</c:forEach>
	<br />

	<form action="SinhVienProcess.do?submit=true" method="post">
		<input type="hidden" name="id" value="${id}" />
		<input type="hidden" name="ref" value="${ref}" />
		<table align="center">
			<tr>
				<td>
					Mã sinh viên
				</td>
				<td>
					<input type="text" name="masinhvien" value="${sinhvien.maSinhVien}" />
				</td>
			</tr>
			<tr>
				<td>
					Họ đệm
				</td>
				<td>
					<input type="text" name="hodem" value="${sinhvien.hoDem}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên
				</td>
				<td>
					<input type="text" name="ten" value="${sinhvien.ten}" />
				</td>
			</tr>
			<tr>
				<td>
					Ngày sinh
				</td>
				<td>
					<fmt:formatDate var="ngaysinh" value="${sinhvien.ngaySinh}" pattern="yyyy-MM-dd" />
					<input type="text" id="popupDatepicker" data-datepick="dateFormat: 'yyyy-mm-dd'" value="${ngaysinh}" name="ngaysinh" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td>
					Giới tính
				</td>
				<td>
					<select name="gioitinh">
						<option value="-1">
							Chọn giới tính
						</option>
						<c:choose>
							<c:when test="${gioitinh == 1}">
								<option value="1" SELECTED>
									Nam
								</option>
								<option value="0">
									Nữ
								</option>
							</c:when>
							<c:otherwise>
								<option value="1">
									Nam
								</option>
								<option value="0" SELECTED>
									Nữ
								</option>
							</c:otherwise>
						</c:choose>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					Số chứng minh thư
				</td>
				<td>
					<input type="text" name="cmtnd" value="${sinhvien.cmtnd}" />
				</td>
			</tr>
			<tr>
				<td>
					Số điện thoại
				</td>
				<td>
					<input type="text" name="sodienthoai" value="${sinhvien.soDienThoai}" />
				</td>
			</tr>
			<tr>
				<td>
					Nơi sinh
				</td>
				<td>
					<input type="text" name="noisinh" value="${sinhvien.noiSinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Quê quán
				</td>
				<td>
					<input type="text" name="quequan" value="${sinhvien.queQuan}" />
				</td>
			</tr>
			<tr>
				<td>
					Hộ khẩu thường trú
				</td>
				<td>
					<input type="text" name="hokhauthuongtru" value="${sinhvien.hoKhauThuongTru}" />
				</td>
			</tr>
			<tr>
				<td>
					Nơi ở hiện tại
				</td>
				<td>
					<input type="text" name="noiohientai" value="${sinhvien.noiOHienTai}" />
				</td>
			</tr>
			<tr>
				<td>
					Chế độ ưu đãi
				</td>
				<td>
					<input type="text" name="chedouudai" value="${sinhvien.cheDoUuDai}" />
				</td>
			</tr>
			<tr>
				<td>
					Dân tộc
				</td>
				<td>
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
			</tr>
			<tr>
				<td>
					Tôn giáo
				</td>
				<td>
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
			</tr>
			
			<tr>
				<td>
					Họ tên bố
				</td>
				<td>
					<input type="text" name="hotenbo" value="${sinhvien.hoTenBo}" />
				</td>
			</tr>
			<tr>
				<td>
					Nghề nghiệp bố
				</td>
				<td>
					<input type="text" name="nghenghiepbo" value="${sinhvien.ngheNghiepBo}" />
				</td>
			</tr>
			<tr>
				<td>
					Họ tên mẹ
				</td>
				<td>
					<input type="text" name="hotenme" value="${sinhvien.hoTenMe}" />
				</td>
			</tr>
			<tr>
				<td>
					Nghề nghiệp mẹ
				</td>
				<td>
					<input type="text" name="nghenghiepme" value="${sinhvien.ngheNghiepMe}" />
				</td>
			</tr>
			
			<tr>
				<td>
					Tên lớp học
				</td>
				<td>
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
			</tr>
			<tr>
				<td>
					Tên khóa học
				</td>
				<td>
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
			</tr>
			<tr>
				<td>
					Ngày nhập học
				</td>
				<td>
					<fmt:formatDate var="ngaynhaphoc" value="${sinhvien.ngayNhapHoc}" pattern="yyyy-MM-dd" />
					<input type="text" id="popupDatepicker2" data-datepick="dateFormat: 'yyyy-mm-dd'" value="${ngaynhaphoc}" name="ngaynhaphoc" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 1
				</td>
				<td>
					<input type="text" name="diemdauvao1" value="${sinhvien.diemDauVao1}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 2
				</td>
				<td>
					<input type="text" name="diemdauvao2" value="${sinhvien.diemDauVao2}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 3
				</td>
				<td>
					<input type="text" name="diemdauvao3" value="${sinhvien.diemDauVao3}" />
				</td>
			</tr>
			<tr>
				<td>
					Ảnh sinh viên
				</td>
				<td>
					<input type="text" name="anhsinhvien" value="${sinhvien.anhSinhVien}" />
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="middle" align="center">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Submit" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>