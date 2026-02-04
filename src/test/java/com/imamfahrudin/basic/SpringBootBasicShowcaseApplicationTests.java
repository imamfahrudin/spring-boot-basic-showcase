package com.imamfahrudin.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootBasicShowcaseApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@Timeout(5) // Timeout after 5 seconds to prevent hanging
	void testMain() {
		// Test that the main method can be called without throwing exceptions
		// Note: This will start the application briefly, but the test framework will handle it
		SpringBootBasicShowcaseApplication.main(new String[]{});
	}

}
