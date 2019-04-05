package metricsCalculator;

import java.util.ArrayList;
import java.util.List;

public class CodeAnalyzer {
	
	public void analyzeCode(String pathOfSourceFile, String typeOfAnalysis, String outputFile) {		
		int linesOfCode;
		int numberOfClasses;
		int numberOfMethods;
		List<String> metrics = new ArrayList<String>();
		
		List<String> lines = new ArrayList<String>();
		try {
			lines = FileIOUtilities.readFile(pathOfSourceFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Analyzer analyzer = AnalyzerFactory.createAnalyzer(typeOfAnalysis);
		linesOfCode = analyzer.countLines(lines);
		numberOfClasses = analyzer.countClasses(lines);
		numberOfMethods = analyzer.countMethods(lines);
		metrics = CodeAnalyzer.combineMetrics(linesOfCode, numberOfClasses, numberOfMethods);		
		
		FileIOUtilities.writeFile(outputFile, metrics);
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
