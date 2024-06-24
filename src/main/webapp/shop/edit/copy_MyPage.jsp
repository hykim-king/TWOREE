<%@page import="com.pcwk.user.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.pcwk.shop.ShopDTO"%>
<%@page import="com.pcwk.shop.ShopDetailDTO"%>
<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.shop.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>
<%
	String list = (String)request.getAttribute("mainPageList");
    UserDTO user= (UserDTO)session.getAttribute("user");
    String userInfo = (String)request.getAttribute("userInfo");
    String myPageList = (String)request.getAttribute("myPageList");  
	SearchDTO searchCon = (SearchDTO)request.getAttribute("vo");
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/TWOREE/shop/css/bootstrap.css">
    <title>test</title>
    <link rel="stylesheet" href="/TWOREE/shop/css/mainPage.css">
    <script src="/TWOREE/shop/js/jquery_3_7_1.js"></script>
<title>Insert title here</title>
<script>

$("#search_form").ready(function() {
	document.addEventListener('keydown', function(event) {
		if (event.keyCode === 13) {
		event.preventDefault();
		
		let frm = document.getElementById("search_form");
		
		// 폼 데이터 설정
		frm.work_div.value = "doRetrieve";
		frm.page_size.value = "6";
		frm.search_div.value = $('#search_div').val();
		
		      		  
		console.log(" frm.work_div.value: " +  frm.work_div.value);
		console.log(" frm.search_word.value: " +  frm.search_word.value);
		console.log(" frm.search_div.value: " +  frm.search_div.value);
		
		frm.action = "<%=cPath%>" + "/shop/shop.do";
		
		// 폼 제출
		frm.submit();
		
		const pageListObj = (<%= list %>);
	   	
	    $("#page_list").empty();
	    $.each(pageListObj, function(index, page) {
	    	let row = $("<ul onclick ='pageListBtn("+page.shopNo+")'></ul>");
	          row.append($("<li class='shop_name'></li>").text(page.shopName));
	          row.append($("<li></li>").text(page.shopLoc));
	          row.append($("<li></li>").text(page.reviewCnt));
	          //row.append($("<li></li>").text(page.shopNo));
	          $("#page_list").append(row);
	      });
	  }
	}, true);
});
	

</script>
</head>
<body>	
	<jsp:include page="/reserver/jsp/header.jsp"></jsp:include>
	<div class="layout_top">
        <form action="/TWOREE/shop/shop.do" name="search_form" method="get" id="search_form">
            <div class="form_inside">
                <div>
                    <input type="hidden" name="work_div"  id="work_div" placeholder="작업구분">
                    <input type="hidden" name="page_size"   id="page_size"  placeholder="페이지 번호">        
                    <input type="hidden" name="seq"       id="seq"      placeholder="순번">
                </div>  
                <div>
                    <div>
                        <select name="search_div" class="search_div_btn" id="search_div">
                            <option value="">전체</option>
                            <option value="10">가게명</option>
                            <option value="20">별점순</option>
                            <option value="30">리뷰순</option>
                        </select>    
                    </div>
                </div>
                <div>
                    <input type="search" name="search_word" class="search_word"  id="search_word" placeholder="검색어를 입력하세요  " >
                </div>
            </div>    
		</form>
        <div id="user_info_page" class="user_info_page">
            <table id="main_page_table">
                <th class="middle_size_word">환영합니다!</th>
                <th class="big_size_word"><%=user.getName()%></th>
                <th><input type="button" class="main_btn" id="to_my_page" value="My page"></th>
            </table>
        </div>
    </div>
<script src="/TWOREE/shop/js/popper_min.js"></script>
    <script>
    
    const pageList = document.querySelector("#page_list");
    
    $(document).ready(function() {
		const reserveConfirmBtn = document.querySelector("#to_my_page");
		     	
		reserveConfirmBtn.addEventListener("click", function(event){
	     		console.log("to_my_page click event" + event)
	     		to_my_page();
	     	});
		
    	function to_my_page(){
    		console.log('to_my_page()');
    		window.location.replace("/TWOREE/user/myPage.do?work_div=doSelectOne");
    		//window.location.href = "/TWOREE/shop/shop.do?work_div=";
    	}
    });
    	
    
    </script>
</body>
</html>