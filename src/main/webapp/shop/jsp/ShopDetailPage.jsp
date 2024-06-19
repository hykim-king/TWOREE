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
<%@ include file="/cmn/common.jsp" %>
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
	        <li class="shop_name" id="shopName"> <%= shopOutVO.getShopName() %> </li>
	        <li id="shopTime">영업시간 : <%="오전" + detailOutVO.getOpenTime() + "/ 오후" + detailOutVO.getCloseTime()%></li>
	        <li id="shopLoc"><%=detailOutVO.getShopLoc() %></li>   
	        <li id="shopScore">별점 : <%=shopOutVO.getScore() %></li>
	        <li id="shopReviewCnt">리뷰갯수 : <%=shopOutVO.getReviewCnt() %></li>
	    <hr>
	        <input type="button" class="main_btn" id="reserve_btn" name="reserve_btn" value="예약하기">
	        <input type="button" class="main_btn" id="ask_btn" name="ask_btn" value="문의하기">
	    <hr>
	        <li class="shop_name">소개 및 공지</li>
	        <li id="shopNotice"> <%=noticeOutVO.getContent() %></li>
	    <hr>
	    	<li class="shop_name">메뉴</li>
	    	 <% for(int i=0; i<=4; i++){ %>
	        <li id="shopMenu"><%=menuOutVO.getMenuName() %></li>
	        <% } %>
	    <hr>
	    	<li class="shop_name">리뷰</li>
	    	<% for(int i=0; i<=4; i++){ %>          
	        <li id="shopReview"><%= reviewOutVO.getReviewContent()%></li>
	         <% } %>
	    </ul>   
	</div>
<script src="/TWOREE/shop/js/popper_min.js"></script>
</body>
</html>