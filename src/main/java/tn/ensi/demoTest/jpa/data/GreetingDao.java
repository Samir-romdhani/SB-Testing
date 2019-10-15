package tn.ensi.demoTest.jpa.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.ensi.demoTest.jpa.entities.Greeting;

@Repository
public interface GreetingDao extends JpaRepository<Greeting, Integer> {

}
