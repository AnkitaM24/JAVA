package com.operations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DeleteServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
       
		String sid=request.getParameter("uid");  
		int uid=Integer.parseInt(sid); 
		
		Operations.delete(uid);  
		response.sendRedirect("ViewServlet");  
		
   }  
	
}
