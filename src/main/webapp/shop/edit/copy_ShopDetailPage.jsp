<%@page import="java.util.List"%>
<%@page import="com.pcwk.user.UserDTO"%>
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
	
	UserDTO user= (UserDTO)session.getAttribute("user");
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/TWOREE/shop/css/bootstrap.css">
    <title>test</title>
    <link rel="stylesheet" href="/TWOREE/shop/css/mainPage.css">
    <script src="/TWOREE/shop/js/jquery_3_7_1.js"></script>
</head>    
<body>
	<hr>
	<div id="shop_detail_page" class="shop_detail_page">
        <ul id="shop_detail_page_ul" class="shop_notice">
            <li class="big_size_word">공지사항 및 소식</li>
            <li class="middle_size_word" id="shopOpenTime"></li>
            <li class="middle_size_word" id="shopCloseTime"></li>
            <li class="middle_size_word" id="shopNotice"></li>
        </ul>
        <ul id="shop_detail_page_ul" class="shop_detail_info">
            <li class="big_size_word" id="shopName"></li>
            <li class="middle_size_word" id="shopLoc"></li>
            <li class="score" id="shopScore"></li>
            <li class="small_size_word" id="shopReviewCnt"></li>
            <input type="button" class="main_btn" id="reserve_btn" name="reserve_btn" value="예약하기">
	        <input type="button" class="main_btn" id="ask_btn" name="ask_btn" value="문의하기">
        </ul>
    </div>
    <div id="shop_detail_page" class="shop_detail_page">
        <ul id="menuList" class="shop_menu">
            
        </ul>
        <ul id="shop_detail_page_ul" class="shop_review">
            <li class="shop_name" class="big_size_word"></li>
            <li id="shopReview" class="middle_size_word"></li>
            <li class="score"></li>
        </ul>
    </div>
    <jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
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
         $("#shopOpenTime").text("오픈 시간 : 오전 " + detailListObj.openTime +"시");
         $("#shopCloseTime").text("마감 시간 : 오후 " +detailListObj.closeTime +"시");
         $("#shopLoc").text(detailListObj.shopLoc);
         $("#shopScore").text("별점 : " + shopListObj.score + "점");
         $("#shopReviewCnt").text("총 리뷰 개수: " + shopListObj.reviewCnt +"개");
         
         $("#shopNotice").empty();
         $.each(noticeListObj, function(index, notice) {
               let li = $("<li></li>");
               li.append($("<li class='small_size_word'></li>").text(notice.openTime));
               li.append($("<li class='small_size_word'></li>").text(notice.closeTime));
               li.append($("<li class='middle_size_word'></li>").text(notice.content));
               li.append($("<li class='small_size_word'></li>").text("작성날짜 : " +notice.noticeWrtDate));
               $("#shopNotice").append(li);
         });
        
         $("#menuList").empty();
         $.each(menuListObj, function(index, menu) {
               let li = $("<li></li>");
               li.append($("<li class='big_size_word'></li>").text(menu.menuName));
               li.append($("<li class='middle_size_word'></li>").text(menu.menuInfo));
               li.append($("<li class='score'></li>").text(menu.price +"원"));
               $("#menuList").append(li);
         });
         
         $("#reviewList").empty();
         $.each(reviewListObj, function(index, review) {
               let li = $("<li></li>");
               li.append($("<li class='big_size_word'></li>").text("작성자 : " +review.userId));
               li.append($("<li class='middle_size_word'></li>").text(review.reviewContent));
               li.append($("<li class='score'></li>").text("별점 : " + review.score +"점"));
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
     		window.open("/TWOREE/shop/shop.do"+"?work_div=reserve&shopNo="+shopNo,"문의","width=700,height=700,top=100,left=100");
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
     		window.open("/TWOREE/user/myPage.do"+"?work_div=doSelectOneX1&shopNo="+shopNo,"예약","width=700,height=700,top=100,left=100");
     	}
	}
	
</script>
<script src="/TWOREE/shop/js/popper_min.js"></script>
</body>
</html>