package com.pcwk.shop;

import java.util.List;

import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;

public class ShopReserveSetMain implements PLog {

	ShopReserveSetDTO dto;
	ShopReserveSetDAO dao;

	public ShopReserveSetMain() {
		dto = new ShopReserveSetDTO(1, 1, 1, "AM11", "PM10");
		dao = new ShopReserveSetDAO();
	}

	public void doSave() {
		log.debug("doSave()");
		int flag = dao.doSave(dto);
		if (1 == flag) {
			log.debug("성공:{}", flag);

		} else {
			log.debug("실패:{}", flag);
		}
	}

	public void doUpdate() {
		log.debug("doUpdate()");
		String startTimeUpdate = "AM";
		String endTimeUpdate = "PM";
		dto.setStartTime(startTimeUpdate);
		dto.setEndTime(endTimeUpdate);
		int flag = dao.doUpdate(dto);

		if (1 == flag) {
			log.debug("성공");
		} else {
			log.debug("실패");
		}
	}

	public void doDelete() {
		log.debug("doDelete()");
		int flag = dao.doDelete(dto);

		if (flag == 1) {
			log.debug("성공 : {}", flag);
		} else {
			log.debug("실패" + flag);
		}
	}

	public void doSelectOne() {
		log.debug("doDelete()");
		ShopReserveSetDTO outVO = dao.doSelectOne(dto);

		if (outVO != null) {
			log.debug("성공 : {} ", outVO);
		} else {
			log.debug("실패 : {} ", outVO);
		}
	}

	public static void main(String[] args) {

		ShopReserveSetMain m = new ShopReserveSetMain();

		// m.doSave();
		// m.doUpdate();
		// m.doDelete();
		 m.doSelectOne();
		// m.doRetrieve();
	}

}
