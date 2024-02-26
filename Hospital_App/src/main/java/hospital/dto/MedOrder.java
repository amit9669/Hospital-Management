package hospital.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class MedOrder 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid ;
	private String shift ;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<MedItems> medItems ;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public List<MedItems> getMedItems() {
		return medItems;
	}

	public void setMedItems(List<MedItems> medItems) {
		this.medItems = medItems;
	}

	@Override
	public String toString() {
		return "MedOrder [mid=" + mid + ", Shift=" + shift + ", medItems=" + medItems + "]";
	}
}
