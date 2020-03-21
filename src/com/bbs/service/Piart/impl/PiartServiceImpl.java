package com.bbs.service.Piart.impl;

import java.util.List;

import com.bbs.dao.Piart.PiartDao;
import com.bbs.dao.Piart.impl.PiartDaoImpl;
import com.bbs.entity.Piart;
import com.bbs.service.Piart.PiartService;

public class PiartServiceImpl implements PiartService {
private PiartDao pd=new PiartDaoImpl();
	@Override
	public boolean savaPlant(Piart piart) {
		int result =pd.savaPiart(piart);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<Piart> show() {
		// TODO Auto-generated method stub
		return pd.getShow();
	}
	@Override
	public boolean delete(int plateId) {
		int result=pd.delete(plateId);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean updata(Piart piart) {
		int result=pd.updata(piart);
		if(result >0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Piart findId(int plateId) {
		return pd.findId(plateId);
	}
	@Override
	public boolean deleteAll(String plateIds) {
		plateIds=plateIds.substring(1,plateIds.lastIndexOf("]")).replaceAll("\"","");
		String[] ids=plateIds.split(",");
		int result=pd.deleteAll(ids);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

}
