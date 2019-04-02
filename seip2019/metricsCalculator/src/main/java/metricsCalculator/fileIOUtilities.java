package metricsCalculator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author nickosfra The purpose of this static class is to read a file and write in another one.
 *
 */

public class fileIOUtilities {
	
	private fileIOUtilities() {
		//private Constructor to prevent class instantiation
	}
	
	public static List<String> readFile(String filepath) throws Exception{
		List<String> lines = new ArrayList<String>();
		String thisLine = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;		
		
		try {
			is = new FileInputStream(filepath);
			isr = new InputStreamReader(is);			
			br = new BufferedReader(isr);
			
			while ((thisLine = br.readLine()) != null) {
				lines.add(thisLine);				
			}			
		} catch (IOException e) {
			System.err.println("Error" + e);
		}
		
		return lines;
	}
	
	public static void writeFile(String filepath, List<String> content) {
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(filepath);
			for (String r : content) {
				writer.append(r);
			}
		} catch (IOException e) {
			System.err.println("Error" + e);
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
