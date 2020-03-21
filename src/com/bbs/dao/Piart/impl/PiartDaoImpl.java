package com.bbs.dao.Piart.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.commons.DataUtils;
import com.bbs.dao.Piart.PiartDao;
import com.bbs.entity.Piart;

public class PiartDaoImpl implements PiartDao {
	private ResultSet rs=null;
	@Override
	public int savaPiart(Piart piart) {
		String sql="insert into bbs_plate(plateTitle,plateMessage,isEnable) value(?,?,0)";
		Object[] params= {piart.getPlateTitle(),piart.getPlateMessage()};
		return DataUtils.executeUpdate(sql, params);
	}
	//显示
	@Override
	public List<Piart> getShow() {
		List<Piart> list =new ArrayList<Piart>();
		try {
			String sql="select * from bbs_plate";
			rs=DataUtils.queryAll(sql, null);
			while(rs.next()) {
				list.add(new Piart(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return list;
	}
	//修改
	@Override
	public int updata(Piart piart) {
		String sql="update bbs_plate SET plateTitle=?,plateMessage=?,isEnable=? where plateId=?";
		Object[] params= {piart.getPlateTitle(),piart.getPlateMessage(),piart.getIsEnable(),piart.getPlateId()};
		return DataUtils.executeUpdate(sql, params);
	}
	//删除
	@Override
	public int delete(int plateId) {
		String sql="delete from bbs_plate where plateId=?";
		Object[] params= {plateId};
		return DataUtils.executeUpdate(sql, params);
	}
	//修改查的id
	@Override
	public Piart findId(int plateId) {
		Piart piart =new Piart();
		try {
			String sql="select * from bbs_plate where plateId=?";
			Object[] params= {plateId};
			rs=DataUtils.queryAll(sql, params);
			if(rs.next()) {
				piart.setPlateId(rs.getInt(1));
				piart.setPlateTitle(rs.getString(2));
				piart.setPlateMessage(rs.getString(3));
				piart.setIsEnable(rs.getInt(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return piart;
	}
	@Override
	public int deleteAll(String[] ids) {
		StringBuffer sql = new StringBuffer("delete from bbs_plate where plateId in(");
		// 根据参数数组的长度，拼接锁需要的?号个数
		for (int i = 0; i < ids.length; i++) {
			sql.append("?");
			if (i != ids.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		return DataUtils.executeUpdate(sql.toString(), ids);
	}

}
