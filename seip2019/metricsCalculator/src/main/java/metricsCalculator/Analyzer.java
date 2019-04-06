package metricsCalculator;

import java.util.List;

/**
 * 
 * @author nickosfra This is an interface that plays the role of the strategy pattern and
 * contains the methods that will be implemented in the classes StringAnalyzer and RegexAnalyzer
 * to count the metrics.
 *
 */

public interface Analyzer {
	
	public int countLines(List<String> lines);
	public int countClasses(List<String> lines);
	public int countMethods(List<String> lines);

}
