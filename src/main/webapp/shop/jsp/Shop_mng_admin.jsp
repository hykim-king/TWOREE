<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dynamic Content Example</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="container my-5">
        <h1 class="mb-4">Dynamic Content Example</h1>
        
        <div class="border-left border-dark pl-3 mb-4">
            <h3 class="mb-3">가게 상세 정보 관리</h3>
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
        
        <div class="border-left border-dark pl-3 mb-4">
            <h3 class="mb-3">예약 현황</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>예약 번호</th>
                        <th>예약 시간</th>
                        <th>예약 인원</th>
                    </tr>
                </thead>
                <tbody id="reservationList"></tbody>
            </table>
        </div>
        
        <div class="border-left border-dark pl-3 mb-4">
            <h3 class="mb-3">메뉴 관리</h3>
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
        
        <div class="border-left border-dark pl-3 mb-4">
            <h3 class="mb-3">고객 문의</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>문의 내용</th>
                        <th>담당자</th>
                        <th>답변 상태</th>
                    </tr>
                </thead>
                <tbody id="inquiryList"></tbody>
            </table>
        </div>
        
        <div class="d-flex justify-content-end mb-4">
            <button class="btn btn-primary mr-2" id="refreshBtn">새로고침</button>
            <button class="btn btn-success mr-2" id="addReservationBtn">예약 추가하기</button>
            <button class="btn btn-success mr-2" id="addMenuBtn">메뉴 추가하기</button>
            <button class="btn btn-success" id="addInquiryBtn">문의 추가하기</button>
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
            
            $("#addInquiryBtn").click(function() {
                // 문의 추가 기능 구현
            });
        });
        
        function loadData() {
            $.ajax({
                url: "getStoreInfoServlet",
                type: "GET",
                dataType: "json",
                success: function(data) {
                    $("#storeName").text(data.storeName);
                    $("#storePhone").text(data.storePhone);
                    $("#storeLocation").text(data.storeLocation);
                    
                    $("#reservationList").empty();
                    $.each(data.reservations, function(index, reservation) {
                        var row = $("<tr></tr>");
                        row.append($("<td></td>").text(reservation.id));
                        row.append($("<td></td>").text(reservation.time));
                        row.append($("<td></td>").text(reservation.numPeople));
                        $("#reservationList").append(row);
                    });
                    
                    $("#menuList").empty();
                    $.each(data.menus, function(index, menu) {
                        var row = $("<tr></tr>");
                        row.append($("<td></td>").text(menu.name));
                        row.append($("<td></td>").text(menu.price));
                        $("#menuList").append(row);
                    });
                    
                    $("#inquiryList").empty();
                    $.each(data.inquiries, function(index, inquiry) {
                        var row = $("<tr></tr>");
                        row.append($("<td></td>").text(inquiry.content));
                        row.append($("<td></td>").text(inquiry.manager));
                        row.append($("<td></td>").text(inquiry.status));
                        $("#inquiryList").append(row);
                    });
                },
                error: function() {
                    alert("Error occurred while loading data.");
                }
            });
        }
    </script>
</body>
</html>