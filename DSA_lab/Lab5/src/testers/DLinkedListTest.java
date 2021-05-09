package testers;

import org.junit.BeforeClass;
import org.junit.Test;

import list.DLinkedList;

public class DLinkedListTest {
	
	@BeforeClass
	public static void setup() {
		System.out.println("Start testing procedure for DLinkedList");
	}
	
	@Test
	public void testSize() {
		ListTest.testSize(new DLinkedList<String>());
	}
	
	@Test
	public void testClear() {
		ListTest.testClear(new DLinkedList<String>());
	}
	
	@Test
	public void testIndexOf() {
		ListTest.testIndex(new DLinkedList<String>());
	}
	
	@Test
	public void testLastIndexOf() {
		ListTest.testLastIndex(new DLinkedList<String>());
	}
	
	@Test
	public void testGetInt() {
		ListTest.testGetInt(new DLinkedList<String>());
	}
	
	@Test
	public void testAddInt() {
		ListTest.testAddInt(new DLinkedList<String>());
	}
	
	@Test
	public void testRemoveInt() {
		ListTest.testRemoveInt(new DLinkedList<String>());
	}
	
	@Test
	public void testSetInt() {
		ListTest.testSetInt(new DLinkedList<String>());
	}
	
	@Test
	public void testAddObj() {
		ListTest.testAddObj(new DLinkedList<String>());
	}
	
	@Test
	public void testRemoveObj() {
		ListTest.testRemoveObj(new DLinkedList<String>());
	}
	
	@Test
	public void testIteratorRemove() {
		ListTest.testIteratorRemove(new DLinkedList<String>());
	}
	
	@Test
	public void testListIteratorRemove() {
		ListTest.testListIteratorRemove(new DLinkedList<String>());
	}
	
	@Test
	public void testListIteratorRemoveBackward() {
		ListTest.testListIteratorRemoveBackward(new DLinkedList<String>());
	}
	
	@Test
	public void testListIteratorSet() {
		ListTest.testListIteratorSet(new DLinkedList<String>());
	}
	
	@Test
	public void testListIteratorSetBackward() {
		ListTest.testListIteratorSetBackward(new DLinkedList<String>());
	}
	
	@Test
	public void testListIteratorAdd() {
		ListTest.testListIteratorAdd(new DLinkedList<String>());
	}
	
	@Test
	public void testListIteratorAddBackward() {
		ListTest.testListIteratorAddBackward(new DLinkedList<String>());
	}
}
