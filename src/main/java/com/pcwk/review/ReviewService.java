package com.pcwk.review;

import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.PLog;

public class ReviewService implements PLog {
	private ReviewDAO dao;

	public ReviewService() {
		dao = new ReviewDAO();
	}
    
	public List<ReviewDTO> doRetrieve(DTO search) {
		
		return dao.doRetrieve(search);
	}
	

	public int doSave(ReviewDTO param) {
		
		return dao.doSave(param);
	}
	

	public int doUpdate(ReviewDTO param) {
		
		return dao.doUpdate(param);
	}
	

	public int doDelete(ReviewDTO param) {
		
		return dao.doDelete(param);
	}


	public ReviewDTO doSelectOne(ReviewDTO param) {
		ReviewDTO outVO = new ReviewDTO();
		outVO=dao.doSelectOne(param);
		return outVO;
	}

}
