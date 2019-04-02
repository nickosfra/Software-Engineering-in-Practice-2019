package metricsCalculator;

import java.util.List;

public class regexAnalyzer implements Analyzer {
	int count;
	
	public int countLines(List<String> lines) {
		this.count = 0;
		boolean temp = false; //it is true when a multi-line comment is opened and false when closed
		for (String r : lines) {
			r.trim();
			if (r.matches("\\s*") 
					|| r.matches("^}") && r.matches("$}")
					|| r.matches(".//")) {
				continue;
			}
			if (r.matches(".[/*]") || r.matches(".[/**]")) {
				temp = true;
				continue;
			}
			if (r.matches("$*/")) {
				temp = false;
				continue;
			}
			if (temp == false) {
				this.count ++;
			}
		}		
		
		return count;
	}

	public int countClasses(List<String> lines) {
		this.count = 0;
		for (String r : lines) {
			r.trim();
			if (r.matches("[\\Apublic class]") || r.matches("[\\Aclass]")) {
				this.count ++;
			}
		}
		
		return count;
	}

	public int countMethods(List<String> lines) {
		this.count = 0;
		for (String r : lines) {
			r.trim();
			if (r.matches("[(){]")) {
				this.count ++;
			}			
		}
		
		return count;
	}
	
}
