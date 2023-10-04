package com.StudentMarks.Faculty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Facultyservlet")
public class FacultySelect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Dto dto =new Dto();
		int x=0;
		HttpSession hp=request.getSession();
		String fid=(String)hp.getAttribute("fid");
		dto.setFid(fid);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {		
		ResultSet rs=Dao.selectAll(dto);
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
			while(rs.next())
			{		
			if(x==0)
			{
			out.println("<b>Subject Name :</b>"+rs.getString(1)
					+"<th>Subject Code</th>"
					+ "<th>Student ID</th>"
					+ "<th>Total Marks(MID 1)</th>"
					+ "<th>Obtaied Marks(MID 1)</th>"
					+ "<th>Total Marks(MID 2)</th>"
					+ "<th>Obtaied Marks(MID 2)</th>"
					+ "<th>Final Marks</th>"
					+"<th>Update</th>");
			x++;
			}
		
			 out.println("<tr>"
			 			+"<td>"+rs.getString(2)+"</td>"
			 			+"<td>"+rs.getString(3)+"</td>"
			 			+"<td>"+rs.getString(4)+"</td>"
			 			+"<td>"+rs.getString(5)+"</td>"
			 			+"<td>"+rs.getString(6)+"</td>"
			 			+"<td>"+rs.getString(7)+"</td>"
			 			+"<td>"+rs.getString(8)+"</td>"
			 		   + "<td><a style='text-decoration:none;' href='Eupdate?sid="+rs.getString(3)+"'>update</a></td>"
			 	       + "</tr>");
			}
			out.println("</table>");
			 out.println("<a href='Faculty.html'><button>Back</button></a>");
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
