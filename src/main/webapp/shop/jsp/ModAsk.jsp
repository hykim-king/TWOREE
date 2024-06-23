<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String askVO =(String)request.getAttribute("askVO");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>문의 관리</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/reserver/jsp/header.jsp"></jsp:include>
    <div class="container my-5" style ="padding:30px;">
        <h1 class="mb-4">문의 관리</h1>
        <form id="askform">
            <div class="form-group row">
                <label for="askId" class="col-sm-2 col-form-label" >문의자 Id :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="askId" disabled="disabled" >
                </div>
            </div>
            
            <div class="form-group row">
                <label for="askTime" class="col-sm-2 col-form-label">문의 시간 :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="askTime" disabled="disabled" >
                </div>
            </div>
            
            <div class="form-group row">
                <label for="askState" class="col-sm-2 col-form-label">문의 상태 :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="askState" disabled="disabled" >
                </div>
            </div> 
            
            <div class="form-group row">
                <label for="askContent" class="col-sm-2 col-form-label">문의 내용:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="askContent" rows="4" disabled="disabled" ></textarea>
                </div>
            </div>
            
            
            <div class="form-group row">
                <label for="askAnswer" class="col-sm-2 col-form-label">문의 답변:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="askAnswer" rows="4" ></textarea>
                </div>
            </div>
            
           
            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="button" class="btn btn-primary" onclick="submitAnswer()">답변 작성</button>
                    <button type="reset" class="btn btn-secondary" >취소</button>
                </div>
            </div>
        </form>
    </div>
<jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
    <script>
        
        
    
        let ask =(<%=askVO%>);
        document.getElementById("askId").value=ask.userId;
        document.getElementById("askTime").value=ask.askDate;
        document.getElementById("askState").value=ask.askState;
        console.log(ask.askNo);
        if(ask.askState =="답변 완료"){
         $("#askAnswer").text(ask.shopAnswer);
         $("#askAnswer").disabled="disabled";        
        }  
              
        $("#askContent").text(ask.userAsk);
        
        
        function submitAnswer(){
            if(ask.askState =="답변 완료"){
                alert('이미 처리된 답변입니다.');
                return;
            }
            
            $.ajax({
                url: '/TWOREE/shop/shop.do',
                type: 'POST',
                data: {
                    askNo: ask.askNo,
                    shopAnswer:  $("#askAnswer").val(),
                    work_div: 'saveAnswer'
                },
                success: function(response) {
                    alert('답변이 작성되었습니다.');
                    window.close();
                },
                error: function(xhr, status, error) {
                    alert('답변 작성 중 오류가 발생했습니다.');
                }
            });
            
        }
                  
        
        
       
    </script>
</body>
</html>