package com.bbs.service.Invitation;

import java.util.List;
import java.util.Map;

import com.bbs.entity.Invitation;
import com.bbs.entity.InvitationAns;

public interface InvitationService {
	boolean saveAdd(Invitation invitation);
	List<Invitation> Show();
	boolean delete(String invitationId);
	Invitation findId(String invitationId);
	boolean updata(Invitation invitation);
	//回复
	Map<String, Object> findDetials(String inviId);

	boolean saveInviAns(InvitationAns ans);
}
