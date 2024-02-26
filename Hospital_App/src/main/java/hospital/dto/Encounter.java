package hospital.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String disease ;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private Person person ;
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Branch> branches;
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<MedOrder> medOrders ;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisese(String disease) {
		this.disease = disease;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public List<MedOrder> getMedOrders() {
		return medOrders;
	}

	public void setMedOrders(List<MedOrder> medOrders) {
		this.medOrders = medOrders;
	}
	@Override
	public String toString() {
		return "Encounter [id=" + id + ", disease=" + disease + ", person=" + person + ", branches=" + branches
				+ ", medOrders=" + medOrders + "]";
	}
}
