<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>가게 정보 입력</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="container my-5">
        <h1 class="text-center mb-4">가게 정보 입력</h1>
        <form>
            <div class="form-group row">
                <label for="storeName" class="col-sm-3 col-form-label">가게 소유주 성함:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="ownerName" placeholder="사장님 성함을 입력하세요.">
                </div>
            </div>
            <div class="form-group row">
                <label for="ownerName" class="col-sm-3 col-form-label">가게 전화번호:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="shopTel" placeholder="가게 전화번호를 입력하세요.">
                </div>
            </div>
            <div class="form-group row">
                <label for="ownerName" class="col-sm-3 col-form-label">영업 시작시간:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="openTime" placeholder="영업 시작 시간을 입력하세요.(ex AM10:00=>1000)">
                </div>
            </div>
            <div class="form-group row">
                <label for="ownerName" class="col-sm-3 col-form-label">영업 종료시간:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="closeTime" placeholder="영업 종료 시간을 입력하세요.(ex PM10:00=>2200">
                </div>
            </div>
            
            <div class="form-group row">
                <label for="address" class="col-sm-3 col-form-label">가게 주소:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="address" placeholder="가게 주소를 입력하세요.">
                </div>
            </div>
            <div class="form-group row">
                <label for="phoneNumber" class="col-sm-3 col-form-label">가게 규정:</label>
                <div class="col-sm-9">
                    <textarea class="form-control" id="shopRule" rows="3"  placeholder="가게 규정을 입력하세요."></textarea>
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-sm-3 col-form-label">주차 정보:</label>
                <div class="col-sm-9">
                    <textarea class="form-control" id="parkInfo" rows="3" placeholder="주차 정보를 입력하세요."></textarea>
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-sm-3 col-form-label">예약시 전할 사항:</label>
                <div class="col-sm-9">
                    <textarea class="form-control" id="ReserveInfo" rows="3" placeholder="주차 정보를 입력하세요."></textarea>
                </div>
            </div>
            <div class="text-center">
                <button type="button" class="btn btn-primary" onclick="saveStoreInfo()">저장</button>
            </div>
        </form>
    </div>

    <script>
        let shopNo = window.opener.getShopNo().textContent;
        function saveStoreInfo() {
           let ownerName = $('#ownerName').val();
           let shopTel = $('#shopTel').val();
           let openTime = $('#openTime').val();
           let closeTime = $('#closeTime').val();
           let address = $('#address').val();
           let shopRule = $('#shopRule').val();
           let parkInfo = $('#parkInfo').val();
           let ReserveInfo = $('#ReserveInfo').val();

            // 입력 필드 검사
              if (ownerName.trim() === '') {
                  alert('가게 소유주 성함을 입력해주세요.');
                 return;
             }
              if (shopTel.trim() === '') {
                 alert('가게 전화번호를 입력해주세요.');
                  return;
             }
              if (openTime.trim() === '') {
                  alert('영업 시작시간을 입력해주세요.');
                   return;
              }
              if (closeTime.trim() === '') {
                 alert('영업 종료시간을 입력해주세요.');
                  return;
             }
              if (address.trim() === '') {
                  alert('가게 주소를 입력해주세요.');
                  return;
              }
           
            let storeInfo = {
                ownerName: $('#ownerName').val(),
                shopTel: $('#shopTel').val(),
                openTime: $('#openTime').val(),
                closeTime: $('#closeTime').val(),
                address: $('#address').val(),
                shopRule: $('#shopRule').val(),
                parkInfo: $('#parkInfo').val(),
                ReserveInfo: $('#ReserveInfo').val(),
                work_div :'ModDetail',
                shop_no :shopNo
            };

            $.ajax({
                type: "POST",
                url: "/TWOREE/shop/shop.do",
                data: JSON.stringify(storeInfo),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(data) {
                    alert("가게 정보가 저장되었습니다.");
                    window.close();
                },
                error: function(xhr, status, error) {
                    alert("가게 정보 저장에 실패했습니다.");
                }
            });
        }
    </script>
</body>
</html>