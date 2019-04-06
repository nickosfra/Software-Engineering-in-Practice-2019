package metricsCalculator;

/**
 * 
 * @author nickosfra This class contains the main method
 *
 */
public class CodeAnalyzerDEMO {

	public static void main(String[] args) {
		
		/*
		 * demand from the user to give arguments
		 */
		if (args.length < 2) {
			System.err.println("Exactly two arguments required: [sourceFile] [string or regex]");
			System.exit(1);
		}
		
		/*
		 * create an object "CodeAnalyzer" of the Facade pattern class 
		 * to start analyzing the given java file
		 */
		CodeAnalyzer analyzer = new CodeAnalyzer();
		analyzer.analyzeCode(args[0], args[1], "./metrics.csv");
	}

}
