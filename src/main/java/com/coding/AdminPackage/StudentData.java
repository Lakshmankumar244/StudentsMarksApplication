package com.coding.AdminPackage;
import com.StudentMarks.Faculty.Dao;
import com.StudentMarks.Faculty.Dto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sdata")
public class StudentData extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ResultSet rs;
		try {
			rs = Dao.getStudentData();
			out.println("<style>button{\r\n"
					+ "    margin : 35px 0 30px 0;\r\n"
					+ "    height: 35px;\r\n"
					+ "    width: 100px;\r\n"
					+ "    font-size: 15px;\r\n"
					+ "    color:white;\r\n"
					+ "    outline:none;\r\n"
					+ "    cursor: pointer;\r\n"
					+ "    font-weight: bold;\r\n"
					+ "    background: #1A237E;\r\n"
					+ "    border-radius: 3px;\r\n"
					+ "    border: 1px solid #3949aB;\r\n"
					+ "    transition: .5s;\r\n"
					+ "}</style>");
			out.println("<table border='5' cellpadding='5' cellspacing='5'>");
			
		  out.println("<th>Student ID</th>"
					+ "<th>Student Name</th>"
					+ "<th>Mobile Number</th>"
					+ "<th>Email ID</th>"
					+ "<th>Department</th>"
					+ "<th>Section</th>"
					+"<th>Delete</th>");
		  while(rs.next())
			{		
			
		
			 out.println("<tr>"
			 			+"<td>"+rs.getString(1)+"</td>"
			 			+"<td>"+rs.getString(2)+"</td>"
			 			+"<td>"+rs.getString(3)+"</td>"
			 			+"<td>"+rs.getString(4)+"</td>"
			 			+"<td>"+rs.getString(5)+"</td>"
			 			+"<td>"+rs.getString(6)+"</td>"
			 		   + "<td><a style='text-decoration:none;' href='Sdelete?sid="+rs.getString(1)+"'>Delete</a></td>"
			 	       + "</tr>");
			}
			out.println("</table>");
			 out.println("<a href='AdminstuReg.html'><button>Back</button></a>");
			 out.println("<a href='Logout'><button>Log out</button></a>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
