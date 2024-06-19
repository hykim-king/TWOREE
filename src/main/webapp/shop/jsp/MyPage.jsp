<%@page import="java.util.List"%>
<%@page import="com.pcwk.shop.ShopDTO"%>
<%@page import="com.pcwk.shop.ShopDetailDTO"%>
<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.shop.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	List<ShopDTO> list = (List<ShopDTO>)request.getAttribute("list");  
	ShopDetailDTO detailDTO =  (ShopDetailDTO)request.getAttribute("detailVO");
	ShopDTO shopDTO =  (ShopDTO)request.getAttribute("shopDTO");
	SearchDTO searchCon = (SearchDTO)request.getAttribute("vo");
	SearchDTO DsearchCon = (SearchDTO)request.getAttribute("Dvo");
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
			<li class="shop_name">이름</li>
			<li>소유 가게</li>  
		</ul>
	</div>
<script src="/TWOREE/shop/js/popper_min.js"></script>
</body>
</html>