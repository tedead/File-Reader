import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

public class Scan extends Database {
	
    static Connection conn = null;
    
    static String url = "jdbc:sqlserver://LAPTOP;databasename=Files";
    
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    static String userName = ""; 
    
    static String password = "";
    
    Statement stmt;
    
	public static void println(String message) {
		
		System.out.println(message);
		
	}

	public static void main(String[] args) {
		

	}
	
	  public static void read(String aInputFileName) {
		  
		println("Reading file: " + aInputFileName);
		
	    File file = new File(aInputFileName);
	    
	    String fileSize = "";
	    
	    try
	    {

	    Class.forName(driver);
	    
	    conn = DriverManager.getConnection(url,userName,password);
	    
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	        
	    }
	    
	    //file.length() is returned as bytes
	    if (file.length() < 1024) {
	    	
	    	fileSize = file.length() + " bytes";
	    	
	    } else if (file.length() >= 1024 && file.length() < 1048576) {
	    	
	    	fileSize = (file.length() / 1024) + " kilobytes";
	    	
	    } else if (file.length() >= 1048576 && file.length() < 1073741824) {
	    	
	    	fileSize = (file.length() / 1024 / 1024) + " megabytes";
	    	
	    } else if (file.length() >= 1073741824) {
	    	
	    	fileSize = (file.length() / 1024 / 1024 / 1024) + " gigabytes";
	    	
	    } else {
	    	
	    	fileSize = "Not determined";
	    	
	    }
	    
	    println("File size: " + fileSize);
	    
	    Date date = new Date(file.lastModified());
	    
	    println("Modified: " + date.toString());
	    
	    println("Readable: " + file.canRead());
	    
	    println("Writeable: " + file.canWrite());
	    
	    println("Executable: " + file.canExecute());
	    
	    println("Hidden: " + file.isHidden());
	    
	    try {
	    	
	      //byte[] result = new byte[(int)file.length()];
	    	
	      //long fileSize = file.length();
	    	
	      InputStream input = null;
	      
	      try {
	    	  
	        //long totalBytesRead = 0;
	        
	        input = new BufferedInputStream(new FileInputStream(file));
	        
	        //while(totalBytesRead < fileSize) {
	        	
	          //long bytesRemaining = (fileSize - totalBytesRead);
	          
	          //input.read() returns -1, 0, or more :
	          //int bytesRead = input.read(fileSize, totalBytesRead, bytesRemaining); 
	          
	          //if (bytesRead > 0) {
	        	  
	            //totalBytesRead = totalBytesRead + bytesRead;
	            
	         // }
	          
	       // }
	        /*
	         the above style is a bit tricky: it places bytes into the 'result' array; 
	         'result' is an output parameter;
	         the while loop usually has a single iteration only.
	        */
	        
	      } finally {
	        
	        input.close();
	        
	      }
	      
	    } catch (Exception ex) {
	    	
	      println("Error: " + ex.getMessage());
	      
	    }
	    
	    //return result;
	    
	  }
	 
}
