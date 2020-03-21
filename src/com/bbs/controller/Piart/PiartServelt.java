package com.bbs.controller.Piart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.entity.Piart;
import com.bbs.service.Piart.PiartService;
import com.bbs.service.Piart.impl.PiartServiceImpl;

/**
 * Servlet implementation class PiartServelt
 */
@WebServlet("/PiartServelt")
public class PiartServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //创建一个业务层对象
	private PiartService ps=new PiartServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PiartServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得客户端传递的参数值
		request.setCharacterEncoding("UTF-8");
		String op=request.getParameter("op");
		if("add".contentEquals(op)) {
			//调用增加模块的方法
			savePlant(request,response);
		}else if("show".equals(op)){
			show(request,response);
		}else if("delete".equals(op)) {
			delete(request,response);
		}else if("update".equals(op)) {
			updata(request,response);
		}else if("findId".equals(op)) {
			findId(request,response);
		}else if("deleteAll".equals(op)) {
			deleteAll(request,response);
		}
	}

	private void deleteAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String plateIds=request.getParameter("plateIds");
		PrintWriter out=response.getWriter();
		boolean isOk=ps.deleteAll(plateIds);
		if(isOk) {
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
	}

	private void findId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int plateId=Integer.parseInt(request.getParameter("plateId"));
		Piart piart =ps.findId(plateId);
		if(piart !=null) {
			request.getSession().setAttribute("piart", piart);
			response.sendRedirect("server/piart-edit.jsp");
		}
		
	}

	private void updata(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out =response.getWriter();
		int plateId=Integer.parseInt(request.getParameter("plateId"));
		String plateTitle=request.getParameter("plateTitle");
		String plateMessage=request.getParameter("plateMessage");
		int isEnable=Integer.parseInt(request.getParameter("isEnable"));
		Piart piart=new Piart();
		piart.setPlateId(plateId);
		piart.setPlateTitle(plateTitle);
		piart.setPlateMessage(plateMessage);
		piart.setIsEnable(isEnable);
		boolean isOk=ps.updata(piart);
		if(isOk) {
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int plateId=Integer.parseInt(request.getParameter("plateId"));
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		boolean isOk = ps.delete(plateId);
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Piart> list=ps.show();
		request.getSession().setAttribute("list", list);
		request.getRequestDispatcher("server/piart-list2.jsp").forward(request, response);
	}

	private void savePlant(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置响应的文件类型
		response.setContentType("application/json;charset=UTF-8");
		// 获得表单的提交数据
		String plateTitle=request.getParameter("plateTitle");
		String plateMessage=request.getParameter("plateMessage");
		Piart piart =new Piart(plateTitle,plateMessage);
		boolean isOk=ps.savaPlant(piart);
		PrintWriter pw=response.getWriter();
		if(isOk) {
			pw.write("{\"result\":\"true\"}");
		}else {
			pw.write("{\"result\":\"false\"}");
		}
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
