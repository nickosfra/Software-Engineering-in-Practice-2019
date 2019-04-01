package metricsCalculator;

import java.util.List;

public class stringAnalyzer {
	int count;
	
	public int countLines(List<String> lines) {
		this.count = 0;
		for (String r : lines) {
			if (r == null || r.isEmpty()) {
				continue;
			}
			
		}
		
		
		
		return 0;
		
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
					&& r.contains("(")
					&& r.contains(")")
					&& r.contains("{")) {
				this.count++;				
			}
		}
		return count;
		
	}
	
}
