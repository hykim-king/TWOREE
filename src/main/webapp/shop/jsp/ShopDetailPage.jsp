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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/TWOREE/shop/css/bootstrap.css">
    <title>test</title>
    <link rel="stylesheet" href="/TWOREE/shop/css/poster.css">
    <script src="/TWOREE/shop/js/jquery_3_7_1.js"></script>
</head>    
<body>
	<div class="detail_page" id="detail_page">
	    <ul id="shopList">
	        <li class="shop_name" id="shopName"></li>
	        <li id="shopOpenTime"></li>
	        <li id="shopCloseTime"></li>
	        <li id="shopLoc"></li>
	        <span>
		        <li class="shop_name">별점</li>
		        <li id="shopScore"></li>
	        </span>
	        <span>
		        <li class="shop_name">리뷰갯수 :</li>
		        <li id="shopReviewCnt"></li>
		   	</span>
	    <hr>
	        <input type="button" class="main_btn" id="reserve_btn" name="reserve_btn" value="예약하기">
	        <input type="button" class="main_btn" id="ask_btn" name="ask_btn" value="문의하기">
	    <hr>
	        <li class="shop_name">소개 및 공지</li>
	        <li id="shopNotice"></li>
	    <hr>
	    	<li class="shop_name" id="menuList">메뉴</li>
	    	 <span>
		        <li id="shopMenu"></li>
		        <li id="menuInfo"></li>
		        <li id="price"></li>
	    	 </span>
	    <hr>
	    	<li class="shop_name" >리뷰</li>        
	        <li id="shopReview"></li>
	    </ul>   
	</div>
<script>

	
	const detailPageDiv = document.querySelector("#detail_page");
	
	function loadData(data) {
		
		let shopListObj =data.get("shopList");
		let detailListObj =data.get("detailList");
		let noticeListObj =data.get("noticeList");
		let menuListObj =data.get("menuList");
		let reviewListObj =data.get("reviewList");
		
		console.log("shopListObj : "+ shopListObj);
		console.log("detailListObj : "+ detailListObj);
		console.log("noticeListObj : "+ noticeListObj);
		console.log("menuListObj : "+ menuListObj);
		console.log("reviewListObj : "+ reviewListObj);
		 
		 $("#shopName").text(shopListObj.shopName);
         $("#shopOpenTime").text(detailListObj.openTime);
         $("#shopCloseTime").text(detailListObj.closeTime);
         $("#shopLoc").text(detailListObj.shopLoc);
         $("#shopScore").text(shopListObj.score);
         $("#shopReviewCnt").text(shopListObj.reviewCnt);
         
         $("#shopNotice").empty();
         $.each(noticeListObj, function(index, notice) {
               let li = $("<li></li>");
               li.append($("<li></li>").text(notice.content));
               $("#shopNotice").append(li);
         });
        
         $("#menuList").empty();
         $.each(menuListObj, function(index, menu) {
               let li = $("<li></li>");
               li.append($("<li></li>").text(menu.menuName));
               li.append($("<li></li>").text(menu.menuInfo));
               li.append($("<li></li>").text(menu.price));
               $("#menuList").append(li);
         });
         
         $("#reviewList").empty();
         $.each(reviewListObj, function(index, review) {
               let li = $("<li></li>");
               li.append($("<li></li>").text(review.userId));
               li.append($("<li></li>").text(review.reviewContent));
               $("#shopReview").append(li);
           });
         
       //예약하기 버튼
     	const moveToReserveBtn = document.querySelector("#reserve_btn");
     	
     	moveToReserveBtn.addEventListener("click", function(event){
     		console.log("moveToReserveBtn click event" + event)
     		moveToReserve();
     	});
     	
     	function moveToReserve(){
     		console.log('moveToReserve()');
     		let shopNo = shopListObj.shopNo;
     		console.log("shopNo : " + shopNo);
     		window.open("/TWOREE/shop/shop.do"+"?work_div=reserve&shopNo="+shopNo,"예약","width=700,height=700,top=100,left=100");
     		//window.location.href = "/TWOREE/shop/shop.do?work_div=";
     	}
     	
     	//문의하기 버튼
     	const askBtn = document.querySelector("#ask_btn");
     	
     	askBtn.addEventListener("click", function(event){
     		console.log("askBtn click event" + event)
     		ask();
     	});
     	
     	function ask(){
     		console.log('ask()');
     		let shopNo = shopListObj.shopNo;
     		console.log("shopNo : " + shopNo);
     		//window.location.href = "/TWOREE/shop/shop.do?work_div=";
     	}
	}
	
	
	
	
	
</script>
<script src="/TWOREE/shop/js/popper_min.js"></script>
</body>
</html>