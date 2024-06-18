<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 작성</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container my-5">
        <h1 class="mb-4">가게 소식 등록</h1>
        <form id="noticeForm">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요" required>
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea class="form-control" id="content" name="content" rows="10" placeholder="내용을 입력하세요" required></textarea>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="important" name="important" value="Y">
                <label class="form-check-label" for="important">중요 공지 여부</label>
            </div>
            <div class="d-flex justify-content-end">
                <button type="submit" class="btn btn-primary mr-2">등록</button>
                <button type="button" class="btn btn-secondary" onclick="cancelForm()">취소</button>
            </div>
        </form>
    </div>

    <script>
        const shopNo= window.opener.getShopNo().textContent;
        const form = document.getElementById('noticeForm');
        console.log(shopNo);
        form.addEventListener('submit', function(event) {
            event.preventDefault(); // 폼 기본 동작 막기
            
            const title = document.getElementById('title').value;
            const content = document.getElementById('content').value;
            const important = document.getElementById('important').checked ? 'Y' : 'N';

            // AJAX 통신으로 데이터 전송
            const xhr = new XMLHttpRequest();
            xhr.open('POST', '/TWOREE/shop/shop.do', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
            xhr.onreadystatechange = function() {
                if ( xhr.status === 200) {
                    // 등록 완료 페이지로 이동
                    window.alert("공지사항을 등록하였습니다.");
                    window.close();
                } else {
                    // 에러 처리
                    alert('공지사항 등록에 실패했습니다.');
                }
            };
            xhr.send('title=' + encodeURIComponent(title) + '&content=' + encodeURIComponent(content) + '&important=' + important + '&work_div=doSaveNotice' +'&shop_no='+shopNo);
        });

        function cancelForm() {
            // 폼 초기화
            form.reset();
        }
    </script>
</body>
</html>