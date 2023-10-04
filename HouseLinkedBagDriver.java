/** 
 * this class is the driver for House, HouseNode, and HouseLinkedBag classes.
 * @author samuel vossen
 *
 */
public class HouseLinkedBagDriver {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		House a = new House("apple street",1200);
		House b = new House("bingo street",1900);
		House c = new House("caviar street",1000);
		House d= new House("drama street",100);
		House e = new House("easter street",100);
		HouseNode HouseNodeTest = new HouseNode(a,null);
		System.out.println("test of the HouseNode class:");
		HouseNode x = new HouseNode(a,null);
		System.out.println("getData test: " + HouseNodeTest.getData());
		HouseNodeTest.setData(b);
		System.out.println("setData test, output should now be equal to bingo street: " + "\n" +HouseNodeTest.getData());
		System.out.println("getLink test: " + HouseNodeTest.getLink());
		HouseNodeTest.setLink(x);
		System.out.println("setLink test, second item should now be equal to apple street: " + "\n" + HouseNodeTest.Display());
		HouseNodeTest.removeNodeAfter();
		System.out.println("removeNodeAfter test. apple street should be removed from list" + "\n" + HouseNodeTest.Display());
		HouseNodeTest.addNodeAfter(a);
		System.out.println("addNodeAfter test. apple street should be add to list" + "\n" + HouseNodeTest.Display());
		System.out.println("listPosition test, should return apple street" + "\n" + HouseNodeTest.listPosition(HouseNodeTest, 2).getData());
		System.out.println("listLength test, should return 2: " + "\n" + HouseNodeTest.listLength(HouseNodeTest));
		System.out.println("listSearch test, should return null: " + "\n" + HouseNodeTest.listSearch(HouseNodeTest,c));
		
		
		
		HouseLinkedBag test = new HouseLinkedBag();
		System.out.println("test of size() using previous HouseNode list should be equal to 2" + "\n" + test.size(HouseNodeTest));
		System.out.println("new HouseLinkedBag object created fallowing methods tested are from that class");
		test.add(a);
		System.out.println("test of add(House element), list should contain apple street");
		test.Display();
		test.add(b);
		System.out.println("test of add(House element), list should contain bingo street");
		test.Display();
		test.add(3, c);
		System.out.println("test of add(int position, House element), list should contain caviar street at postion 3");
		test.Display();
		System.out.println("test of add(House element), list should contain drama street");
		test.addLast(d);
		test.Display();
		
		
		System.out.println("test of remove(House target), caviar street should be removed from list and statement should be true: "
				+ test.remove(c));
		test.Display();
		test.removeLast();
		System.out.println("test of removeLast(), last item should be removed");
		test.Display();
		System.out.println("test of addLast(), last item should be caviar street");
		test.addLast(c);
		test.Display();
		System.out.println("test of addLast(), last item should be drama street");
		test.addLast(d);
		test.Display();
		System.out.println("test of addLast(), last item should be caviar street");
		System.out.println("test of countRange(House start, House end)"
				+ " number of elements falling between apple street and drama street = " + "\n" + test.countRange(a, d));
		test.set(2, e);
		System.out.println("test of set(int position, House element), second item should be easter street");
		test.Display();
		System.out.println("test of total(), total value of all the square feet in the list = " + test.total());
		System.out.println("bellow is a link list created by lessThan method for all elements smaller than easter street");
		System.out.println(test.lessThan(e).Display());
		test.Display();
		System.out.println("test of max(), max value in list is E = " + test.max());
		System.out.println("using advanced for loop to test iterator, full list should display");
		for (House thing : test) {
		    System.out.println(thing);
		}
	
	}}


