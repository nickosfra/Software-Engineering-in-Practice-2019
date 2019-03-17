package histoGrades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/***
 * @author nickosfra The purpose of this class is to generate a chart that demonstrates
 * the frequency of students' grades.
 */


public class HistogramGenerator {
	
	/***
	 * Receives an Integer array that contains the frequency of the grades of the students,
	 * from which the chart is created. At first, a dataset is created
	 * in order to creates the data series in it, which is only an element
	 * of the dataset. The chart is finally generated and presented in the screen.
	 *  
	 */
	
	public void genHist(int[] dataValues) {
		
		/*
		 * The XYSeriesCollection object (dataset) can also 
		 * be visualized in the same chart.
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		/*
		 * We can create many series in one dataset.
		 */
		XYSeries data = new XYSeries("Grades");
		
		int i = 0;
		/*
		 * We create our data XYSeries series by adding
		 * the elements of the Integer array dataValues.
		 */
		for (int el : dataValues) {
			data.add(i, el);
			i++;
		}
		
		//add the series to the dataset
		dataset.addSeries(data);
		
		boolean legend = false;
		boolean tooltips = false;
		boolean urls = false;
		
		/*
		 * Create an object of the class JFreeChart in order to
		 * initialize a createXYLineChart JFreeChart.
		 */
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grade", "Number of Students", dataset,
							PlotOrientation.VERTICAL, legend, tooltips, urls);
		
		/*
		 * Initialize a frame for visualizing the chart and attach
		 * the previously created chart
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		
		//Force the user to give argument.
		if (args.length == 0) {
			System.err.println("Exactly one argument required, please give an argument.");
			System.exit(1);
		}
		
		//Create a Scanner scanner object, which reads the file given
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream(args[0]));
		} catch (FileNotFoundException e) {
			System.err.println("Error:" + e);
		}
		
		/*
		 * Integer array grades that will be filled 
	     * with the grades of the students
		 */
		int[] grades = new int[11];
		for (int i =0; i < 11; i++) {
			grades[i] = 0;
		}
		
		while (scanner.hasNextInt()) {
			//System.out.println(grades)
			grades[scanner.nextInt()]++;
		}
		scanner.close();
		
		HistogramGenerator histoGen = new HistogramGenerator();
		histoGen.genHist(grades);		
		
	}

}
