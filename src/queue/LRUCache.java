package queue;

import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	int capacity;
	int size;
	Queue<Integer> checker;
	HashMap<Integer, Integer> cache;
	// @param capacity, an integer

	public LRUCache(int capacity) {
		// write your code here
		this.capacity = capacity;
		size = 0;
		checker = new LinkedList<Integer>();
		cache = new HashMap<Integer, Integer>(capacity);

	}

	// @return an integer
	public int get(int key) {
		// write your code here
		if (!cache.containsKey(key))
			return -1;
		return cache.get(key);
	}

	// @param key, an integer
	// @param value, an integer
	// @return nothing
	public void set(int key, int value) {
		// write your code here
		if (size < this.capacity) {
			cache.put(key, value);
			checker.offer(key);
			size++;
			return;
		}
		if (size == this.capacity) {
			if (cache.containsKey(key)) {
				
				checker.remove(key);
				checker.offer(key);
				cache.put(key, value);
			} else {
				int polled = checker.poll();
				cache.remove(polled);
				cache.put(key, value);
				checker.offer(key);
			}

		}
	}

	public static void main(String[] args) {
		LRUCache c = new LRUCache(3);
		int[] input = { 7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1 };
		 for (Integer i: input){
			 c.set(i,i);
			 System.out.println("Add num " + i + ", the cache has "+c.cache.toString());
		 }
//		c.set(2, 1);
//		c.set(1, 1);
//		System.out.println(c.get(2));
//		c.set(4, 1);
//		System.out.println(c.get(1));
	}
}
