package testers;

import org.junit.BeforeClass;
import org.junit.Test;

import list.SLinkedList;

public class SLinkedListTest {
	
	@BeforeClass
	public static void setup() {
		System.out.println("Start testing procedure for SLinkedList");
	}
	
	@Test
	public void testSize() {
		ListTest.testSize(new SLinkedList<String>());
	}
	
	@Test
	public void testClear() {
		ListTest.testClear(new SLinkedList<String>());
	}
	
	@Test
	public void testIndexOf() {
		ListTest.testIndex(new SLinkedList<String>());
	}
	
	@Test
	public void testLastIndexOf() {
		ListTest.testLastIndex(new SLinkedList<String>());
	}
	
	@Test
	public void testGetInt() {
		ListTest.testGetInt(new SLinkedList<String>());
	}
	
	@Test
	public void testAddInt() {
		ListTest.testAddInt(new SLinkedList<String>());
	}
	
	@Test
	public void testRemoveInt() {
		ListTest.testRemoveInt(new SLinkedList<String>());
	}
	
	@Test
	public void testSetInt() {
		ListTest.testSetInt(new SLinkedList<String>());
	}
	
	@Test
	public void testAddObj() {
		ListTest.testAddObj(new SLinkedList<String>());
	}
	
	@Test
	public void testRemoveObj() {
		ListTest.testRemoveObj(new SLinkedList<String>());
	}
	
	@Test
	public void testIteratorRemove() {
		ListTest.testIteratorRemove(new SLinkedList<String>());
	}
	
	@Test
	public void testListIteratorRemove() {
		ListTest.testListIteratorRemove(new SLinkedList<String>());
	}
	
	@Test
	public void testListIteratorSet() {
		ListTest.testListIteratorSet(new SLinkedList<String>());
	}
	
	@Test
	public void testListIteratorAdd() {
		ListTest.testListIteratorAdd(new SLinkedList<String>());
	}
}
