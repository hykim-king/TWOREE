<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/TWOREE/myPage/css/bootstrap.min.css">  
<title>예약현황</title>
<style>
    h5{
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
        flex:1;
    }
    .right-section {
        flex: 3;
        padding-left: 20px;
        border-left: 1px solid #ddd;
        overflow-y: auto;
    }
    .table-container {
        max-height: 400px; /* 원하는 최대 높이로 설정 */
        overflow-y: auto;
    }
</style>
</head>
<body>
    <div class="left-section">
        <h2>전체</h2> 
        <h2>리뷰내역</h2>
    </div>
    <div class="right-section">
        <!-- 버튼 --> 
        <div class="mb-2 d-grid gap-2 d-md-flex justify-content-md-end"> 
            <button type="reset" class="btn btn-dark" value="" >새로고침</button> 
            <button type="button" class="btn btn-secondary" value="" onClick="location.href='my_v.jsp'">뒤로가기</button>
        </div>
        <!--// 버튼 ----------------------------------------------------------------->
       <div class="table-container">
          <table class="table table-hover">
          <thead>
                    <tr class="table-dark table-hover table-bordered" id="option_reserver">
                 	<th>예약정보</th>	
                 	<th>개인정보</th>	
                 	<th>메뉴</th>	
                 	<th>옵션</th>
                 	</tr>
     	 </thead> 
    	 <tbody> 
					<tr><td>가게이름</td>	 <td>날짜</td>   <td>메뉴이름</td>    <td>★★★☆☆</td>
					<tr><td>리뷰번호</td>	 <td>인원수</td>	    <td>가격</td>	      <td>내용</td>
   			 </tbody>
			 <table>
        </div>
    </div>
</body>
</html>
