<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.user.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>       
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
const profBtn = document.querySelector("#profBtn"); 
const doRetrieveRtn = document.querySelector("#doRetrieveR"); 
const doRetrieveVtn = document.querySelector("#doRetrieveV"); 
const doRetrieveXtn = document.querySelector("#doRetrieveX");
const shopAdminBtn = document.querySelector("#shopAdmin");
const doUpdateBtn = document.querySelector("#doUpdate");
const userId = document.querySelector("#userId");
const password = document.querySelector("#password");   //password
const name = document.querySelector("#name");
const userEmail = document.querySelector("#userEmail");
const tel = document.querySelector("#tel"); 
const birthday = document.querySelector("#birthday");
const adminDiv = document.querySelector("#adminDiv");
//const shopAdmin = document.querySelector("#shopAdmin");
//const penaltyDate = document.querySelector("#penaltyDate");
const isAdmin = "${outVO.shopAdmin}";

console.log(isAdmin);
if(isAdmin =="N"){
adminDiv.hidden='hidden';
}


doUpdateBtn.addEventListener("click", function(event){
	console.log('doUpdateBtn click event'+event);
	doUpdate();
});


shopAdminBtn.addEventListener("click", function(event){
  console.log('shopAdminBtn click event'+event);
  doManage();
});
function doManage(){
   window.location.replace("/TWOREE/shop/shop.do?work_div=shop_mng");
 
 }
       function doUpdate(){
       	console.log('doUpdate()');
       	console.log("userId:"+userId.value);
       	console.log("name:"+name.value);
       	console.log("password:"+password.value);
       	console.log("userEmail:"+userEmail.value);
       	console.log("tel:"+tel.value);
       	console.log("birthday:"+birthday.value);
       	//console.log("shopAdmin:"+shopAdmin.value);
       	//console.log("penaltyDate:"+penaltyDate.value);
       
       	if( isEmpty(password.value) ==true){
           alert('password를 확인 하세요.');
           return;
       } 
       $.ajax({
           type: "POST", 
           url:"/TWOREE/user/myPage.do",
           asyn:"true",
           dataType:"html",
           data:{
               "work_div":"doUpdate",
               "userId": userId.value,
               "password": password.value,
               "name": name.value,
               "userEmail": userEmail.value,
               "tel": tel.value,
               "birthday": birthday.value,
               "userId": userId.value
               
           },
           success:function(response){//통신 성공
               console.log("success data:"+response);
           
               //null, undefined처리
               if(response){
               	try{
               		const messageVO = JSON.parse(response);
               		console.log("messageVO.messageId:"+messageVO.messageId);
                   console.log("messageVO.msgContents:"+messageVO.msgContents);
                   
                   if(isEmpty(messageVO) == false &&  "1" === messageVO.messageId){
                   	alert(messageVO.msgContents); 
                   }else{
                   	alert(messageVO.msgContents);
                   }
               		
               	}catch(e){    
               		console.error("JSON 파싱 에러:",e);
               	}
               	
               	
               }else{
               	console.warn("response가 null혹은 undefined.");
               	alert("response가 null혹은 undefined.");
               }
           
           },
           error:function(data){//실패시 처리
                   console.log("error:"+data);
           }
       });    
       
       }//--doUpdate() end
       


profBtn.addEventListener("click",function(event){
	console.log('profBtn click'); 
	window.location.replace("/TWOREE/user/myPage.do?work_div=doSelectOne&userId="+"user1"); 
	
});
 
doRetrieveRtn.addEventListener("click",function(event){
	console.log('doRetrieveRtn click'); 

	$.ajax({
        type: "POST", 
        url:"/TWOREE/user/myPage.do",
        asyn:"true",
        dataType:"html",
        data:{
            "work_div":"doRetrieveR",
             
            
        },
        success:function(response){//통신 성공
            console.log("success data:"+response);
        	
            //null, undefined처리
            if(response){
            	try{
            		const messageVO = JSON.parse(response);
            		console.log("messageVO.messageId:"+messageVO.messageId);
                	console.log("messageVO.msgContents:"+messageVO.msgContents);
                
                if(isEmpty(messageVO) == false &&  "1" === messageVO.messageId){
                	 
                	window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveR2"); 
                }else{
                	alert(messageVO.msgContents);
                }
            		
            	}catch(e){    
            		console.error("JSON 파싱 에러:",e);
            	}
            	
            	
            }else{
            	console.warn("response가 null혹은 undefined.");
            	alert("response가 null혹은 undefined.");
            }
        
        },
        error:function(data){//실패시 처리
                console.log("error:"+data);
        }
    });    
	});//-Rtn
	
	doRetrieveVtn.addEventListener("click",function(event){
		console.log('doRetrieveVtn click'); 

		$.ajax({
	    type: "POST", 
	    url:"/TWOREE/user/myPage.do",
	    dataType:"html",
	    data:{
	        "work_div": "doRetrieveV",
	        
	    },
        success:function(response){//통신 성공
            console.log("success data:"+response);
        	console.log(userId.value);
            //null, undefined처리
            if(response){
            	try{
            		const messageVO = JSON.parse(response);
            		console.log("messageVO.messageId:"+messageVO.messageId);
                	console.log("messageVO.msgContents:"+messageVO.msgContents);
                
                if(isEmpty(messageVO) == false &&  "1" === messageVO.messageId){
                	 
                	window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveV2"); 
                }else{
                	alert(messageVO.msgContents);
                }
            		
            	}catch(e){    
            		console.error("JSON 파싱 에러:",e);
            	}
            	
            	
            }else{
            	console.warn("response가 null혹은 undefined.");
            	alert("response가 null혹은 undefined.");
            }
        
        },
        error:function(data){//실패시 처리
                console.log("error:"+data);
        }
    });    
	});//-doRetrieveVtn
		
	doRetrieveXtn.addEventListener("click",function(event){
		console.log('doRetrieveVtn click'); 

		$.ajax({
	    type: "POST", 
	    url:"/TWOREE/user/myPage.do",
	    dataType:"html",
	    data:{
	        "work_div": "doRetrieveX",
	         
	    },
	    success:function(response){//통신 성공
            console.log("success data:"+response);
        	
            //null, undefined처리
            if(response){
            	try{
            		const messageVO = JSON.parse(response);
            		console.log("messageVO.messageId:"+messageVO.messageId);
                	console.log("messageVO.msgContents:"+messageVO.msgContents);
                
                if(isEmpty(messageVO) == false &&  "1" === messageVO.messageId){
                	 
                	window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveX2"); 
                }else{
                	alert(messageVO.msgContents);
                }
            		
            	}catch(e){    
            		console.error("JSON 파싱 에러:",e);
            	}
            	
            	
            }else{
            	console.warn("response가 null혹은 undefined.");
            	alert("response가 null혹은 undefined.");
            }
        
        },
        error:function(data){//실패시 처리
                console.log("error:"+data);
        }
    });    
	});//-doRetrieveVtn
					
		
	
}) ;//--document
</script>
<script type="text/javascript">

//Check javascript has loaded
$(document).ready(function() {
    // Initial setup: Show the "show" image and hide the "hide" image
    $('#showImg').show();
    $('#hideImg').hide();

    // Click event of the showPassword button
    $('#showPassword').on('click', function() {
        // Get the password field
        var passwordField = $('#password');

        // Get the current type of the password field will be password or text
        var passwordFieldType = passwordField.attr('type');

        // Check to see if the type is a password field
        if (passwordFieldType == 'password') {
            // Change the password field to text
            passwordField.attr('type', 'text');

            // Show the "hide" image and hide the "show" image
            $('#hideImg').show();
            $('#showImg').hide();
        } else {
            // If the password field type is not a password field then set it to password
            passwordField.attr('type', 'password');

            // Show the "show" image and hide the "hide" image
            $('#showImg').show();
            $('#hideImg').hide();
        }
    });
});

</script>
 <script type="text/javascript">
 $(function() {
	    $("#tel").keyup(function(){
	        var val = $(this).val().replace(/[^0-9]/g, '');

	        // Truncate the value if it exceeds 12 characters
	        if(val.length > 11) {
	            val = val.substring(0, 11);
	        }

	        if(val.length > 3 && val.length < 6){
	            var tmp = val.substring(0,2);
	            if(tmp == "02"){
	                $(this).val(val.substring(0,2) + "-" + val.substring(2));
	            } else {
	                $(this).val(val.substring(0,3) + "-" + val.substring(3));
	            }
	        } else if (val.length > 6){
	            var tmp = val.substring(0,2);
	            var tmp2 = val.substring(0,4);
	            if(tmp == "02"){
	                if(val.length == "10"){
	                    $(this).val(val.substring(0,2) + "-" + val.substring(2, 6) + "-" + val.substring(6));
	                } else {
	                    $(this).val(val.substring(0,2) + "-" + val.substring(2, 5) + "-" + val.substring(5));
	                }
	            } else if(tmp2 == "0505"){
	                if(val.length == "12"){
	                    $(this).val(val.substring(0,4) + "-" + val.substring(4, 8) + "-" + val.substring(8));
	                } else {
	                    $(this).val(val.substring(0,4) + "-" + val.substring(4, 7) + "-" + val.substring(7));
	                }
	            } else {
	                if(val.length == "11"){
	                    $(this).val(val.substring(0,3) + "-" + val.substring(3, 7) + "-" + val.substring(7));
	                } else {
	                    $(this).val(val.substring(0,3) + "-" + val.substring(3, 6) + "-" + val.substring(6));
	                }
	            }
	        }
	    });
	});

</script>
    <title>프로필</title>
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
      #showPassword {
            background: transparent;
            border: none;
            cursor: pointer;
        }
        .show-password-img {
            width: 20px;
            height: 20px;
            display: none;
        }
     
     
    </style>
</head>
<jsp:include page="/reserver/jsp/header.jsp"></jsp:include>
<div class ="body"> 
<body>  
    <div class="menu">
          <img src="/TWOREE/myPage/img/user_icon1.png" width= 80px><br> 
       	 <p class="text-success"> <strong> ${outVO.userId}</strong></p>
         
        <ul>
            <li><input type="button" value="내프로필" class="btn btn-outline-success " id="profBtn" ></li>
            <li><input type="button" value="예약"    class="btn btn-light " id="doRetrieveR" ></li>
            <li><input type="button" value="리뷰"    class="btn btn-light " id="doRetrieveV" ></li>
            <li><input type="button" value="고객문의" class="btn btn-light " id="doRetrieveX" ></li>
        </ul>
        
         <hr>
          <hr>
           <hr>
        
        
    </div>
    <div class="content">
        <h5>개인 정보</h5>
        <p></p>
        <div class="content_info">
            <ul>
                <li>
                    <label for="userId">아이디 &nbsp &nbsp &nbsp</label>
                    <input type="text" id="userId"  style="border: none; name="userId" readonly="readonly" value="${outVO.userId}"> 
                </li>
                <li>
                    <label for="userEmail">이메일 &nbsp &nbsp &nbsp</label>
                    <input type="email" id="userEmail" style="border: none; name="userEmail" readonly="readonly" value="${outVO.userEmail}"> 
                </li>
                <li>
                    <label for="password">비밀번호 &nbsp</label>
                    <input type="password" id="password" style="border: none; name="password"  required">  
              			 <button id="showPassword">
        				<img src="/TWOREE/myPage/img/hide.png " alt="Show" id="showImg" class="show-password-img">
        				<img src="/TWOREE/myPage/img/show.png" alt="Hide" id="hideImg" class="show-password-img">
   					 	</button> 	 
                </li>     
           
                <li>
                    <label for="name">이름 &nbsp &nbsp &nbsp &nbsp</label>
                    <input type="text" id="name"  style="border: none; name="name"  readonly="readonly" value="${outVO.name}"> 
                </li>
                <li>
                    <label for="tel">전화번호 &nbsp</label>
                    <input type="text" id="tel" style="border: none; name ="tel" required value="${outVO.tel}"> 
                </li>
                <li>
                    <label for="birthday">생년월일 &nbsp</label>
                    <input type="text" id="birthday" style="border: none; name="birthday" readonly="readonly" value="${outVO.birthday}"> 
                </li> 
            </ul>
                  <button type="submit" class="btn btn-secondary" id ="doUpdate" style="float: right;">수정하기</button>
        </div>
        
        <div class="content_info" id='adminDiv'>
        
            <ul>
                <li>
                    <label>관리자 &nbsp </label>
                     <!--   <div class="form-check form-switch">
                     <input class="form-check-input" type="checkbox" id="Switches" checked> 
                     <label class="form-check-label" for="Switches"></label>  
                      </div>--> 
                    <button type="button" class="btn btn-success"  id ="shopAdmin" style="float: right;">관리하기</button>
                </li>
                 
            </ul>
            
        </div>
        <br>
         <h5>예약 관리</h5>
        <div class="content_info">
        
            <ul>
                <li>
                    <label>예약패널티 &nbsp </label>
                     <!--   <div class="form-check form-switch">
                     <input class="form-check-input" type="checkbox" id="Switches" checked> 
                     <label class="form-check-label" for="Switches"></label>  
                      </div>-->
                    <button type="button" class="btn btn-secondary" style="float: right;">확인하기</button>
                </li>
                 
            </ul>
            
        </div>
        
        
    </div> 
    
</body> 
 </div>
   <jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
</html>
 




