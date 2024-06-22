<%@page import="com.pcwk.user.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.pcwk.shop.ShopDTO"%>
<%@page import="com.pcwk.shop.ShopDetailDTO"%>
<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.shop.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    
    UserDTO user= (UserDTO)session.getAttribute("user");
    String myPageList = (String)request.getAttribute("myPageList");  
	SearchDTO searchCon = (SearchDTO)request.getAttribute("vo");
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/TWOREE/shop/css/bootstrap.css">
    <title>test</title>
    <link rel="stylesheet" href="/TWOREE/shop/css/poster.css">
    <script src="/TWOREE/shop/js/jquery_3_7_1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="my_page">
		<ul>
			<li class="shop_name"><%=user.getName()%></li>
			<input type="button" class="main_btn" id="reserve_confirm" value="가게 예약 내역">
		</ul>
	</div>
<script src="/TWOREE/shop/js/popper_min.js"></script>
    <script>
    
    $(document).ready(function() {
		const reserveConfirmBtn = document.querySelector("#reserve_confirm");
		     	
		reserveConfirmBtn.addEventListener("click", function(event){
	     		console.log("reserveConfirmBtn click event" + event)
	     		reserveConfirm();
	     	});
		
    	function reserveConfirm(){
    		console.log('reserveConfirm()');
    		window.open("/TWOREE/myPage/jsp/my_p.jsp");
    		//window.location.href = "/TWOREE/shop/shop.do?work_div=";
    	}
    });
    	
    </script>
</body>
</html>