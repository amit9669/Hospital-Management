package hospital.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hid ;
	private String name ;
	
	public int getHId() {
		return hid;
	}
	public void setHId(int hid) {
		this.hid = hid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Hospital [id=" + hid + ", name=" + name + "]";
	}
}
