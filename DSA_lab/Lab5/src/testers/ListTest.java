package testers;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
	
	public static void testSize(List<String> list) {
		System.out.print("test size ... ");
		assertEquals(0, list.size());
		list.add("a");
		assertEquals(1, list.size());
		list.add("a");
		assertEquals(2, list.size());
		list.add("a");
		list.add("a");
		list.add("a");
		assertEquals(5, list.size());
		System.out.println("checked");
	}
	
	public static void testClear(List<String> list) {
		System.out.print("test clear ... ");
		list.add("a");
		list.add("a");
		list.clear();
		assertEquals(0, list.size());
		list.clear();
		assertEquals(0, list.size());
		System.out.println("checked");
	}
	
	public static void testIndex(List<String> list) {
		System.out.print("test indexOf ... ");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("a");
		assertEquals(0, list.indexOf("a"));
		assertEquals(1, list.indexOf("b"));
		assertEquals(2, list.indexOf("c"));
		assertEquals(3, list.indexOf("d"));
		assertEquals(-1, list.indexOf("e"));
		System.out.println("checked");
	}
	
	public static void testLastIndex(List<String> list) {
		System.out.print("test lastIndexOf ... ");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("a");
		assertEquals(4, list.lastIndexOf("a"));
		assertEquals(1, list.lastIndexOf("b"));
		assertEquals(2, list.lastIndexOf("c"));
		assertEquals(3, list.lastIndexOf("d"));
		assertEquals(-1, list.lastIndexOf("e"));
		System.out.println("checked");
	}
	
	public static void testGetInt(List<String> list) {
		System.out.print("test get(int) ... ");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
		assertEquals("d", list.get(3));
		assertEquals("e", list.get(4));
		assertEquals("f", list.get(5));
		assertEquals("g", list.get(6));
		assertEquals("h", list.get(7));
		System.out.println("checked");
	}
	
	public static void testAddInt(List<String> list) {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		list.add(0, "m");
		assertEquals(0, list.indexOf("m"));
		
		list.add(3, "n");
		assertEquals(3, list.indexOf("n"));
	}
	
	public static void testRemoveInt(List<String> list) {
		System.out.print("test remove(int) ... ");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		assertEquals("d", list.remove(3));
		assertEquals("c", list.remove(2));
		System.out.println("checked");
	}
	
	public static void testSetInt(List<String> list) {
		System.out.print("test set(int) ... ");
		list.add("a");
		list.add("b");
		list.add("c");
		list.set(2, "m");
		assertEquals(2, list.indexOf("m"));
		System.out.println("checked");
	}
	
	public static void testAddObj(List<String> list) {
		System.out.print("test remove(Object) ... ");
		list.add("a");
		list.add("b");
		assertEquals(2, list.size());
		list.add("c");
		list.add("d");
		assertEquals(4, list.size());
		System.out.println("checked");
	}
	
	public static void testRemoveObj(List<String> list) {
		System.out.print("test remove(Object) ... ");
		list.add("a");
		list.add("b");
		list.add("c");
		assertEquals(true, list.remove("b"));
		assertEquals(2, list.size());
		System.out.println("checked");
	}
	
	public static void testIteratorRemove(List<String> list) {
        System.out.print("test iterator.remove ... ");
        for(int i = 0; i < 10; i++)
            list.add("" + i);
        assertEquals(10, list.size());
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String item = it.next();
            if(Integer.parseInt(item)%2 != 0)
                it.remove();
        }
        assertEquals(5, list.size());
        assertEquals("2", list.get(1));
        assertEquals("8", list.get(4));
		System.out.println("checked");
	}
	
	public static void testListIteratorRemove(List<String> list) {
        System.out.print("test iterator.remove forward ... ");
        for(int i = 0; i < 10; i++)
            list.add("" + i);
        assertEquals(10, list.size());
        ListIterator<String> it = list.listIterator();
        while(it.hasNext()){
            String item = it.next();
            if(Integer.parseInt(item)%2 != 0)
                it.remove();
        }
        assertEquals(5, list.size());
        assertEquals("2", list.get(1));
        assertEquals("8", list.get(4));
		System.out.println("checked");
	}
	
	public static void testListIteratorRemoveBackward(List<String> list) {
        System.out.print("test iterator.remove backward ... ");
        for(int i = 0; i < 10; i++)
            list.add("" + i);
        assertEquals(10, list.size());
        ListIterator<String> it = list.listIterator(list.size());
        while(it.hasPrevious()){
            String item = it.previous();
            if(Integer.parseInt(item)%2 != 0)
                it.remove();
        }
        assertEquals(5, list.size());
        assertEquals("2", list.get(1));
        assertEquals("8", list.get(4));
		System.out.println("checked");
	}
	
	
	public static void testListIteratorSet(List<String> list) {
        System.out.print("test listIterator.set forward ... ");
        for(int i = 0; i < 10; i++)
            list.add("" + i);
        assertEquals(10, list.size());
        ListIterator<String> it = list.listIterator();
        while(it.hasNext()){
            String item = it.next();
            if(Integer.parseInt(item)%2 != 0){
                String new_item =  String.format("%d", Integer.parseInt(item)*2);
                it.set(new_item);
            }
        }
        assertEquals(10, list.size());
        assertEquals("0", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("2", list.get(2));
        assertEquals("6", list.get(3));
        assertEquals("18", list.get(9));
		System.out.println("checked");
	}
	
    public static void testListIteratorSetBackward(List<String> list){
        System.out.print("test listIterator.set backward ... ");
        for(int i = 0; i < 10; i++)
            list.add("" + i);
        assertEquals(10, list.size());
        ListIterator<String> it = list.listIterator(list.size());
        while(it.hasPrevious()){
            String item = it.previous();
            if(Integer.parseInt(item)%2 != 0){
                String new_item =  String.format("%d", Integer.parseInt(item)*2);
                it.set(new_item);
            }
        }
        assertEquals(10, list.size());
        assertEquals("0", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("2", list.get(2));
        assertEquals("6", list.get(3));
        assertEquals("18", list.get(9));
		System.out.println("checked");
    }
    
    public static void testListIteratorAdd(List<String> list){
        System.out.print("test listIterator.add with next() ... ");
        for(int i = 0; i < 10; i++)
            list.add("" + i);
        assertEquals(10, list.size());
        
        ListIterator<String> it = list.listIterator();
        while(it.hasNext()){
            String item = it.next();
            if(Integer.parseInt(item)%2 != 0){
                String new_item =  String.format("%d", Integer.parseInt(item)*2);
                it.add(new_item);
            }
        }
        assertEquals(15, list.size());        
        assertEquals("0", list.get(0));
        assertEquals("1", list.get(1));
        assertEquals("2", list.get(2));
        assertEquals("2", list.get(3));
        assertEquals("9", list.get(13));
        assertEquals("18", list.get(14));
        
		System.out.println("checked");
    }
    
    public static void testListIteratorAddBackward(List<String> list){
        System.out.print("test listIterator.add with previous() ... ");
        for(int i = 0; i < 10; i++)
            list.add("" + i);
        assertEquals(10, list.size());
        
        ListIterator<String> it = list.listIterator(list.size());
        while(it.hasPrevious()){
            String item = it.previous();
            if(Integer.parseInt(item)%2 != 0){
                String new_item =  String.format("%d", Integer.parseInt(item)*2);
                it.add(new_item);
            }
        }
        assertEquals(15, list.size());

        assertEquals("0", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("1", list.get(2));
        assertEquals("2", list.get(3));
        assertEquals("18", list.get(13));
        assertEquals("9", list.get(14));
		System.out.println("checked");
    }
	
	
}
