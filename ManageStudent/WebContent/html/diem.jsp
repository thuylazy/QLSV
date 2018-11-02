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
		function addDiem() {
			var sinhvienid = document.getElementById('sinhvienid').value;
			var e = document.getElementById('monhocid');
			var monhocid = e.options[e.selectedIndex].value;
			e = document.getElementById('hocky');
			var hockyid = e.options[e.selectedIndex].value;
			var diemchuyencan = document.getElementById('diemchuyencan').value;
			var diemgiuaky = document.getElementById('diemgiuaky').value;
			var diemthi = document.getElementById('diemthi').value;

			if(checkValidAdd()) {
				if(!confirm("Chắc chắn nhập thông tin điểm?")) {
					return;
				}

				$.get('AddDiemServices.do', {sinhvienid: sinhvienid, monhocid: monhocid, hockyid: hockyid, diemchuyencan: diemchuyencan, diemgiuaky: diemgiuaky, diemthi: diemthi}, function(data) {
					var o = $.parseJSON(data);
					var $tr = '';

					$tr = $('<tr class="trData">').append(
							$('<td><span>').text(o.tenMonHoc),
							$('<td><span>').text(diemchuyencan),
							$('<td><span>').text(diemgiuaky),
							$('<td><span>').text(diemthi),
							$('<td><span class="diemTBM">').text(calculateSumary(diemchuyencan, diemgiuaky, diemthi, o.hscc, o.hsgk, o.hshk))
					);
					$('#tblData tr:first').after($tr);
					alert("Nhập điểm sinh viên thành công!");
					$('#diemchuyencan').val('');
					$('#diemgiuaky').val('');
					$('#diemthi').val('');
					$('#diemTKHK').text(o.diemTBHK);
					$('#diemtongketcakhoa').text(o.diemTK);
					$('#tennganh').text(o.tenNganh);
					$('#tenchuyennganh').text(o.tenChuyenNganh);
				});
			}
		}

		function keyDown(e) {
			e = e || window.event;

			if(e.keyCode == 13) {
				document.getElementById('Submit').click();
			}
		}

		function checkValidAdd() {
			var e = document.getElementById('monhocid');
			if(e.options[e.selectedIndex].value <= 0) {
				alert("Chưa chọn môn học");
				return false;
			}

			if(document.getElementById('diemchuyencan').value == '') {
				alert("Chưa nhập điểm chuyên cần");
				return false;
			}

			if(document.getElementById('diemgiuaky').value == '') {
				alert("Chưa nhập điểm giữa kỳ");
				return false;
			}

			if(document.getElementById('diemthi').value == '') {
				alert("Chưa nhập điểm thi");
				return false;
			}

			return true;
		}

		function redirect(dmName) {
			window.location.href = "ListDM.do?name=" + dmName;
		}

		function calculateSumary(diemChuyenCan, diemGiuaKy, diemThi, hscc, hsgk, hshk) {
			var sumDiem = diemChuyenCan * hscc + diemGiuaKy * hsgk + diemThi * hshk;
			var sumHeSo = parseFloat(hscc) + parseFloat(hsgk) + parseFloat(hshk);
			console.log('sumDiem: ' + sumDiem + '; sumHeSo: ' + sumHeSo);
			return ((sumDiem / sumHeSo).toFixed(2));
		}

		function calculateHocKy() {
			var tmp = document.getElementsByTagName('span');
			var count = 0;
			var diemTK = 0;

			for(var i = 0; i < tmp.length; i++) {
				if(tmp[i].className == 'diemTBM') {
					//alert(tmp[i].innerHTML.split("/script>")[1]);
					diemTK += parseFloat(tmp[i].innerHTML.split("/script>")[1]);
					count++;
				}
			}

			if(count <= 0) {
				for(var i = 0; i < tmp.length; i++) {
					if(tmp[i].className == 'diemTBM') {
						//alert(tmp[i].innerHTML);
						diemTK += parseFloat(tmp[i].innerHTML);
						count++;
					}
				}
			}
			var rt = (diemTK/count).toFixed(2);

			document.getElementById('diemTKHK').innerHTML = rt;
		}

		function loadData() {
			var e = document.getElementById('hocky');
			var hocKyId = e.options[e.selectedIndex].value;
			var sinhVienId = document.getElementById('sinhvienid').value;
			var hocKy = new Object();
			hocKy.tenMonHoc = $('#tenMonHoc').val();
			hocKy.diemChuyenCan = $('#diemChuyenCan').val();
			hocKy.diemGiuaKy = $('diemGiuaKy').val();
			hocKy.diemThi = $('#diemThi').val();
			hocKy.hscc = $('hscc').val();
			hocKy.hsgk = $('hsgk').val();
			hocKy.hshk = $('hshk').val();

			$.ajax({
				url: "HocKyServices.do",
				type: 'GET',
				dataType: 'json',
				data: 'hocKyId='+hocKyId+'&sinhVienId='+sinhVienId,
				contentType: 'application/json',
				mimeType: 'application/json',

				success: function(data) {
					//$("#tblData tr:has(td)").remove();
					$("#tblData .trData").remove();
					//data = $.parseJSON(data);
					var $tr = '';
					var diemTKHK = 0;
					var count = 0;

					/*
					$.each(data, function(i, hocKy) {
						$tr = '';
						alert(count);
						diemTKHK += parseFloat(calculateSumary(hocKy.diemChuyenCan, hocKy.diemGiuaKy, hocKy.diemThi, hocKy.hscc, hocKy.hsgk, hocKy.hshk));
						count++;

						$tr = $('<tr class="trData">').append(
							$('<td><span>').text(hocKy.tenMonHoc),
							$('<td><span>').text(hocKy.diemChuyenCan),
							$('<td><span>').text(hocKy.diemGiuaKy),
							$('<td><span>').text(hocKy.diemThi),
							$('<td><span class="diemTBM">').text(diemTKHK.toFixed(2))
						);
					});*/

						var idx = 0;
						for(idx = 0; idx < data.length; idx++) {
							diemTKHK = 0;
							diemTKHK += parseFloat(calculateSumary(data[idx].diemChuyenCan, data[idx].diemGiuaKy, data[idx].diemThi, data[idx].hscc, data[idx].hsgk, data[idx].hshk));
							count++;

							$tr = $('<tr class="trData">').append(
								$('<td><span>').text(data[idx].tenMonHoc),
								$('<td><span>').text(data[idx].diemChuyenCan),
								$('<td><span>').text(data[idx].diemGiuaKy),
								$('<td><span>').text(data[idx].diemThi),
								$('<td><span class="diemTBM">').text(diemTKHK.toFixed(2))
							);
							$('#tblData tr:first').after($tr);
						}

					//$('#tblData tr:last').after($tr);
					document.getElementById('diemTKHK').innerHTML = diemTKHK.toFixed(2);
					//calculateHocKy();
				},
				error: function(data, status, err) {
					alert("error: "+data+" status: "+status+" er:"+er);
				}
			});
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
			<span class="icon"><img src="./images/icon/dashboard-icon.png"></span>
			<hgroup>
				<h1>QUẢN LÝ DANH MỤC</h1>
				<h2>Danh sách các danh mục</h2>
			</hgroup>
		</header>
		<div class="content cycle">
		<h1 class="mark-title">Thông tin sinh viên</h1>
		<input type="hidden" name="id" id="sinhvienid" value="${sinhvien.sinhVienId}" />
		<table width="269" height="114" border="0" class="mark-table">
		  <tr>
		    <td width="108" bgcolor="#CCCCCC">Mã Sinh Viên</td>
		    <td width="145">
		     <span>${sinhvien.maSinhVien }</span>
		   </td>
		  </tr>
		  <tr>
		    <td bgcolor="#CCCCCC">Tên Sinh Viên</td>
		    <td><span>${sinhvien.hoDem} <c:out value=" " /> ${sinhvien.ten}</span></td>
		  </tr>
		  <tr>
		    <td bgcolor="#CCCCCC">Lớp</td>
		    <td>
		    	<span>
					${lop}
				</span>
		    </td>
		  </tr>
		  <tr>
		    <td bgcolor="#CCCCCC">Ngành</td>
		    <td>
		    	<span id="tennganh">
		    		${nganh}
				</span>
		    </td>
		  </tr>
		  <tr>
		    <td bgcolor="#CCCCCC">Chuyên ngành</td>
		    <td  width="145">
		    	<span id="tenchuyennganh">
					${chuyennganh}
				</span>
		    </td>
		  </tr>
		  <tr>
		    <td bgcolor="#CCCCCC">Khóa</td>
		    <td>
		    	<span>${khoahoc}</span>
		    </td>
		  </tr>
		</table>
		<h1 class="mark-title">Bảng điểm</h1>
		  <label>
		  <select name="hocky" id="hocky" onchange="loadData();">
		    <c:forEach items="${lshocky}" var="hocky">
		    	<option value="${hocky.hocKyId}">${hocky.tenHocKy}</option>
		    </c:forEach>
		  </select>
		  </label>
		<table width="809" border="1" bordercolor="0" class="mark-table" id="tblData">
		  <tr>
		    <th width="199" bgcolor="#CCCCCC">Tên môn học</th>
		    <th width="199" bgcolor="#CCCCCC">Điểm chuyên cần</th>
		    <th width="144" bgcolor="#CCCCCC">Điểm giữa kỳ</th>
		    <th width="144" bgcolor="#CCCCCC">Điểm thi</th>
		    <th width="144" bgcolor="#CCCCCC">Tổng kết</th>
		    <th width="30" bgcolor="#CCCCCC"></th>
		  </tr>
		  	<c:choose>
			    <c:when test="${diemcount <= 0}">
			    </c:when>
			    <c:otherwise>
			    	<c:forEach items="${lsdiem}" var="diem">
		  <tr class="trData">
						<td>
					    	<span>${diem.monHoc.tenMonHoc}</span>
					    </td>
					    <td>
			  		     	<span>${diem.diemChuyenCan}</span>
			   		    </td>
					    <td>
					    	<span>${diem.diemGiuaKy}</span>
					     </td>
					    <td>
					    	<span>${diem.diemThi}</span>
					    </td>
					    <td>
					    	<span id="tongket" class="diemTBM"><script>document.write(calculateSumary('${diem.diemChuyenCan}', '${diem.diemGiuaKy}', '${diem.diemThi}', '${diem.monHoc.heSoChuyenCan}', '${diem.monHoc.heSoGiuaKy}', '${diem.monHoc.heSoHocKy}'));</script></span>
					    </td>
					    <td>
					    	<span><a class="btn-delete" href="javascript:void(0)"></a></span>
					    </td>
			    	</c:forEach>
		  </tr>
			    </c:otherwise>
		    </c:choose>
		  <tr>
			<td>
				<span>
					<select id="monhocid">
						<c:forEach items="${lsnganh}" var="nganh">
							<option DISABLED style="font-weight: bold">Ngành: ${nganh.tenNganh}</option>
							<c:forEach items="${lschuyennganh}" var="chuyennganh">
								<c:if test="${chuyennganh.nganhId == nganh.nganhId}">
									<option DISABLED style="font-weight: bold">--Chuyên Ngành: ${chuyennganh.tenChuyenNganh}</option>
									<c:forEach items="${lsmonhoc}" var="monhoc">
										<c:if test="${monhoc.chuyenNganhId == chuyennganh.chuyenNganhId}">
											<option value="${monhoc.monHocId}">----${monhoc.tenMonHoc}</option>
										</c:if>
									</c:forEach>
									<option DISABLED></option>
								</c:if>
							</c:forEach>
						</c:forEach>
					</select>
				</span>
			</td>
			<td>
				<span><input id="diemchuyencan" type="text" onkeydown="keyDown();" name="txtdiemchuyencan" value="" /></span>
			</td>
			<td>
				<span><input id="diemgiuaky" type="text" onkeydown="keyDown();" name="txtdiemgiuaky" value="" /></span>
			</td>
			<td>
				<span><input id="diemthi" type="text" onkeydown="keyDown()"; name="txtdiemthi" value="" /></span>
			</td>
			<td>
				<span></span>
			</td>
			<td>
				<span></span>
			</td>
		  </tr>
		</table>
		<p class="mT20">Tổng kết phẩy của học kỳ này : <a id="diemTKHK"><script>calculateHocKy();</script></a></p>
		<h1 class="mark-title">Xếp loại</h1>
		<table width="481" border="1" bordercolor="#000000" bgcolor="#FFFFFF" class="mark-table">
		  <tr bgcolor="#CCCCCC">
		    <td width="155">Tổng kết phẩy cả khóa</td>
		    <td width="184">Xếp loại tốt nghiệp</td>
		  </tr>
		  <tr>
		    <td><span id="diemtongketcakhoa">${diemtongket}</span></td>
		    <td><span id="xeploai">
				<c:choose>
					<c:when test="${diemtongket == 'NaN'}">
						<c:out value="CHƯA XẾP LOẠI" />
					</c:when>
					<c:when test="${diemtongket != 'NaN' && diemtongket > 8}">
						<c:out value="GIỎI" />
					</c:when>
					<c:when test="${diemtongket != 'NaN' && diemtongket > 6}">
						<c:out value="KHÁ" />
					</c:when>
					<c:when test="${diemtongket != 'NaN' && diemtongket > 4}">
						<c:out value="TRUNG BÌNH - KHÁ" />
					</c:when>
					<c:otherwise>
						<c:out value="TRUNG BÌNH" />
					</c:otherwise>
				</c:choose>
			</span></td>
		  </tr>
		</table>
		  <label>
		  <input class="result-btn mT20" name="Submit" onclick="addDiem()" type="button" id="Submit" value="Submit" />
		  <input class="result-btn mT20" name="Submit" type="button" id="Submit" value="Trở lại" />
		  </label>
		<p>&nbsp; </p>
		<p>&nbsp;</p>
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
	var contentHeight = $('.content').height();
	$('.left-menu').css('height', contentHeight);
</script>
</body>
</html>