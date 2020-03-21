package com.bbs.dao.InvitationAns;

import java.util.List;

import com.bbs.entity.InvitationAns;

public interface InivtationAnsDao {
	List<InvitationAns> findByInivid(String inivId);
	
	int saveInivAns(InvitationAns ans);
}
