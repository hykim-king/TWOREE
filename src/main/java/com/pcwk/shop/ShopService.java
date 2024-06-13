package com.pcwk.shop;

import com.pcwk.ehr.cmn.DTO;
import java.util.List;

import com.pcwk.ehr.cmn.PLog;


public class ShopService implements PLog{
	
	private ShopDAO dao;

	public ShopService() {
		dao = new ShopDAO();
	}
	
	/*
	 * 紐⑸줉 議고쉶
	 * @param search
	 * @return List<BoardDTO>
	 * */
	public List<ShopDTO> doRetrieve(DTO search) {
		
		return dao.doRetrieve(search);
	}
	
	/**
	 * ���옣
	 * @param param
	 * @return BoardDTO
	 */
	public int doSave(ShopDTO param) {
		
		return dao.doSave(param);
	}
	
	/**
	 * �뾽�뜲�씠�듃
	 * @param param
	 * @return BoardDTO
	 */
	public int doUpdate(ShopDTO param) {
		
		return dao.doUpdate(param);
	}
	
	/**
	 * �궘�젣
	 * @param param
	 * @return BoardDTO
	 */
	public int doDelete(ShopDTO param) {
		
		return dao.doDelete(param);
	}
	/**
	 * �떒嫄� 議고쉶
	 * @param param
	 * @return BoardDTO
	 */
	public ShopDTO selectOneReadCnt(ShopDTO param) {
		ShopDTO outVO = new ShopDTO();
		
		//updateReadCnt
		int flag = dao.doUpdateReadCnt(param);
		log.debug("flag : {}", flag);
		
		outVO.setFlag(flag);
		
		//증가 후 조회
		//doSelectOne
		outVO = dao.doSelectOne(param);
				
		return outVO;
	}
}
