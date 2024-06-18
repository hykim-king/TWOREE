<%@page import="com.pcwk.shop.ShopDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String jsonShop =(String)request.getAttribute("shopVO");
   String jsonShopDetail =(String)request.getAttribute("shopDetailVO");
   String jsonReserveList = (String)request.getAttribute("outReserveVOList");
   String jsonMenuList =(String)request.getAttribute("outMenuVOList"); 
   String jsonAskList =(String)request.getAttribute("outAskVOList"); 
   String jsonReviewList = (String)request.getAttribute("outReviewVOList");
   String jsonShopList   = (String)request.getAttribute("shopList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dynamic Content Example</title>
    <script src="/TWOREE/shop/js/bootstrap_bundle_min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <style>
     .printList {
     height : 500px;
     }
     div {
     padding : 10px;}
     
     .dropdown {
     padding : 20px;
     margin :20px;}
    </style>
</head>
<body>
    <div class="container my-5">
        <h1 class="mb-4" id="shopName"></h1>
        <div class="dropdown">
        <button class="btn btn-primary mr-2" style="float:right" id="AddShopBtn">가게 추가</button>
             <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" style="float:right" id="shopNow">
                 가게 선택
             </button>
          <ul class="dropdown-menu" id ="shopList">   
          </ul>
                 
        </div>
        
        <div class="p-3 border border-info border-start-0 rounded-end" >
            <h3 class="mb-3">가게 상세 정보 관리</h3>
            <button class="btn btn-primary mr-2" style="float:right" id="DeTailModifyBtn">상세정보설정</button>
            <button class="btn btn-primary mr-2" id="RegNoticeBtn" style="float:right">가게소식등록</button>
            <table class="table table-striped table-hover table-bordered">
                <tbody>
                    <tr>
                        <td>가게 이름</td>
                        <td id="storeName"></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td id="storePhone"></td>
                    </tr>
                    <tr>
                        <td>위치</td>
                        <td id="storeLocation"></td>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <div class="p-3 border border-info border-start-0 rounded-end printList overflow-auto" >
            <h3 class="mb-3">예약 현황</h3>
            <button class="btn btn-primary mr-2" style="float:right" id="reserveSetBtn">예약 설정</button>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                    <tr class="table-success">
                        <th >예약자 ID</th>
                        <th>예약 시간</th>
                        <th>예약 인원</th>
                        <th>예약 상태</th>
                    </tr>
                </thead>
                <tbody id="reservationList"></tbody>
            </table>
        </div>
        
        <div class="p-3 border border-info border-start-0 rounded-end printList overflow-auto" >
            <h3 class="mb-3">메뉴 관리</h3>
            <button class="btn btn-primary mr-2" style="float:right" id="addMenuBtn">메뉴 추가하기</button>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                    <tr class="table-success">
                        <th>메뉴 이름</th>
                        <th>가격</th>
                    </tr>
                </thead>
                <tbody id="menuList"></tbody>
            </table>
        </div>
        
        <div class="p-3 border border-info border-start-0 rounded-end printList overflow-auto">
            <h3 class="mb-3">고객 문의</h3>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                    <tr class="table-success">
                        <th>문의 내용</th>
                        <th>작성자 id</th>
                        <th>작성 시간</th>
                        <th>답변 상태</th>
                    </tr>
                </thead>
                <tbody id="askList"></tbody>
            </table>
        </div>
        
        <div class="p-3 border border-info border-start-0 rounded-end printList overflow-auto">
            <h3 class="mb-3">리뷰</h3>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                    <tr class="table-success">
                        <th>작성자 ID</th>
                        <th>별점</th>
                        <th>리뷰 내용</th>
                        <th>리뷰 작성일</th>
                    </tr>
                </thead>
                <tbody id="reviewList"></tbody>
            </table>
        </div>
                
    </div>
    <p id ="shopNo" hidden="true">
   
    </p>
    
    <script>
         function forwording(num){
        	   window.location.replace("/TWOREE/shop/shop.do?work_div=shop_mng&shop_no="+num);
         }
    
        $(document).ready(function() {
            
            loadData();
            $("#shopNow").click(function() {
            	
            });
            
            $("#AddShopBtn").click(function() {
                // 가게 추가 기능 구현
            });
            
            $("#RegNoticeBtn").click(function() {
                window.open("/TWOREE/shop/jsp/RegNotice.jsp"+"?shop_no="+(<%=jsonShop %>).shopNo,"공지 등록","width=500,height=700,top=100,left=100");
            });
            
            $("#reserveSetBtn").click(function() {
                window.open("/TWOREE/shop/jsp/ReserveSet.jsp"+"?shop_no="+(<%=jsonShop %>).shopNo,"메뉴 등록","width=500,height=500,top=100,left=100");
           
            });
            
            $("#addMenuBtn").click(function() {
                window.open("/TWOREE/shop/jsp/RegMenu.jsp"+"?shop_no="+(<%=jsonShop %>).shopNo,"메뉴 등록","width=500,height=500,top=100,left=100");
            });
            
            $("#DeTailModifyBtn").click(function() {
                window.open("/TWOREE/shop/jsp/ShopDetailSet.jsp"+"?shop_no="+(<%=jsonShop %>).shopNo,"메뉴 등록","width=500,height=500,top=100,left=100");
            });
        });
        
        function getShopNo(){
          return document.getElementById('shopNo');
        }
        
        function loadData() {
                  
                  let shopObj =(<%=jsonShop %>);
                  let shopDetailObj = <%=jsonShopDetail %>;
                  let reserveListObj = <%=jsonReserveList%>;
                  let menuListObj = <%=jsonMenuList%>;
                  let askListObj = <%=jsonAskList%>;
                  let reviewListObj = <%=jsonReviewList%>
                  let shopListObj = <%=jsonShopList%>
                  let shopMap = new Map();
                  
                  
                  $("#shopNow").text(shopObj.shopName);
                  $("#shopName").text(shopObj.shopName);
                  $("#storeName").text(shopObj.shopName);
                  $("#storePhone").text(shopDetailObj.shopTel);
                  $("#storeLocation").text(shopDetailObj.shopLoc);
                  $("#shopNo").text(shopObj.shopNo);
                    
                  $("#shopList").empty();
                  $.each(shopListObj, function(index, shop) {
                        let row = $("<li></li>");
                        row.append($("<a class='dropdown-item' href='#' id='"+shop.shopName+"' onclick ='forwording("+shop.shopNo+")'></a>").text(shop.shopName));
                        $("#shopList").append(row);
                        shopMap.set(shop.shopName,shop.shopNo);
                  });
                 
                   
                  $("#reservationList").empty();
                  $.each(reserveListObj, function(index, reserve) {
                        let row = $("<tr></tr>");
                        row.append($("<td></td>").text(reserve.userId));
                        row.append($("<td></td>").text(reserve.reserveDate));
                        row.append($("<td></td>").text(reserve.people));
                        row.append($("<td></td>").text(reserve.reserveState));
                        row.append($("<td hidden='true'></td>").text(reserve.reserveNo));
                        $("#reservationList").append(row);
                  });
                  
                    
                  $("#menuList").empty();
                  $.each(menuListObj, function(index, menu) {
                        let row = $("<tr></tr>");
                        row.append($("<td></td>").text(menu.menuName));
                        row.append($("<td></td>").text(menu.price));
                        row.append($("<td hidden='true'></td>").text(menu.menuNo));
                        $("#menuList").append(row);
                  });
                     
                  $("#askList").empty();
                  $.each(askListObj, function(index, ask) {
                        let row = $("<tr></tr>");
                        row.append($("<td></td>").text(ask.userAsk));
                        row.append($("<td></td>").text(ask.userId));
                        row.append($("<td></td>").text(ask.askDate));
                        row.append($("<td></td>").text(ask.askState));
                        row.append($("<td hidden='true'></td>").text(ask.askNo));
                        $("#askList").append(row);
                    });
                 
                 $("#reviewList").empty();
                  $.each(reviewListObj, function(index, review) {
                        let row = $("<tr></tr>");
                        row.append($("<td></td>").text(review.userId));
                        row.append($("<td></td>").text(review.score));
                        row.append($("<td></td>").text(review.reviewContent));
                        row.append($("<td></td>").text(review.reviewWrtDate));
                        row.append($("<td hidden='true'></td>").text(review.reviewNo));
                        $("#reviewList").append(row);
                    });
                
           
        }
    </script>
</body>
</html>