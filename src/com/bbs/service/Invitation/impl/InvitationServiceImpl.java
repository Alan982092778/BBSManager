package com.bbs.service.Invitation.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbs.dao.Invitation.InvitationDao;
import com.bbs.dao.Invitation.impl.InvitationDaoImpl;
import com.bbs.dao.InvitationAns.InivtationAnsDao;
import com.bbs.dao.InvitationAns.impl.InivtationAnsDaoImpl;
import com.bbs.entity.Invitation;
import com.bbs.entity.InvitationAns;
import com.bbs.service.Invitation.InvitationService;

public class InvitationServiceImpl implements InvitationService {
	private InivtationAnsDao dao=new InivtationAnsDaoImpl();
	private InvitationDao id=new InvitationDaoImpl();
	@Override
	public boolean saveAdd(Invitation invitation) {
		int result=id.saveAdd(invitation);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<Invitation> Show() {
		// TODO Auto-generated method stub
		return id.getShow();
	}
	@Override
	public boolean delete(String invitationId) {
		int result=id.delete(invitationId);
		if(result >0) {
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public Invitation findId(String invitationId) {
		// TODO Auto-generated method stub
		return id.findId(invitationId);
	}
	@Override
	public boolean updata(Invitation invitation) {
		int result=id.updata(invitation);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Map<String, Object> findDetials(String inviId) {
		Map<String, Object> ins = new HashMap<String, Object>();
		// 獲得執行id的帖子對象
		Invitation invi = id.findInvi(inviId);
		// 獲得指定id首頁回復鑫的數據
		List<InvitationAns> ans = dao.findByInivid(inviId);
		// 將獲得的數據保存到map集合
		ins.put("invi", invi);
		ins.put("ans", ans);
		return ins;
	}
	@Override
	public boolean saveInviAns(InvitationAns ans) {
		int result = dao.saveInivAns(ans);
		if (result > 0) {
			return true;
		}else {
			return false;
		}
	}

}
