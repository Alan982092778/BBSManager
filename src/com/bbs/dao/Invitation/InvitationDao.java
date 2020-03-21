package com.bbs.dao.Invitation;

import java.util.List;

import com.bbs.entity.Invitation;

public interface InvitationDao {
	//添加
	int saveAdd(Invitation invitation);
	//显示
	List<Invitation> getShow();
	//删除
	int delete(String invitationId);
	//修改id
	Invitation findId(String invitationId);
	//修改
	int updata (Invitation invitation);
	
	//回复
	Invitation findInvi(String inviId);

	int updateInvi(Invitation invi);
}
