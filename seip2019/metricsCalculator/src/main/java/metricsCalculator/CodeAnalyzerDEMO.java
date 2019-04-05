package metricsCalculator;

public class CodeAnalyzerDEMO {

	public static void main(String[] args) {
		
		if (args.length < 2) {
			System.err.println("Exactly two arguments required: [sourceFile] [string or regex]");
			System.exit(1);
		}
		
		CodeAnalyzer analyzer = new CodeAnalyzer();
		analyzer.analyzeCode(args[0], args[1], "./metrics.csv");
	}

}
