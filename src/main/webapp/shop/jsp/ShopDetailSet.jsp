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
                <label for="storeName" class="col-sm-3 col-form-label">가게 이름:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="storeName" placeholder="가게 이름을 입력하세요.">
                </div>
            </div>
            <div class="form-group row">
                <label for="ownerName" class="col-sm-3 col-form-label">예약 가능 날짜:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="ownerName" placeholder="예약 가능 날짜를 입력하세요.">
                </div>
            </div>
            <div class="form-group row">
                <label for="address" class="col-sm-3 col-form-label">예약 가능 인원 수:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="address" placeholder="예약 가능 인원 수를 입력하세요.">
                </div>
            </div>
            <div class="form-group row">
                <label for="phoneNumber" class="col-sm-3 col-form-label">예약 마감 시간:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="phoneNumber" placeholder="예약 마감 시간을 입력하세요.">
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-sm-3 col-form-label">가게 설명:</label>
                <div class="col-sm-9">
                    <textarea class="form-control" id="description" rows="3" placeholder="가게 설명을 입력하세요."></textarea>
                </div>
            </div>
            <div class="text-center">
                <button type="button" class="btn btn-primary" onclick="saveStoreInfo()">저장</button>
            </div>
        </form>
    </div>

    <script>
        function saveStoreInfo() {
            var storeInfo = {
                storeName: $('#storeName').val(),
                ownerName: $('#ownerName').val(),
                address: $('#address').val(),
                phoneNumber: $('#phoneNumber').val(),
                description: $('#description').val()
            };

            $.ajax({
                type: "POST",
                url: "/saveStoreInfo",
                data: JSON.stringify(storeInfo),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(data) {
                    alert("가게 정보가 저장되었습니다.");
                },
                error: function(xhr, status, error) {
                    alert("가게 정보 저장에 실패했습니다.");
                }
            });
        }
    </script>
</body>
</html>