package EmailAdress;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class EmailAdressGenerate {
	
	public static void readTxt() throws FileNotFoundException {
    
		try (Scanner scanner = new Scanner(new File("src\\EmailAdress\\nevek.txt"))) {
 
			Set<String> emailAdresses = new HashSet<>();
	
	        while (scanner.hasNextLine()) {
	            try (Scanner rowScanner = new Scanner(scanner.nextLine())) {
	            	
	            	String[] user = rowScanner.nextLine().split(" ");
	            	String email = user[0].substring(0, 3).toUpperCase() + "_" + user[1].substring(0, 2).toLowerCase() + "@webler.hu";
	            	int num = 1;
	            	
		            while (emailAdresses.contains(email) ) 
	                	email = user[0].substring(0, 3).toUpperCase() + "_" + user[1].substring(0, 2).toLowerCase() + "_" + String.valueOf(++num) + "@webler.hu";

	            	emailAdresses.add(email);
	            	System.out.println(email);
            	}
        	}
		}
    }
}
