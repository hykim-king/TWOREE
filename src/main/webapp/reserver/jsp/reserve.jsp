<%@page import="com.pcwk.user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
     String shopDetail =(String)request.getAttribute("shopDetailVO");  
     String shop =(String)request.getAttribute("shopVO");
     String reserveSet =(String)request.getAttribute("reserveSetVO");
     String userName =(String)request.getAttribute("userName");
     String userTel =(String)request.getAttribute("userTel");
     String userEmail =(String)request.getAttribute("userEmail");
%>
 
<!DOCTYPE html>
<html>
<head>
      <meta charset="UTF-8">
      <title> 예약 하기</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>  
      <link rel="stylesheet" href="/TWOREE/reserver/css/accordion.scss">
      <style>
        .accordion-button {
  background-color: #f8f9fa; /* 아코디언 헤더 배경색 변경 */
  width : 100%;
}

.accordion-body {
  padding: 20px; /* 아코디언 바디 패딩 조정 */
}
      </style>
</head>
<body>
<div class="container my-5">
  <h1 id="shopName"></h1>
  <form>
    <div class="form-group row">
      <label for="peopleNum" class="col-sm-3 col-form-label">예약 인원:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="peopleNum" placeholder="예약 인원수를 입력해주세요 ex)2,6,10">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="reservationDate" class="col-sm-3 col-form-label">예약 날짜:</label>
      <div class="col-sm-9">
        <input type="date" class="form-control" id="reservationDate" >
      </div>
    </div>
    
    <div class="form-group row">
      <label for="reserveTime" class="col-sm-3 col-form-label">예약 시간:</label>
      <div class="col-sm-9">
        <select id="reserveTime" style="width:200px;">
        <option>시간 선택</option>

        </select>
      </div>
    </div>
    
    <h3 style="margin-top:20px;">예약자 정보</h3>
    <div class="form-group row">
      <label for="userName" class="col-sm-3 col-form-label" >예약자:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="userName" >
      </div>
    </div>
    
    <div class="form-group row">
      <label for="userTel" class="col-sm-3 col-form-label">연락처:</label>
      <div class="col-sm-9">
           <input type="text" class="form-control" id="userTel" >
      </div>
    </div>
    
    <div class="form-group row">
      <label for="userEamil" class="col-sm-3 col-form-label">이메일:</label>
      <div class="col-sm-9">
           <input type="text" class="form-control" id="userEamil">
      </div>
    </div>
    
    <div class="form-group row">
       <label for="userComment" class="col-sm-2 col-form-label">요청 사항:</label>
       <div class="col-sm-10">
             <textarea class="form-control" id="userComment" rows="4" placeholder="업체에 요청하실 내용을 적어주세요"></textarea>
        </div>
     </div>
     
     
      <div class="accordion" id="accordionExample">
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingOne">
            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
              판매자 정보
            </button>
          </h2>
          <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
               <div class="accordion-body" >
                <table class="table table-striped table-hover table-bordered">
                  <tbody id ="accordion-text">
                
                  </tbody>
                </table>
               </div>
          </div>
        </div>
      </div>
      
      
      
    <div class="form-group row">
      <div class="col-sm-12 text-right">
        <button class="btn btn-primary" id ="registerButton" onclick="reserve()">예약</button>
      </div>
    </div>
  </form>
</div>  

<script>

       let shopDetail = <%=shopDetail%>;
       const userName = "<%=userName%>";
       const userTel = "<%=userTel%>";
       const userEmail = "<%=userEmail%>";
       console.log(userEmail);
       let shop = <%=shop%>;
       let reserveSet = <%=reserveSet%>;
       
    $(document).ready(function() {
            
            loadData();
            
            
            $("#registerButton").click(function() {
            	submitReserve();
            });
            
           
            
          
        });
        
        
   function loadData(){
       $("#shopName").text(shop.shopName);
       document.getElementById("userName").value =userName;
       document.getElementById("userTel").value =userTel;
       document.getElementById("userEamil").value =userEmail;

      
       $("#accordion-text").empty();
       let row =$("<tr></tr>");
       row.append($("<td style='width:200px;'></td>").text(" 판매자 이름 :"));
       row.append($("<td></td>").text(shopDetail.ownerName));
        $("#accordion-text").append(row);
       row =$("<tr></tr>");
       row.append($("<td style='width:200px;'></td>").text(" 가게 전화번호 :"));
       row.append($("<td></td>").text(shopDetail.shopTel));
        $("#accordion-text").append(row);
       row =$("<tr></tr>");
       row.append($("<td style='width:200px;'></td>").text(" 가게 위치 :"));
       row.append($("<td></td>").text(shopDetail.shopLoc));
        $("#accordion-text").append(row);
       row =$("<tr></tr>");
       row.append($("<td style='width:200px;'></td>").text(" 주차 정보 :"));
       row.append($("<td></td>").text(shopDetail.parkInfo));
        $("#accordion-text").append(row);
       row =$("<tr></tr>");
       row.append($("<td style='width:200px;'></td>").text(" 가게 규정 :"));
       row.append($("<td></td>").text(shopDetail.shopRule));
        $("#accordion-text").append(row);
       row =$("<tr></tr>");
       row.append($("<td style='width:200px;'></td>").text(" 예약시 주의사항 :"));
       row.append($("<td></td>").text(shopDetail.reserverInfo));
        $("#accordion-text").append(row);
       
       $("#reserveTime").empty();
       let times = Number(reserveSet.endTime)-Number(reserveSet.startTime);
       console.log(times);
       console.log(Number(reserveSet.endTime));
       let timeMap =new Map();
       timeMap.set(900, "AM 09:00");
       timeMap.set(930, "AM 09:30");
       timeMap.set(960, "AM 10:00");
       timeMap.set(990, "AM 10:30");
       timeMap.set(1020, "AM 11:00");
       timeMap.set(1050, "AM 11:30");
       timeMap.set(1080, "PM 12:00");
       timeMap.set(1110, "PM 12:30");
       timeMap.set(1140, "PM 01:00");
       timeMap.set(1170, "PM 01:30");
       timeMap.set(1200, "PM 02:00");
       timeMap.set(1230, "PM 02:30");
       timeMap.set(1260, "PM 03:00");
       timeMap.set(1290, "PM 03:30");
       timeMap.set(1320, "PM 04:00");
       timeMap.set(1350, "PM 04:30");
       timeMap.set(1380, "PM 05:00");
       timeMap.set(1410, "PM 05:30");
       timeMap.set(1440, "PM 06:00");
       timeMap.set(1470, "PM 06:30");
       timeMap.set(1500, "PM 07:00");
       timeMap.set(1530, "PM 07:30");
       timeMap.set(1560, "PM 08:00");
       timeMap.set(1590, "PM 08:30");
       timeMap.set(1620, "PM 09:00");
       timeMap.set(1650, "PM 09:30");
       timeMap.set(1680, "PM 10:00");
       timeMap.set(1710, "PM 10:30");
       timeMap.set(1740, "PM 11:00");
       timeMap.set(1770, "PM 11:30");
       timeMap.set(1800, "PM 12:00");    
       times = times/50;
       console.log(times);
       let startTime = ((Number(reserveSet.startTime)-900)/5)*3+900; 
       console.log("startTime :"+startTime);
       for(let i =0;i<=times;i++){
       
       $("#reserveTime").append($("<option value='"+timeMap.get(startTime+30*i)+"'></option>").text(timeMap.get(startTime+30*i)));
       }
             
                  
        
   }
 
  
   function submitReserve() {
      const shopNo= shop.shopNo;
      let peopleNum = $('#peopleNum').val();
      let reservationDate = $('#reservationDate').val();
      let reserveTime = $('#reserveTime').val();
      let userComment = $('#userComment').val();
      let tel =$('#userTel').val();
      
      $.ajax({
          type: "POST",
          url: "/TWOREE/shop/shop.do", 
          async: false,
          data: {
        	    peopleNum: peopleNum,
        	    reservationDate: reservationDate,
        	    reserveTime: reserveTime,
        	    userComment: userComment,
                work_div:'makeReserve',
                tel :tel,
                shopNo: shopNo
          }
          ,
          success: function(data) {
                   console.log("success");
                    alert("예약 신청을 완료했습니다.");
                    window.close();
          },
          error: function(data) {
                   alert("예약 신청을 실패하였습니다.");
                  console.log("error"+error);
                  window.close();
                 
          }
      });
      
  }
</script>
</body>
</html>