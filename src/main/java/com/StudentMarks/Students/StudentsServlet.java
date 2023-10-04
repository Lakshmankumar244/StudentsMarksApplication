package com.StudentMarks.Students;
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
@WebServlet("/Sselect")
public class StudentsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String sid=request.getParameter("sid");
			
			Dto dto=new Dto();
			dto.setSid(sid);
			
			
			try {
				ResultSet rs=Dao.StudentSelect(dto);
				out.println("<style>button,#inside{\r\n"
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
				int x=0;
				while(rs.next())
				{
					
				if(x==0)
				{
				out.println("<table border='5' align:'center';' cellpadding='5' cellspacing='5'>"
						+ "<th>Subject Name</th>"
						+ "<th>Subject Code</th>"
						+ "<th>Faculty ID</th>"
						+ "<th>Student ID</th>"
						+ "<th>Total Marks(MID 1)</th>"
						+ "<th>Obtaied Marks(MID 1)</th>"
						+ "<th>Total Marks(MID 2)</th>"
						+ "<th>Obtaied Marks(MID 2)</th>"
						+ "<th>Final Marks</th>");
				x++;
				}
			 out.println("<tr>"
				 		   + "<td>"+rs.getString(1)+"</td>"
				 			+"<td>"+rs.getString(2)+"</td>"
				 			+"<td>"+rs.getString(3)+"</td>"
				 			+"<td>"+rs.getString(4)+"</td>"
				 			+"<td>"+rs.getString(5)+"</td>"
				 			+"<td>"+rs.getString(6)+"</td>"
				 			+"<td>"+rs.getString(7)+"</td>"
				 			+"<td>"+rs.getString(8)+"</td>"
				 			+"<td>"+rs.getString(9)+"</td>"
				 		   + "</tr>");
			}
			out.println("</table>");
			out.println("<a href='Student.html'><button>Back</button></a>");
			out.println("<a style='margin:30px;' href='Logout'><button>Log out</button></a>");
			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
