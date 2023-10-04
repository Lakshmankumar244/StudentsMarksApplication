package com.coding.AdminPackage;
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

@WebServlet("/Alogin")
public class AdminLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			Long aid=Long.parseLong(request.getParameter("aid"));
			String password=request.getParameter("password");
			Long username=aid;
			Dto dto=new Dto();
				dto.setAid(aid);
				dto.setPassword(password);
			
			HttpSession session=request.getSession();	
				session.setAttribute("username",username);
				session.setAttribute("password",password);
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			try {
				ResultSet rs=Dao.adminLogin(dto);
				if(rs.next())
				{
					RequestDispatcher rd=request.getRequestDispatcher("AdminstuReg.html");
					rd.forward(request, response);
				}
				else
				{
					out.println("<h1 style='font-size:20px; color:black; margin-top:100px'>Invalid ID or Password</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("AdminLog.html");
					rd.include(request,response);
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
