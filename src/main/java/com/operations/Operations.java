package com.operations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operations {
	
	/* Connection Method */
	
	public static Connection getConnection(){  
		Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vrdata","root","");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	}  
	
	/* Save Operation */
	
	    public static int save(GetSet e){  
	        int status=0;  
	        try{  
	            Connection con=Operations.getConnection(); 
	            
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into addvr(fname, lname, number, city, vreg, make, model, fuel, rent) values (?,?,?,?,?,?,?,?,?)");  
	            
	            ps.setString(1,e.getFname()); 
	            ps.setString(2,e.getLname()); 
	            ps.setString(3,e.getNumber()); 
	            ps.setString(4,e.getCity()); 
	            ps.setString(5,e.getVreg()); 
	            ps.setString(6,e.getMake()); 
	            ps.setString(7,e.getModel()); 
	            ps.setString(8,e.getFuel()); 
	            ps.setString(9,e.getRent()); 
	            
	            status=ps.executeUpdate();  
	              System.out.println("Runing2");
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    
	    /* Search Record */
	    
	    //Assign column name method
	    
	    public static String vali(String coln) {
	    	String column = null;
	    	String f1="fname", f2="lname", f3="number", f4="city", f5="vreg", f6="make", f7="model", f8="fuel", f9="rent";
	    	
	    	if(coln.equals(f1)) {
	    		column=f1;
	    	}
	    	else if (coln.equals(f2)) {
	    		column=f2;
			} 
	    	else if (coln.equals(f3)) {
	    		column=f3;
			}
	    	else if (coln.equals(f4)) {
	    		column=f4;
			}
	    	else if (coln.equals(f5)) {
	    		column=f5;
			}
	    	else if (coln.equals(f6)) {
	    		column=f6;
			}
	    	else if (coln.equals(f7)) {
	    		column=f7;
			}
	    	else if (coln.equals(f8)) {
	    		column=f8;
			}
	    	else if (coln.equals(f9)) {
	    		column=f9;
			}
	    	
	    	else {
				column="error";
			}
			return column;
	    	

	    }
	    
	    public static List<GetSet> search(String search, String col){  
	        List<GetSet> list=new ArrayList<GetSet>();  
	        
	        try{  
	        	
	        	String s=Operations.vali(col);
	        	
	            Connection con=Operations.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from addvr where "+s+" Like ?"); 

	            ps.setString(1,'%' +search+'%');
	            
	            System.out.println("Record Searched");
	            System.out.println(s);
	            System.out.println(search);
	            
	            
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	GetSet e=new GetSet();  
	                e.setUid(rs.getInt(1));  
	                e.setFname(rs.getString(2));  
	                e.setLname(rs.getString(3));
	                e.setNumber(rs.getString(4));
	                e.setCity(rs.getString(5));
	                e.setVreg(rs.getString(6));
	                e.setMake(rs.getString(7));
	                e.setModel(rs.getString(8));
	                e.setFuel(rs.getString(9));
	                e.setRent(rs.getString(10));
	               
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
	    
	    
	    
	    
	    public static List<GetSet> getAllEmployees(){  
	        List<GetSet> list=new ArrayList<GetSet>();  
	          
	        try{  
	            Connection con=Operations.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from addvr");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	GetSet e=new GetSet();  
	                e.setUid(rs.getInt(1));  
	                e.setFname(rs.getString(2));  
	                e.setLname(rs.getString(3));
	                e.setNumber(rs.getString(4));
	                e.setCity(rs.getString(5));
	                e.setVreg(rs.getString(6));
	                e.setMake(rs.getString(7));
	                e.setModel(rs.getString(8));
	                e.setFuel(rs.getString(9));
	                e.setRent(rs.getString(10));
	               
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	    
	    public static int update(GetSet e){  
	        int status=0;  
	        try{  
	            Connection con=Operations.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update addvr set fname=?, lname=?,number=?, city=?, vreg=?, make=?, model=?, fuel=?, rent=? where uid=?");  
	             
	            ps.setString(1,e.getFname());  
	            ps.setString(2,e.getLname());
	            ps.setString(3,e.getNumber());
	            ps.setString(4,e.getCity());
	            ps.setString(5,e.getVreg());
	            ps.setString(6,e.getMake());
	            ps.setString(7,e.getModel());
	            ps.setString(8,e.getFuel());
	            ps.setString(9,e.getRent());
	            ps.setInt(10,e.getUid()); 
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    
	    public static GetSet getEmployeeById(int uid){  
	    	GetSet e=new GetSet();  
	          
	        try{  
	            Connection con=Operations.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from addvr where uid=?");  
	            ps.setInt(1,uid);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setUid(rs.getInt(1));  
	                e.setFname(rs.getString(2));  
	                e.setLname(rs.getString(3)); 
	                e.setNumber(rs.getString(4));
	                e.setCity(rs.getString(5));
	                e.setVreg(rs.getString(6));
	                e.setMake(rs.getString(7));
	                e.setModel(rs.getString(8));
	                e.setFuel(rs.getString(9));
	                e.setRent(rs.getString(10));
	                
 
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    
	    
	    /* Delete Operation */
	    
	    public static int delete(int uid){  
	        int status=0;  
	        try{  
	            Connection con=Operations.getConnection();  
	           
	            PreparedStatement ps=con.prepareStatement("delete from addvr where uid=?");  
	            
	            ps.setInt(1,uid);
	            
	            status=ps.executeUpdate();  
	              
	            con.close(); 
	            
	        }catch(Exception e){e.printStackTrace();}  
	        
	        return status;  
	    }

		public static List<GetSet> getSortRent() {
			
			 List<GetSet> list=new ArrayList<GetSet>();  
		        
		        try{  
		        	
		        	
		            Connection con=Operations.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from addvr where rent='9989 Yes'"); 
   
		            System.out.println("Record Searched");
		            
		            
		            ResultSet rs=ps.executeQuery();  
		            while(rs.next()){  
		            	GetSet e=new GetSet();  
		                e.setUid(rs.getInt(1));  
		                e.setFname(rs.getString(2));  
		                e.setLname(rs.getString(3));
		                e.setNumber(rs.getString(4));
		                e.setCity(rs.getString(5));
		                e.setVreg(rs.getString(6));
		                e.setMake(rs.getString(7));
		                e.setModel(rs.getString(8));
		                e.setFuel(rs.getString(9));
		                e.setRent(rs.getString(10));
		               
		                list.add(e);  
		            }  
		            con.close();  
		        }catch(Exception e){e.printStackTrace();}  
		          
			
			return list;
		}  

		
		public static int count(){  
	        int count=0;  
	        try{  
	            Connection con=Operations.getConnection();  
	            GetSet e=new GetSet();
	            
	            PreparedStatement ps=con.prepareStatement("select count(*) from addvr");  
	            ResultSet rs=ps.executeQuery();
	            rs.next();
	            
	            count = rs.getInt(1);
	            
	            con.close(); 
	            
	        }catch(Exception e){e.printStackTrace();}  
	        
	        return count;  
	    }
		
		public static int countRent(){  
	        int count=0;  
	        try{  
	            Connection con=Operations.getConnection();  
	            GetSet e=new GetSet();
	            
	            PreparedStatement ps=con.prepareStatement("select count(*) from addvr where rent='9989 Yes'");  
	            ResultSet rs=ps.executeQuery();
	            rs.next();
	            
	            count = rs.getInt(1);
	            
	            con.close(); 
	            
	        }catch(Exception e){e.printStackTrace();}  
	        
	        return count;  
	        
	        
	    }
		
		public static int countRentNot(){  
	        int count=0;  
	        try{  
	            Connection con=Operations.getConnection();  
	            GetSet e=new GetSet();
	            
	            PreparedStatement ps=con.prepareStatement("select count(*) from addvr where rent='128683 No'");  
	            ResultSet rs=ps.executeQuery();
	            rs.next();
	            
	            count = rs.getInt(1);
	            
	            con.close(); 
	            
	        }catch(Exception e){e.printStackTrace();}  
	        
	        return count;  
	    }
		
		

}
