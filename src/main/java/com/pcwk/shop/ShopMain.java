package com.pcwk.shop;

import java.util.List;

import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;

public class ShopMain implements PLog{
	
	ShopDTO dto;
	ShopDao dao;
	
	public ShopMain() {
		dto = new ShopDTO(1, "admin", "용인 샤브샤브", "24/06/11", 0, 0, 0, "Y");
		dao = new ShopDao();
	}
	
	public void doSave() {
		log.debug("doSave()");
		int flag = dao.doSave(dto);
		if(1 == flag) {
			log.debug("성공:{}",flag);
			
		}else {
			log.debug("실패:{}",flag);
		}
	}
	
	public void doUpdate() {
		log.debug("doUpdate()");
		String updateStr = "_Ultra";
		dto.setShopName(dto.getShopName()+updateStr);
		int flag = dao.doUpdate(dto);
		
		if(1 == flag) {
			log.debug("성공");
		}else {
			log.debug("실패");
		}
	}
	
	public void doDelete() {
		log.debug("doDelete()");
		int flag = dao.doDelete(dto);
		
		if(flag == 1) {
			log.debug("성공 : {}", flag);
		}else {
			log.debug("실패" + flag);
		}
	}
	
	public void doSelectOne() {
		log.debug("doDelete()");
		ShopDTO outVO = dao.doSelectOne(dto);
		
		if(outVO != null) {
			log.debug("성공 : {} ", outVO);
		}else {
			log.debug("실패 : {} ", outVO);
		}
	}
	
	public void doRetrieve() {
		log.debug("doRetrieve()");
		
		SearchDTO searchVO = new SearchDTO();
		searchVO.setPageNo(1);
		searchVO.setPageSize(10);
		searchVO.setSearchDiv("10");
		searchVO.setSearchWord("aabb");
		//검색 구분 
		//10 : 가게 이름으로 검색, 20 : 리뷰 갯수 검색, 30 : 별점순 검색
		//searchVO.setSearchDiv("40");
		//searchVO.setSearchWord("admin");
		List<ShopDTO> list = dao.doRetrieve(searchVO);
		
		int i = 0;
		for(ShopDTO vo : list) {
			log.debug("i : {}, vo : {}", ++i,vo);
		}
		
	}
	
	public static void main(String[] args) {
		
		ShopMain m = new ShopMain();
		
		//m.doSave();
		//m.doUpdate();
		//m.doDelete();
		//m.doSelectOne();
		m.doRetrieve();
	}

}
