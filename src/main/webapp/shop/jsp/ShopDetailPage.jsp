<%@page import="java.util.List"%>
<%@page import="com.pcwk.shop.ShopDTO"%>
<%@page import="com.pcwk.shop.ShopDetailDTO"%>
<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.shop.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	List<ShopDTO> list = (List<ShopDTO>)request.getAttribute("list");  
	ShopDetailDTO dto =  (ShopDetailDTO)request.getAttribute("detailVO");
	SearchDTO searchCon = (SearchDTO)request.getAttribute("vo");
	SearchDTO DsearchCon = (SearchDTO)request.getAttribute("Dvo");
%>
   
<body>
	<div class="detail_page">
	    <ul>
	        <li class="shop_name"></li>
	        <li>영업시간</li>
	        <li>가게주소</li>   
	        <li>평점</li>
	        <li>리뷰갯수</li>
	    <hr>
	        <input type="button" class="main_btn" id="reserve_btn" name="reserve_btn" value="예약하기">
	        <input type="button" class="main_btn" id="ask_btn" name="ask_btn" value="문의하기">
	    <hr>
	        <li>소개 및 공지</li>
	    <hr>
	        <li>메뉴</li>
	        <li>메뉴</li>
	        <li>메뉴</li>
	        <li>메뉴</li>
	    <hr>          
	        <li>리뷰</li>
	        <li>리뷰</li>
	        <li>리뷰</li>
	        <li>리뷰</li>
	    </ul>   
	</div>
<script src="/TWOREE/shop/js/popper_min.js"></script>
</body>
</html>