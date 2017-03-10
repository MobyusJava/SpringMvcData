package be.mobyus.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	@ManyToMany
	private List<Competence> competences;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email,
			List<Competence> Competences) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.competences = Competences;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> Competences) {
		this.competences = Competences;
	}

	public boolean hasCompetence(Competence Competence) {
		for (Competence containedCompetence: getCompetences()) {
			if (containedCompetence.getId() == Competence.getId()) {
				return true;
			}
		}
		return false;
	}

}
