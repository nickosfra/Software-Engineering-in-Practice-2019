package metricsCalculator;

public class AnalyzerFactory {
	
	public static Analyzer createAnalyzer(String type) {
		Analyzer analyzer = null;
		
		if (type == "string") {
			analyzer = new stringAnalyzer();
		} else if (type == "regex") {
			analyzer = new regexAnalyzer();
		}		
		
		return analyzer;
		
	}

}
