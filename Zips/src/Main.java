import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void lookUp(String text) {							// Defining a static function called Lookup
		
		for (int i = 0; i < text.length() ; i++) {						// i = 0 plus i with 1 until the length of the text has run out
			if (text.substring(i, i+1).equals("\\")) { 					// Looks through every character in the line it has been given.
				System.out.print(" Starting on: " + i + " \t ");  		// This prints the position it is currently writing on
				System.out.println(text.substring(i,text.length()));	// This prints out what ever there is Beyond the '\' sign (Which is the raw code we are gonna use)
			}
		}
	}
	
	public static ArrayList<String> listCode(String code) {
		ArrayList<String> chars  = new ArrayList<String>();
		
		for (int i = 0; i < code.length(); i++) {
			chars.add(code.substring(i, i+1));
		}
		return chars;
	}
	
	public static void word(String text, ArrayList<String> code) {  //Should be able to go through a text and find the string until it encounters a /
		
		for (int j = 0; j < text.length(); j++) {
			String str = Character.toString(text.charAt(j));
			
			if (str.equals(code.get(0))) {
				
				for (int i = 0; i < code.size(); i++) {
					System.out.println("i is: "  +i);
					String nextStr = Character.toString(text.charAt(j+i));
					if (!(str.equals(code.get(i)))) {
						System.out.println("Breaking");
						break;
					} else {
						System.out.println("Worked");
					}
					System.out.println("This is nextStr: " + nextStr);
				}
				
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<String> code;
		
		Scanner inFile = null;  			// Makes a new scanner for a file
		try {
		    File file = new File("C:\\Users\\god_k\\Desktop\\_Ee\\Zip\\Ziplov\\Zips\\src\\ff.rtf"); //Makes a new file which is the rtf file
		    inFile = new java.util.Scanner(file);	// Makes a new scanner for the file (So it enables us to use .hasNextLine etc.)
		    String line = null;						// Declares a new string named line, which contains nothing
		    code = listCode("\\f31506");
			   while (inFile.hasNextLine()) {		// Do this while this file still has a new line (Until the document is empty)
			        line = inFile.nextLine();		//  Set the string we just made to the new line our while loop just found
			        word(line, code);
			   		//lookUp(line);					// Calling custom made function Lookup
			        //System.out.println(line);		// Print the line
			        
			   }
			   
		} catch (FileNotFoundException e) { 			// Do this if the program encounters this problem: FileNotFoundException
		    System.out.println("File not found!");		// Print  File not found
		}

	}

}