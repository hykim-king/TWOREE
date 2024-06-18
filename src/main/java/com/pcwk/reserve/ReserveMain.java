package com.pcwk.reserve;

import java.util.List;

import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;

public class ReserveMain implements PLog{

	ReserveDao rao;
	ReserveDTO rto;
	
	public ReserveMain() {
		rao = new ReserveDao();
		rto = new ReserveDTO(21, "user1", 1, 4, "2024-06-12", "2024-06-01", "010-0000-0001", "예약신청", "2024-06-11", "4명이요");
	}
	
	public void doSave() {
		log.debug("doSave()");
		int flag = rao.doSave(rto);
		if(1 == flag) {
			log.debug("성공:{}",flag);
		}else {
			log.debug("실패:{}",flag);
		}
		
	}
	public void doUpdate() {
		log.debug("doUpdate()");
		String updateStr = "";
		rto.setUserId(rto.getUserId() +updateStr);
		rto.setShopNo(rto.getShopNo());
		rto.setPeople(rto.getPeople());
		rto.setReserveDate(rto.getReserveDate() +updateStr);
		rto.setReserveAppDate(rto.getReserveAppDate() +updateStr);
		rto.setUserTel(rto.getUserTel() +updateStr);
		rto.setReserveState(rto.getReserveState() +updateStr);
		rto.setConfirmedDate(rto.getConfirmedDate() +updateStr);
		rto.setUserComment(rto.getUserComment() +updateStr);
		rto.setReserveNo(3);
		
		rao.doUpdate(rto);
		int flag = rao.doUpdate(rto);
		if(1 == flag) {
			log.debug("성공:{}",flag);
			
		}else {
			log.debug("실패:{}",flag);
		}
			
	} 
	public void doDelete() {
		log.debug("doDelete()");
		int flag = rao.doDelete(rto);
		
		if(1 == flag) {
			log.debug("성공:{}",flag);
			
		}else {
			log.debug("실패:{}",flag);
		}
	
	}
	
	public ReserveDTO doSelectOne() {
		log.debug("doSelectOne()");
		ReserveDTO outVO = rao.doSelectOne(rto);
		
		if(null != outVO) {
			log.debug("단건 조회 성공"+outVO);
		}else {
			log.debug("단건 조회 실패"+outVO);
		
		}
		
		return outVO;
	}
	
	public void doRetrieve() {
		log.debug("doRetrieve()");
		SearchDTO searchVO = new SearchDTO();
		searchVO.setPageNo(1);
		searchVO.setPageSize(10);
	
		searchVO.setSearchDiv("10");
		searchVO.setSearchWord("user1");
		List<ReserveDTO> list = rao.doRetrieve(searchVO);
		int i =0;
		for(ReserveDTO vo : list) {
			log.debug("i:{}, vo:{}",++i,vo);
		}
	}
	
	
	public static void main(String[] args) {
		
		ReserveMain m =new ReserveMain();
		//m.doSave();
		//m.doUpdate();
		//m.doDelete();
		//m.doSelectOne();
		m.doRetrieve();

	}

}
