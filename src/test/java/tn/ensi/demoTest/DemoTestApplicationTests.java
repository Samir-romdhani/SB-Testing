package tn.ensi.demoTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.ensi.demoTest.controller.GreetingController;
import tn.ensi.demoTest.jpa.entities.Greeting;


/**
 * Test unitaire avec Junit4 : Spring Runner
 * @author rs
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTestApplicationTests {

	@Autowired
    private GreetingController greetingController;

    @Test
    public void testHelloMessage() {
        Greeting message = greetingController.greeting0("");
        assertThat(message).isNotNull();
    }

}
