package com.bbs.dao.Invitation.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.commons.DataUtils;
import com.bbs.dao.Invitation.InvitationDao;
import com.bbs.entity.Invitation;

public class InvitationDaoImpl implements InvitationDao {
	private ResultSet rs=null;
	@Override
	public int saveAdd(Invitation invitation) {
		String sql="INSERT INTO bbs_invitation(invitationId,invitationMessage,userId,plateId,categoryId) VALUES (?,?,?,?,?)";
		Object[] params= {invitation.getInvitationId(),invitation.getInvitationMessage(),invitation.getUserId(),invitation.getPlateId(),invitation.getCategoryId()};
		return DataUtils.executeUpdate(sql, params);
	}

	@Override
	public List<Invitation> getShow() {
		List<Invitation> list=new ArrayList<Invitation>();
		try {
			String sql="SELECT i.*,p.plateTitle,c.category FROM bbs_invitation i INNER JOIN bbs_plate p ON(i.`plateId`=p.`plateId`) INNER JOIN bbs_category c ON(i.`categoryId`=c.`categoryId`)";
			rs=DataUtils.queryAll(sql, null);
			while(rs.next()) {
				list.add(new Invitation(rs.getString("invitationId"),rs.getString("invitationMessage"),rs.getString("userId"),rs.getInt("plateId"),rs.getInt("categoryId"),rs.getInt("isPass"),rs.getInt("isEnable"),rs.getInt("isCream"),rs.getDate("invitationCreate"),rs.getDate("invitationModify"),rs.getString("plateTitle"),rs.getString("category")));
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
	public int delete(String invitationId) {
		String sql="delete from bbs_invitation where invitationId=?";
		Object[] params= {invitationId};
		return DataUtils.executeUpdate(sql, params);
	}

	@Override
	public Invitation findId(String invitationId) {
		Invitation in=new Invitation();
		try {
			String sql="SELECT * FROM bbs_invitation WHERE invitationId=?";
			Object[] params= {invitationId};
			rs=DataUtils.queryAll(sql, params);
			if(rs.next()) {
				in.setInvitationId(rs.getString(1));
				in.setInvitationMessage(rs.getString(2));
				in.setUserId(rs.getString(3));
				in.setPlateId(rs.getInt(4));
				in.setCategoryId(rs.getInt(5));
				in.setIsPass(rs.getInt(6));
				in.setIsEnable(rs.getInt(7));
				in.setIsCream(rs.getInt(8));
				in.setInvitationCreate(rs.getDate(9));
				in.setInvitationModify(rs.getDate(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return in;
	}

	@Override
	public int updata(Invitation invitation) {
		String sql="UPDATE bbs_invitation SET invitationMessage=?,plateId=?,categoryId=?,invitationModify=default WHERE invitationId=?";
		Object[] params= {invitation.getInvitationMessage(),invitation.getPlateId(),invitation.getCategoryId(),invitation.getInvitationId()};
		return DataUtils.executeUpdate(sql, params);
	}

	@Override
	public Invitation findInvi(String inviId) {
		Invitation invi = null;
		try {
			String sql = "select invitationId,invitationMessage,userId,plateId,categoryId from bbs_invitation where invitationId=?";
			Object[] params = {inviId};
			rs = DataUtils.queryAll(sql, params);
			if(rs.next()) {
				invi = new Invitation(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return invi;
	}

	@Override
	public int updateInvi(Invitation invi) {
		String sql = "update bbs_invitation set invitationMessage=?,userId=?,plateId=?,categoryId=?,invitationModify=default where invitationId=?";
		Object[] params = {invi.getInvitationMessage(),invi.getUserId(),invi.getPlateId(),invi.getCategoryId(),invi.getInvitationId()};
		return DataUtils.executeUpdate(sql, params);
	}

}
