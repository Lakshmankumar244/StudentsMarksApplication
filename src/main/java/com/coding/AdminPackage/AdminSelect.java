package com.coding.AdminPackage;
import com.StudentMarks.Faculty.*;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Aselect")
public class AdminSelect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
		
			ResultSet rs=Dao.adminSelect();
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
			out.println("<table border='5' cellpadding='10' cellspacing='10'>"
					   +"<th>Subject Name</th>"
					   +"<th>Subject Code</th>"
					   +"<th>Student ID</th>"
					   +"<th>Total Marks(MID-1)</th>"		   
					   +"<th>Obtained Marks(MID-1)</th>"		
					   +"<th>Total Marks(MID-2)</th>"
					   +"<th>Obtained Marks(MID-2)</th>"
					   +"<th>Final Marks</th>");
			while(rs.next())
			{
				out.println("<tr>"
						+"<td>"+rs.getString(1)+"</td>"
						+"<td>"+rs.getString(2)+"</td>"
						+"<td>"+rs.getInt(3)+"</td>"
						+"<td>"+rs.getInt(4)+"</td>"
						+"<td>"+rs.getInt(5)+"</td>"
						+"<td>"+rs.getInt(6)+"</td>"
						+"<td>"+rs.getInt(7)+"</td>"
						+"<td>"+rs.getInt(8)+"</td></tr>");
			}
			out.println("</table>");
			out.println("<a id='space' href='AdminstuReg.html'><button>Back</button>");
			out.println("<a href='Logout'><button>Log out</button>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
