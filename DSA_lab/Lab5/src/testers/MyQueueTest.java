package testers;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import list.MyQueue;


public class MyQueueTest {
	
	@BeforeClass
	public static void setup() {
		System.out.println("Start testing procedure for MyQueue");
	}
	
	@Test
	public void testEmpty() {
		System.out.print("test empty() ... ");
		MyQueue<Integer> queue = new MyQueue<Integer>();
		assertEquals(true, queue.empty());
		queue.enqueue(0);
		assertEquals(false, queue.empty());
		queue.enqueue(0);
		assertEquals(false, queue.empty());
		queue.dequeue();
		queue.dequeue();
		assertEquals(true, queue.empty());
		System.out.println("checked");
	}
	
	@Test
	public void testDequeue() {
		System.out.print("test dequeue() ... ");
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		assertEquals((Integer) 10, queue.dequeue());
		assertEquals((Integer) 20, queue.dequeue());
		assertEquals((Integer) 30, queue.dequeue());
		System.out.println("checked");
	}
	
	@Test
	public void testPeek() {
		System.out.print("test peek() ... ");
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		assertEquals((Integer) 10, queue.peek());
		assertEquals((Integer) 10, queue.peek());
		queue.dequeue();
		assertEquals((Integer) 20, queue.peek());
		System.out.println("checked");
	}

}
