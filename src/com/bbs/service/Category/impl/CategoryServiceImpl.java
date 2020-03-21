package com.bbs.service.Category.impl;

import java.util.List;

import com.bbs.dao.Category.CategoryDao;
import com.bbs.dao.Category.impl.CategoryDaoImpl;
import com.bbs.entity.Category;
import com.bbs.service.Category.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao cd=new CategoryDaoImpl();
	@Override
	public List<Category> show() {
		// TODO Auto-generated method stub
		return cd.show();
	}

}
