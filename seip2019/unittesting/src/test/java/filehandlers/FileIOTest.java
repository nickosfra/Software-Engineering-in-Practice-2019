package filehandlers;

import org.junit.Assert;
import org.junit.Test;

public class FileIOTest {
	
	FileIO fio = new FileIO();
	
	int[] arr = new int[] {1,5,8,31,24}; //expected outcome
	
	/**
	 * Method that checks if the
	 * file contains valid numbers
	 */
	@Test
	public void getvalidInput() {
		Assert.assertArrayEquals(arr, fio.readFile("src\\test\\resources\\validInt.txt"));
	}
	
	/**
	 * Method that checks if excetpion
	 * is thrown when file contains invalid characters 
	 */
	@Test (expected = NumberFormatException.class)
	public void getInvalidInputException() {
		fio.readFile("src\\test\\resources\\invalidChars.txt");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void cannotFindFile() {
		fio.readFile("non-existing");
	}
	
	@Test (expected = NumberFormatException.class)
	public void outOfBounds() {
		fio.readFile("src\\test\\resources\\OutOfBoundsInt.txt");
	}
	
}