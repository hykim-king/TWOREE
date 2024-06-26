package com.pcwk.ehr.cmn;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 모든 컨트롤러는 ControllerV 인터페이스를 implements 받아야한다.
 * @author user
 *
 */
public interface ControllerV {

	/**
	 * Controller 공통 메서드
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException 
	 */
	public JView doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException;
		

}
