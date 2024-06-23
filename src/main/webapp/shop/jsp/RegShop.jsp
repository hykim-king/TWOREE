<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>가게 등록</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/reserver/jsp/header.jsp"></jsp:include>
    <div class="container my-5" style ="padding:30px;">
        <h1 class="mb-4">가게 등록</h1>
        <form id="shopForm">
            <div class="form-group row">
                <label for="shopName" class="col-sm-2 col-form-label">가게 이름:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="shopName" placeholder="가게 이름을 입력하세요">
                </div>
            </div>
            <div class="form-group row">
                <label for="shopCode" class="col-sm-2 col-form-label">사업자 번호:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="shopCode" rows="3" placeholder="사업자 번호를 입력하세요"></textarea>
                </div>
            </div>
            <div class="form-group row">
                <label for="shopTel" class="col-sm-2 col-form-label">전화 번호:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="shopTel" placeholder="연락받으실 번호를 입력하세요">
                </div>
            </div>
            
            <div style ="border:solid black 2px; margin :50px; padding :20px;">
                <h3>안내사항</h3>
                <p>가게 등록을 위해서는 확인 과정이 필요합니다. 2~3영업일 내로 연락 드리겠습니다.</p>
            </div>
            
            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="button" class="btn btn-primary" onclick="registerShop()">등록</button>
                    <button type="reset" class="btn btn-secondary">취소</button>
                </div>
            </div>
            
            
        </form>
    </div>
<jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
    <script>
        function registerShop() {
        
              let shopName =$('#shopName').val();
              let shopTel =$('#shopTel').val();
              let shopCode =$('#shopCode').val();
              
             
            // 입력 필드 검사
              if (shopName.trim() === '') {
                  alert('가게 이름을 입력해주세요.');
                 return;
             }
              if (shopTel.trim() === '') {
                 alert('전화번호를 입력해주세요.');
                  return;
             }
              if (shopCode.trim() === '') {
                  alert('사업자 번호를 입력해주세요.');
                   return;
              }
        
        
            $.ajax({
                url: '/TWOREE/shop/shop.do',
                type: 'POST',
                data: {
                    shopName: shopName,
                    shopTel: shopTel,
                    shopCode: shopCode,
                    work_div: 'reg_Shop',
                    userId : "admin"
                    
                },
                success: function(response) {
                    alert('가게가 등록되었습니다.');
                    window.close();
                },
                error: function(xhr, status, error) {
                    alert('가게 등록 중 오류가 발생했습니다.');
                }
            });
        }
    </script>
</body>
</html>