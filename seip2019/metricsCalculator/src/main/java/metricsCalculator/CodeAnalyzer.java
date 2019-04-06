package metricsCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author nickosfra This class plays the role of the "Facade" pattern
 * and communicates with the CodeAnalyzerDEMO class that contains the main
 * method. It contains two methods; "analyzeCode" and "combineMetrics"
 *
 */
public class CodeAnalyzer {
	
	/*
	 * this methods receives three string arguments, which relatively contain the path
	 * of the file that the user gives, the type of analysis he/she wants to
	 * implement and the path in which the app will create the ".csv" file with the results
	 */
	public void analyzeCode(String pathOfSourceFile, String typeOfAnalysis, String outputFile) {		
		int linesOfCode;
		int numberOfClasses;
		int numberOfMethods;
		List<String> metrics = new ArrayList<String>(); //in list "metrics" we will put the results
		
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
