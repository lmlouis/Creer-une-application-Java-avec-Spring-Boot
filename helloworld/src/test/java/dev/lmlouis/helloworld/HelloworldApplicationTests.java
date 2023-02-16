package dev.lmlouis.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import dev.lmlouis.helloworld.service.BusinessService;

@SpringBootTest
class HelloworldApplicationTests {

	@Autowired
	BusinessService bs;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetHelloWorld(){
		String exceptedString = "Hello World!";

		String actualString = bs.getHelloWorld().getValue();
		assertEquals(exceptedString, actualString);
	}

}
