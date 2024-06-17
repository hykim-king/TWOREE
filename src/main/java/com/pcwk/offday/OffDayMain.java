package com.pcwk.offday;

import java.util.List;

import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;


public class OffDayMain implements PLog {
	 OffDayDAO dao;
	 OffDayDTO offDay;
	 SearchDTO searchVO;
	 
	 public OffDayMain() {
		super();
		dao = new OffDayDAO();
		offDay = new OffDayDTO();
	}
	public void doSave() {
		    offDay.setShopNo(2);
		    offDay.setClosedDay("20240612");
	    	int flag =0;
	    	flag=dao.doSave(offDay);
	    	if (0 == flag) {
				log.debug("등록 실패 :{}", flag);
			} else {
				log.debug("등록 성공 :{}", flag);
			}
	  }
	
	public void doDelete() {
		offDay.setOffDaySeq(1);
		int flag =0;
    	flag=dao.doDelete(offDay);
    	if (0 == flag) {
			log.debug("삭제 실패 :{}", flag);
		} else {
			log.debug("삭제 성공 :{}", flag);
		}
	}
	
	public void doRetrieve() {
		log.debug(" doRetrieve()");
		searchVO = new SearchDTO();

		searchVO.setSearchSeq(2);
		//searchVO.setSearchDiv(null);
		List <OffDayDTO> list = dao.doRetrieve(searchVO);
		int i = 0;
		for (OffDayDTO vo : list) {
			log.debug("i: {}, vo: {}", ++i, vo);
		}

	}
	
	public static void main(String[] args) {
		OffDayMain m = new OffDayMain();
		m.doSave();
		//m.doDelete();
		//m.doRetrieve();
		

	}

}
