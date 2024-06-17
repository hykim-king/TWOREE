<%@page import="com.pcwk.shop.ShopDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String jsonShop =(String)request.getAttribute("shopVO");
   String jsonShopDetail =(String)request.getAttribute("shopDetailVO");
   String jsonReserveList = (String)request.getAttribute("outReserveVOList");
   String jsonMenuList =(String)request.getAttribute("outMenuVOList"); 
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dynamic Content Example</title>
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
        <h1 class="mb-4" id="shopName">abc</h1>
        <div class="dropdown">
        <button class="btn btn-primary mr-2" style="float:right" id="AddShopBtn">가게 추가</button>
             <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" style="float:right" id="shopSelectBtn">
                 Dropdown button
             </button>
          <ul class="dropdown-menu" id ="shopList">
          </ul>
          
        
        </div>
        <div class="p-3 border border-info border-start-0 rounded-end" >
            <h3 class="mb-3">가게 상세 정보 관리</h3>
            <button class="btn btn-primary mr-2" style="float:right" id="DeTailModifyBtn">상세정보설정</button>
            <button class="btn btn-primary mr-2" id="RegNoticeBtn" style="float:right">가게소식등록</button>
            <table class="table">
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
        
        <div class="p-3 border border-info border-start-0 rounded-end printList" >
            <h3 class="mb-3">예약 현황</h3>
            <button class="btn btn-primary mr-2" style="float:right" id="reserveTimeSetBtn">예약 시간 설정</button>
            <button class="btn btn-primary mr-2" style="float:right" id="offerTimeSetBtn">영업 시간 설정</button>
            <table class="table">
                <thead>
                    <tr>
                        <th>예약자 ID</th>
                        <th>예약 시간</th>
                        <th>예약 인원</th>
                        <th>예약 상태</th>
                    </tr>
                </thead>
                <tbody id="reservationList"></tbody>
            </table>
        </div>
        
        <div class="p-3 border border-info border-start-0 rounded-end printList" >
            <h3 class="mb-3">메뉴 관리</h3>
            <button class="btn btn-primary mr-2" style="float:right" id="addMenuBtn">메뉴 추가하기</button>
            <table class="table">
                <thead>
                    <tr>
                        <th>메뉴 이름</th>
                        <th>가격</th>
                    </tr>
                </thead>
                <tbody id="menuList"></tbody>
            </table>
        </div>
        
        <div class="p-3 border border-info border-start-0 rounded-end printList">
            <h3 class="mb-3">고객 문의</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>문의 내용</th>
                        <th>작성자 id</th>
                        <th>작성 시간</th>
                        <th>답변 상태</th>
                    </tr>
                </thead>
                <tbody id="askList"></tbody>
            </table>
        </div>
        
        <div class="p-3 border border-info border-start-0 rounded-end printList">
            <h3 class="mb-3">리뷰</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>리뷰</th>
                        <th>작성자 id</th>
                        <th>답변 상태</th>
                    </tr>
                </thead>
                <tbody id="reviewList"></tbody>
            </table>
        </div>
                
    </div>
    <p id ="shopNo" hidden="true">
   
    </p>
    
    <script>
        $(document).ready(function() {
            console.log("준비됨");
            loadData();
            $("#shopSelectBtn").click(function() {
                loadData();
            });
            
            $("#AddShopBtn").click(function() {
                // 가게 추가 기능 구현
            });
            
            $("#addReservationBtn").click(function() {
                // 예약 추가 기능 구현
            });
            
            $("#addMenuBtn").click(function() {
                // 메뉴 추가 기능 구현
            });
            
            $("#addAskBtn").click(function() {
                // 문의 추가 기능 구현
            });
        });
        
        function loadData() {
                  
                  let shopObj =(<%=jsonShop %>);
                  let shopDetailObj = <%=jsonShopDetail %>;
                  let reserveListObj = <%=jsonReserveList%>;
                  let menuListObj = <%=jsonMenuList%>;
                  
                  console.log(reserveListObj);
                	$("#shopNow").text(shopObj.shopName);
                	$("#shopName").text(shopObj.shopName);
                  $("#storeName").text(shopObj.shopName);
                  $("#storePhone").text(shopDetailObj.shopTel);
                  $("#storeLocation").text(shopDetailObj.shopLoc);
                  $("#shopNo").text(shopObj.shopNo);
                  /*  
                  $("#shopList").empty();
                  $.each(data.shops, function(index, shop) {
                        let row = $("<li><a class='dropdown-item' href='#'></a></li>");
                        row.append($text(shop.name));
                        $("#shopList").append(row);
                  });
                  */
                   
                  $("#reservationList").empty();
                  $.each(reserveListObj, function(index, reserve) {
                        let row = $("<tr></tr>");
                        row.append($("<td></td>").text(reserve.userId));
                        row.append($("<td></td>").text(reserve.reserveDate));
                        row.append($("<td></td>").text(reserve.people));
                        row.append($("<td></td>").text(reserve.reserveState));
                        $("#reservationList").append(row);
                  });
                  
                    
                  $("#menuList").empty();
                  $.each(menuListObj, function(index, menu) {
                        let row = $("<tr></tr>");
                        row.append($("<td></td>").text(menu.menuName));
                        row.append($("<td></td>").text(menu.price));
                        $("#menuList").append(row);
                  });
                  /*   
                  $("#askList").empty();
                  $.each(data.ask, function(index, ask) {
                        let row = $("<tr></tr>");
                        row.append($("<td></td>").text(ask.content));
                        row.append($("<td></td>").text(ask.wrtId));
                        row.append($("<td></td>").text(ask.askWrtDate));
                        row.append($("<td></td>").text(ask.status));
                        $("#askList").append(row);
                    });
                 */
                
           
        }
    </script>
</body>
</html>