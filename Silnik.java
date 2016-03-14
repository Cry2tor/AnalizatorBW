package bw;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Silnik {
	
	static String token1 = "";

	
	public String getItem(String[][] kombinacje, String item2, String item1)
	{
		String zmienna = null;
		String zmienna2 = null;
		for(int i = 0; i < 30; ++i){
			zmienna = kombinacje[i][0];
			zmienna2 = kombinacje[i][1];
			System.out.println(zmienna);
			System.out.println(zmienna2);
			System.out.println(item2);
			System.out.println(item1);
			System.out.println(item1.equalsIgnoreCase(zmienna));
			System.out.println(item1.contentEquals(zmienna));
			System.out.println(zmienna.compareTo(item1));
			if(item1.equalsIgnoreCase(zmienna) == true ){
				if(item2.equalsIgnoreCase(zmienna2) == true){
					zmienna = kombinacje[i][2];	
					break;
				}
			}
			else
			zmienna = "nie znaleziono";
		}
		return zmienna;
	}
	
	public String[][] getValue(String[][] kombinacje) throws FileNotFoundException{
		Scanner inputStream = null;
		 

		try{
			InputStream in = GUI.class.getClassLoader().getResourceAsStream("kombinacjeHelm");
		    
		    Scanner scan = new Scanner(in);
		    inputStream = scan;
		    
		    } catch(Exception e){
		    	System.out.println("nie daĹ‚o rady pobraÄ‡ do zmiennej");  
		}
        
		kombinacje = new String[345][3];
	    for (int row = 0; row < 342; row++) {
            for (int column = 0; column < 3; column++) {
            		 token1 = inputStream.nextLine();
            		 kombinacje[row][column] = token1;
            		 System.out.println(kombinacje[row][0]);
            }
        }
        inputStream.close();
        
		return kombinacje;
	}
}
