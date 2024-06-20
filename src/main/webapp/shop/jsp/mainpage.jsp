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
	String list = (String)request.getAttribute("shopList");  
	SearchDTO searchCon = (SearchDTO)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/TWOREE/shop/css/bootstrap.css">
    <title>test</title>
    <link rel="stylesheet" href="/TWOREE/shop/css/poster.css">
    <script src="/TWOREE/shop/js/jquery_3_7_1.js"></script>
<script>

document.addEventListener("DOMContentLoaded", function(){
	console.log("DOMContentLoaded--");
	
	const pageListBtn = document.querySelector("#page_list");
	console.log("pageListBtn : " + pageListBtn);
	
	pageListBtn.addEventListener("click", function(event){
		console.log("pageListBtn click event" + event)
	});
	
}); //"DOMContentLoaded"

	const pageList = document.querySelector("#page_list");

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
	
</script>
</head>
<body>
    <hr>
    <div class="container">
        <form action="/TWOREE/shop/shop.do" name="board_frm" method="get" id="board_frm"  class="row g-2 align-items-center">
            <div class="col-sm-4">
            <input type="hidden" name="work_div"  id="work_div" placeholder="작업구분">
            <input type="hidden" name="page_no"   id="page_no"  placeholder="페이지 번호">        
            <input type="hidden" name="seq"       id="seq"      placeholder="순번">
            </div>
            <div class="row mb-2">
                <label for="search_div" class="col-sm-2 col-form-label">구분</label>
                <div class="col-sm-1">
                    <div>
                        <select name="search_div" class="form-control" id="search_div">
                            <option value="">전체</option>
                            <option value="10">가게명</option>
                            <option value="20">별점순</option>
                            <option value="30">리뷰순</option>
                        </select>    
                    </div>
                </div>
                <div class="col-sm-4">
                    <input type="search" name="search_word" class="form-control"  id="search_word" placeholder="가게명을 입력하세요  " >
                </div>
            </div>
        </form>
        <hr>
	<jsp:include page="/shop/jsp/MyPage.jsp" flush="false"/>
        <div class="main_page" id ="page_list">
           <!-- position for ul  -->
        </div>
    <jsp:include page="/shop/jsp/ShopDetailPage.jsp" flush="false"/>
    </div>
    <script>
    
    
    $(document).ready(function() {
    	
    	$("#pageListBtn").click(function() {
           
        });
    });
    
   
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
   
	    
    </script>
<script src="/TWOREE/shop/js/popper_min.js"></script>
</body>
</html>