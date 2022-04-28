package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
	
	@Test
	public void TestQueue_1() {
		// Dequeue is called on a empty Queue
		Queue queue = new Queue(3);
		try {queue.dequeue();}
		catch(IllegalStateException e) {	
		}
	}
	@Test
	public void TestQueue_2() {
		// Check if the last position was overwritten
		Queue queue = new Queue(3);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.dequeue();
		queue.dequeue();
		assertTrue(queue.dequeue() == 40);
	}
	@Test
	public void TestQueue_3() {
		// Check if the order is as expected after the first value is dequeued
		Queue queue = new Queue(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		queue.enqueue(4);
		assertTrue(queue.dequeue() == 2);
		assertTrue(queue.dequeue() == 3);
		assertTrue(queue.dequeue() == 4);
	}
}