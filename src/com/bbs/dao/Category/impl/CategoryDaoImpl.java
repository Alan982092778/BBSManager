package com.bbs.dao.Category.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.commons.DataUtils;
import com.bbs.dao.Category.CategoryDao;
import com.bbs.entity.Category;

public class CategoryDaoImpl implements CategoryDao {
	private ResultSet rs=null;
	@Override
	public List<Category> show() {
		List<Category> list=new ArrayList<Category>();
		try {
			String sql="select * from bbs_category";
			rs=DataUtils.queryAll(sql, null);
			while(rs.next()) {
				list.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return list;
	}

}
