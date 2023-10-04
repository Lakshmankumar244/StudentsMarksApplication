package com.StudentMarks.Faculty;

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

@WebServlet("/Flogin")
public class FacultyLog extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		String fid=request.getParameter("fid");
		String password=request.getParameter("password");
		
		String username=fid;
		
		HttpSession hp=request.getSession();
		hp.setAttribute("fid", fid);
		
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		Dto dto=new Dto();
			dto.setFid(fid);
			dto.setScode(password);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			ResultSet rs=Dao.facultyLogin(dto);
			if(rs.next())
			{
			RequestDispatcher rd=request.getRequestDispatcher("Facultyservlet");
				rd.forward(request, response);
			}
			else
			{
				out.println("<h1 style='font-size:20px'>Invalid ID or Password</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("Faculty.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
