<%@page import="java.util.List"%>
<%@page import="com.pcwk.shop.ShopDTO"%>
<%@page import="com.pcwk.shop.ShopDetailDTO"%>
<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.menu.MenuDTO"%>
<%@page import="com.pcwk.review.ReviewDTO"%>
<%@page import="com.pcwk.shop.ShopNoticeDTO"%>
<%@page import="com.pcwk.shop.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    ShopDTO shopOutVO = (ShopDTO)request.getAttribute("outVO");
    ShopDetailDTO detailOutVO = (ShopDetailDTO)request.getAttribute("detailOutVO");
    ShopNoticeDTO noticeOutVO = (ShopNoticeDTO)request.getAttribute("noticeOutVO");
    MenuDTO menuOutVO = (MenuDTO)request.getAttribute("menuOutVO");
    ReviewDTO reviewOutVO = (ReviewDTO)request.getAttribute("reviewOutVO");
%>
   
<body>
	<div class="detail_page">
	    <ul>
	        <li class="shop_name"> <%= shopOutVO.getShopName() %> </li>
	        <li>영업시간 : <%="오전" + detailOutVO.getOpenTime() + "/ 오후" + detailOutVO.getCloseTime() %></li>
	        <li><%=shopOutVO.getShopLoc() %></li>   
	        <li>별점 : <%=shopOutVO.getScore() %></li>
	        <li>리뷰갯수 : <%=shopOutVO.getReviewCnt() %></li>
	    <hr>
	        <input type="button" class="main_btn" id="reserve_btn" name="reserve_btn" value="예약하기">
	        <input type="button" class="main_btn" id="ask_btn" name="ask_btn" value="문의하기">
	    <hr>
	        <li>소개 및 공지 <br> <%=noticeOutVO.getContent() %></li>
	    <hr>
	    	 <% for(int i=0; i<=4; i++){ %>
	        <li>메뉴  <%=noticeOutVO.getContent().indexOf(i) %></li>
	        <% } %>
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