<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/TWOREE/User/assets/css/bootstrap.css">
<script src="/TWOREE/User/assets/js/jquery_3_7_1.js"></script>
<script src="/TWOREE/User/assets/js/common.js"></script> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/TWOREE/assets/js/jquery_3_7_1.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/User/cmn/menu.jsp"></jsp:include>
    <h2>MAIN</h2>
    <hr/>
    session:${sessionScope.member}
    <jsp:include page="/User/cmn/footer.jsp"></jsp:include>

</div>
<script src="/TWOREE/assets/js/bootstrap.bundle.min.js"></script> 
</body>
</html>