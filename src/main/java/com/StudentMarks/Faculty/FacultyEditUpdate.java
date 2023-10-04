package com.StudentMarks.Faculty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Eupdate")
public class FacultyEditUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			HttpSession hp=request.getSession();
			String fid=(String)hp.getAttribute("fid");	
			
			String sid=request.getParameter("sid");
			
			HttpSession hp2=request.getSession();
			hp2.setAttribute("sid", sid);
			
			Dto dto=new Dto();
				
				dto.setSid(sid);
				dto.setFid(fid);
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			try {
				ResultSet rs = Dao.selectRecord(dto);
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
			out.println("<table border Style='border-collapse:collapse' cellpadding='10' cellspacing='10'>");			  
			if(rs.next())
			{		  
			out.println("<b>Student ID : </b>"+rs.getString(1)
					   +"&nbsp&nbsp&nbsp&nbsp&nbsp<b>Faculty ID : </b>"+rs.getString(7));
				out.println("<table border='5' cellpadding='5' cellspacing='5'>");
			    out.println("<form name='form1' action='Fupdate' method='get'>"
						  + "</tr>"
			    		  + "<td>Obtained Marks(MID-1) :</td>"
						  + "<td><input type='text' name='om1' value='"+rs.getInt(3) +"'></td>"
						  + "</tr>"
						  + "<td>Obtained Marks(MID-2) :</td>"
						  + "<td><input type='text' name='om2'value='"+rs.getInt(5)+"'></td>"
						  + "</tr>"
						  + "</table>"
						  + "<input id='inside' type='submit' value='submit'>"
						  +"&nbsp&nbsp&nbsp&nbsp&nbsp"
						  + "<input id='inside' type='reset' value='cancel'>"
						  +"&nbsp&nbsp&nbsp&nbsp&nbsp"
						  +"<a href='Facultyservlet'><button>Back</button></a>"
						  + "</form> ");
			    
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
