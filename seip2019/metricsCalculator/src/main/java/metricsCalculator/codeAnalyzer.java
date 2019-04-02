package metricsCalculator;

import java.util.ArrayList;
import java.util.List;

public class codeAnalyzer {
	
	public void analyzeCode(String pathOfSourceFile, String typeOfAnalysis, String outputFile) {		
		int linesOfCode;
		int numberOfClasses;
		int numberOfMethods;
		List<String> metrics = new ArrayList<String>();
		
		List<String> lines = new ArrayList<String>();
		try {
			lines = fileIOUtilities.readFile(pathOfSourceFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Analyzer analyzer = AnalyzerFactory.createAnalyzer(typeOfAnalysis);
		linesOfCode = analyzer.countLines(lines);
		numberOfClasses = analyzer.countClasses(lines);
		numberOfMethods = analyzer.countMethods(lines);
		metrics = codeAnalyzer.combineMetrics(linesOfCode, numberOfClasses, numberOfMethods);		
		
		fileIOUtilities.writeFile(outputFile, metrics);
	}
	
	public static List<String> combineMetrics(int linesOfCode, int numberOfClasses, int numberOfMethods){
		List<String> list = new ArrayList<String>();
		list.add(String.valueOf(linesOfCode));
		list.add(",");
		list.add(String.valueOf(numberOfClasses));
		list.add(",");
		list.add(String.valueOf(numberOfMethods));		
		
		return list;		
	}

}
