package com.pcwk.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.pcwk.user.UserDTO;
import com.pcwk.user.UserService;



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
    UserService userService;
    
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
		userService= new UserService();
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
	
	public JView  modAsk(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("modAsk()");
		log.debug("=====================");
		int askNo =Integer.parseInt(StringUtill.nvl(req.getParameter("askNo"), "0"));
		AskDTO inVO = new AskDTO();
		inVO.setAskNo(askNo);
		AskDTO outVO = askService.doSelectOne(inVO);
		Gson gson=new Gson();
		String jsonString = gson.toJson(outVO);
		req.setAttribute("askVO", jsonString);
		return new JView("/shop/jsp/ModAsk.jsp");
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
	
	public JView saveAnswer(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doSaveMenu()");
		log.debug("=====================");
		int askNo =Integer.parseInt(StringUtill.nvl(req.getParameter("askNo"), "0"));
		String shopAnswer =StringUtill.nvl(req.getParameter("shopAnswer"), "");
		AskDTO inVO = new AskDTO();
		inVO.setShopAnswer(shopAnswer);
		inVO.setAskNo(askNo);
		inVO.setAskState("답변 완료");
		int flag =askService.doWrtAnswer(inVO);
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
	
	public JView makeReserve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("makeReserve()");
		log.debug("=====================");
		HttpSession session = req.getSession();
		ReserveDTO reserve =new ReserveDTO();
		UserDTO user = (UserDTO)session.getAttribute("user");
		int shopNo = Integer.parseInt(StringUtill.nvl(req.getParameter("shopNo"), "0"));
		int peopleNum = Integer.parseInt(StringUtill.nvl(req.getParameter("peopleNum"),""));
		String reservationDate =StringUtill.nvl(req.getParameter("reservationDate"),"");
		String tel = StringUtill.nvl(req.getParameter("tel"),"");
		String reserveTime = StringUtill.nvl(req.getParameter("reserveTime"),"");
		String userComment = StringUtill.nvl(req.getParameter("userComment"),"");
		
		reserve.setShopNo(shopNo);
		reserve.setUserId(user.getUserId());
		reserve.setReserveState("예약신청");
		reserve.setPeople(peopleNum);
		reserve.setReserveDate(reservationDate);
		reserve.setUserTel(tel);
		reserve.setReserveTime(reserveTime);
		reserve.setUserComment(userComment);
		reserveService.doSave(reserve);
		return null;
	}
	
	public JView doReserve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("Reserve()");
		log.debug("=====================");
		ShopDTO shopInVO = new ShopDTO();
		ShopDetailDTO shopDetailInVO = new ShopDetailDTO();
		ShopReserveSetDTO shopReserveSetInVO =new ShopReserveSetDTO();
		HttpSession session = req.getSession();
		
		
		int shopNo = Integer.parseInt(StringUtill.nvl(req.getParameter("shopNo"), "0"));
		shopInVO.setShopNo(shopNo);
		shopDetailInVO.setShopNo(shopNo);
		shopReserveSetInVO.setShopNo(shopNo);
		
		UserDTO user = (UserDTO)session.getAttribute("user");
		ShopDTO shopVO = shopService.doSelectOne(shopInVO);
		ShopDetailDTO shopDetailVO = shopDetailService.doSelectOne(shopDetailInVO);
		ShopReserveSetDTO reserveSetVO =shopReserveSetService.doSelectOne(shopReserveSetInVO);
		
		String userName =user.getName();
		String userTel=user.getTel();
		String userEmail =user.getUserEmail();
		
		Gson gson=new Gson();
		String jsonString = gson.toJson(shopVO);
		req.setAttribute("shopVO", jsonString);
		
		jsonString = gson.toJson(shopDetailVO);
		req.setAttribute("shopDetailVO", jsonString);
		
		jsonString = gson.toJson(reserveSetVO);
		req.setAttribute("reserveSetVO", jsonString);
		
		req.setAttribute("userName", userName);
		req.setAttribute("userTel", userTel);
		req.setAttribute("userEmail", userEmail);
		return new JView("/reserver/jsp/reserve.jsp");
	}
	
	public JView doMngPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doMngPage()");
		log.debug("=====================");
		ShopDTO shopinVO =new ShopDTO();
		ShopDetailDTO shopDetailinVO = new ShopDetailDTO();
		HttpSession session = req.getSession();
		UserDTO user = (UserDTO)session.getAttribute("user");
		
		
		int shopNo = userService.getMyShopNo(user);
	    
		shopinVO.setShopNo(shopNo);
		shopDetailinVO.setShopNo(shopNo);
		String logInUser = user.getUserId();
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
		case "ModAsk" :
			viewName =modAsk(req,res);
			break;
		case "saveAnswer" :
			viewName = saveAnswer(req,res);
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
		case "doSelectOne" :
			viewName = doSelectOne(req, res);
			break;
		case "reserve" :
			viewName = doReserve(req,res);
			break;
		case "makeReserve" :
			viewName = makeReserve(req,res);
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
		
		SearchDTO myPageListInVO= new SearchDTO();
		
		log.debug("pageNO : {}", pageNo);
		log.debug("pageSize : {}", pageSize);
		log.debug("searchWord : {}", searchWord);
		log.debug("searchDiv : {}", searchDiv);
		
		inVO.setPageNo(Integer.parseInt(pageNo));
		inVO.setPageSize(Integer.parseInt(pageSize));
		inVO.setSearchWord(searchWord);
		inVO.setSearchDiv(searchDiv);
		log.debug("inVO : {}", inVO);     
		
		myPageListInVO.setPageNo(Integer.parseInt(pageNo));
		myPageListInVO.setPageSize(40);
		myPageListInVO.setSearchWord("admin");
		myPageListInVO.setSearchDiv(searchDiv);
		log.debug("myPageListInVO : {}", myPageListInVO);     
		
		//service call
		List<ShopDTO> list = shopService.doRetrieve(inVO);
		List<ShopDTO> myPageList = shopService.doRetrieve(myPageListInVO);
		
		int i =0;
		
		for(ShopDTO vo : list) {
			log.debug("i : {}, vo : {} :", ++i, vo);
		}
		
		for(ShopDTO vo : myPageList) {
			log.debug("i : {}, vo : {} :", ++i, vo);
		}
		
		Gson gson=new Gson();
		String jsonString = gson.toJson(list);
        req.setAttribute("mainPageList", jsonString);
        
        jsonString = gson.toJson(list);
        req.setAttribute("myPageList", jsonString);
		
		//req.setAttribute("list", list);
		
		req.setAttribute("vo", inVO);
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/J02/board_list.jsp");
		//dispatcher.forward(req, res);
		
		return viewName = new JView("/shop/jsp/mainpage.jsp");
	}
	
	public JView doSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doSelectOne()");
		log.debug("=====================");
			
		ShopDTO shopInVO = new ShopDTO();
		ShopDetailDTO detailInVO = new ShopDetailDTO();
		
		String shopNo = StringUtill.nvl(req.getParameter("shopNo"), "0");
		
		ShopNoticeDTO noticeInVO = new ShopNoticeDTO();
		SearchDTO searchNotice= new SearchDTO();
		searchNotice.setSearchDiv("10");
		searchNotice.setSearchWord(shopNo);
		
		MenuDTO menuInVO = new MenuDTO();
		SearchDTO searchMenu= new SearchDTO();
		searchMenu.setPageNo(1);
		searchMenu.setPageSize(4);
		searchMenu.setSearchSeq(Integer.parseInt(shopNo));
		
		ReviewDTO reviewInVO = new ReviewDTO();
		SearchDTO searchReview= new SearchDTO();
		searchReview.setPageNo(1);
		searchReview.setPageSize(4);
		searchReview.setSearchDiv("20");
		searchReview.setSearchSeq(Integer.parseInt(shopNo));
		
		shopInVO.setShopNo(Integer.parseInt(shopNo));
		detailInVO.setShopNo(Integer.parseInt(shopNo));
		noticeInVO.setShopNo(Integer.parseInt(shopNo));
		menuInVO.setShopNo(Integer.parseInt(shopNo));
		reviewInVO.setShopNo(Integer.parseInt(shopNo));
		
		log.debug("shopInVO : "+ shopInVO);
		log.debug("detailInVO : "+ detailInVO);
		log.debug("noticeInVO : "+ noticeInVO);
		log.debug("menuInVO : "+ menuInVO);
		log.debug("reviewInVO : "+ reviewInVO);
		
		ShopDTO shopOutVO = shopService.selectOneReadCnt(shopInVO);
		ShopDetailDTO detailOutVO = shopDetailService.doSelectOne(detailInVO);
		List<ShopNoticeDTO> noticeOutVO = shopNoticeService.doRetrieve(searchNotice);
		List<MenuDTO> menuOutVO = menuService.doRetrieve(searchMenu);
		List<ReviewDTO> reviewOutVO = reviewService.doRetrieve(searchReview);
		
		int i =0;
		for(ShopNoticeDTO vo : noticeOutVO) {
			log.debug("i : {}, vo : {} :", ++i, vo);
		}
		for(MenuDTO vo : menuOutVO) {
			log.debug("i : {}, vo : {} :", ++i, vo);
		}
		for(ReviewDTO vo : reviewOutVO) {
			log.debug("i : {}, vo : {} :", ++i, vo);
		}
		
		//UI 데이터 전달
		res.setContentType("text/html; charset=UTF-8");
		Gson gson=new Gson();
		
		Map<String, Object> responseMap = new HashMap<>();
		
		responseMap.put("shopList", shopOutVO);
		responseMap.put("detailList", detailOutVO);
		responseMap.put("noticeList", noticeOutVO);
		responseMap.put("menuList", menuOutVO);
		responseMap.put("reviewList", reviewOutVO);
		
		String jsonResponse = gson.toJson(responseMap);
		PrintWriter out = res.getWriter();
		
		out.print(jsonResponse);
		
        return null;
		
	}

}
