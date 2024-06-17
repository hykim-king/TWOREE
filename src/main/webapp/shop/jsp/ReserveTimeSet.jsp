<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 예약 정보 입력</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
  <h1>가게 예약 정보 입력</h1>
  <form>
    <div class="form-group row">
      <label for="store-name" class="col-sm-3 col-form-label">예약 가능 테이블 수:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="store-name" placeholder="예약 가능 테이블 수">
      </div>
    </div>
    <div class="form-group row">
      <label for="owner-name" class="col-sm-3 col-form-label">예약 가능 인원 수:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="owner-name" placeholder="예약 가능 인원 수">
      </div>
    </div>
    <div class="form-group row">
      <label for="phone" class="col-sm-3 col-form-label">예약 시작 시간:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="phone" placeholder="예약 시작 시간">
      </div>
    </div>
    <div class="form-group row">
      <label for="address" class="col-sm-3 col-form-label">예약 종료 시간:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="address" placeholder="예약 종료 시간">
      </div>
    </div>
    <div class="form-group row">
      <label for="date" class="col-sm-3 col-form-label">휴무일:</label>
      <div class="col-sm-9">
        <div class="input-group">
          <input type="date" class="form-control" id="date" placeholder="예약 가능 날짜">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button" onclick="addDate()">추가</button>
          </div>
        </div>
        <div id="date-list"></div>
      </div>
    </div>
    <div class="form-group row">
      <div class="col-sm-12 text-right">
        <button class="btn btn-primary" id ="registerButton">저장</button>
      </div>
    </div>
  </form>
</div>

<script>
  var dateList = [];

  function addDate() {
    var dateInput = document.getElementById("date");
    var dateValue = dateInput.value;
    if (dateValue) {
      dateList.push(dateValue);
      var dateListDiv = document.getElementById("date-list");
      var dateSpan = document.createElement("span");
      dateSpan.textContent = dateValue + " ";
      dateListDiv.appendChild(dateSpan);
      dateInput.value = "";
    }
  }
  
  $('#registerButton').click(function() {
      // 입력된 데이터 가져오기
      let data = {
          name: $('#nameInput').val(),
          email: $('#emailInput').val()
          // 기타 필요한 데이터 추가
      };

      // Ajax 요청 보내기
      $.ajax({
          type: 'POST',
          url: '/register', // 서버 측 등록 API 엔드포인트
          data: JSON.stringify(data), // 데이터를 JSON 형식으로 변환
          contentType: 'application/json; charset=utf-8', // 컨텐츠 타입 설정
          dataType: 'json', // 서버 응답 데이터 타입 설정
          success: function(response) {
              // 등록 성공 시 처리 로직
              console.log('등록 성공:', response);
          },
          error: function(xhr, status, error) {
              // 등록 실패 시 처리 로직
              console.error('등록 실패:', error);
          }
      });
  });
</script>
</body>
</html>