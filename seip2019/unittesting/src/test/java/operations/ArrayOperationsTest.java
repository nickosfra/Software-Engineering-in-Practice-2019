package operations;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import filehandlers.FileIO;
import operations.ArrayOperrations;

public class ArrayOperationsTest {
	
	FileIO fio = mock(FileIO.class);
	IntegerOperations io = mock(IntegerOperations.class);
	ArrayOperrations ao = new ArrayOperrations(fio, io);
	
	/**
	 * Method that checks if method
	 * findMaxInFile throws exception
	 * when it receives an empty file as input
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_emptyFileToRead_Mocking() {
		
		int[] arr = new int[] {};
		when(fio.readFile("empty")).thenReturn(arr);
		ao.findMaxInFile("empty");
		
	}
	
	@Test
	public void test_findMaxRegularCase_Mocking() {
		
		int[] arr = new int[] {1,2,3,54,21};
		when(fio.readFile("array")).thenReturn(arr);
		Assert.assertEquals(54, ao.findMaxInFile("array"));
		
	}
	
	/**
	 * Method that checks if
	 * method reverseArray throws
	 * exception when it receives an
	 * empty txt file as an argunment
	 */
	@Test(expected= IllegalArgumentException.class)
	public void test_emptyFileReverse_Mocking() {
		
		int[] arr = new int[] {};
		when(fio.readFile("empty")).thenReturn(arr);
		
		ao.reverseArray("empty");
		
	}
	
	@Test
	public void test_FileReverseRegularCase_Mocking() {
		when(fio.readFile("test")).thenReturn(new int[] {-15,5,0,20});
		when(io.reverseSign(-15)).thenReturn(15);
		when(io.reverseSign(5)).thenReturn(-5);
		when(io.reverseSign(0)).thenReturn(0);
		when(io.reverseSign(20)).thenReturn(-20);
		
		Assert.assertArrayEquals(new int[] {15, -5, 0, -20}, ao.reverseArray("test"));
		
	}
}
