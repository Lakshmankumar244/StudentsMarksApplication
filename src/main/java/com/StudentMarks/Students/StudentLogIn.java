package com.StudentMarks.Students;
import com.StudentMarks.Faculty.Dto;
import com.StudentMarks.Faculty.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Slogin")
public class StudentLogIn extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			String sid=request.getParameter("sid");
			String mobile=request.getParameter("mobile");
			String username=sid;
			String password=mobile;
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password",password);
			
			Dto dto=new Dto();
			dto.setSid(sid);
			dto.setMobile(mobile);
			
			try {
				ResultSet rs=Dao.studentLogin(dto);
				if(rs.next())
				{
					RequestDispatcher rd=request.getRequestDispatcher("Sselect");
					rd.forward(request, response);
				}
				else
				{
					out.println("<h1 style='font-size:20px' >Invalid Username or password</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("Student.html");
					rd.include(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
