<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메뉴 등록</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/reserver/jsp/header.jsp"></jsp:include>
    <div class="container my-5">
        <h1 class="mb-4">메뉴 등록</h1>
        <form id="menuForm">
            <div class="form-group row">
                <label for="menuName" class="col-sm-2 col-form-label">메뉴 이름:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="menuName" placeholder="메뉴 이름을 입력하세요">
                </div>
            </div>
            <div class="form-group row">
                <label for="menuDescription" class="col-sm-2 col-form-label">메뉴 설명:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="menuDescription" rows="3" placeholder="메뉴 설명을 입력하세요"></textarea>
                </div>
            </div>
            <div class="form-group row">
                <label for="menuPrice" class="col-sm-2 col-form-label">메뉴 가격:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="menuPrice" placeholder="메뉴 가격을 입력하세요">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="button" class="btn btn-primary" onclick="registerMenu()">등록</button>
                    <button type="reset" class="btn btn-secondary">취소</button>
                </div>
            </div>
        </form>
    </div>
<jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
    <script>
        function registerMenu() {
            let menuName = $('#menuName').val();
            let menuDescription = $('#menuDescription').val();
            let menuPrice = $('#menuPrice').val();
            let shopNo = window.opener.getShopNo().textContent;
            $.ajax({
                url: '/TWOREE/shop/shop.do',
                type: 'POST',
                data: {
                    menuName: menuName,
                    menuDescription: menuDescription,
                    menuPrice: menuPrice,
                    work_div: 'reg_Menu',
                    shop_no: shopNo
                },
                success: function(response) {
                    alert('메뉴가 등록되었습니다.');
                    window.close();
                },
                error: function(xhr, status, error) {
                    alert('메뉴 등록 중 오류가 발생했습니다.');
                }
            });
        }
    </script>
</body>
</html>