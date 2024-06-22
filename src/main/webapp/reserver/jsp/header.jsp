<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html lang="ko">
<script>
const logOutBtn = document.querySelector("#logOut");
logOutBtn.addEventListener("click", function(event){
	console.log('logOut click event'+event);
	logOut();
});

function logOut(){
	console.log('logOut');
	window.location.replace("/TWOREE/login/login.do?work_div=logout");
}


</script>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/TWOREE/myPage/css/bootstrap.min.css"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        header {
            background-color: #333;
            color: white;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        header h1 {
            margin: 0;
            flex: 1;
            text-align: center;
            font-size: 1.5rem;
        }
        .login-btn {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <header>
        <h1>TWOREE</h1>
        <button class="btn btn-success" id="logOut">로그아웃</button>
    </header>
</body>
</html>
