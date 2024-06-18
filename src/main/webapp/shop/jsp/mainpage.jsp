<%@page import="java.util.List"%>
<%@page import="com.pcwk.shop.ShopDTO"%>
<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.shop.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   List<ShopDTO> list = (List<ShopDTO>)request.getAttribute("list");   
   SearchDTO searchCon = (SearchDTO)request.getAttribute("vo");
   %>
   searchCon:<%=searchCon %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/TWOREE/shop/css/bootstrap.css">
    <title>test</title>
    <link rel="stylesheet" href="/TWOREE/shop/css/poster.css">
    <script src="/TWOREE/shop/js/jquery_3_7_1.js"></script>
</head>
<body>
    <hr>
    <div class="container">
        <form action="#" name="board_frm" method="get" id="board_frm"  class="row g-2 align-items-center">
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
        <jsp:include page="MyPage.jsp" flush="false"/>
        <div class="main_page">
           	 	<%for(ShopDTO vo   :list){ %>
            <ul>
                <li>가게명 : <%=vo.getShopName() %></li>
                <li>가게 주소 : <%=vo.getShopName() %> </li>
                <li>별점 : <%=vo.getShopName() %></li> 
            </ul>
                <%  } %>
        </div>
       <jsp:include page="ShopDetailPage.jsp" flush="false"/>
    </div>
<script src="/TWOREE/shop/js/popper_min.js"></script>
</body>
</html>