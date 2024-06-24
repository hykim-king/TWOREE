<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.reserve.ReserveDTO"%>
<%@page import="com.pcwk.user.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
//String outVO = (String)request.getAttribute("outVO");

document.addEventListener("DOMContentLoaded", function(){
const profBtn = document.querySelector("#toprof"); 
const doRetrieveRtn = document.querySelector("#doRetrieveR"); 
const doRetrieveVtn = document.querySelector("#doRetrieveV"); 
const doRetrieveXtn = document.querySelector("#doRetrieveX");
const doSelectOne = document.querySelector("#doSelectOne");
const userId = document.querySelector("#userId");



profBtn.addEventListener("click",function(event){
	toprof();
});
	
function toprof(){ 
	console.log('profBtn click'); 
	window.location.replace("/TWOREE/user/myPage.do?work_div=doSelectOne");   
}

doRetrieveRtn.addEventListener("click", function(event) {
    console.log('doRetrieveRtn click');
    window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveR2");
});

doRetrieveVtn.addEventListener("click", function(event) {
    console.log('doRetrieveVtn click');
    window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveV2");
});

doRetrieveXtn.addEventListener("click", function(event) {
    console.log('doRetrieveXtn click');
    window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveX2");
});

					
		
	
}) ;//--document
</script>
</script> 
    <title>예약현황</title>
    <style>
    	h5 {
   		 color: white;
     }
     textarea {
         width: 100%;
         height: 4em;
         resize: none;
     }
     
     .body {
         display: flex;
         margin: 0;
         padding: 100px; /* 가장자리 여백 */
         height: calc(100vh - 100px); /* 패딩 값을 제외한 높이 설정 */
         box-sizing: border-box;
         flex-direction: row;
         gap: 20px;
     }
     
     .body .menu { 
         display: flex;
         flex-direction: column;
         width: 350px;
         min-width: 100px;
         background-color: white;
         border: 1px solid #ccc;
         padding: 20px;
         box-shadow: 2px 0 5px rgba(0,0,0,0.1);
         box-sizing: border-box;
         align-items: center; /* 메뉴를 수평 가운데 정렬 */
         border-radius: 10px; /* 모서리를 둥글게 */
     }
     
     .body .content {
         flex-grow: 1; /* 남은 공간을 차지하도록 설정 */
         padding: 20px;
         box-sizing: border-box;
         border: 1px solid #ccc;
         overflow: auto; /* 내용이 넘칠 경우 스크롤 생성을 위해 */
         border-radius: 10px; /* 모서리를 둥글게 */
         background-color: #ccc;
     }
     
     .body .content_info {
         margin-top: 10px;
         flex-grow: 1; /* 남은 공간을 차지하도록 설정 */
         padding: 20px;
         box-sizing: border-box;
         border: 1px solid #ccc;
         overflow: auto; /* 내용이 넘칠 경우 스크롤 생성을 위해 */
         border-radius: 10px; /* 모서리를 둥글게 */
         background-color: #FFFFFF;
     }
     
     .body .menu ul {
         list-style-type: none;
         padding: 0;
         text-align: left; /* 왼쪽 정렬 */
         width: 100%; /* ul 요소가 전체 너비를 차지하게 설정 */
     }
     
     .body .menu ul li {
         margin: 10px 0;
     }
     
     .body .menu ul li a {
         text-decoration: none;
         color: #333;
     }
     
     .body .menu ul li a:hover {
         text-decoration: underline;
     }
     
     .body .content ul {
         list-style: none;
         padding-left: 0;
     }
     
     .body .content ul li {
         margin: 10px;
     } 

        .footer {
         display: flex;
         justify-content: center;
         align-items: center;
         position: fixed;
         bottom: 0;
         width: 100%;
         background-color: #f8f9fa;
         padding: 10px;
         border-top: 1px solid #ccc;
     }
    </style>
</head>
<jsp:include page="/reserver/jsp/header.jsp"></jsp:include>
<div class ="body">
<body>  
    <div class="menu"> 
        <img src="/TWOREE/myPage/img/user_icon1.png" width= 80px><br> 
        
       <p class="text-success"><strong><%= list.get(0).getUserId()%></strong></p>  
       
       <ul>
            <li><input type="button" value="내프로필" class="btn btn-light " id="toprof" ></li>
            <li><input type="button" value="예약"    class="btn btn-outline-success " id="doRetrieveR" ></li>
            <li><input type="button" value="리뷰"    class="btn btn-light " id="doRetrieveV" ></li>
            <li><input type="button" value="고객문의" class="btn btn-light " id="doRetrieveX" ></li>
        </ul>
        
         <hr>
          <hr>
           <hr>
        
        
    </div>
    <div class="content">
        <h5>전체 예약 정보</h5>
        <p></p>
     <div class="right-section">
        <!-- 버튼 -->
        <div class="mb-2 d-grid gap-2 d-md-flex justify-content-md-end"> 
          <button type="reset" class="btn btn-secondary"  value="" >새로고침</button> 
            <button type="button" class="btn btn-danger" value="" onClick="location.href=''">예약취소</button>
        </div>
        <!--// 버튼 ----------------------------------------------------------------->
       <div class="table-container">
          <table class="table table-hover">
          <thead>
                    <tr class="table-warning table-hover table-bordered" id="option_reserver">
                 	<th>예약정보</th>	
                 	<th>개인정보</th>	
                 	<th>날짜</th>	
                 	<th>옵션</th>
                 	<th class="text_center col-sm-1">관리</th>
                 	</tr>
     	 </thead> 
    	 	<tbody> 
    	 	    <%     if(null != list && list.size()>0){
          				for(ReserveDTO vo   :list){  
		         %>   
    	 	 
    	 	
					<tr><td rowspan="3" >[가게번호] <%=vo.getShopNo()%></td>	 
						<td>[주문자] <%=vo.getUserId()%></td>   
						<td>[예약날짜] <%=vo.getReserveDate()%></td>    
						<td>[예약상태] <%=vo.getReserveState()%></td>
						<td rowspan="3">
						 <input type="button"  data-hidden-info="" value="수정"  class="btn btn-outline-success "></td>
            
					<tr> 
						<td>[인원 수] <%=vo.getPeople()%></td> 
						<td>[확정날짜] <%=vo.getConfirmedDate()%></td>	 
						<td>[요청사항] <%=vo.getUserComment()%></td>
					<tr> 
						<td> </td> 
						<td> </td>	 
						<td> </td>
			 <%   
          				 }//for
         		}//--if 
      		  %> 
   			 </tbody>
			 </table>
        </div>
    </div>
    </div> 
</body>
</div>
 <jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
</html>
