import java.util.Iterator;
import java.util.NoSuchElementException;
/** 
 * this class create a HouseLinkedBag object that has variables head of type HouseNode and manyItems of type int.
 * @author samuel vossen
 *
 */
public class HouseLinkedBag implements Iterable<House> {
private HouseNode head;
private int manyItems;
/**
 * retrieves the integer stores in manyItems.
 * @return the object stored manyItems.
 */

/**
 * this the constructor for the class it creates a new HouseLinkedBag object.
 * @postcondition a new empty list has been created.
 */
public HouseLinkedBag() {
	this.head = null;
	this.manyItems =0;
}
/**
 * this method calculates how many items are in the list.
 * @param  head.
 * a HouseNode object.
 * @return the number of items in the list.
 */
public static int size(HouseNode head) {
	HouseNode cursor;
	int answer;
	
	answer = 0;
	for (cursor = head; cursor != null; cursor = cursor.getLink()) {
		answer++;
	}
	return answer;
}
/**
 * print each item in the list all the items it the list.
 */
public void Display() {
	HouseNode current = head;
	while(current != null) {
		System.out.println(current.getData());
		current = current.getLink();
	}}
/**
 * this element adds a new element to the list. 
 * @param element.
 * a House object.
 * @postcondition object has been added to the list. manyItems is incremented by +1.
 */
public void add(House element) {
	if(head == null) {
	head= new HouseNode(element,null);
	manyItems++;}
	else {head.addNodeAfter(element);
	manyItems++;}
}
/**
 * adds an element to the list in a specific position, if the position is greater 
 * than manyItems it is added as the last item in the list.
 * @param position
 * an integer.
 * @param element
 * a House object
 * @postcondition element is added to the list in the specific position, or at the end of the list.
 * manyItems is incremented by +1.
 */
public void add(int position, House element) {
	HouseNode current = head;
	if(position > manyItems) {position = manyItems;}
	if(position == 1) {
		head = new HouseNode(element,head);
	}
	if (position > 1) {
	for(int i=1;i<position;i++) {
		current = current.getLink();
	}
	current.addNodeAfter(element);
	manyItems++;}
	
}
/**
 * this method adds a element to the end of the list.
 * @param element.
 * a House object.
 * @postcondition element has been added to the end of the list. manyItems is incremented by +1.
 */
public void addLast(House element) {
	HouseNode current = head;
	for(int i=1;i<manyItems;i++) {
		current = current.getLink();
	}
	current.addNodeAfter(element);
	manyItems++;}
/**
 * this method removes an object from the list.
 * @param target
 * a House Object.
 * @postcondition element is removed from list. manyItems is incremented by -1.
 */
public boolean remove(House target) {
	boolean output = false;
	int position =0;
	HouseNode current = head;
	for(int i=0;i<manyItems;i++) {
	if(current.getData().equals(target)) {
		output = true;
		break;
	}
	position++;
	current = current.getLink();
}
	HouseNode newCurrent = head;
	for(int i=1;i<position;i++) {
		newCurrent = newCurrent.getLink();
	}
	newCurrent.removeNodeAfter();
	manyItems--;
	return output;
}
/**
 * this method removes the last item in the list.
 * @postcondition last item in the list is removed. manyItems is incremented by -1.
 */
public void removeLast() {
	HouseNode current = head;
	for(int i=1;i<manyItems-1 ;i++) {
		current = current.getLink();
	}
	current.removeNodeAfter();
	manyItems--;}
/**
 * this method counts the number of objects thats value is between two object.
 * @param start.
 * a House object.
 * @param end.
 * a House object.
 * @return the number of objects whose values are between start and end.
 */
public int countRange(House start, House end) {
	int counter = 0;
	HouseNode current = head;
	for(int i=0;i<manyItems ;i++) {
		if(current.getData().compareTo(start) == 1 && current.getData().compareTo(end) == -1) {
			counter++;
		}
		current = current.getLink();
	}
	return counter;
}
/**
 * adds element to the list at a specific position. 
 * @param position.
 * an integer.
 * @param element
 * a House object
 * @postcondition element has been added to the list at the specific position.
 */
public void set(int position, House element) {
	HouseNode current = head;
	if(position > 0 && position <= manyItems) {
	for(int i=1; i<position-1;i++) {
		current = current.getLink();
	}
	current.removeNodeAfter();
	current.addNodeAfter(element);}
}
/**
 * this method calculates the values of all the squarefoot values in the list added together. 
 * @return the values of all the squarefoot values in the list added together. 
 */
public int total() {
	int total = 0;
	int houseValue = 0;
	HouseNode current = head;
	for(int i=0; i<manyItems;i++) {
		houseValue = current.getData().getSquareFoot();
		total = total + houseValue;
		current = current.getLink();
	}
	return total;
}
/**
 * this method takes one Thing as input
	and returns an output a linked list that includes all elements that are less than or equal
	to the input element.
 * @param element.
 * a House object.
 * @return linked list that includes all elements that are less than or equal to the input element.
 */
public HouseNode lessThan(House element) {
	HouseNode current = head;
	HouseLinkedBag newList = new HouseLinkedBag();
	for(int i=0; i<manyItems; i++) {
		if(current.getData().compareTo(element) == -1) {
			newList.add(current.getData());
		}
		current = current.getLink();
	}
	return newList.head;
}
/**
 * this method finds the largest value in the list. 
 * @return the largest element in the list. 
 */
public House max() {
	HouseNode current = head;
	House maxElement = null;
	House trackerElement;
	for(int i = 0; i<manyItems; i++) {
		maxElement = current.getData();
		HouseNode tracker = head;
		for(int z = i; i<manyItems; i++) {
			if(tracker.getData().compareTo(maxElement) == 1) {
				maxElement = tracker.getData();
			}
			tracker = tracker.getLink();
		}
		current = current.getLink();
	}
	return maxElement;
}
/**
 * this is an inner iterator class for the HouseLinkedBagIterator class.
 * @author Samuel vossen
 */
class HouseLinkedBagIterator implements Iterator<House>{
	 public HouseNode current = head;
	 /**
	  * this method determines if their is an object after the current object in the list. 
	  * @return true if their is a next object, false if their in not. 
	  */
	 public boolean hasNext() {
	boolean output = false;
	if(current != null) {
	if(current.getData() != null) {
		output = true;
	};}
	return output;
	
}
/**
 * the method retrieves the data in the next element in the list. 
 * @return the data in the next element in the list.
 */
public House next() {
	if(hasNext() == false){
        House data = current.getData();
        return data;}
	if(hasNext()){
        House bata = current.getData();
        current = current.getLink();
        return bata;
    }
	return null;

}}
/**
 * this method creates new HouseLinkedBagIterator object.
 * @return new HouseLinkedBagIterator object.
 */
@Override
public Iterator<House> iterator() {
	
	// TODO Auto-generated method stub
	return new HouseLinkedBagIterator();
}
public static void main(String[] args) {
		// TODO Auto-generated method stub
	House a = new House("a",1200);
	House b = new House("b",1900);
	House c = new House("c",1000);
	House d= new House("d",100);
	House e = new House("e",100);
	HouseLinkedBag test = new HouseLinkedBag();
	System.out.println("ManyItems = " + test.manyItems);
	test.add(a);
	test.Display();
	System.out.println("ManyItems = " + test.manyItems);
	System.out.println("------add a------------------");
	test.add(b);
	test.Display();
	System.out.println("ManyItems = " + test.manyItems);
	System.out.println("--add b----------------------");
	test.add(3, c);
	test.Display();
	System.out.println("ManyItems = " + test.manyItems);
	System.out.println("-----add c-------------------");
	test.addLast(d);
	test.Display();
	System.out.println("ManyItems = " + test.manyItems);
	System.out.println("----add d--------------------");
	System.out.println(test.remove(c));
	test.Display();
	System.out.println("ManyItems = " + test.manyItems);
	System.out.println("-------remove c---------------");
	test.removeLast();
	test.Display();
	System.out.println("ManyItems = " + test.manyItems);
	System.out.println("--------------remove last---------");
	test.addLast(c);
	test.addLast(d);
	test.Display();
	System.out.println("ManyItems = " + test.manyItems);
	System.out.println("-----add c and d-------------------");
	System.out.println("number of elements falling between a and d = " + test.countRange(a, d));
	System.out.println("ManyItems = " + test.manyItems);
	test.set(2, e);
	test.Display();
	System.out.println("ManyItems = " + test.manyItems);
	System.out.println("-----replace b with e using set method-------------------");
	System.out.println("total value of all the square feet in the list = " + test.total());
	System.out.println("bellow is a link list created by lessThan method for all elements smaller than e");
	System.out.println(test.lessThan(e).Display());
	System.out.println("-----------------------");
	test.Display();
	System.out.println("max value in list = " + test.max());
	test.set(2, b);
	test.Display();
	System.out.println("max value in list = " + test.max());
	}





}
