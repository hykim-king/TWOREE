package com.pcwk.review;

import java.util.List;

import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;

public class ReviewMain implements PLog {
	 ReviewDAO dao;
	 ReviewDTO review;
	 SearchDTO searchVO;
	 
	 public ReviewMain() {
		super();
		dao = new ReviewDAO();
		review = new ReviewDTO();
	}

	public void doSave() {
		    review.setShopNo(2);
		    review.setUserId("user1");
		    review.setReviewContent("맛집이네요");
		    review.setReviewWrtDate("2024-06-13");
		    review.setScore(6);
	    	int flag =0;
	    	flag=dao.doSave(review);
	    	if (0 == flag) {
				log.debug("등록 실패 :{}", flag);
			} else {
				log.debug("등록 성공 :{}", flag);
			}
	    }
	    
		public void doDelete() {
			review.setReviewNo(1);
			int flag =0;
	    	flag=dao.doDelete(review);
	    	if (0 == flag) {
				log.debug("삭제 실패 :{}", flag);
			} else {
				log.debug("삭제 성공 :{}", flag);
			}
		
		}
		
	    public void doUpdate() {
	    	review.setReviewNo(2);
	    	review.setReviewContent("벌레나옴");
	    	 review.setScore(4);
			int flag = dao.doUpdate(review);
			if (0 == flag) {
				log.debug("업데이트 실패 ");
			} else {
				log.debug("업데이트 성공 ");
			}
			
		}
	    
		public void doSelectOne() {
			review.setReviewNo(2);
			ReviewDTO outVO = dao.doSelectOne(review);
			if (null != outVO) {
				log.debug("단건 조회 성공");
			} else {
				log.debug("단건 조회 실패");
			}
			log.debug(outVO);
			
			
		}
		
		
		public void doRetrieve() {
			log.debug(" doRetrieve()");
			searchVO = new SearchDTO();
			searchVO.setPageNo(1);
			searchVO.setPageSize(4);
			searchVO.setSearchSeq(0);
			//searchVO.setSearchWord("0");
			searchVO.setSearchDiv("20");
			List <ReviewDTO> list = dao.doRetrieve(searchVO);
			int i = 0;
			for (ReviewDTO vo : list) {
				log.debug("i: {}, vo: {}", ++i, vo);
			}

		}
        
	public static void main(String[] args) {
		ReviewMain m = new ReviewMain();
		//m.doSave();
		//m.doDelete();
		//m.doUpdate();
		//m.doSelectOne();
		m.doRetrieve();
	}

}
