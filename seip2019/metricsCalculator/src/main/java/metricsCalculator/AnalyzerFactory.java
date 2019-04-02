package metricsCalculator;

public class AnalyzerFactory {
	
	public static Analyzer createAnalyzer(String type) {
		Analyzer analyzer = null;
		
		if (type.equals("string")) {
			analyzer = new stringAnalyzer();
		} else if (type.equals("regex")) {
			analyzer = new regexAnalyzer();
		}		
		
		return analyzer;
		
	}

}
