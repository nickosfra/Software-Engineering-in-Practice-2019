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
 * @author nickosfra The purpose of this static class is to read a file and
 * create and write to a csv file.
 *
 */

public class FileIOUtilities {
	
	private FileIOUtilities() {
		//private Constructor to prevent class instantiation
	}
	
	/*
	 * the "readFile" method receives a string which represents the
	 * path of the java file that the user wants to analyze and
	 * returns a list, each element of which has a line of the given file
	 */
	public static List<String> readFile(String filepath) throws Exception{
		/*each element of the list "lines" will contain each line of the java file given by the user*/ 
		List<String> lines = new ArrayList<String>();
		String thisLine = null; //string variable that will be used to read the file's each line
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;		
		
		try {
			/*
			 * open and read the java file
			 */
			is = new FileInputStream(filepath);
			isr = new InputStreamReader(is);			
			br = new BufferedReader(isr);
			
			while ((thisLine = br.readLine()) != null) {
				/*
				 * add to list "lines" the content of variable "thisLine" 
				 * which each time contains a line of the java file
				 */
				lines.add(thisLine); 				
			}			
		} catch (IOException e) {
			System.err.println("Error" + e);
		}
		
		return lines;
	}
	
	/*
	 * the "writeFile" method receives a string path in which we want to
	 * create the new ".csv" file which contains the metrics and a string list
	 * with 3 elements which contains the metrics
	 */
	public static void writeFile(String filepath, List<String> content) {
		
		FileWriter writer = null;
		
		try {
			/*
			 * we use a writer "FileWriter" to write our metrics in the ".csv" file 
			 */
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
