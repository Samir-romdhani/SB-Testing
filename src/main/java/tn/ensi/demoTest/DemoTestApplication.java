package tn.ensi.demoTest;

import java.util.ResourceBundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoTestApplication {

	{
		String nomProjet = ResourceBundle.getBundle("application").getString("project.nom");
		String versionProjet = ResourceBundle.getBundle("application").getString("project.version");
		System.out.println("###################################");
		System.out.println("Nom Projet  : "+nomProjet);
		System.out.println("Version  : "+versionProjet);	
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoTestApplication.class, args);

	}

}
