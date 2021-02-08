import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

	public static void main(String[] args) {
		
	    Connection conn = null;
	    
	    String url = "jdbc:sqlserver://LAPTOP;databasename=Files";
	    
	    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    
	    String userName = ""; 
	    
	    String password = "";
	    
	    Statement stmt;
	    
	    try {
	    
	    Class.forName(driver);
	    
	    conn = DriverManager.getConnection(url,userName,password);
	    
	    System.out.println("OK");
	    
	    } catch(Exception e) {
	    	
	    	System.out.println(e.getMessage());
	    	
	    }
		
	}

}
