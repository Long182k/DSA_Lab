package testers;

import org.junit.BeforeClass;
import org.junit.Test;

import list.MyArrayList;

public class MyArrayListTest {
	
	@BeforeClass
	public static void setup() {
		System.out.println("Start testing procedure for MyArrayList");
	}
	
	@Test
	public void testSize() {
		ListTest.testSize(new MyArrayList<String>());
	}
	
	@Test
	public void testClear() {
		ListTest.testClear(new MyArrayList<String>());
	}
	
	@Test
	public void testIndexOf() {
		ListTest.testIndex(new MyArrayList<String>());
	}
	
	@Test
	public void testLastIndexOf() {
		ListTest.testLastIndex(new MyArrayList<String>());
	}
	
	@Test
	public void testGetInt() {
		ListTest.testGetInt(new MyArrayList<String>());
	}
	
	@Test
	public void testAddInt() {
		ListTest.testAddInt(new MyArrayList<String>());
	}
	
	@Test
	public void testRemoveInt() {
		ListTest.testRemoveInt(new MyArrayList<String>());
	}
	
	@Test
	public void testSetInt() {
		ListTest.testSetInt(new MyArrayList<String>());
	}
	
	@Test
	public void testAddObj() {
		ListTest.testAddObj(new MyArrayList<String>());
	}
	
	@Test
	public void testRemoveObj() {
		ListTest.testRemoveObj(new MyArrayList<String>());
	}
	
	@Test
	public void testIteratorRemove() {
		ListTest.testIteratorRemove(new MyArrayList<String>());
	}
	
	@Test
	public void testListIteratorRemove() {
		ListTest.testListIteratorRemove(new MyArrayList<String>());
	}
	
	@Test
	public void testListIteratorRemoveBackward() {
		ListTest.testListIteratorRemoveBackward(new MyArrayList<String>());
	}
	
	@Test
	public void testListIteratorSet() {
		ListTest.testListIteratorSet(new MyArrayList<String>());
	}
	
	@Test
	public void testListIteratorSetBackward() {
		ListTest.testListIteratorSetBackward(new MyArrayList<String>());
	}
	
	@Test
	public void testListIteratorAdd() {
		ListTest.testListIteratorAdd(new MyArrayList<String>());
	}
	
	@Test
	public void testListIteratorAddBackward() {
		ListTest.testListIteratorAddBackward(new MyArrayList<String>());
	}
}