package metricsCalculator;

import java.util.List;

public class stringAnalyzer implements Analyzer {
	int count;
	
	public int countLines(List<String> lines) {
		this.count = 0;
		boolean temp = false; //it is true when a multi-line comment is opened and false when closed
		for (String r : lines) {
			r.trim();
			if (r == null || r.isEmpty()
					|| (r.startsWith("}") && r.endsWith("}")) //ignore lines which have one single block closure character
					|| r.contains("//")) {					  //ignore comments					 
				continue;
			}
			if (r.contains("/*") || r.contains("/**")) {
				temp = true;
				continue;				
			}
			if (r.endsWith("*/")) {
				temp = false;
				continue;
			}
			if (temp == false) {
				this.count++;
			}			
		}		
		return count;
	}
	
	public int countClasses(List<String> lines) {
		this.count = 0;
		for (String r : lines) {
			r.trim();
			if (r.startsWith("public class") || r.startsWith("class")) {
				this.count ++;
			}
		}		
		return count;		
	}
	
	public int countMethods(List<String> lines) {
		this.count = 0;
		for (String r: lines) {
			r.trim();
			if (r.startsWith("public") || r.startsWith("private")					
					|| r.contains("(")
					&& r.contains(")")
					&& r.contains("{")) {
				this.count++;				
			}
		}
		return count;		
	}
}
