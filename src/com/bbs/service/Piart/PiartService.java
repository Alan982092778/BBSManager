package com.bbs.service.Piart;

import java.util.List;

import com.bbs.entity.Piart;

public interface PiartService {
	boolean savaPlant(Piart piart);
	List<Piart> show();
	boolean delete(int plateId);
	boolean updata(Piart piart);
	Piart findId(int plateId);
	boolean deleteAll(String plateIds);
}
