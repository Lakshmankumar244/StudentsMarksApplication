package com.coding.AdminPackage;
import com.StudentMarks.Faculty.Dto;
import com.StudentMarks.Faculty.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin")
public class AdminRegistration extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		
		String sid=request.getParameter("sid");
		String stuname=request.getParameter("stuname");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String dept=request.getParameter("dept");
		String sec= request.getParameter("sec");
		Dto dto=new Dto();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		dto.setSid(sid);
		dto.setStuname(stuname);
		dto.setMobile(mobile);
		dto.setEmail(email);
		dto.setDept(dept);
		dto.setSec(sec);
		
		try {
			int rows1=Dao.AdminStuRegistration(dto);
			int rows2=Dao.AdminStuRegistration2(dto);
			if(rows1>0 && rows2>0)
			{
				out.println("<style>body{"
						+ "	justify-content:center;"
						+ "	align-items:center;"
						+ "	display: flex;"
						+ "    font-family:sans-serif;"
						+ "     text-align: center;"
						+ "}"
						+ ".container{"
						+ "	 position: relative;"
						+ "    margin-top: 100px;"
						+ "    width: 450px;"
						+ "    height:auto;"
						+ "    background:#fff;"
						+ "    border-radius: 5px;"
						+ "    text-align:center;"
						+ "}"
						+ ".lablel{"
						+ "	  padding: 20px 130px;"
						+ "    font-size: 30px;"
						+ "    font-weight: bold;"
						+ "    color:#130f40;"
						+ "}"
						+"button{"
						+ "    margin : 35px 0 30px 0;"
						+ "    height: 35px;"
						+ "    width: 100px;"
						+ "    font-size: 15px;"
						+ "    color:white;"
						+ "    outline:none;"
						+ "    cursor: pointer;"
						+ "    font-weight: bold;"
						+ "    background: #1A237E;"
						+ "    border-radius: 3px;"
						+ "    border: 1px solid #3949aB;"
						+ "    transition: .5s;"
						+ "}"
						+"</style>");
				out.println("<body>"
						+"<div class=container>"
						+ "<div class=label style='font-size:30px'>Registered Successfully</div><br><br>"
						+ "<img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzJh8m8l9ovAXVIN7gx0cXZ3oGzA--8j6bMw&usqp=CAU.png'><br><br>"
						+ "<a href='AdminstuReg.html'><button>Back</button></a>"
						+ "</div>"
						+"</body>");
				
			}
			else
			{
				out.println("<div style='font-size:20px'>Please Try Again</div>");
				RequestDispatcher rd=request.getRequestDispatcher("AdminstuReg.html");
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
