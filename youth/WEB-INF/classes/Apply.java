package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Apply extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String company=request.getParameter("t1").trim();
	HttpSession session=request.getSession();
	String id = session.getAttribute("user").toString();
	try{
		String msg = DBConnection.apply(company,id);
		if(msg.equals("success")){
			RequestDispatcher rd=request.getRequestDispatcher("SearchJob.jsp?t1=Successfully applied for selected job");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("SearchJob.jsp?t1="+msg);
			rd.forward(request, response);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
