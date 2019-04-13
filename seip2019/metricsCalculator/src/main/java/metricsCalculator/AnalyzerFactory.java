package metricsCalculator;

/**
 * 
 * @author nickosfra This class plays the role of the
 * "Factory" pattern which creates the analyzer that the
 * user wants to use
 *
 */

public class AnalyzerFactory {
	
	/*
	 * the method "createAnalyzer" receives a string which contains
	 * either the value "string" or "regex" and expresses the type
	 * of analyzer the user wants to use and returns the relative
	 * object ("StringAnalyzer" or "RegexAnalyzer")
	 */
	public static Analyzer createAnalyzer(String type) {
		Analyzer analyzer = null;
		
		if (type.equals("string")) {
			analyzer = new StringAnalyzer();
		} else if (type.equals("regex")) {
			analyzer = new RegexAnalyzer();
		}		
		
		return analyzer;
		
	}

}
