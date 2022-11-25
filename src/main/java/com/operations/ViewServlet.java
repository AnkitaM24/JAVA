package com.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();   
      
		List<GetSet> list=Operations.getAllEmployees(); 
		
//		Operations op = new Operations();
        
        
		
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
		
		out.print("<div class=\"container p-2\">\r\n"
				+ "	  \r\n"
				+ "<!-- Add Vehicle Details Form --> \r\n"
				+ "		<div class=\"d-flex justify-content-center p-4 m-4 \">\r\n"
				+ "			<div class=\"card w-100\">\r\n"
				+ "				<div class=\"card-header text-center\"><h5 >Registered Vehicle Records</h5></div>\r\n"
				+ "  					<div class=\"card-body\">\r\n"
				
				+ "<div class='d-flex justify-content-evenly'>"
				+ "<div class=\"mb-4 text-center\">\r\n"
				+ "<table >"
				+ "<tr class='p-2 table-primary'>"
				+ "<td class='p-3'>Total Records:</td>"
				+ "<td class=\"text-bg-primary p-2 h4 rounded-5\"> "+Operations.count()+" </td>"
				+ "<td class='p-3'>Avaialable For Rent:</td>"
				+ "<td class=\"text-bg-success  p-2 h4 rounded-5\"> "+Operations.countRent()+" </td>"
				+ "<td class='p-3'>Not Avaialable for Rent:</td>"
				+ "<td class=\"text-bg-warning  p-2 h4 rounded-5\"> "+Operations.countRentNot()+" </td>"
				+ "</tr>"
				+ "</table>"
				+ ""
				+ "</div>\r\n"
				+ "</div>"
				
				
				+ "<table>"


				+ "<tr>\r\n"
				+"<form method='post' action='SearchServlet'>"
				+ "<td>"
				+ "  										<div class=\"form-floating mb-3\">\r\n"
				+ "											<select name=\"col\" class=\"form-select\">\r\n"
				+ "												<option value=\"fname\">First Name</option>\r\n"
				+ "												<option value=\"lname\">Last Name</option>\r\n"
				+ "												<option value=\"number\">Mobile</option>\r\n"
				+ "												<option value=\"city\">City</option>\r\n"
				+ "												<option value=\"vreg\">Vehicle Reg.</option>\r\n"
				+ "												<option value=\"make\">Make</option>\r\n"
				+ "												<option value=\"model\">Model</option>\r\n"
				+ "												<option value=\"fuel\">Fuel</option>\r\n"
				+ "												<option value=\"rent\">Avail on Rent</option>\r\n"
				+ "											</select>\r\n"
				+ "											<label for=\"floatingInput\">Search Type</label>\r\n"
				+ "										</div>\r\n"
				+ "</td>"
				+ "<td>"
				+ "<div class='form-floating mb-3 w-auto'>"
				+ "<input name=\"search\" type=\"text\" class=\"form-control\" id=\"floatingInput\" placeholder=\"First Name\">\r\n"
				+ "<label for=\"floatingInput\">Search Input</label>"
				+ "</div>"
				+ "<td>\r\n"
				+ "<div class='form-floating mb-3 p-2'>\r\n"
				+ "<button type=\"submit\" class=\"btn btn-success\">Search</button>\r\n"
				+ "</div>\r\n"
				+ "</td>"
				+ "</form>"
				+ "<td>\r\n"
				+ "  										<div class=\"form-floating mb-3\">\r\n"
				+ "  											<a href='sortrent'><button type=\"submit\" class=\"btn btn-outline-primary\" >Sort By Avail Rent</button></a>\r\n"
				+ "  										</div>\r\n"
				+ "  									</td>"

				+ "</tr>"
				+ "</table>"
				

				
				
				+ "  						<table class=\"table\">\r\n"
				+ "  <thead>\r\n"
				+ "    <tr class=\"table-dark\">\r\n"
				+ "      <th scope=\"col\">#</th>\r\n"
				+ "      <th scope=\"col\">First</th>\r\n"
				+ "      <th scope=\"col\">Last</th>\r\n"
				+ "      <th scope=\"col\">Mobile</th>\r\n"
				+ "      <th scope=\"col\">City</th>\r\n"
				+ "      <th scope=\"col\">Vehicle Reg.</th>\r\n"
				+ "      <th scope=\"col\">Make</th>\r\n"
				+ "      <th scope=\"col\">Model</th>\r\n"
				+ "      <th scope=\"col\">Fuel</th>\r\n"
				+ "      <th scope=\"col\">Avail for Rent</th>\r\n"
				+ "      <th scope=\"col\">Edit</th>\r\n"
				+ "      <th scope=\"col\">Delete</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>");

    for(GetSet e:list){  
     out.print("<tbody>\r\n"
     		+ "    <tr>\r\n"
     		+ "      <th scope=\"row\">"+e.getUid()+"</th>\r\n"
     		+ "      <td>"+e.getFname()+"</td>\r\n"
     		+ "      <td>"+e.getLname()+"</td>\r\n"
     		+ "      <td>"+e.getNumber()+"</td>\r\n"
     		+ "      <td>"+e.getCity()+"</td>\r\n"
     		+ "      <td>"+e.getVreg()+"</td>\r\n"
     		+ "      <td>"+e.getMake()+"</td>\r\n"
     		+ "      <td>"+e.getModel()+"</td>\r\n"
     		+ "      <td>"+e.getFuel()+"</td>\r\n"
     		+ "      <td>&#"+e.getRent()+"</td>\r\n"
     		+ "      <td><a  href='EditServlet?uid="+e.getUid()+"'>Edit</a></td>\r\n"
     		+ "      <td><a class=\"text-danger\" href='DeleteServlet?uid="+e.getUid()+"'>Delete</a></td>\r\n"
     		+ "    </tr>\r\n"
     		+ "  </tbody>");
     

    }  
    out.print("</table>");  
    
    
      
    out.close();  
}  

	}
