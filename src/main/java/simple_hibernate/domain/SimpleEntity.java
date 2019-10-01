package simple_hibernate.domain;

import javax.persistence.*;

@Entity
@Table(name = "entities")
public class SimpleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "property_one")
	private String propertyOne;
	@Column(name = "property_two")
	private int propertyTwo;
	@Column(name = "property_three")
	private boolean propertyThree;
	
	public SimpleEntity() {
		
	}
	
	public SimpleEntity(String propertyOne, int propertyTwo, boolean propertyThree) {
		this.propertyOne = propertyOne;
		this.propertyTwo = propertyTwo;
		this.propertyThree = propertyThree;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int value) {
		this.id = value;
	}
	
	public String getPropertyOne() {
		return propertyOne;
	}
	
	public void setPropertyOne(String value) {
		this.propertyOne = value;
	}
	
	public int getPropertyTwo() {
		return propertyTwo;
	}
	
	public void setPropertyTwo(int value) {
		this.propertyTwo = value;
	}
	
	public boolean getPropertyThree() {
		return propertyThree;
	}
	
	public void setPropertyThree(boolean value) {
		this.propertyThree = value;
	}

}
