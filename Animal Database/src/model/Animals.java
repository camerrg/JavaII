package model;

import java.util.Arrays;

public class Animals {
 private String [] Type;
 private int animalID;
 	
 
 public Animals() {
	super();
	// TODO Auto-generated constructor stub
}


public String[] getType() {
	return Type;
}


public void setType(String[] type) {
	Type = type;
}


public int getAnimalID() {
	return animalID;
}


public void setAnimalID(int animalID) {
	this.animalID = animalID;
}


public Animals(String[] type, int animalID) {
	super();
	Type = type;
	this.animalID = animalID;
}
 
@Override
public String toString() {
	return "Animals [Type=" + Arrays.toString(Type) + ", animalID=" + animalID + "]";
}
	

}
