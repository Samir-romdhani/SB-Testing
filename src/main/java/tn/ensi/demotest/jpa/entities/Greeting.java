package tn.ensi.demotest.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Greeting")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
public class Greeting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private final long id;
	
	@Column(name="content")
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
