package com.bbs.dao.Piart;

import java.util.List;

import com.bbs.entity.Piart;

public interface PiartDao {
	//添加
	int savaPiart(Piart piart);
	//显示
	List<Piart> getShow();
	//修改id
	Piart findId(int plateId);
	//修改
	int updata(Piart piart);
	//删除
	int delete(int plateId);
	//批量删除
	int deleteAll(String[] ids);
}
