package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class charTest {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		char[] test = {'A', 'B', 'C'};
		System.out.println(new String(test));
	}

}
