package com.iceze;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.iceze.model.Property;
import com.iceze.service.BasicTaskManager;
import com.iceze.service.TaskException;
import com.iceze.service.TaskManager;
import com.iceze.util.LoadFromFileUtil;

/**
 * Main Application class.
 * 
 * @author miroslav
 */
public class PropertyApp {
	
	/**
	 * The main method.
	 * 
	 * @param args, String[] 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main( String[] args ) throws IOException {
    	if(args.length < 1) {
            throw new RuntimeException("No path to the input Property Data was provided.");
        }
    	
    	final String propertiesFilePath = args[0];
        
    	final List<Property> properties = LoadFromFileUtil.loadProperties(propertiesFilePath);
    	
    	Scanner scanner = new Scanner(System.in);
    	TaskManager taskManager = new BasicTaskManager();
    	
    	while(true) {
			// prompt for the user's command
		    System.out.print("enter command: ");
		    
		    // get user input 
		    String userInput = scanner.nextLine();
		    String[] arguments = userInput.split(" ");
		    
		    if(arguments.length > 0 && arguments[0].equals("Q")) {
		    	System.out.print("Bye!\n");
				
				// exit the application
				System.exit(0);
		    } else {
			    String displayResult = "";
			    
			    try {
			    	displayResult = taskManager.executeTask(properties, arguments);
			    } catch(TaskException e) {
			    	displayResult = e.getMessage();
			    }
	
			    System.out.println(displayResult);
		    }
		}
    }
}
