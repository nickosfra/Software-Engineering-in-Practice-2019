package operations;

import org.junit.Assert;
import org.junit.Test;

public class IntegerOperationsTest {
	
	IntegerOperations iop = new IntegerOperations();
	
	@Test
	public void test_getSign_positive() {
		Assert.assertEquals(-3, iop.reverseSign(3));
	}
	
	
	@Test
	public void test_getSign_negative() {
		Assert.assertEquals(3, iop.reverseSign(-3));
	}
	
	
	@Test
	public void test_getSign_zero() {
		Assert.assertEquals(0, iop.reverseSign(0));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void test_getNegativeNumber_exception() {
		iop.add(2,-1);
		iop.add(-2,1);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void test_getMaxNumber_exception() {
		iop.add(Integer.MAX_VALUE - 5, 8);
	}
	
	
	@Test(expected = IllegalArgumentException.class) 
	public void test_getNegativeInteger_exception() {
		iop.powerOfTwo(-5);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void test_getBigInteger_exception() {
		iop.powerOfTwo(36);
	}
	
	@Test
	public void normalCase() {
		Assert.assertEquals(20, iop.add(10,10));
	}

}
