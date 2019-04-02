package metricsCalculator;

public class codeAnalyzerDEMO {

	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.err.println("Exactly two arguments required: [sourceFile] [string or regex]");
			System.exit(1);
		}
		
		codeAnalyzer analyzer = new codeAnalyzer();
		analyzer.analyzeCode(args[0], args[1], "./metrics.csv");
	}

}
