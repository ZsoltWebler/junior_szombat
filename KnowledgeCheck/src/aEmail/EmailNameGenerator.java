package aEmail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailNameGenerator {

	private static String generateUserName(String firstName, String lastName ) {
		

        String beginnigOfEmail = "";

        beginnigOfEmail += firstName.substring(0, 3).toUpperCase();
        beginnigOfEmail += "_";
        beginnigOfEmail += lastName.substring(0, 2).toLowerCase();
                
        return beginnigOfEmail;
        }
   
	private static String nrInsertionToAvoidTheSameEmails(String beginnigOfEmail, List<String> emails ) {
		int same = 0;
		String firmEmail;
		
		for(int i=0; i<emails.size(); i++) {			
			if( emails.get(i).substring(0, 6).equals(beginnigOfEmail)) {
				same++;
			}
		}
		if (same > 0) {
			firmEmail = beginnigOfEmail + Integer.toString(same) + "@webler.hu";
		} else {
			firmEmail = beginnigOfEmail + "@webler.hu";
		}
		
	return firmEmail;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File("src\\aEmail\\nevek.txt"));

		List<String> emails = new ArrayList<>();
		
		
		String[] fulName;
		String firmEmail,beginnigOfEmail;
		
		while (scanner.hasNextLine()) {

			   fulName = scanner.nextLine().split(" ");
			   beginnigOfEmail = generateUserName(fulName[0],fulName[1]);
			   firmEmail = nrInsertionToAvoidTheSameEmails(beginnigOfEmail, emails);
			   emails.add(firmEmail);
			   
		}
		scanner.close();

		
		// Prohahoz a terminalra is kiirattam		
		for ( String email : emails) {
			  System.out.println(email);
		}
		// Prohahoz a terminalra is kiirattam	
		
		try {
			
			FileWriter fw = new FileWriter("src\\aEmail\\emails.txt");
			PrintWriter printWriter = new PrintWriter(fw);
			
			for ( String email : emails) {
				printWriter.println(email);
			}
			printWriter.close();	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
