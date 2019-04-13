package metricsCalculator;

import java.util.List;

/**
 * 
 * @author nickosfra This class implements the analyzer which
 * uses string comparisons to calculate the metrics
 *
 */

public class StringAnalyzer implements Analyzer {
	int count;
	
	/*
	 * this method receives a string list that contains a line in each element
	 * and returns an integer that indicates the number of lines that the java file has
	 */	
	public int countLines(List<String> lines) {
		this.count = 0;
		boolean temp = false; //it is true when a multi-line comment is opened and false when closed
		String trimmedLine;
		for (String r : lines) {
			trimmedLine = r.trim();
			if (trimmedLine == null || trimmedLine.isEmpty()
					/*ignore lines which have one single block closure character*/
					|| (trimmedLine.startsWith("}") && trimmedLine.endsWith("}"))
					/*ignore comments*/
					|| trimmedLine.contains("//")) { 						 
				continue;
			}
			
			/*
			 * this condition is true when there is a remark for "opening" a comment block
			 */
			if (trimmedLine.contains("/*") || trimmedLine.contains("/**")) {
				temp = true;
				continue;				
			}
			
			/*
			 * this condition is true when there is a remark for "closing" a comment block
			 */
			if (trimmedLine.endsWith("*/")) {
				temp = false;
				continue;
			}
			
			/*
			 * this condition is true only when the line is not empty, does not contains single closing
			 * remarks (i.e."}") and the line is not a comment
			 */
			if (temp == false) {
				this.count++;
			}			
		}		
		return count;
	}
	
	/*
	 * this method receives a string list that contains a line in each element
	 * and returns an integer that indicates the number of classes that the java file has
	 */
	public int countClasses(List<String> lines) {
		this.count = 0;
		String trimmedLine;
		for (String r : lines) {
			trimmedLine = r.trim();
			if (trimmedLine.startsWith("public class") || trimmedLine.startsWith("class")) {
				this.count ++;
			}
		}		
		return count;		
	}
	
	/*
	 * this method receives a string list that contains a line in each element
	 * and returns an integer that indicates the number of methods that the java file has
	 */	
	public int countMethods(List<String> lines) {
		this.count = 0;
		String trimmedLine;
		for (String r: lines) {
			trimmedLine = r.trim();
			if ((trimmedLine.startsWith("public") || trimmedLine.startsWith("private"))					
					&& (trimmedLine.contains("(")
					&& trimmedLine.contains(")")
					&& trimmedLine.contains("{"))) {
				this.count++;				
			}
		}
		return count;		
	}
}
