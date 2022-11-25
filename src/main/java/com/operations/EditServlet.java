package com.operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet{
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException {  
		 
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
	        out.print("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"css/bootstrap.css\"></link>\r\n"
					+ "</head>");
			
			out.print("<nav class=\"navbar navbar-expand-lg p-2 mb-1 bg-dark\">\r\n"
					+ "  		<div class=\"container-fluid\">\r\n"
					+ "    		<a class=\"navbar-brand text-white\" href=\"#\">VR Manage</a>\r\n"
					+ "    		<div class=\"d-flex justify-content-end\" >\r\n"
					+ "	    		<div class=\"p-2\">\r\n"
					+ "	    			<a href=\"index.html\"><button type=\"button\" class=\"btn btn-outline-light \">Add</button></a>\r\n"
					+ "	    		</div>\r\n"
					+ "	    		<div class=\"p-2\">\r\n"
					+ "	    			<a href=\"ViewServlet\"><button type=\"button\" class=\"btn btn-outline-light\">View</button></a>\r\n"
					+ "	    		</div>\r\n"
					+ "			</div>\r\n"
					+ "        </div>\r\n"
					+ "	</nav>");
	        
	        String id=request.getParameter("uid");  
	        int uid=Integer.parseInt(id);  
	          
	        GetSet e=Operations.getEmployeeById(uid);
	        
	        out.print("<div class='container p-2'>"
	        		+ "<div class='d-flex justify-content-center p-4 m-4'>"
	        		+ "<div class='card w-auto'>"
	        		+ "<div class='card-header text-center'><h5 >Details Updation</h5></div>"
	        		+ "<div class='card-body'>"
	        		+ "<form action='EditServlet2' method='post'>"
	        		+ "<table>"
	        		+ "<tr>"
	        		+ "<td colspan='2'>"
	        		+ "<div class='form-floating mb-3'>"
	        		+ "<input name='uid' type='text' class='form-control' value='"+e.getUid()+"' readonly />"
	        		+ "<label>Unique User ID (ReadOnly)</label>"
	        		+ "</div>"
	        		+ "									</td>\r\n"
	        		+"</tr>"
	        		+ "<tr>"
	        		+ "<td>"
	        		+ "<div class='form-floating mb-3'>"
	        		+ "<input name='fname' type='text' class='form-control' value='"+e.getFname()+"'/>"
	        		+ "<label>First Name</label>"
	        		+ "</div>"
	        		+ "									</td>\r\n"
	        		+ "									<td>\r\n"
	        		+ "										<div class=\"form-floating mb-3\">\r\n"
	        		+ "											<input name=\"lname\" type=\"text\" class=\"form-control\" id=\"floatingInput\" value='"+e.getLname()+"'>\r\n"
	        		+ "											<label for=\"floatingInput\">Last Name</label>\r\n"
	        		+ "										</div>\r\n"
	        		+ "									</td>\r\n"
	        		+ "  								</tr>\r\n"
	        		+ "  								\r\n"
	        		+ "  								<tr>\r\n"
	        		+ "  									<td>\r\n"
	        		+ "  										<div class=\"form-floating mb-3\">\r\n"
	        		+ "								<input name=\"number\" type=\"text\" class=\"form-control\" id=\"floatingInput\" value='"+e.getNumber()+"'>\r\n"
	        		+ "								<label for=\"floatingInput\">Mobile No</label>\r\n"
	        		+ "							</div>\r\n"
	        		+ "  									</td>\r\n"
	        		+ "  									<td>\r\n"
	        		+ "  										<div class=\"form-floating mb-3\">\r\n"
	        		+ "								<select name=\"city\" class=\"form-select\">\r\n"
	        				+ "									<option value=\"Pune\">"+e.getCity()+"</option>\r\n"
	        		+ "									<option value=\"Pune\">Pune</option>\r\n"
	        		+ "									<option value=\"Mumbai\">Mumbai</option>\r\n"
	        		+ "									<option value=\"Nashik\">Nashik</option>\r\n"
	        		+ "								</select>\r\n"
	        		+ "								<label for=\"floatingInput\">City</label>\r\n"
	        		+ "							</div>\r\n"
	        		+ "  									</td>\r\n"
	        		+ "  								</tr>\r\n"
	        		+ "  								\r\n"
	        		+ "  								<tr>\r\n"
	        		+ "  									<td colspan=\"2\"><div class=\"form-floating mb-3\">\r\n"
	        		+ "								<input name=\"vreg\" type=\"text\" class=\"form-control\" id=\"floatingInput\" value='"+e.getVreg()+"'>\r\n"
	        		+ "								<label for=\"floatingInput\">Vehicle Reg. No</label>\r\n"
	        		+ "							</div>	</td>\r\n"
	        		+ "  								</tr>\r\n"
	        		+ "  								\r\n"
	        		+ "  								<tr>\r\n"
	        		+ "  									<td>\r\n"
	        		+ "  										<div class=\"form-floating mb-3\">\r\n"
	        		+ "											<input name=\"make\" type=\"text\" class=\"form-control\" id=\"floatingInput\" value='"+e.getMake()+"'>\r\n"
	        		+ "											<label for=\"floatingInput\">Make</label>\r\n"
	        		+ "										</div>\r\n"
	        		+ "									</td>\r\n"
	        		+ "									<td>\r\n"
	        		+ "										<div class=\"form-floating mb-3\">\r\n"
	        		+ "											<input name=\"model\" type=\"text\" class=\"form-control\" id=\"floatingInput\" value='"+e.getModel()+"'>\r\n"
	        		+ "											<label for=\"floatingInput\">Model</label>\r\n"
	        		+ "										</div>\r\n"
	        		+ "									</td>\r\n"
	        		+ "  								</tr>\r\n"
	        		+ "  								\r\n"
	        		+ "  								<tr>\r\n"
	        		+ "  									<td>\r\n"
	        		+ "  										<div class=\"form-floating mb-3\">\r\n"
	        		+ "								<select name=\"fuel\" class=\"form-select\">\r\n"
	        		+ "									<option value=\"Petrol\">"+e.getFuel()+"</option>\r\n"
+ "									<option value=\"Petrol\">Petrol</option>\r\n"
	        		+ "									<option value=\"Diesel\">Diesel</option>\r\n"
	        		+ "									<option value=\"Electric\">Electric</option>\r\n"
	        		+ "								</select>\r\n"
	        		+ "								<label for=\"floatingInput\">Fuel Type</label>\r\n"
	        		+ "							</div>\r\n"
	        		+ "									</td>\r\n"
	        		+ "									<td>\r\n"
	        		+ "										<div class=\"form-floating mb-3\">\r\n"
	        		+ "								<select name=\"rent\" class=\"form-select\">\r\n"
	        		+ "								<option value="+e.getRent()+">&#"+e.getRent()+"</option>\r\n"
	        		+ "								<option value='9989 Yes'>&#9989 Yes</option>\r\n"
	        		+ "									<option value='128683 No'>&#128683 No</option>\r\n"
	        		+ "								</select>\r\n"
	        		+ "								<label for=\"floatingInput\">Available for Rent</label>\r\n"
	        		+ "							</div>"
	        		+ "									</td>\r\n"
	        		+ "  								</tr>\r\n"
	        		+ "  								\r\n"
	        		+ "  								<tr>\r\n"
	        		+ "  								<td colspan=\"2\">\r\n"
	        		+ "  								<div class=\"form-floating mb-3\"><button type=\"submit\" class=\"btn btn-success\">Edit & Save</button></div></td>\r\n"
	        		+ "  								</tr>\r\n"
	        		+ "  							\r\n"
	        		+ "  							</table>\r\n"
	        		+ "						</form>\r\n"
	        		+ "  					</div>\r\n"
	        		+ "			</div>\r\n"
	        		+ "		</div>\r\n"
	        		+ "	</div>\r\n"
	        		+ "</body>\r\n"
	        		+ "</html>");
	          
	        out.close();  
	    }  

}
