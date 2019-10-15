package tn.ensi.demoTest.controller;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.ensi.demoTest.jpa.data.GreetingDao;
import tn.ensi.demoTest.jpa.entities.Greeting;

@RestController
public class GreetingController {

	@Autowired
	private GreetingDao greetingDao;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/all")
	public MappingJacksonValue greeting() {
		Iterable<Greeting> greetings = new ArrayList<Greeting>();
		greetings = greetingDao.findAll();
		MappingJacksonValue greetingsFiltres = new MappingJacksonValue(greetings);
		return greetingsFiltres;
	}

	@RequestMapping("/greeting")
	public Greeting greeting0(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
