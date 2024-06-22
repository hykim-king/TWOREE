<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String reserveVO =(String)request.getAttribute("reserveVO");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약 관리</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/reserver/jsp/header.jsp"></jsp:include>
    <div class="container my-5">
        <h1 class="mb-4">예약 관리</h1>
        <form id="menuForm">
            <div class="form-group row">
                <label for="reserveId" class="col-sm-2 col-form-label" >예약자 Id:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="reserveId" disabled="disabled" >
                </div>
            </div>
            
            <div class="form-group row">
                <label for="reserveTime" class="col-sm-2 col-form-label">예약 시간:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="reserveTime" disabled="disabled" >
                </div>
            </div>
            
            <div class="form-group row">
                <label for="peopleNum" class="col-sm-2 col-form-label">인원수 :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="peopleNum" disabled="disabled" >
                </div>
            </div> 
            
            <div class="form-group row">
                <label for="userTel" class="col-sm-2 col-form-label">예약자 전화번호:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userTel" disabled="disabled" >
                </div>
            </div>
            
            <div class="form-group row">
                <label for="reserveState" class="col-sm-2 col-form-label">예약 상태:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="reserveState" disabled="disabled" >
                </div>
            </div>

            
            <div class="form-group row">
                <label for="userComment" class="col-sm-2 col-form-label">요청 사항:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="userComment" rows="3" disabled="disabled" ></textarea>
                </div>
            </div>
            
           
            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="button" class="btn btn-primary" onclick="confirmReserve()">예약 승인</button>
                    <button type="button" class="btn btn-primary" onclick="cancelReserve()">예약 취소</button>
                </div>
            </div>
        </form>
    </div>
<jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
    <script>
    
    
        let reserve =(<%=reserveVO%>);
        document.getElementById("reserveId").value=reserve.userId;
        document.getElementById("reserveTime").value=reserve.reserveDate;
        document.getElementById("userTel").value=reserve.userTel;
        document.getElementById("reserveState").value=reserve.reserveState;
        document.getElementById("peopleNum").value=reserve.people;
        
        
        $("#userComment").text(reserve.userComment);
        
                     
        
        function confirmReserve(){
            if(reserve.reserveState !="예약신청"){
                alert('이미 처리된 신청입니다.');
                return;
            }
            if(false==confirm('예약을 승인 하시겠습니까?')){
               return;
            }
            
            $.ajax({
                url: '/TWOREE/shop/shop.do',
                type: 'POST',
                data: {
                    reserveNo: reserve.reserveNo,
                    work_div: 'confirmReserve'
                },
                success: function(response) {
                    alert('예약이 승인되었습니다.');
                    window.close();
                },
                error: function(xhr, status, error) {
                    alert('예약 승인 중 오류가 발생했습니다.');
                }
            });
        
        }
        
        function cancelReserve(){
             if(reserve.reserveState !="예약신청"){
                alert('이미 처리된 신청입니다.');
                return;
            }
            if(false==confirm('예약을 거절 하시겠습니까?')){
               return;
            }
            
            $.ajax({
                url: '/TWOREE/shop/shop.do',
                type: 'POST',
                data: {
                    reserveNo: reserve.reserveNo,
                    work_div: 'cancelReserve'
                },
                success: function(response) {
                    alert('예약이 거절되었습니다. 사용자에게 전달해주세요.\n 사용자 번호 : '+reserve.userTel);
                    window.close();
                },
                error: function(xhr, status, error) {
                    alert('예약 승인 중 오류가 발생했습니다.');
                }
            });
        
        }
        
        
        
       
    </script>
</body>
</html>