package com.bbs.dao.InvitationAns.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.commons.DataUtils;
import com.bbs.dao.InvitationAns.InivtationAnsDao;
import com.bbs.entity.InvitationAns;

public class InivtationAnsDaoImpl implements InivtationAnsDao {
	private ResultSet rs;
	@Override
	public List<InvitationAns> findByInivid(String inivId) {
		List<InvitationAns> list = new ArrayList<InvitationAns>();
		try {
			String sql = "select * from bbs_invitation_ans where invitationId=?";
			Object[] params = {inivId};
			rs = DataUtils.queryAll(sql, params);
			while (rs.next()) {
				InvitationAns ans = new InvitationAns(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5));
				list.add(ans);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public int saveInivAns(InvitationAns ans) {
		String sql = "INSERT INTO bbs_invitation_ans(ansId,ansMessage,invitationId,userId) VALUES(?,?,?,?)";
		Object[] params = {ans.getAnsId(),ans.getAnsMessage(),ans.getInvitationId(),ans.getUserId()};
		return DataUtils.executeUpdate(sql, params);
	}

}
