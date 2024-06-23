<%@page import="java.util.List"%>
<%@page import="com.pcwk.shop.ShopDTO"%>
<%@page import="com.pcwk.shop.ShopDetailDTO"%>
<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.shop.ShopDao"%>
<%@page import="com.pcwk.ehr.cmn.MessageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>
<%
	String list = (String)request.getAttribute("mainPageList");
	String searchData = (String)request.getAttribute("myPageList");
	SearchDTO searchCon = (SearchDTO)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/TWOREE/shop/css/bootstrap.css">
    <title>test</title>
    <link rel="stylesheet" href="/TWOREE/shop/css/mainPage.css">
    <script src="/TWOREE/shop/js/jquery_3_7_1.js"></script>
</head>
<body>
	<jsp:include page="/shop/edit/copy_MyPage.jsp" flush="false"/>
	<hr>
        <div class="div_for_four" id="page_list">
	        	<!-- ul page -->
	        
        </div>
    <jsp:include page="/shop/edit/copy_ShopDetailPage.jsp" flush="false"/>
    <script>

	
	function getShopNo(){
        return document.getElementById('shopNo');
      }
	
	const shopNo = getShopNo();
	
	function pageListBtn(shopNo){
		console.log("pageListBtn clicked");
		console.log("shopNo : " + shopNo);
		
		$.ajax({
		    type: "GET", 
		    url:"/TWOREE/shop/shop.do",
		    contentType : "application/json; charset:UTF-8",
		    asyn:"true",
		    dataType:"html",
		    data:{
		        "work_div":"doSelectOne",
		        "shopNo": shopNo
		    },
		    success:function(response){//통신 성공
		        console.log("success data:"+response);
		    	
		    	//null, undefined
		    	if(response){
	    		    	let jsonData = JSON.parse(response);
		    			let map = new Map(Object.entries(jsonData));
		    			console.log(map.get("shopList"));
	    		    	loadData(map);
		    		
		    	}else{
		    		console.warn("res가 null 혹은 undefined");
		    		alert(messageVO.msgContents);
		    	}
		    },
		    error:function(response){//실패시 처리
		            console.log("error:"+response);
		    }
		});//ajax end
		
	}
	
    
    $(document).ready(function() {
    	
    	$("#pageListBtn").click(function() {
           
        });
    	
    });
    

   	const pageListObj = (<%= list %>);

	    $("#page_list").empty();
	    $.each(pageListObj, function(index, page) {
	    	let row = $("<div class='main_page'></div>");
	        let ul = $("<ul id='main_page_ul' onclick='pageListBtn(" + page.shopNo + ")'></ul>");

	        ul.append($("<li class='big_size_word'></li>").text(page.shopName));
	        ul.append($("<li class='middle_size_word'></li>").text(page.shopLoc));
	        ul.append($("<li class='score'></li>").text("별점: " + page.reviewCnt));

	        row.append(ul);
	        $("#page_list").append(row);
	    });
   
    </script>
<script src="/TWOREE/shop/js/popper_min.js"></script>
</body>
</html>