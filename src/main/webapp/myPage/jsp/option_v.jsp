<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.reserve.ReserveDTO"%>
<%@page import="com.pcwk.user.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>        
<%
List<ReserveDTO> list = (List<ReserveDTO>)request.getAttribute("reserverList"); 
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/TWOREE/myPage/css/bootstrap.min.css"> 
<script src="/TWOREE/myPage/js/jquery_3_7_1.js"></script>
<script src="/TWOREE/myPage/js/common.js"></script>
<script>
document.addEventListener("DOMContentLoaded", function(){
    const toReviewBtn = document.querySelector("#toReview"); 
    const userId = document.querySelector("#userId");

    toReviewBtn.addEventListener("click", function(event){
    	toReview();
    });

        function toReview(){
    		console.log('toReview()');
    		alert("게시 목록으로 이동 합니다.");
    		window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveV2"); 
    	}  
}); //--document


</script>

<title>리뷰쓰기</title>
<style>
    h5 {
        color: white;
    }
    textarea {
        width: 100%;
        height: 4em; 
        resize: none;
    }
    body {
        margin: 0;
        padding: 120px;
        height: 100vh;
        box-sizing: border-box;
        display: flex;
        flex-direction: row;
        gap: 20px;
    }
    .left-section {
        flex: 1;
    }
    .right-section {
        flex: 3;
        padding-left: 20px;
        border-left: 1px solid #ddd;
        overflow-y: auto;
    }
    .table-container {
        max-height: 800px; /* 원하는 최대 높이로 설정 */
        overflow-y: auto;
    }
</style>
</head>
<body> 
    <div class="left-section">
        <h2>리뷰</h2> 
        <h2>작성</h2>
        
    </div>
    <div class="right-section">
        <!-- 버튼 -->
              <a>[안내] 방문완료일 경우 리뷰를 작성하실 수 있습니다.</a> 
        <div class="mb-2 d-grid gap-2 d-md-flex justify-content-md-end"> 
        
            <button type="reset" class="btn btn-secondary" value="" >새로고침</button>   
            <button type="button" class="btn btn-info" id="toReview" name="toReview" >뒤로가기</button>
        </div> 
        <!--// 버튼 ----------------------------------------------------------------->
        <div class="table-container">
            <table class="table table-hover" id="boardList">
                <thead>
                    <tr class="table-info table-hover table-bordered" id="option_reserver">
                        <th>가게번호</th>    
                        <th>개인정보</th>    
                        <th>날짜</th>    
                        <th>예약현황</th>
                      
                    </tr>
                </thead> 
                <tbody> 
                    <%     
                        for(ReserveDTO vo : list) {  
                    %>   
                    <tr<% if (!"방문완료".equals(vo.getReserveState())) { %> class="disabled-row"<% } %>>
                        <td> <%=vo.getShopNo()%></td>    
                        <td>[주문자] <%=vo.getUserId()%></td>   
                        <td> <%=vo.getReserveDate()%></td>    
                        <td> <%=vo.getReserveState()%></td>
                        <td>
                            <div>
                                
                            </div>
                        </td>
                        <td style="display: none;"><%=vo.getReserveDate()%></td>
                    </tr>
                    <%   
                        }
                    %> 
                </tbody>
            </table>
            
        </div>
    </div> 
    <script>
    document.addEventListener("DOMContentLoaded", function(){
        const rows = document.querySelectorAll("#boardList tbody tr:not(.disabled-row)");
        const buttons = document.querySelectorAll(".btn-outline-success:not([disabled])");

        rows.forEach(function(row){
            row.addEventListener('click', function(){
                console.log('row click');
                let shopValue = this.querySelector('td:first-child').textContent.trim();
                console.log('shopValue:' + shopValue); 
                doSelectOne(shopValue);
            });
        });

        buttons.forEach(function(button){
            button.addEventListener('click', function(){
                let hiddenInfo = this.getAttribute('data-hidden-info');
                console.log('hiddenInfo:' + hiddenInfo);
                doSelectOne(hiddenInfo);
            }); 
        });

        function doSelectOne(shopValue){
            window.open("/TWOREE/user/myPage.do?work_div=doSelectOneR1&shopNo=" + shopValue); 
        }
    });//document end
    </script> 
</body>   
</html>
