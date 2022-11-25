package com.operations;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;   
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  


public class SaveServlet extends HttpServlet {
	
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String fname=request.getParameter("fname");  
	        String lname=request.getParameter("lname");
	        String number=request.getParameter("number");
	        String city=request.getParameter("city");
	        String vreg=request.getParameter("vreg");
	        String make=request.getParameter("make");
	        String model=request.getParameter("model");
	        String fuel=request.getParameter("fuel");
	        String rent=request.getParameter("rent");
	          
	        GetSet e=new GetSet();  
	        e.setFname(fname);
	        e.setLname(lname);
	        e.setNumber(number);
	        e.setCity(city);
	        e.setVreg(vreg);
	        e.setMake(make);
	        e.setModel(model);
	        e.setFuel(fuel);
	        e.setRent(rent);
	          
	        int status=Operations.save(e);  
	        if(status>0){  
	            out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("index.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	    }  
	
	

}
