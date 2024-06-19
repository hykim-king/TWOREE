<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String menu =(String)request.getAttribute("menuVO");
   String menuSeq =(String)request.getAttribute("menuNo"); 
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메뉴 관리</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="container my-5">
        <h1 class="mb-4">메뉴 관리</h1>
        <form id="menuForm">
            <div class="form-group row">
                <label for="menuName" class="col-sm-2 col-form-label">메뉴 이름:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="menuName" placeholder="메뉴 이름을 입력하세요" >
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
                    <button type="button" class="btn btn-primary" onclick="modifyMenu()">수정</button>
                    <button type="button" class="btn btn-primary" onclick="deleteMenu()">삭제</button>
                    <button type="reset" class="btn btn-secondary">취소</button>
                </div>
            </div>
        </form>
    </div>

    <script>
        let menu =(<%=menu%>);
        document.getElementById("menuName").value=menu.menuName;
        document.getElementById("menuPrice").value=menu.price;
        $("#menuDescription").text(menu.menuInfo);
        console.log(menu.menuNo);
        
        
        
        
        
        
        
        function deleteMenu(){
            if(false==confirm('삭제 하시겠습니까?')){
               return;
            }
            
            $.ajax({
                url: '/TWOREE/shop/shop.do',
                type: 'POST',
                data: {
                    menuNo: menu.menuNo,
                    work_div: 'delMenu'
                },
                success: function(response) {
                    alert('메뉴가 삭제되었습니다.');
                    window.close();
                },
                error: function(xhr, status, error) {
                    alert('메뉴 삭제 중 오류가 발생했습니다.');
                }
            });
        
        }
        
        
        function modifyMenu() {
            if(false==confirm('수정 하시겠습니까?')){
               return;
            }
           
        let menuName = $('#menuName').val();
        let menuDescription = $('#menuDescription').val();
        let menuPrice = $('#menuPrice').val();
        let shopNo = window.opener.getShopNo().textContent; 
           
           $.ajax({
                url: '/TWOREE/shop/shop.do',
                type: 'POST',
                data: {
                    menuNo: menu.menuNo,
                    menuName: menuName,
                    menuDescription: menuDescription,
                    menuPrice: menuPrice,
                    work_div: 'doModifyMenu',
                    shop_no: shopNo
                },
                success: function(response) {
                    alert('메뉴가 수정되었습니다.');
                    window.close();
                },
                error: function(xhr, status, error) {
                    alert('메뉴 수정 중 오류가 발생했습니다.');
                }
            });
            }
       
    </script>
</body>
</html>