package com.pcwk.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.pcwk.ask.AskDTO;
import com.pcwk.ask.AskService;
import com.pcwk.ehr.cmn.ControllerV;
import com.pcwk.ehr.cmn.JView;
import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;
import com.pcwk.ehr.cmn.StringUtill;
import com.pcwk.menu.MenuDTO;
import com.pcwk.menu.MenuService;
import com.pcwk.offday.OffDayDTO;
import com.pcwk.offday.OffDayService;
import com.pcwk.reserve.ReserveDTO;
import com.pcwk.reserve.ReserveService;
import com.pcwk.review.ReviewDTO;
import com.pcwk.review.ReviewService;
import com.pcwk.shop.ShopNoticeService;

public class ShopController extends HttpServlet implements ControllerV, PLog{
private static final long serialVersionUID = 1L;
	
	ShopService shopService;
	ShopDetailService shopDetailService;
    ReserveService reserveService;
    MenuService menuService;
    AskService askService;
    ReviewService reviewService;
    ShopNoticeService shopNoticeService;
    ShopReserveSetService shopReserveSetService;
    OffDayService offDayService; 
    public ShopController() {
    	log.debug("=====================");
		log.debug("ShopController()");
		log.debug("=====================");
		
		shopService = new ShopService();
		shopDetailService= new ShopDetailService();
		reserveService = new ReserveService();
		menuService = new MenuService();
		askService = new AskService();
		reviewService = new ReviewService();
		shopNoticeService= new ShopNoticeService();
		shopReserveSetService=new ShopReserveSetService();
		offDayService = new OffDayService();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.debug("=====================");
		log.debug("doGet()");
		log.debug("=====================");
		doWork(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.debug("=====================");
		log.debug("doPost()");
		log.debug("=====================");
		doWork(req, res);
	}
	
	public JView moveToReg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.debug("=====================");
		log.debug("moveToReg()");
		log.debug("=====================");

		return new JView("/board/board_reg.jsp");
	}
	
//	public JView doSave(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//		log.debug("=====================");
//		log.debug("doSave()");
//		log.debug("=====================");
//		ShopDTO inVO = new ShopDTO();
//		
//		String shopNo = StringUtill.nvl(req.getParameter("shop_no"), "");
//		String managerId = StringUtill.nvl(req.getParameter("manager_id"), "");
//		String shopName = StringUtill.nvl(req.getParameter("shop_name"), "");
//		String isVerified = StringUtill.nvl(req.getParameter("is_verified"), "");
//		
//		log.debug("title : {}", shopNo);
//		log.debug("regId : {}", managerId);
//		log.debug("contents : {}", shopName);
//		log.debug("isVerified : {}", isVerified);
//		
//		inVO.setShopNo(Integer.parseInt(shopNo));
//		inVO.setManagerId(managerId);
//		inVO.setShopName(shopName);
//		inVO.setIsVerified(isVerified);
//		
//		int flag = this.service.doSave(inVO);
//		log.debug("flag : {}", flag);
//		
//		if(1 == flag) {
//			return new JView("/board/board.do?work_div=doRetrieve");
//		}
//		
//		return null;
//	}
//	public JView ajaxDoSave(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//		log.debug("=====================");
//		log.debug("ajaxDoSave()");
//		log.debug("=====================");
//		ShopDTO inVO = new ShopDTO();
//		
//		String title = StringUtill.nvl(req.getParameter("title"), "");
//		String regId = StringUtill.nvl(req.getParameter("regId"), "");
//		String contents = StringUtill.nvl(req.getParameter("contents"), "");
//		
//		log.debug("title : {}", title);
//		log.debug("regId : {}", regId);
//		log.debug("contents : {}", contents);
//		
//		inVO.setTitle(title);
//		inVO.setContents(contents);
//		inVO.setRegId(regId);
//		inVO.setModId(regId);
//		
//		System.out.println("dsmakm");
//		int flag = this.service.doSave(inVO);
//		log.debug("flag : {}", flag);
//		
//		String message = "";
//		if(flag == 1) {
//			message = "등록성공";
//		}else {
//			message = "등록실패";
//		}
//		MessageVO messageVO = new MessageVO();
//		messageVO.setMessageId(String.valueOf(flag));
//		messageVO.setMsgContents(message);
//		
//		log.debug("messageVO : {}", messageVO);
//		
//		Gson gson = new Gson();
//		String jsonString = gson.toJson(messageVO);
//		
//		log.debug("jsonString : {}", jsonString);
//		
//		res.setContentType("text/html; charset=UTF-8");
//		
//		PrintWriter out = res.getWriter();
//		out.print(jsonString);
//		
//		
//		return null;
//	}
	public JView doSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doSelectOne()");
		log.debug("=====================");
		
		ShopDTO inVO = new ShopDTO();
		ShopDetailDTO detailInVO = new ShopDetailDTO();
		ShopNoticeDTO noticeInVO = new ShopNoticeDTO();
		MenuDTO menuInVO = new MenuDTO();
		ReviewDTO reviewInVO = new ReviewDTO();
		
		String shopNo = StringUtill.nvl(req.getParameter("shop_no"), "0");
		
		inVO.setShopNo(Integer.parseInt(shopNo));
		detailInVO.setShopNo(Integer.parseInt(shopNo));
		log.debug("inVO : "+ inVO);
		log.debug("detailInVO : "+ detailInVO);
		
		ShopDTO outVO = shopService.selectOneReadCnt(inVO);
		ShopDetailDTO detailOutVO = shopDetailService.doSelectOne(detailInVO);
		ShopNoticeDTO noticeOutVO = shopNoticeService.doSelectOne(noticeInVO);
		MenuDTO menuOutVO = menuService.doSelectOne(menuInVO);
		ReviewDTO reviewOutVO = reviewService.doSelectOne(reviewInVO);
		//ShopDetailDTO detailOutVo = ShopDetailService.doSelectOne(detailInVO); 
		log.debug("outVO : "+ outVO);
		log.debug("detailOutVO : "+ detailOutVO);
		log.debug("noticeOutVO : "+ noticeOutVO);
		log.debug("menuOutVO : "+ menuOutVO);
		log.debug("reviewOutVO : "+ reviewOutVO);
		
		//UI 데이터 전달
		req.setAttribute("outVO", outVO);
		req.setAttribute("detailOutVO", detailOutVO);
		req.setAttribute("noticeOutVO", noticeOutVO);
		req.setAttribute("menuOutVO", menuOutVO);
		req.setAttribute("reviewOutVO", reviewOutVO);
		
		return new JView("/shop/jsp/mainpage_mng.jsp");
		
	}
	
	public JView doSaveNotice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doSaveNotice()");
		log.debug("=====================");
		String title = StringUtill.nvl(req.getParameter("title"), "");
		String content = StringUtill.nvl(req.getParameter("content"), "");
		String fixed = StringUtill.nvl(req.getParameter("important"), "");
		String shopNo = StringUtill.nvl(req.getParameter("shop_no"), "0");
		ShopNoticeDTO inVO = new ShopNoticeDTO();
		inVO.setContent(content);
		inVO.setNoticeTitle(title);
		inVO.setFixed(fixed);
		inVO.setShopNo(Integer.parseInt(shopNo));
		int flag =shopNoticeService.doSave(inVO);
		res.setStatus(200);
		return null;
				
	}
	public JView doSaveMenu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doSaveMenu()");
		log.debug("=====================");
		String menuName = StringUtill.nvl(req.getParameter("menuName"), "");
		String menuInfo = StringUtill.nvl(req.getParameter("menuDescription"), "");
		int price = Integer.parseInt(StringUtill.nvl(req.getParameter("menuPrice"), "0"));
		int shopNo =Integer.parseInt(StringUtill.nvl(req.getParameter("shop_no"), "0"));
		MenuDTO inVO = new MenuDTO();
		inVO.setMenuName(menuName);
		inVO.setMenuInfo(menuInfo);
		inVO.setPrice(price);
		inVO.setShopNo(shopNo);
		int flag = menuService.doSave(inVO);
		res.setStatus(200);
		return null;
	}
	
	public JView modMenu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("modMenu()");
		log.debug("=====================");
		int menuNo = Integer.parseInt(StringUtill.nvl(req.getParameter("menuNo"), "0"));
		MenuDTO inVO = new MenuDTO();
		inVO.setmenuNo(menuNo);
		MenuDTO outVO = menuService.doSelectOne(inVO);
		Gson gson=new Gson();
		String jsonString = gson.toJson(outVO);
		req.setAttribute("menuVO", jsonString);
		return new JView("/shop/jsp/ModMenu.jsp");
	}
	
	public JView doModifyMenu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doModifyMenu()");
		log.debug("=====================");
		String menuName = StringUtill.nvl(req.getParameter("menuName"), "");
		String menuInfo = StringUtill.nvl(req.getParameter("menuDescription"), "");
		int price = Integer.parseInt(StringUtill.nvl(req.getParameter("menuPrice"), "0"));
		int shopNo =Integer.parseInt(StringUtill.nvl(req.getParameter("shop_no"), "0"));
		int menuNo =Integer.parseInt(StringUtill.nvl(req.getParameter("menuNo"), "0"));
		MenuDTO inVO = new MenuDTO();
		inVO.setMenuName(menuName);
		inVO.setMenuInfo(menuInfo);
		inVO.setPrice(price);
		inVO.setShopNo(shopNo);
		inVO.setmenuNo(menuNo);
		int flag = menuService.doUpdate(inVO);
		res.setStatus(200);
		return null;
	}
	
	public JView delMenu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("delMenu()");
		log.debug("=====================");
		int menuNo = Integer.parseInt(StringUtill.nvl(req.getParameter("menuNo"), "0"));
		MenuDTO inVO = new MenuDTO();
		inVO.setmenuNo(menuNo);
		int flag = menuService.doDelete(inVO);
		return null;
	}
	
	public JView modReserve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("modReserve()");
		log.debug("=====================");
		int reserveNo =Integer.parseInt(StringUtill.nvl(req.getParameter("reserveNo"), "0"));
		ReserveDTO inVO = new ReserveDTO();
		inVO.setReserveNo(reserveNo);
		ReserveDTO outVO = reserveService.doSelectOne(inVO);
		Gson gson=new Gson();
		String jsonString = gson.toJson(outVO);
		req.setAttribute("reserveVO", jsonString);
		return new JView("/shop/jsp/ModReserve.jsp");
	
	}
	
	public JView  confirmReserve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("confirmReserve()");
		log.debug("=====================");
		int reserveNo =Integer.parseInt(StringUtill.nvl(req.getParameter("reserveNo"), "0"));
		ReserveDTO inVO = new ReserveDTO();
		inVO.setReserveNo(reserveNo);
		inVO.setReserveState("승인완료");
		int flag = reserveService.updateState(inVO);
		return null;
	}
	
	public JView  cancelReserve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("cancelReserve()");
		log.debug("=====================");
		int reserveNo =Integer.parseInt(StringUtill.nvl(req.getParameter("reserveNo"), "0"));
		ReserveDTO inVO = new ReserveDTO();
		inVO.setReserveNo(reserveNo);
		inVO.setReserveState("예약거절");
		int flag = reserveService.updateState(inVO);
		return null;
	}
	
	public JView regShop(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doSaveMenu()");
		log.debug("=====================");
		String shopName = StringUtill.nvl(req.getParameter("shopName"), "");
		String managerId = StringUtill.nvl(req.getParameter("userId"), "");
		ShopDTO inVO = new ShopDTO();
		inVO.setShopName(shopName);
		inVO.setManagerId(managerId);
		inVO.setIsVerified("N");
		int flag = shopService.doSave(inVO);
		res.setStatus(200);
		return null;
	}
	
	
	
	public JView modDetail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doSaveMenu()");
		log.debug("=====================");
		String ownerName = StringUtill.nvl(req.getParameter("ownerName"), "");
		String shopTel = StringUtill.nvl(req.getParameter("shopTel"), "");
		String openTime = StringUtill.nvl(req.getParameter("openTime"), "");
		String closeTime = StringUtill.nvl(req.getParameter("closeTime"), "");
		String address = StringUtill.nvl(req.getParameter("address"), "");
		String shopRule = StringUtill.nvl(req.getParameter("shopRule"), "");
		String parkInfo = StringUtill.nvl(req.getParameter("parkInfo"), "");
		String ReserveInfo = StringUtill.nvl(req.getParameter("ReserveInfo"), "");
		int shopNo = Integer.parseInt(StringUtill.nvl(req.getParameter("shop_no"), "0"));
		ShopDetailDTO inVO = new ShopDetailDTO();
		inVO.setShopNo(shopNo);
		inVO.setOwnerName(ownerName);
		inVO.setShopTel(shopTel);
		inVO.setOpenTime(openTime);
		inVO.setCloseTime(closeTime);
		inVO.setShopLoc(address);
		inVO.setShopRule(shopRule);
		inVO.setParkInfo(parkInfo);
		inVO.setReserverInfo(ReserveInfo);
		int flag = shopDetailService.doSaveOrModify(inVO);
		res.setStatus(200);
		return null;
				
	}
	
	public JView setReserve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("setReserve()");
		log.debug("=====================");
		int tableCap = Integer.parseInt(StringUtill.nvl(req.getParameter("tableCap"), "0"));
		int peopleCap = Integer.parseInt(StringUtill.nvl(req.getParameter("peopleCap"), "0"));
		String reserveOpenTime = StringUtill.nvl(req.getParameter("reserveOpenTime"), "");
		String reserveCloseTime = StringUtill.nvl(req.getParameter("reserveCloseTime"), "");
		int shopNo = Integer.parseInt(StringUtill.nvl(req.getParameter("shop_no"), "0"));
		String offDays =req.getParameter("offDays");
		
		
		
		ShopReserveSetDTO inVO = new ShopReserveSetDTO();
		inVO.setTableCap(tableCap);
		inVO.setPeopleCap(peopleCap);
		inVO.setStartTime(reserveOpenTime);
		inVO.setEndTime(reserveCloseTime);
		inVO.setShopNo(shopNo);
		int flag = shopReserveSetService.doSaveOrModify(inVO);
		
		
		OffDayDTO offDayInVO = new OffDayDTO();
		offDayInVO.setShopNo(shopNo);
		offDays=offDays.substring(1, offDays.length()-1);
		
		
		String []offDay =offDays.split(",");
		for(String str : offDay) {
			str=str.substring(1,str.length()-1);
			offDayInVO.setClosedDay(str);
			offDayService.doSave(offDayInVO);
		}
		res.setStatus(200);
		return null;
	}
	
	public JView doMngPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doMngPage()");
		log.debug("=====================");
		ShopDTO shopinVO =new ShopDTO();
		ShopDetailDTO shopDetailinVO = new ShopDetailDTO();
		
		
		
		int shopNo = Integer.parseInt(StringUtill.nvl(req.getParameter("shop_no"), "0"));
	
		shopinVO.setShopNo(shopNo);
		shopDetailinVO.setShopNo(shopNo);
        
		String logInUser = "admin";
		SearchDTO searchShop = new SearchDTO();
		searchShop.setPageNo(1);
		searchShop.setPageSize(10);
		searchShop.setSearchDiv("40");
		searchShop.setSearchWord(logInUser);
		//searchWord session통해 바꾸어줘야함

		
		
		SearchDTO searchReserve = new SearchDTO();
		searchReserve.setPageNo(1);
		searchReserve.setPageSize(30);
		searchReserve.setSearchDiv("20");
		searchReserve.setSearchSeq(shopNo);
		
		
		
		SearchDTO searchMenu = new SearchDTO();
		searchMenu.setPageNo(1);
		searchMenu.setPageSize(30);
		searchMenu.setSearchSeq(shopNo);
		
		
		
		SearchDTO searchAsk = new SearchDTO();
		searchAsk.setPageNo(1);
		searchAsk.setPageSize(30);
		searchAsk.setSearchDiv("20");
		searchAsk.setSearchSeq(shopNo);
		
		
		
		SearchDTO searchReview = new SearchDTO();
		searchReview.setPageNo(1);
		searchReview.setPageSize(30);
		searchReview.setSearchDiv("20");
		searchReview.setSearchSeq(shopNo);
		
		
		log.debug("shopinVO : "+ shopinVO);
		log.debug("searchShop : "+ searchShop);
		log.debug("shopDetailinVO : "+ shopDetailinVO);
		log.debug("searchReserve : "+ searchReserve);
		log.debug("searchMenu : "+ searchMenu);
		log.debug("searchAsk : "+ searchAsk);
		log.debug("searchReview : "+ searchReview);
		
		
		
		ShopDTO outShopVO = shopService.doSelectOne(shopinVO);
		ShopDetailDTO outShopDetailVO = shopDetailService.doSelectOne(shopDetailinVO);
		List<ReserveDTO> outReserveVOList = reserveService.doRetrieve(searchReserve);
		List<MenuDTO> outMenuVOList = menuService.doRetrieve(searchMenu);
		List<AskDTO> outAskVOList = askService.doRetrieve(searchAsk);
		List<ReviewDTO> outReviewVOList = reviewService.doRetrieve(searchReview);
		List<ShopDTO> shopList = shopService.doRetrieve(searchShop);


		log.debug("outShopVO : "+ outShopVO);
		log.debug("shopList : "+ shopList);
		log.debug("outShopDetailVO : "+ outShopDetailVO);
		log.debug("outReserveVOList : "+outReserveVOList);
		log.debug("outMenuVOList : "+outMenuVOList);
		log.debug("outAskVOList : "+outAskVOList);
		log.debug("outReviewVOList : "+outReviewVOList);
		
		
		Gson gson=new Gson();
		String jsonString = gson.toJson(shopList);
        req.setAttribute("shopList", jsonString);
		
		jsonString = gson.toJson(outShopVO);
        req.setAttribute("shopVO", jsonString);
        
        
        jsonString = gson.toJson(outShopDetailVO);
        req.setAttribute("shopDetailVO", jsonString);
        
        
        jsonString = gson.toJson(outReserveVOList);
        req.setAttribute("outReserveVOList", jsonString);
        
        jsonString = gson.toJson(outMenuVOList);
        req.setAttribute("outMenuVOList", jsonString);
        
        jsonString = gson.toJson(outAskVOList);
        req.setAttribute("outAskVOList", jsonString);
        
        jsonString = gson.toJson(outReviewVOList);
        req.setAttribute("outReviewVOList", jsonString);
        
		return new JView("/shop/jsp/Shop_mng_admin.jsp");
	}
	
	
	public JView doWork(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doWork()");
		log.debug("=====================");
		
		JView viewName = null;
		
		//request ���ڵ� ó�� :
		req.setCharacterEncoding("UTF-8");
		
		String workDiv = StringUtill.nvl(req.getParameter("work_div"),"");
		log.debug("workDiv : {}", workDiv);
		
		switch(workDiv) {
		case "doSelectOne" :
			viewName = doSelectOne(req, res);
			break;
		case "doSaveNotice" :
			viewName = doSaveNotice(req,res);
			break;
		case "reg_Menu" :
			viewName = doSaveMenu(req,res);
			break;
		case "ModDetail" :
			viewName = modDetail(req,res);
			break;
		case "ModMenu" :
			viewName = modMenu(req,res);
			break;
		case "delMenu" :
			viewName = delMenu(req,res);
			break;
		case "doModifyMenu" :
			viewName = doModifyMenu(req,res);
			break;
		case "ModReserve" :
			viewName = modReserve(req,res);
			break;
		case "confirmReserve" :
			viewName = confirmReserve(req,res);
			break;
		case "cancelReserve" :
			viewName = cancelReserve(req,res);
			break;
		case "setReserve" :
			viewName = setReserve(req,res);
			break;
		case "reg_Shop" :
		    viewName = regShop(req,res);
		    break;
		case "shop_mng" :
			viewName = doMngPage(req,res);
			break;
		case "moveToReg" :
			viewName = moveToReg(req, res);
			break;
		case "doRetrieve" :
			viewName = doRetrieve(req, res);
			break;
		default :
			log.debug("workDiv : {}", workDiv);
			break;
		}
		
		return viewName;
	}
	
	public JView doRetrieve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doRetrieve()");
		log.debug("=====================");
		HttpSession session = req.getSession();
		
		JView viewName = null;
		
		SearchDTO inVO= new SearchDTO();
		//page_no
		//page_size
		String pageNo = StringUtill.nvl(req.getParameter("page_no"),"1");
		String pageSize = StringUtill.nvl(req.getParameter("page_size"),"10");
		String searchWord = StringUtill.nvl(req.getParameter("search_word"),"");
		String searchDiv = StringUtill.nvl(req.getParameter("search_div"),"");
		
		log.debug("pageNO : {}", pageNo);
		log.debug("pageSize : {}", pageSize);
		log.debug("searchWord : {}", searchWord);
		log.debug("searchDiv : {}", searchDiv);
		
		inVO.setPageNo(Integer.parseInt(pageNo));
		inVO.setPageSize(Integer.parseInt(pageSize));
		inVO.setSearchWord(searchWord);
		inVO.setSearchDiv(searchDiv);
		log.debug("inVO : {}", inVO);     
		
		//service call
		List<ShopDTO> list = shopService.doRetrieve(inVO);
		
		int i =0;
		
		for(ShopDTO vo : list) {
			log.debug("i : {}, vo : {} :", ++i, vo);
		}
		
		
		req.setAttribute("list", list);
		
		req.setAttribute("vo", inVO);
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/J02/board_list.jsp");
		//dispatcher.forward(req, res);
		
		return viewName = new JView("/shop/jsp/mainpage.jsp");
	}
}
