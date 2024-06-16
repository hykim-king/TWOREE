<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    </style>
</head>
<body>
    <div class="container my-5">
        <h1 class="mb-4" id="shopName"></h1>
        
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
                        <th>예약 번호</th>
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
                <tbody id="inquiryList"></tbody>
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
                <tbody id="askList"></tbody>
            </table>
        </div>
                
    </div>
    
    <script>
        $(document).ready(function() {
            loadData();
            
            $("#refreshBtn").click(function() {
                loadData();
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
            $.ajax({
                url: "getStoreInfoServlet",
                type: "GET",
                dataType: "json",
                success: function(data) {
                	$("#shpName").text(data.shopName);
                    $("#storeName").text(data.storeName);
                    $("#storePhone").text(data.storePhone);
                    $("#storeLocation").text(data.storeLocation);
                    
                    $("#reservationList").empty();
                    $.each(data.reservations, function(index, reservation) {
                        var row = $("<tr></tr>");
                        row.append($("<td></td>").text(reservation.id));
                        row.append($("<td></td>").text(reservation.time));
                        row.append($("<td></td>").text(reservation.numPeople));
                        row.append($("<td></td>").text(reservation.reserveState));
                        $("#reservationList").append(row);
                    });
                    
                    $("#menuList").empty();
                    $.each(data.menus, function(index, menu) {
                        var row = $("<tr></tr>");
                        row.append($("<td></td>").text(menu.name));
                        row.append($("<td></td>").text(menu.price));
                        $("#menuList").append(row);
                    });
                    
                    $("#askList").empty();
                    $.each(data.ask, function(index, ask) {
                        var row = $("<tr></tr>");
                        row.append($("<td></td>").text(ask.content));
                        row.append($("<td></td>").text(ask.wrtId));
                        row.append($("<td></td>").text(ask.askWrtDate));
                        row.append($("<td></td>").text(ask.status));
                        $("#inquiryList").append(row);
                    });
                },
                error: function() {
                }
            });
        }
    </script>
</body>
</html>