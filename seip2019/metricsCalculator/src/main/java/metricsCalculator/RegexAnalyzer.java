package metricsCalculator;

import java.util.List;

public class RegexAnalyzer implements Analyzer {
	int count;
	
	public int countLines(List<String> lines) {
		this.count = 0;
		boolean temp = false; //it is true when a multi-line comment is opened and false when closed
		String trimmedLine;
		for (String r : lines) {
			trimmedLine = r.trim();
			if (trimmedLine.matches("\\s*") 
					|| trimmedLine.matches("^}") && trimmedLine.matches("$}")
					|| trimmedLine.matches(".//")) {
				continue;
			}
			if (trimmedLine.matches(".[/*]") || trimmedLine.matches(".[/**]")) {
				temp = true;
				continue;
			}
			if (trimmedLine.matches("$*/")) {
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
		String trimmedLine;
		for (String r : lines) {
			trimmedLine = r.trim();
			if (trimmedLine.matches("\\bclass\\b")) {
				this.count ++;
			}
		}
		
		return count;
	}

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
