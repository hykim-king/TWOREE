package com.pcwk.shop;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.pcwk.ehr.cmn.ControllerV;
import com.pcwk.ehr.cmn.PLog;

import com.pcwk.shop.ShopDTO;
import com.pcwk.shop.ShopService;
import com.pcwk.ehr.cmn.JView;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.SearchDTO;
import com.pcwk.ehr.cmn.StringUtill;
import com.pcwk.menu.MenuDTO;
import com.pcwk.menu.MenuService;
import com.pcwk.reserve.ReserveDTO;
import com.pcwk.reserve.ReserveService;

public class ShopController extends HttpServlet implements ControllerV, PLog{
private static final long serialVersionUID = 1L;
	
	ShopService shopService;
	ShopDetailService shopDetailService;
    ReserveService reserveService;
    MenuService menuService;
    public ShopController() {
    	log.debug("=====================");
		log.debug("ShopController()");
		log.debug("=====================");
		
		shopService = new ShopService();
		shopDetailService= new ShopDetailService();
		reserveService = new ReserveService();
		menuService = new MenuService();
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
		
		String shopNo = StringUtill.nvl(req.getParameter("shop_no"), "0");
		
		inVO.setShopNo(Integer.parseInt(shopNo));
		log.debug("inVO : "+ inVO);
		
		ShopDTO outVO = shopService.selectOneReadCnt(inVO);
		log.debug("outVO : "+ outVO);
		
		//UI 데이터 전달
		req.setAttribute("outVO", outVO);
		
		return new JView("/shop/jsp/mainpage_mng.jsp");
		
	}
	
	public JView doMngPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.debug("=====================");
		log.debug("doMngPage()");
		log.debug("=====================");
		ShopDTO shopinVO =new ShopDTO();
		ShopDetailDTO shopDetailinVO = new ShopDetailDTO();
		ReserveDTO reserveVO = new ReserveDTO(); 
		MenuDTO menuInVO = new MenuDTO();
		
		int shopNo = Integer.parseInt(StringUtill.nvl(req.getParameter("shop_no"), "0"));
	
		shopinVO.setShopNo(shopNo);
		shopDetailinVO.setShopNo(shopNo);
		reserveVO.setShopNo(shopNo);
		
		
		SearchDTO searchReserve = new SearchDTO();
		searchReserve.setPageNo(1);
		searchReserve.setPageSize(30);
		searchReserve.setSearchDiv("20");
		searchReserve.setSearchSeq(shopNo);
		
		SearchDTO searchMenu = new SearchDTO();
		searchMenu.setPageNo(1);
		searchMenu.setPageSize(30);
		searchMenu.setSearchSeq(shopNo);
		
		
		log.debug("shopinVO : "+ shopinVO);
		log.debug("shopDetailinVO : "+ shopDetailinVO);
		log.debug("reserveVO : "+ reserveVO);
		log.debug("searchMenu : "+ searchMenu);
		
		
		ShopDTO outShopVO = shopService.doSelectOne(shopinVO);
		ShopDetailDTO outShopDetailVO = shopDetailService.doSelectOne(shopDetailinVO);
		List<ReserveDTO> outReserveVOList = reserveService.doRetrieve(searchReserve);
		List<MenuDTO> outMenuVOList = menuService.doRetrieve(searchMenu);
		
		
		//ShopDetailDTO outShopDetailVO =;
		log.debug("outShopVO : "+ outShopVO);
		log.debug("outShopDetailVO : "+ outShopDetailVO);
		log.debug("outReserveVOList : "+outReserveVOList);
		log.debug("outMenuVOList : "+outMenuVOList);
		
		
		Gson gson=new Gson();
		String jsonString = gson.toJson(outShopVO);
        req.setAttribute("shopVO", jsonString);
        
        
        jsonString = gson.toJson(outShopDetailVO);
        req.setAttribute("shopDetailVO", jsonString);
        
        
        jsonString = gson.toJson(outReserveVOList);
        req.setAttribute("outReserveVOList", jsonString);
        
        jsonString = gson.toJson(outMenuVOList);
        req.setAttribute("outMenuVOList", jsonString);
        
        
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
//		case "ajaxDoSave" :
//			viewName = ajaxDoSave(req, res);
//			break;
//		case "doSave" :
//			viewName = doSave(req, res);
//			break;
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
		
		//return ������ Ȯ��
		int i =0;
		for(ShopDTO vo : list) {
			log.debug("i : {}, vo : {} :", ++i, vo);
		}
		
		//UI ������ ����
		req.setAttribute("list", list);
		
		//�˻� ���� UI�� ����
		req.setAttribute("vo", inVO);
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/J02/board_list.jsp");
		//dispatcher.forward(req, res);
		
		return viewName = new JView("/shop/jsp/mainpage.jsp");
	}
}
