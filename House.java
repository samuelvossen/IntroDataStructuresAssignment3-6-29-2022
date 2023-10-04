/** 
 * this class create a House object that has variables street of type string and squareFoot of type int.
 * @author samuel vossen
 *
 */
public class House implements Comparable<House> {
	private String street;
	private int squareFoot;
	/**
	 * this is a constructor that creates a new house object with the parameter passed.
	 * @param street 
	 * the name of the street the house is on.
	 * @param squareFoot
	 * the square footage of the house.
	 * @postcondition a new House object has been created with the instance variables set to the values passed by the parameters. 
	 */

	public House(String street, int squareFoot) {
	super();
	this.street = street;
	this.squareFoot = squareFoot;
	}
	/**
	 * this method retrieves that value stored in street for the House object.
	 * @return street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * this method retrieves that value stored in squareFoot for the House object.
	 * @return SquareFoot
	 */
	public int getSquareFoot() {
		return squareFoot;
	}
	/**
	 * creates a string version of the information stored in the house object
	 * @return string version of the information stored in the house object
	 */
	@Override
	public String toString() {
		return "house [street=" + street + ", squareFoot=" + squareFoot + "]"+"\n";
	}
	/**
	 * test to see if two house objects are equal to each other by comparing their instance variables.
	 * @precondition other != null.
	 * @param other
	 * a House object
	 * @return true if the instance variables of the objects are the same, false if they are not.
	 */
	public boolean equals(House other) {
		boolean output = false;
		if (other != null) {
		if (this.squareFoot == other.getSquareFoot() & this.street.equalsIgnoreCase(other.getStreet())){
			output = true;
		}}
		return output;
	}
	/**
	 * this method compares the instance variables of the House object passed to the Object that called it.
	 * @precondition other != null.
	 * @param other.
	 * a house object.
	 * @return 1 if the object passed is larger, 0 if they are the same, and -1 if it is smaller.
	 */
	public int compareTo(House other) {
		int output = 0;
		if(other != null) {
		output = this.street.compareToIgnoreCase(other.street);
		if (output < 0) {output = -1;}
		if (output > 0) {output = 1;}
		if (output == 0) {
			if(other.squareFoot < this.squareFoot) {output = -1;}
			if (other.squareFoot > this.squareFoot) {output = 1;}
		}}
		return output;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
House a = new House("a",1200);
House b = new House("a",1900);
House c = new House("a",1000);
House d= new House("A",100);
System.out.println("anser should be -1" + a.compareTo(b));
System.out.println("anser should be 1" + a.compareTo(c));
System.out.println("anser should be 0" + a.compareTo(d));
System.out.println(a.squareFoot == b.getSquareFoot() & a.street.equalsIgnoreCase(b.getStreet()));
System.out.println(a.equals(b));
System.out.println(a.toString());
	}

}
