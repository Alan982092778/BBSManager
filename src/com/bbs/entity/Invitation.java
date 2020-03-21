package com.bbs.entity;

import java.util.Date;

public class Invitation {
	//表里面的数据
	private String invitationId;
	private String invitationMessage;
	private String userId;
	private int plateId;
	private int categoryId;
	private int isPass;
	private int isEnable;
	private int isCream;
	private Date invitationCreate;
	private Date invitationModify;
	//主题等
	private String plateTitle;
	private String category;
	
	
	public String getPlateTitle() {
		return plateTitle;
	}
	public void setPlateTitle(String plateTitle) {
		this.plateTitle = plateTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public String getInvitationMessage() {
		return invitationMessage;
	}
	public void setInvitationMessage(String invitationMessage) {
		this.invitationMessage = invitationMessage;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public int getPlateId() {
		return plateId;
	}
	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getIsPass() {
		return isPass;
	}
	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
	public int getIsCream() {
		return isCream;
	}
	public void setIsCream(int isCream) {
		this.isCream = isCream;
	}
	public Date getInvitationCreate() {
		return invitationCreate;
	}
	public void setInvitationCreate(Date invitationCreate) {
		this.invitationCreate = invitationCreate;
	}
	public Date getInvitationModify() {
		return invitationModify;
	}
	public void setInvitationModify(Date invitationModify) {
		this.invitationModify = invitationModify;
	}
	public Invitation(String invitationId, String invitationMessage, String userId, int plateId, int categoryId) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateId = plateId;
		this.categoryId = categoryId;
	}
	public Invitation(String invitationId, String invitationMessage, String userId, int plateId, int categoryId,
			int isPass, int isEnable, int isCream, Date invitationCreate, Date invitationModify, String plateTitle,
			String category) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateId = plateId;
		this.categoryId = categoryId;
		this.isPass = isPass;
		this.isEnable = isEnable;
		this.isCream = isCream;
		this.invitationCreate = invitationCreate;
		this.invitationModify = invitationModify;
		this.plateTitle = plateTitle;
		this.category = category;
	}
	public Invitation() {
		super();
	}
	public Invitation(String invitationId, String invitationMessage, int plateId, int categoryId) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.plateId = plateId;
		this.categoryId = categoryId;
	}
	public Invitation(String invitationId, String invitationMessage, int plateId, int categoryId,
			Date invitationModify) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.plateId = plateId;
		this.categoryId = categoryId;
		this.invitationModify = invitationModify;
	}
	public Invitation(String invitationId, String invitationMessage, String userId, int plateId, int categoryId,
			int isPass, int isEnable, int isCream, Date invitationCreate, Date invitationModify) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateId = plateId;
		this.categoryId = categoryId;
		this.isPass = isPass;
		this.isEnable = isEnable;
		this.isCream = isCream;
		this.invitationCreate = invitationCreate;
		this.invitationModify = invitationModify;
	}
	
	
	
}
