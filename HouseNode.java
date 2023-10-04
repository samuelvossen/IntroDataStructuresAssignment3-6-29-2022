/** 
 * this class create a HouseNode object that has variables data of type house and link of type HouseNode.
 * @author samuel vossen
 *
 */
public class HouseNode {
private House data;
private HouseNode link;
/**
 * constructor for HouseNode class that creates a new houseNode object whos instance variables are set to the parameters passed.
 * @param data.
 * a House object.
 * @param link
 * a HouseNode object.
 * @postcondition a new houseNode object has been created whos instance variables are set to the parameters passed.
 */
	public HouseNode(House data, HouseNode link) {
	super();
	this.data = data;
	this.link = link;
}
	/**
	 * retrieves the object stores in data.
	 * @return the object stored in data.
	 */
	public House getData() {
		return data;
	}
	/**
	 * sets data to the parameter passed.
	 * @param  data
	 * a House object
	 * @postcondition the variable data is set to the parameter past.
	 */
	public void setData(House data) {
		this.data = data;
	}
	/**
	 * retrieves the object stores in Link.
	 * @return the object stored in link.
	 */
	public HouseNode getLink() {
		return link;
	}
	/**
	 * sets link to the parameter passed.
	 * @param  link
	 * a HouseNode object
	 * @postcondition the variable link is set to the parameter past.
	 */
	public void setLink(HouseNode link) {
		this.link = link;
	}
	/**
	 * removes the node after the node that was used to call the method.
	 * @postcondition then node after the node that was used to call the method is removed from the list. 
	 */
	public void removeNodeAfter() {
		link = link.link;
	}
	/**
	 * adds element after the node that was used to call it. 
	 * @param element.
	 * a House object.
	 * @postcondition object has been added to the list directly after the node that was used to call the method. 
	 */
	public void addNodeAfter(House element) {
		link = new HouseNode(element, link);
	}
	/**
	 * displays all the objects in the in the list. 
	 * @return all the objects in the list as a string.
	 */
	public String Display() {
		HouseNode current = this.link;
		String output = this.data + "";
		while(current != null) {
			output = output + current.data + "";
			current = current.link;
		}
		return output;
	}
	/**
	 * this static method returns that value stored in the specified position after a houseNode object. 
	 * @param head
	 * a HouseNode object.
	 * @param position
	 * a integer.
	 * @return returns that value stored in the specified position after a houseNode object. 
	 */
public static HouseNode listPosition(HouseNode head, int position)
{
   HouseNode cursor;
   int i;
   if (position <= 0)
      throw new IllegalArgumentException("position is not positive.");
   cursor = head;
   for (i = 1; (i < position) && (cursor != null); i++)
      cursor = cursor.link;
   return cursor;
}
/**
 * this method determine how many objects in the list
 * @param head
 * a HouseNode object
 * @return number of objects in the list.
 */
public static int listLength(HouseNode head) {
	HouseNode cursor;
	int answer;
	
	answer = 0;
	for (cursor = head; cursor != null; cursor = cursor.link) {
		answer++;
	}
	return answer;
}
/**
 * this method searches a list to see if it contains a specific object.
 * @param head
 * a HouseNode object.
 * @param target
 * a House Object
 * @returns if the list does contain the House object it will return the object, 
 * if the list doesn't contain the house object it will return null.
 */
public static HouseNode listSearch(HouseNode head, House target)
{
    HouseNode cursor;
    for (cursor = head; cursor != null; cursor = cursor.link)
       if (target == cursor.data)
          return cursor;
    return null;
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House a = new House("a",1200);
		House b = new House("a",1900);
		House c = new House("a",1000);
		House d= new House("A",100);
		HouseLinkedBag test = new HouseLinkedBag();
		test.add(a);
		test.Display();
		HouseNode x = null;
		HouseNode y = new HouseNode(a,x);
	}
}
