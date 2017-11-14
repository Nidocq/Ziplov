package Zipa;

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.*;

	public class Main {
		
		/*
		public static int lookUpPos(String text, String code) {							
			int posi = 0;
			int g = 0;
			for (int i = 0; i < text.length() ; i++) {						
			String str = Character.toString(text.charAt(i));
				if (str.equals(code)) { 					
					posi = i;
				} else {
					g++;
				}
				if (g == text.length()) {
					System.out.println("Nothing found");
					return 0;
				}
			}
			System.out.println("Resturning pos: " + posi);
			return posi;
			
		}
		
		*/
			
		public static ArrayList<String> listCode(String code) {
			ArrayList<String> chars  = new ArrayList<String>();
			
			for (int i = 0; i < code.length(); i++) {
				chars.add(code.substring(i, i+1));
			}
			return chars;
		}
		
		public static int findWord(String text, ArrayList<String> code) { 
			int times = 0;
			try {
				int codelen = code.size();
				System.out.println("Text length: " + text.length());
				for (int j = 0; j < text.length(); j++) {  // LOOPS THROUGH THE WHOLE TEXT
					
					String str = Character.toString(text.charAt(j)); // NEXT STRING
					System.out.println(str);
					if (j<code.size()-(code.size()-1)) { // fIND THE FIRST LETTER IN THE TEXT WHICH HAS TO BE THE FIRST LETTER OF THE CODE
						if (str.toLowerCase().equals(code.get(1))) { // SEARCH THE FIRST LETTER WHICH IS BESIDES THE NULL OF THE START OF THE TEXT
							codelen = 0;
							
							for (int i = 0; i < code.size()-1; i++) { // FOUND FIRST LETTER, NOW SEARCH THE REST
								int jpi = j+i; 
								String nextStr = Character.toString(text.charAt(jpi));
								if (nextStr.equals(".")||nextStr.equals("?")||nextStr.equals("!")) {
									codelen += 1;
									System.out.println("Increasing codelen by 1, occuring in '?', '!', '.'");
								}	
								if (!(nextStr.toLowerCase().equals(code.get(i+1)))) {
									break;
								} else {
									codelen += 1;
									System.out.println("codelen increased by 1 in ex loop");
								}												
							}
							
							if (codelen == code.size()-1) {
								times += 1;
								System.out.println("Times: " + times);
							}	
						}
						
				} else {
					
					if (str.toLowerCase().equals(code.get(0))) { // SEARCH THE FIRST LETTER 
						System.out.println("Found first letter which is: " + "\'"+str+"\'" + " " + "\'"+code.get(0)+"\'");
						codelen = 0;
						
						for (int i = 0; i < code.size(); i++) { // FOUND FIRST LETTER, NOW SEARCH THE REST
							
							int jpi = j+i; 
							String nextStr = Character.toString(text.charAt(jpi));
							System.out.println("Setting nextStr to: " + text.charAt(jpi) + " jpi");
							System.out.println("Looking for the rest: " + "\'"+nextStr+"\'" + " " + "\'"+code.get(i)+"\'"+ "\t j: " + j + " \t i: " + i);
							if (code.get(code.size() -1).equals(".")||code.get(code.size() -1).equals("?")||code.get(code.size() -1).equals("!")) { // Or a punctuation or null
								System.out.println("WORRRRKSSSS--------");
								codelen += 1;
								System.out.println();
							}
							System.out.println("statement" + !nextStr.equals((code.size())-1)); // outputs true, make statement of this

							if (nextStr.equals(".")||nextStr.equals("?")||nextStr.equals("!")) {
								codelen += 1;
								System.out.println("Increasing codelen by 1, occuring in '?', '!', '.'");
								
							}
							// MAKE THEPROGRAM THE LAST CHARACTER IF THE .=! DO 
							// if the last character in the code is equal to a ".", "?", "!". then give it a codelen
							
							if (!(nextStr.toLowerCase().equals(code.get(i)))) {
								break;
							} else {
								codelen += 1;
								System.out.println("Codelen increased by 1: " + codelen);
							}												
						}
						System.out.println("checking");
						System.out.println(code.size() + " " + codelen);
						if (codelen == code.size()) {
							times += 1;
							System.out.println("Times: " + times);
						}
						System.out.println("code-1" + "'" +code.get(code.size() -1) + "'");										
					}
					}
				}
				
			} catch (java.lang.StringIndexOutOfBoundsException e) { //java.lang.StringIndexOutOfBoundsException
				times += 1;
				System.out.println("Times caused by exception");
			}
			return times;
		}
							
		public static void ooo(String text, String code) {
			
			
			String space = " ";
			String word = code;
			String whole_word = space+word+space;
			
			System.out.println("WHOLEWOELDDDD" + whole_word);
			
			number += findWord(text, listCode(whole_word));
			
			System.out.println("Ordet '" + code + "' forekommer " + number + " gang(e)");
		}
		
		
		public static void main(String[] args) {
			
			Scanner inFile = null;  			
			try {

				java.util.ArrayList ls = new java.util.ArrayList();
			    File file = new File("C:\\Users\\god_k\\Desktop\\Projects\\Java\\src\\Zipa\\mother.txt"); //Makes a new file which is the rtf file
			    inFile = new java.util.Scanner(file);	// Makes a new scanner for the file (So it enables us to use .hasNextLine etc.)
			    String line = null;						// Declares a new string named line, which contains nothing
			    
				   while (inFile.hasNextLine()) {		// Do this while this file still has a new line (Until the document is empty)
				        line = inFile.nextLine();		//  Set the string we just made to the new line our while loop just found
				        System.out.println(line);		// Print the line
				        og += findWord(line, listCode(" og "));
				        det += findWord(line, listCode(" det "));
				        jeg += findWord(line, listCode(" jeg "));
				        er += findWord(line, listCode(" er "));
				        
				        System.out.println("Ordet 'og' bliver kaldt: " + og);
				        System.out.println("Ordet 'det' bliver kaldt: " + det);
				        System.out.println("Ordet 'jeg' bliver kaldt: " + jeg);
				        System.out.println("Ordet 'er' bliver kaldt: " + er);
				        
				   } 
			} catch (FileNotFoundException e) {				// Do this if the program encounters this problem: FileNotFoundException
			    System.out.println("File not found!");		// Print  File not found
			}
		}
	}
