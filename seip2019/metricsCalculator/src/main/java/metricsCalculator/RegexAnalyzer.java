package metricsCalculator;

import java.util.List;

/**
 * 
 * @author nickosfra This class implements the analyzer which
 * uses regular expressions to calculate the metrics
 *
 */

public class RegexAnalyzer implements Analyzer {
	int count;
	
	/*
	 * this method receives a string list that contains a line in each element
	 * and returns an integer that indicates the number of lines that the java file has
	 */
	public int countLines(List<String> lines) {
		this.count = 0;
		boolean temp = false; //it is true when a multi-line comment is opened and false when closed
		String trimmedLine; //string variable that contains a line without whitespace at the front nd the end of the line
		for (String r : lines) {
			trimmedLine = r.trim(); //remove whitespace at the front and end of line
			if (trimmedLine.matches("\\s*") 
					|| trimmedLine.matches("^}") && trimmedLine.matches("$}")
					|| trimmedLine.matches(".//")) {
				continue;
			}
			
			/*
			 * this condition is true when there is a remark for "opening" a comment block
			 */
			if (trimmedLine.matches(".[/*]") || trimmedLine.matches(".[/**]")) {
				temp = true;
				continue;
			}
			
			/*
			 * this condition is true when there is a remark for "closing" a comment block
			 */
			if (trimmedLine.matches("$*/")) {
				temp = false;
				continue;
			}
			
			/*
			 * this condition is true only when the line is not empty, does not contains single closing
			 * remarks (i.e."}") and the line is not a comment
			 */
			if (temp == false) {
				this.count ++;
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
			if (trimmedLine.matches("\\bclass\\b")) {
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
		for (String r : lines) {
			trimmedLine = r.trim();
			if (trimmedLine.matches("(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])")) {
				this.count ++;
			}			
		}
		
		return count;
	}
	
}
