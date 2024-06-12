package com.pcwk.menu;

import java.util.List;

import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;

public class MenuMain implements PLog {
	 MenuDAO dao;
	 MenuDTO menu;
	 SearchDTO searchVO;
	 
	 public MenuMain() {
		super();
		dao = new MenuDAO();
		menu = new MenuDTO();
		menu.setMenuName("간장찜닭");
		menu.setMenuInfo("간장으로 조리한 찖닭 2~3인분");
		menu.setPrice(20000);
		menu.setShopNo(2);
	}

	public void doSave() {
	    	int flag =0;
	    	flag=dao.doSave(menu);
	    	if (0 == flag) {
				log.debug("등록 실패 :{}", flag);
			} else {
				log.debug("등록 성공 :{}", flag);
			}
	    }
	    
		public void doDelete() {
			menu.setMenuNO(1);
			int flag =0;
	    	flag=dao.doDelete(menu);
	    	if (0 == flag) {
				log.debug("삭제 실패 :{}", flag);
			} else {
				log.debug("삭제 성공 :{}", flag);
			}
		
		}
	    public void doUpdate() {
	    	String updateStr = "_U";
			menu.setMenuName(menu.getMenuName() + updateStr);
			menu.setMenuInfo(menu.getMenuInfo() + updateStr);
			menu.setPrice(menu.getPrice()+1000);
			menu.setMenuNO(21);
			int flag = dao.doUpdate(menu);
			if (0 == flag) {
				log.debug("업데이트 실패 ");
			} else {
				log.debug("업데이트 성공 ");
			}
			
		}
	    
		public void doSelectOne() {
			menu.setMenuNO(21);
			MenuDTO outVO = dao.doSelectOne(menu);
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
			searchVO.setPageSize(10);
			searchVO.setSearchSeq(2);
			//searchVO.setSearchDiv(null);
			List <MenuDTO> list = dao.doRetrieve(searchVO);
			int i = 0;
			for (MenuDTO vo : list) {
				log.debug("i: {}, vo: {}", ++i, vo);
			}

		}

	public static void main(String[] args) {
		MenuMain m = new MenuMain();
		//m.doSave();
		//m.doDelete();
		//m.doUpdate();
		//m.doSelectOne();
		m.doRetrieve();
	}

}
