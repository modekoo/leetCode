package test.nextGreaterNumericallyBalancedNumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class NextGreaterNumericallyBalancedNumberTest {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		int n = 1;
		
		assertEquals(22, nextBeautifulNumber(n));
		
	}
	
	private int nextBeautifulNumber(int n) {
		
		int result = 0;
		
		int length = String.valueOf(n).length() == 1 ? 2 : String.valueOf(n).length();
		
		
		
		return result;
	}

}
