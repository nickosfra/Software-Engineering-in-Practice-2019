package metricsCalculator;

import java.util.List;

public interface Analyzer {
	
	public int countLines(List<String> lines);
	public int countClasses(List<String> lines);
	public int countMethods(List<String> lines);

}
