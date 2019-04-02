package metricsCalculator;

import java.util.List;

public class stringAnalyzer implements Analyzer {
	int count;
	
	public int countLines(List<String> lines) {
		this.count = 0;
		boolean temp = false; //it is true when a multi-line comment is opened and false when closed
		String trimmedLine;
		for (String r : lines) {
			trimmedLine = r.trim();
			if (trimmedLine == null || trimmedLine.isEmpty()
					|| (trimmedLine.startsWith("}") && trimmedLine.endsWith("}")) //ignore lines which have one single block closure character
					|| trimmedLine.contains("//")) {					  //ignore comments					 
				continue;
			}
			if (trimmedLine.contains("/*") || trimmedLine.contains("/**")) {
				temp = true;
				continue;				
			}
			if (trimmedLine.endsWith("*/")) {
				temp = false;
				continue;
			}
			if (temp == false) {
				//System.out.println(r);
				this.count++;
			}			
		}		
		return count;
	}
	
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
	
	public int countMethods(List<String> lines) {
		this.count = 0;
		String trimmedLine;
		for (String r: lines) {
			trimmedLine = r.trim();
			if ((trimmedLine.startsWith("public") || trimmedLine.startsWith("private"))					
					&& (trimmedLine.contains("(")
					&& trimmedLine.contains(")")
					&& trimmedLine.contains("{"))) {
				System.out.println(r);
				this.count++;				
			}
		}
		return count;		
	}
}
