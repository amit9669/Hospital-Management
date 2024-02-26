package hospital.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedItems 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name ;
	private double medcost ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMedcost() {
		return medcost;
	}
	public void setMedcost(double medcost) {
		this.medcost = medcost;
	}
	@Override
	public String toString() {
		return "MedItems [id=" + id + ", name=" + name + ", Medcost=" + medcost + "]";
	}
}
