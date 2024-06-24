package com.pcwk.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.pcwk.ehr.cmn.SearchDTO;
import com.google.gson.Gson;
import com.pcwk.ask.AskDTO;
import com.pcwk.ask.AskService;
import com.pcwk.ehr.cmn.ControllerV;
import com.pcwk.ehr.cmn.EncryptUtil;
import com.pcwk.ehr.cmn.JView;
import com.pcwk.ehr.cmn.MessageVO;
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
	public JView doSaveReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
		log.debug("-----------------");
		log.debug("doSaveReview()");
		log.debug("-----------------");
        
		ReviewDTO inVO = new ReviewDTO();
		  
		String shopNo = StringUtill.nvl(request.getParameter("shopNo"), ""); 
		String userId = StringUtill.nvl(request.getParameter("userId"), "");
		String reviewContent =  StringUtill.nvl(request.getParameter("reviewContent"), "");
		String score =  StringUtill.nvl(request.getParameter("score"), "");
		
		
		inVO.setShopNo(Integer.parseInt(shopNo));
		inVO.setUserId(userId);
		inVO.setReviewContent(reviewContent);
		inVO.setScore(Integer.parseInt(score)); 
		
		log.debug("inVO:"+inVO);
		int flag = reviewService.doSave(inVO);
		String message = "";
		log.debug("flag:"+flag);
		
		if(1==flag) {
			message = "리뷰가 등록되었습니다.";
		}else {
			message = "다시시도해주십시오.";
		}
		
		MessageVO  messageVO=new MessageVO();
		messageVO.setMessageId(String.valueOf(flag));
		messageVO.setMsgContents(message);
		
		Gson  gson=new Gson();
		String jsonString = gson.toJson(messageVO);
		
		log.debug("jsonString:"+jsonString);
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		
		return null;
	}
	
	public JView doSaveAsk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
		log.debug("-----------------");
		log.debug("doSaveAsk()");
		log.debug("-----------------");
        
		AskDTO inVO = new AskDTO();
		  
		String shopNo = StringUtill.nvl(request.getParameter("shopNo"), "");
		String userAsk = StringUtill.nvl(request.getParameter("userAsk"), "");
		String userId = StringUtill.nvl(request.getParameter("userId"), "");
		  
		inVO.setShopNo(Integer.parseInt(shopNo));
		inVO.setUserId(userId);
		inVO.setUserAsk(userAsk);
		inVO.setAskState("문의 요청"); 
		log.debug("inVO:"+inVO);
		int flag = askService.doSave(inVO);
		String message = "";
		log.debug("flag:"+flag);
		
		if(1==flag) {
			message = "success";
		}else {
			message = "fail";
		}
		
		MessageVO  messageVO=new MessageVO();
		messageVO.setMessageId(String.valueOf(flag));
		messageVO.setMsgContents(message);
		
		Gson  gson=new Gson();
		String jsonString = gson.toJson(messageVO);
		
		log.debug("jsonString:"+jsonString);
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		
		return null;
	}

	
	public JView doSelectOne(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
      	log.debug("-----------------");
    	log.debug("doSelectOne()");
    	log.debug("-----------------");		
    	
    	UserDTO inVO = new UserDTO(); 
    	HttpSession session=request.getSession();
    	inVO=(UserDTO)session.getAttribute("user");
    	log.debug("inVO:"+inVO);
    	
    	//this.service.selectOneReadCnt(inVO);
    	
    	UserDTO outVO = this.service.doSelectOne(inVO);
    	log.debug("outVO:"+outVO); 
    	
    	
    	request.setAttribute("outVO",outVO);
    	
    	
    
    	return new JView("/myPage/jsp/my_p.jsp");
    
    }
	public JView doSelectOneR1(HttpServletRequest request, HttpServletResponse response)
	    	throws ServletException, IOException {
	      	log.debug("-----------------");
	    	log.debug("doSelectOneR1()");
	    	log.debug("-----------------");		
	    	  
	    	String shopNo = StringUtill.nvl(request.getParameter("shopNo"),""); 
	    	String userId = StringUtill.nvl(request.getParameter("userId"),"");
	    	HttpSession session = request.getSession();
	    	
	    	UserDTO user = (UserDTO)session.getAttribute("user");
	    	
	    	request.setAttribute("shopNo",shopNo);
	    	request.setAttribute("userId",user.getUserId());
	    	log.debug(shopNo);	
	    	log.debug(userId);
	    return new JView("/myPage/jsp/review_write.jsp");
	    
	    }
	public JView doSelectOneX1(HttpServletRequest request, HttpServletResponse response)
	    	throws ServletException, IOException {
	      	log.debug("-----------------");
	    	log.debug("doSelectOneX1()");
	    	log.debug("-----------------");
	    	
	     	AskDTO inVO = new AskDTO();  
	     	String ShopNo = StringUtill.nvl(request.getParameter("shopNo"), "0");
	    	
	    	inVO.setShopNo(Integer.parseInt(ShopNo));
	    	log.debug("inVO:"+inVO);
	    	
	    	//this.service.selectOneReadCnt(inVO);
	    	
	    	request.setAttribute("doSelectOneX1InVO", inVO);
	    	
	    	return new JView("/myPage/jsp/xask_write.jsp");
	    
	    }
	
	public JView doRetrieveR(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      	log.debug("-----------------");
	    	log.debug("doRetrieveR()");
	    	log.debug("-----------------");		 
	    	 
	    	//ReserveDTO inVO = new ReserveDTO(); 
	    	SearchDTO searchVO = new SearchDTO();
	    	HttpSession session = request.getSession(); 
	    	UserDTO user = (UserDTO)session.getAttribute("user"); 
	    	int pageNo =1;
	    	int pageSize = 10;
	    	String searchDiv = "10";
	    	String searchWord = user.getUserId();
	    	
	    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
	    	
	    	
	    	
	    	//inVO.setUserId(userId);
	    	searchVO.setPageNo(pageNo);
	    	searchVO.setPageSize(pageSize);
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
			 
			request.setAttribute("reserverList", list);
			log.debug("list:{}",list); 
					
			request.setAttribute("reserverList", list);
			log.debug("list:{}",list); 
			
			int flag = (list != null && !list.isEmpty()) ? 1 : 0; 
			String message = "";

			log.debug("flag:" + flag);

			if (1 == flag) {
			    message = "예약넘어가기 성공";
			} else {
			    message = "예약내역이 존재하지 않습니다.";
			}
			
			MessageVO  messageVO=new MessageVO();
			messageVO.setMessageId(String.valueOf(flag));
			messageVO.setMsgContents(message);
			
			Gson  gson=new Gson();
			String jsonString = gson.toJson(messageVO);
			
			log.debug("jsonString:"+jsonString);
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.print(jsonString);
			
			return null;
		}
	
	public JView doRetrieveR1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      	log.debug("-----------------");
	    	log.debug("doRetrieveR1()");
	    	log.debug("-----------------");		
	    	
	    	//HttpSession session = request.getSession();
	    	//ReserveDTO inVO = new ReserveDTO(); 
	    	SearchDTO searchVO = new SearchDTO();
	    	
	    	HttpSession session = request.getSession(); 
	    	UserDTO user = (UserDTO)session.getAttribute("user"); 
	    	int pageNo =1;
	    	int pageSize = 10;
	    	String searchDiv = "10";
	    	String searchWord = user.getUserId();
	    	
	    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
	    	
	    	//inVO.setUserId(userId);
	    	searchVO.setPageNo(pageNo);
	    	searchVO.setPageSize(pageSize);
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
			 
			request.setAttribute("reserverList", list);
			log.debug("list:{}",list); 
					
			 return new JView("/myPage/jsp/option_v.jsp");	
		}
	
	public JView doRetrieveR2(HttpServletRequest request, HttpServletResponse response) {
		log.debug("-----------------");
    	log.debug("doRetrieveR2()");
    	log.debug("-----------------");		 
    	 
    	//ReserveDTO inVO = new ReserveDTO(); 
    	SearchDTO searchVO = new SearchDTO();
    	HttpSession session = request.getSession(); 
    	UserDTO user = (UserDTO)session.getAttribute("user"); 
    	int pageNo =1;
    	int pageSize = 10;
    	String searchDiv = "10";
    	String searchWord = user.getUserId();
    	
    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
    	
    	
    	
    	//inVO.setUserId(userId);
    	searchVO.setPageNo(pageNo);
    	searchVO.setPageSize(pageSize);
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
		 
		request.setAttribute("reserverList", list);
		log.debug("list:{}",list); 
				
		request.setAttribute("reserverList", list);
		log.debug("list:{}",list); 
		
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
	    	HttpSession session = request.getSession(); 
	    	UserDTO user = (UserDTO)session.getAttribute("user"); 
	    	int pageNo =1;
	    	int pageSize = 10;
	    	String searchDiv = "10";
	    	String searchWord = user.getUserId();
	    	
	    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
	    	
	    	//inVO.setUserId(userId);
	    	searchVO.setPageNo(pageNo);
	    	searchVO.setPageSize(pageSize);
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
			 
			request.setAttribute("reviewList", list);
			log.debug("list:{}",list); 
					 
			
			int flag = (list != null && !list.isEmpty()) ? 1 : 0; 
			String message = "";

			log.debug("flag:" + flag);

			if (1 == flag) {
			    message = "리뷰 넘어가기 성공";
			} else {
			    message = "리뷰 내역이 존재하지 않습니다.";
			}
			
			MessageVO  messageVO=new MessageVO();
			messageVO.setMessageId(String.valueOf(flag));
			messageVO.setMsgContents(message);
			
			Gson  gson=new Gson();
			String jsonString = gson.toJson(messageVO);
			
			log.debug("jsonString:"+jsonString);
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.print(jsonString);
			
			return null;
		}
	public JView doRetrieveV1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      	log.debug("-----------------");
	    	log.debug("doRetrieveV1()");
	    	log.debug("-----------------");		
	    	
	    	//HttpSession session = request.getSession();
	    	//ReserveDTO inVO = new ReserveDTO(); 
	    	SearchDTO searchVO = new SearchDTO();
	    	int pageNo =1;
	    	int pageSize = 10;
	    	String searchDiv = "10";
	    	String searchWord = StringUtill.nvl(request.getParameter("userId"),"");
	    	
	    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
	    	
	    	//inVO.setUserId(userId);
	    	searchVO.setPageNo(pageNo);
	    	searchVO.setPageSize(pageSize);
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
			
			//UI 占쎈쑓占쎌뵠占쎄숲 占쎌읈占쎈뼎
			request.setAttribute("reviewList", list); 
			log.debug("list:{}",list);
			
			 return new JView(" ");	
		}
	public JView doRetrieveV2(HttpServletRequest request, HttpServletResponse response) {
		log.debug("-----------------");
    	log.debug("doRetrieveV2()");
    	log.debug("-----------------");		 
    	 
    	//ReserveDTO inVO = new ReserveDTO(); 
    	SearchDTO searchVO = new SearchDTO();
    	HttpSession session = request.getSession(); 
    	UserDTO user = (UserDTO)session.getAttribute("user"); 
    	int pageNo =1;
    	int pageSize = 10;
    	String searchDiv = "10";
    	String searchWord = user.getUserId();
    	
    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
    	
    	
    	
    	//inVO.setUserId(userId);
    	searchVO.setPageNo(pageNo);
    	searchVO.setPageSize(pageSize);
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
		 
		request.setAttribute("reviewList", list);
		log.debug("list:{}",list); 
				 
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
        	HttpSession session = request.getSession(); 
	    	UserDTO user = (UserDTO)session.getAttribute("user"); 
	    	int pageNo =1;
	    	int pageSize = 10;
	    	String searchDiv = "10";
	    	String searchWord = user.getUserId();
	    	
    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
    	
	    	
	    	//inVO.setUserId(userId);
            searchVO.setPageNo(pageNo);
            searchVO.setPageSize(pageSize);
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
			 
			request.setAttribute("askList", list);
			log.debug("list:{}",list); 
			
			
			int flag = (list != null && !list.isEmpty()) ? 1 : 0; 
			String message = "";

			log.debug("flag:" + flag);

			if (1 == flag) {
			    message = "문의 넘어가기 성공";
			} else {
			    message = "문의 내역이 존재하지 않습니다.";
			}
			
			MessageVO  messageVO=new MessageVO();
			messageVO.setMessageId(String.valueOf(flag));
			messageVO.setMsgContents(message);
			
			Gson  gson=new Gson();
			String jsonString = gson.toJson(messageVO);
			
			log.debug("jsonString:"+jsonString);
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.print(jsonString);
			
			return null;
		}
	
	public JView doRetrieveX2(HttpServletRequest request, HttpServletResponse response) {
		log.debug("-----------------");
    	log.debug("doRetrieveV2()");
    	log.debug("-----------------");		 
    	 
    	//ReserveDTO inVO = new ReserveDTO(); 
    	SearchDTO searchVO = new SearchDTO();
    	HttpSession session = request.getSession(); 
    	UserDTO user = (UserDTO)session.getAttribute("user"); 
    	int pageNo =1;
    	int pageSize = 10;
    	String searchDiv = "10";
    	String searchWord = user.getUserId();
    	
    	//String userId = StringUtill.nvl(request.getParameter("userId"),"");
    	
    	
    	
    	//inVO.setUserId(userId);
    	searchVO.setPageNo(pageNo);
    	searchVO.setPageSize(pageSize);
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
		 
		request.setAttribute("askList", list);
		log.debug("list:{}",list); 
		
		 return new JView("/myPage/jsp/my_x.jsp");	
        }
	
	public JView doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
		log.debug("-----------------");
		log.debug("doUpdate()");
		log.debug("-----------------");
		
		UserDTO  inVO=new UserDTO();
		
		String userId = StringUtill.nvl(request.getParameter("userId"),"");
		String password = EncryptUtil.Encrypt(StringUtill.nvl(request.getParameter("password"),""));
		String name = StringUtill.nvl(request.getParameter("name"),"");
		String userEmail = StringUtill.nvl(request.getParameter("userEmail"),"");
		String tel = StringUtill.nvl(request.getParameter("tel"),"");
		String birthday = StringUtill.nvl(request.getParameter("birthday"),"");
		//String shopAdmin = StringUtill.nvl(request.getParameter("shopAdmin"),"");
		//String penaltyDate = StringUtill.nvl(request.getParameter("penaltyDate"),"0");
		
		
		inVO.setUserId(userId);
		inVO.setPassword(password);
		inVO.setName(name);
		inVO.setUserEmail(userEmail);
		inVO.setTel(tel);
		inVO.setBirthday(birthday);
		//inVO.setUserId((userId));
		
		log.debug("inVO:"+inVO);
		int flag = service.doUpdate(inVO);
		String message = "";
		log.debug("flag:"+flag);
		
		if(1==flag) {
			message = "성공";
		}else {
			message = "실패";
		}
		
		MessageVO  messageVO=new MessageVO();
		messageVO.setMessageId(String.valueOf(flag));
		messageVO.setMsgContents(message);
		
		Gson  gson=new Gson();
		String jsonString = gson.toJson(messageVO);
		
		log.debug("jsonString:"+jsonString);
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		
		return null;
	} 
	@Override
	public JView doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
		log.debug("-------------------");
    	log.debug("doWork()");
    	log.debug("-------------------");
		
    	JView viewName = null;
    	
    	String workDiv = StringUtill.nvl(request.getParameter("work_div"),"");
    	log.debug("workDiv:{}",workDiv);
    	
    	switch(workDiv) {
    	
    	case"doSaveAsk":
    		viewName = doSaveAsk(request, response);
    		break;
    	case"doSaveReview":
    		viewName = doSaveReview(request, response);
    		break;
    		
    	case"doSelectOne":
    		viewName = doSelectOne(request, response);
    		break; 
    		
    	case"doSelectOneR1":
    		viewName = doSelectOneR1(request, response);
    		break; 
    	case"doSelectOneX1":
    		viewName = doSelectOneX1(request, response);
    		break; 	
    		
    	case"doRetrieveR":
    		viewName = doRetrieveR(request, response);
    		break;
    		
    	case"doRetrieveR1":
    		viewName = doRetrieveR1(request, response);
    		break;
    	case"doRetrieveR2":
    		viewName = doRetrieveR2(request, response);
    		break;
    	case"doRetrieveV":
    		viewName = doRetrieveV(request, response);
    		break; 
    		
    	case"doRetrieveV1":
    		viewName = doRetrieveV1(request, response);
    		break;
    		
    	case"doRetrieveV2":
    		viewName = doRetrieveV2(request, response);
    		break;
    	
    	case"doRetrieveX":
    		viewName = doRetrieveX(request, response);
    		break;
    	case"doRetrieveX2":
    		viewName = doRetrieveX2(request, response);
    		break;		
    		
    	case"doUpdate":
    		viewName = doUpdate(request, response);
    		break;		
    		
    	}
    		
    	return viewName;
	}
	
}
