package com.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.entity.Invitation;
import com.bbs.entity.InvitationAns;
import com.bbs.service.Invitation.InvitationService;
import com.bbs.service.Invitation.impl.InvitationServiceImpl;

/**
 * Servlet implementation class InvitationServerlt
 */
@WebServlet("/InvitationServerlt")
public class InvitationServerlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InvitationService is=new InvitationServiceImpl();
    private InvitationService invis = new InvitationServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvitationServerlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String op=request.getParameter("op");
		if("add".equals(op)) {
			saveAdd(request,response);
		}else if("show".equals(op)) {
			Show(request,response);
		}else if("delete".equals(op)) {
			delete(request,response);
		}else if("updata".equals(op)) {
			updata(request,response);
		}else if("findId".equals(op)) {
			findId(request,response);
		}else if("details".equals(op)) {
			findDetails(request,response);
		}else if("addans".equals(op)) {
			saveInviAns(request,response);
		}
	}

	private void saveInviAns(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 得到系统的默认时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String userId = request.getParameter("userId");
		String inviId = request.getParameter("inviId");
		String ansMessage = request.getParameter("ansMessage");
		String ansId = userId+format.format(date);
		// 創建要報錯的回復對象
		InvitationAns ans = new InvitationAns(ansId, ansMessage, inviId, userId);
		boolean isOk = invis.saveInviAns(ans);
		if(isOk) {
			findDetails(request,response);
		}else {
			response.sendRedirect("server/single-no-sidebar.jsp");
		}
	}

	private void findDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 調用業務層中查詢帖子詳情的方法
		// 一個是帖子的信息，一個是該帖子所有的回復信息
		String inviId = request.getParameter("inviId");
		Map<String, Object> ins = invis.findDetials(inviId);
		request.getSession().setAttribute("ins", ins);
		response.sendRedirect("server/single-no-sidebar.jsp");
	}

	private void findId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String invitationId=request.getParameter("invitationId");
		Invitation invitation =is.findId(invitationId);
		if(invitation !=null) {
			request.getSession().setAttribute("invitation", invitation);
			response.sendRedirect("server/invitation-edit.jsp");
		}
	}

	private void updata(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out =response.getWriter();
		String invitationId=request.getParameter("invitationId");
		String invitationMessage=request.getParameter("invitationMessage");
		int plateId=Integer.parseInt(request.getParameter("plateId"));
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		Invitation invitation=new Invitation();
		invitation.setInvitationId(invitationId);
		invitation.setInvitationMessage(invitationMessage);
		invitation.setPlateId(plateId);
		invitation.setCategoryId(categoryId);
		boolean isOk=is.updata(invitation);
		if(isOk) {
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String invitationId=request.getParameter("invitationId");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		boolean isOk=is.delete(invitationId);
		if(isOk) {
			pw.write("{\"result\":\"true\"}");
		}else {
			pw.write("{\"result\":\"false\"}");
		}
		pw.flush();
	}

	private void Show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Invitation> listi=is.Show();
		request.getSession().setAttribute("listi", listi);
		request.getRequestDispatcher("server/invitation-list.jsp").forward(request, response);
	}

	private void saveAdd(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String invitationMessage=request.getParameter("invitationMessage");
		String plateId=request.getParameter("plateId");
		String categoryId=request.getParameter("categoryId");
		String userId = request.getParameter("userId");
		// 得到系统的默认时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String invitationId = userId+format.format(date);
		Invitation invitation = new Invitation(invitationId, invitationMessage, userId, Integer.parseInt(plateId), Integer.parseInt(categoryId));
		boolean isOk=is.saveAdd(invitation);
		PrintWriter out=response.getWriter();
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
