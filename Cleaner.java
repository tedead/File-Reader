import java.io.File;


public class Cleaner extends Scan {
	
	static long fileCount = 0;

	public static void println(String message) {
		
		System.out.println(message);
		
	}

	public static void main(String[] args) {
		
		try {
		
	        for (int x = 0; x < args.length; x++) {
	        	
	    		printList(args[0] + "\\", args[x + 1]);
	    		
	    		println("Count of " + args[x + 1] + " files: " + fileCount);
	            
	        }
		
		} catch(Exception e) {
			
			
		}

	
	}
	
	public static void printList(String dir, String ext) {
		
		//Scan the root directory for initial files and directories
		File[] faFiles = new File(dir).listFiles();
		
		if (faFiles != null) {
		
			for(File file: faFiles) {
			    
				if(file.isDirectory()) {
			    	
					printList(file.getAbsolutePath(), ext);
					      
				} else {
					
					String fName = file.getName();
					
					int pos = fName.lastIndexOf(".");
					
					if (pos > 0) {
						
					    fName = fName.substring(pos + 1);
					    
					}
					
					if (fName.toLowerCase().equals(ext)) {

						println(file.getAbsolutePath());
						
						read(file.getAbsolutePath());
							
						fileCount++;
					
					}
					
				}
				
				
			}
		
		}
		
	}

}
