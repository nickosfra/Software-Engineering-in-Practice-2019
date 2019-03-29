package metricsCalculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/***
 * 
 * @author nickosfra The purpose of this static class is to read a file and write in another one.
 *
 */

public class fileIOUtilities {
	
	public FileInputStream readFile(String p) {
		FileInputStream in = null;
		
		try {
			in = new FileInputStream(p);			
		} catch (FileNotFoundException e) {
			System.err.println("Error: " + e);
		}
		
		return in;
	}
	
	public FileOutputStream writeFile(FileInputStream f) {
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream("output.txt");
		}		
		
		return null;
		
		
	}
}
