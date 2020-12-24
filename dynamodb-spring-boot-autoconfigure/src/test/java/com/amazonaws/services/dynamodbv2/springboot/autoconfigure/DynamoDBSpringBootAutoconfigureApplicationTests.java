package com.amazonaws.services.dynamodbv2.springboot.autoconfigure;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DynamoDBRepositoriesAutoConfiguration.class)
class DynamoDBSpringBootAutoconfigureApplicationTests {

	@Test
	public void whenSpringContextIsBootstrapped_thenNoExceptions() {
	}

}
