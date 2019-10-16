package tn.ensi.demoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import tn.ensi.demotest.controller.GreetingController;
import tn.ensi.demotest.jpa.data.GreetingDao;
import tn.ensi.demotest.jpa.entities.Greeting;

/**
 * Test fonctionnelles avec MockitoJUnitRunner
 * 
 * @author romdhanisamir94@gmail.com
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DemoTestApplicationTests {

	@InjectMocks
	private GreetingController greetingController;

	@Mock
	private GreetingDao greetingDao;

	@Test
	public void testHelloMessage() {
		Greeting message = greetingController.greeting0("");
		assertThat(message).isNotNull();
	}

	@Test
	public void testHelloAllMessage() {
		ArrayList<Greeting> list = new ArrayList<Greeting>();
		Greeting sam = new Greeting(1, "sam");
		Greeting lucas = new Greeting(2, "lucas");
		list.add(sam);
		list.add(lucas);
		when(greetingDao.findAll()).thenReturn(list);
		assertThat(greetingController.greeting().getValue()).asList().size().isGreaterThan(1);
		assertThat(greetingController.greeting().getValue()).asList().contains(lucas);
	}

}
