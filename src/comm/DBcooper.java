package comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBcooper {
	 Connection ct = null;  
     Statement  sm = null;  
     ResultSet rs = null;  
     
     
 public void dbinit()//初始化数据库
 {                      
	 String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 String url="jdbc:sqlserver://192.1.0.61:34313;databaseName=DSENIC";
	 String dbname="sa";
	 String dbpassword="DSESQL2008";
 
	//  连接数据库
	  try{
	   Class.forName(driver).newInstance();
	   ct=DriverManager.getConnection(url,dbname,dbpassword);
	   sm=ct.createStatement();
	  }
	  catch(Exception ex){
	   System.out.println(ex);
	  }	 
	 
 }   
   
 public ResultSet getResult()  
 {  
       
     try  
     {  
         String sql1="use DSENIC;select * from dse_userinfo";  
         Statement stm=ct.createStatement();  
         ResultSet rs=stm.executeQuery(sql1);  
         return rs;  
     }  
     catch(Exception ex)  
     {  
           
     }  
     return null;  
 }  
 
 
 
     
}
