package com.pcwk.ehr.cmn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller 에서 생성된 JSP의 View경로를 전달.
 * @author user
 *
 */
public class JView {
	//jsp view이름
	private String viewName;

	public JView(String viewName) {
		super();
		this.viewName = viewName;
	}
	
	/**
	 * viewName 가져오는 getter()
	 * @return
	 */
	public String getViewName() {
		return viewName;
	}
	
	/**
	 * viewName 으로 request, response 전달
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}
	
}
