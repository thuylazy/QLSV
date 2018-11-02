<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Retina Dashboard</title>
	<link rel="stylesheet" href="css/style.css" media="all" />
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
</head>
<body class="login">
	<section>
		<h1><strong>Hệ thống</strong> Quản Lý Sinh Viên</h1>

		<!-- Start list thông báo lỗi (nếu có) -->
			<%
			if(request.getAttribute("lsMessage") != null) {
				List<String> lsErrMessage = (ArrayList<String>)request.getAttribute("lsMessage");
				for (String errMessage : lsErrMessage) {
			%>
			<a style="font: bold; color: red"> <%= errMessage %> </a><br />
			<%
				}
			}

			String loginId = "Tên đăng nhập";
			if(session.getAttribute("loginId") != null) {
				loginId = session.getAttribute("loginId").toString();
			}

			String pass = "password";
			if(session.getAttribute("password") != null) {
				pass = session.getAttribute("password").toString();
			}
			%>
		<!-- End list thông báo lỗi -->

		<br />
		<form method="post" action="Login.do">
			<input name="loginId" type="text" value="<%= loginId%>" />
			<input name="password" value="<%= pass%>" type="password" />
			<button class="blue">Login</button>
		</form>
		<p><a href="#">Quên mật khẩu?</a></p>
	</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script type="text/javascript">
// Page load delay by Curtis Henson - http://curtishenson.com/articles/quick-tip-delay-page-loading-with-jquery/
$(function(){
	$('.login button').click(function(e){
		// Get the url of the link
		var toLoad = $(this).attr('href');

		// Do some stuff
		$(this).addClass("loading");

			// Stop doing stuff
			// Wait 700ms before loading the url
			setTimeout(function(){window.location = toLoad}, 10000);

		// Don't let the link do its natural thing
		e.preventDefault
	});

	$('input').each(function() {

       var default_value = this.value;

       $(this).focus(function(){
               if(this.value == default_value) {
                       this.value = '';
               }
       });

       $(this).blur(function(){
               if(this.value == '') {
                       this.value = default_value;
               }
       });

});
});
</script>
</body>
</html>