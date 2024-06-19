package com.pcwk.user;
import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcwk.ehr.cmn.SearchDTO;
import com.pcwk.ask.AskDTO;
import com.pcwk.ask.AskService;
import com.pcwk.ehr.cmn.ControllerV;
import com.pcwk.ehr.cmn.JView;
import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.StringUtill;
import com.pcwk.reserve.ReserveDTO;
import com.pcwk.reserve.ReserveService;
import com.pcwk.review.ReviewDTO;
import com.pcwk.review.ReviewService;
import com.pcwk.user.UserDTO;

public class UserController implements ControllerV, PLog {

	
	private static final long serialVersionUID = 1L;
    
	UserService  service;
	ReserveService reserveService;
	ReviewService reviewService;
	AskService askService;
	//CodeService codeService;
	
	
	public UserController() {
		log.debug("-------------------");
    	log.debug("LoginController()");
    	log.debug("-------------------");
    	service = new UserService();
    	reserveService = new ReserveService();
    	reviewService = new ReviewService();
    	askService = new AskService();
    	    	
	} 
	public JView doSelectOne(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
      	log.debug("-----------------");
    	log.debug("doSelectOne()");
    	log.debug("-----------------");		
    	
    	UserDTO inVO = new UserDTO(); 
    	String userId = StringUtill.nvl(request.getParameter("userId"),"0");
    	
    	inVO.setUserId(userId);
    	log.debug("inVO:"+inVO);
    	
    	//this.service.selectOneReadCnt(inVO);
    	
    	UserDTO outVO = this.service.doSelectOne(inVO);
    	log.debug("outVO:"+outVO); 
    	
    	
    	request.setAttribute("outVO",outVO);
    	
    	
    
    return new JView("/myPage/jsp/my_p.jsp");
    
    }
	public JView doRetrieveR(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      	log.debug("-----------------");
	    	log.debug("doRetrieveR()");
	    	log.debug("-----------------");		
	    	
	    	//HttpSession session = request.getSession();
	    	//ReserveDTO inVO = new ReserveDTO(); 
	    	SearchDTO searchVO = new SearchDTO();
	    	String pageNo = StringUtill.nvl(request.getParameter("page_no"),"1");
			String pageSize = StringUtill.nvl(request.getParameter("page_size"),"10");
	    	String searchDiv = StringUtill.nvl( request.getParameter("search_div"),"10");
	    	String searchWord = StringUtill.nvl(request.getParameter("search_word"),"");
	    	
	    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
	    	
	    	//inVO.setUserId(userId);
	    	searchVO.setPageNo(Integer.parseInt(pageNo));
	    	searchVO.setPageSize(Integer.parseInt(pageSize));
	    	searchVO.setSearchDiv(searchDiv);
	    	searchVO.setSearchWord(searchWord);
	    	log.debug("searchVO: {}"+searchVO); 
	    	
	    	//log.debug("userId:"+userId);
	    	log.debug("searchWord : {}", searchWord);
			log.debug("searchDiv : {}", searchDiv);
	    	 
	    	
	    	List<ReserveDTO> list = reserveService.doRetrieve(searchVO);
	    	
	    	int i=0;
	    	
			for(ReserveDTO vo :list) {
				log.debug("i: {}, vo: {}",++i,vo);
			}
			
			//UI 데이터 전달
			request.setAttribute("list", list);
			log.debug("list:{}",list);
			//검색조건 UI로 전달
			request.setAttribute("vo", searchVO);
			
			log.debug("searchVO:"+searchVO); 
			
			 return new JView("/myPage/jsp/my_r.jsp");	
		}
	public JView doRetrieveV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      	log.debug("-----------------");
	    	log.debug("doRetrieveV()");
	    	log.debug("-----------------");		
	    	
	    	//HttpSession session = request.getSession();
	    	//ReserveDTO inVO = new ReserveDTO(); 
	    	SearchDTO searchVO = new SearchDTO();
	    	String pageNo = StringUtill.nvl(request.getParameter("page_no"),"1");
			String pageSize = StringUtill.nvl(request.getParameter("page_size"),"10");
	    	String searchDiv = StringUtill.nvl( request.getParameter("search_div"),"10");
	    	String searchWord = StringUtill.nvl(request.getParameter("search_word"),"");
	    	
	    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
	    	
	    	//inVO.setUserId(userId);
	    	searchVO.setPageNo(Integer.parseInt(pageNo));
	    	searchVO.setPageSize(Integer.parseInt(pageSize));
	    	searchVO.setSearchDiv(searchDiv);
	    	searchVO.setSearchWord(searchWord);
	    	log.debug("searchVO: {}"+searchVO); 
	    	
	    	//log.debug("userId:"+userId);
	    	log.debug("searchWord : {}", searchWord);
			log.debug("searchDiv : {}", searchDiv);
	    	 
	    	
	    	List<ReviewDTO> list = reviewService.doRetrieve(searchVO);
	    	
	    	int i=0;
	    	
			for(ReviewDTO vo :list) {
				log.debug("i: {}, vo: {}",++i,vo);
			}
			
			//UI 데이터 전달
			request.setAttribute("list", list);
			log.debug("list:{}",list);
			//검색조건 UI로 전달
			request.setAttribute("vo", searchVO);
			
			log.debug("searchVO:"+searchVO); 
			
			 return new JView("/myPage/jsp/my_v.jsp");	
		}
	
	public JView doRetrieveX(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      	log.debug("-----------------");
	    	log.debug("doRetrieveX()");
	    	log.debug("-----------------");		
	    	
	    	//HttpSession session = request.getSession();
	    	//ReserveDTO inVO = new ReserveDTO(); 
	    	SearchDTO searchVO = new SearchDTO();
	    	String pageNo = StringUtill.nvl(request.getParameter("page_no"),"1");
			String pageSize = StringUtill.nvl(request.getParameter("page_size"),"10");
	    	String searchDiv = StringUtill.nvl( request.getParameter("search_div"),"10");
	    	String searchWord = StringUtill.nvl(request.getParameter("search_word"),"");
	    	
	    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
	    	
	    	//inVO.setUserId(userId);
	    	searchVO.setPageNo(Integer.parseInt(pageNo));
	    	searchVO.setPageSize(Integer.parseInt(pageSize));
	    	searchVO.setSearchDiv(searchDiv);
	    	searchVO.setSearchWord(searchWord);
	    	log.debug("searchVO: {}"+searchVO); 
	    	
	    	//log.debug("userId:"+userId);
	    	log.debug("searchWord : {}", searchWord);
			log.debug("searchDiv : {}", searchDiv);
	    	 
	    	
	    	List<AskDTO> list = askService.doRetrieve(searchVO);
	    	
	    	int i=0;
	    	
			for(AskDTO vo :list) {
				log.debug("i: {}, vo: {}",++i,vo);
			}
			
			//UI 데이터 전달
			request.setAttribute("list", list);
			log.debug("list:{}",list);
			//검색조건 UI로 전달
			request.setAttribute("vo", searchVO);
			
			log.debug("searchVO:"+searchVO); 
			
			 return new JView("/myPage/jsp/my_x.jsp");	
		}
 
	@Override
	public JView doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("-------------------");
    	log.debug("doWork()");
    	log.debug("-------------------");
		
    	JView viewName = null;
    	
    	String workDiv = StringUtill.nvl(request.getParameter("work_div"),"");
    	log.debug("workDiv:{}",workDiv);
    	
    	switch(workDiv) {
    	case"doSelectOne":
    		viewName = doSelectOne(request, response);
    		break; 
    	case"doRetrieveR":
    		viewName = doRetrieveR(request, response);
    		break;
    		
    	case"doRetrieveV":
    		viewName = doRetrieveV(request, response);
    		break;
    	case"doRetrieveX":
    		viewName = doRetrieveX(request, response);
    		break;	
    		
    	}
    		
    	return viewName;
	}
	
}
