package tn.ensi.demotest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.ensi.demotest.jpa.data.GreetingDao;
import tn.ensi.demotest.jpa.entities.Greeting;

@RestController
public class GreetingController {

	@Autowired
	private GreetingDao greetingDao;

	private static final String TEMPLATE = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/all")
	public MappingJacksonValue greeting() {
		Iterable<Greeting> greetings = greetingDao.findAll();
		return new MappingJacksonValue(greetings);
	}

	@GetMapping("/greeting")
	public Greeting greeting0(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
	}

}
