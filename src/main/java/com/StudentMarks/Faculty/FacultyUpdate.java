package com.StudentMarks.Faculty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Fupdate")
public class FacultyUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
				int om1=Integer.parseInt(request.getParameter("om1"));
				int om2=Integer.parseInt(request.getParameter("om2"));		
				
				HttpSession hp=request.getSession();
				String fid=(String)hp.getAttribute("fid");
				
				HttpSession hp2=request.getSession();
				String sid=(String)hp2.getAttribute("sid");
				
				Dto dto=new Dto();
				
				dto.setOm1(om1);
				dto.setOm2(om2);
				dto.setSid(sid);
				dto.setFid(fid);
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();				

				try {
					
					int rows=Dao.UpdateAll(dto);
					if(rows>0)
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
								+ "<div class=label style='font-size:30px'>Updated Successfully</div><br><br>"
								+ "<img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzJh8m8l9ovAXVIN7gx0cXZ3oGzA--8j6bMw&usqp=CAU.png'><br><br>"
								+ "<a href='Facultyservlet'><button>Back</button></a>"
								+ "</div>"
								+"</body>");
					}
					else
					{
						out.println("Please Try Again");
						RequestDispatcher rd=request.getRequestDispatcher("Eupdate");
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
