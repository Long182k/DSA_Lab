package testers;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import list.MyStack;

public class MyStackTest {
	
	@BeforeClass
	public static void setup() {
		System.out.println("Start testing procedure for MyStack");
	}
	
	@Test
	public void testEmpty() {
		System.out.print("test empty() ... ");
		MyStack<Integer> stack = new MyStack<Integer>();
		assertEquals(true, stack.empty());
		stack.push(0);
		assertEquals(false, stack.empty());
		stack.push(0);
		assertEquals(false, stack.empty());
		stack.pop();
		stack.pop();
		assertEquals(true, stack.empty());
		System.out.println("checked");
	}
	
	@Test
	public void testPop() {
		System.out.print("test pop() ... ");
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		assertEquals((Integer) 30, stack.pop());
		assertEquals((Integer) 20, stack.pop());
		assertEquals((Integer) 10, stack.pop());
		System.out.println("checked");
	}
	
	@Test
	public void testPeek() {
		System.out.print("test peek() ... ");
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		assertEquals((Integer) 30, stack.peek());
		assertEquals((Integer) 30, stack.peek());
		stack.pop();
		assertEquals((Integer) 20, stack.peek());
		System.out.println("checked");
	}
	
	@Test
	public void testSearch() {
		System.out.print("test search() ... ");
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		assertEquals(3, stack.search(10));
		assertEquals(2, stack.search(20));
		assertEquals(1, stack.search(30));
		assertEquals(-1, stack.search(40));
		System.out.println("checked");
	}

}
