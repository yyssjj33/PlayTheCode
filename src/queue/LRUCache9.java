package queue;

import java.util.HashMap;

public class LRUCache9 {
	private class Node {
		Node prev;
		Node next;
		int key;
		int val;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.prev = null;
			this.next = null;
		}
		
	}
	private int capacity;
	private HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
	private Node head = new Node(-1,-1);
	private Node tail = new Node(-1,-1);
	
	private void delete(Node node){
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	private void addTail(Node node){
		node.next = tail;
		tail.prev.next = node;
		node.prev = tail.prev;
		tail.prev = node;
		
	}
	
	public LRUCache9(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (hm.containsKey(key)){
			Node temp = hm.get(key);
			delete(temp);
			addTail(temp);
			return hm.get(key).val;
		}
		return -1;
	}

	public void set(int key, int value){
		if (hm.size() < this.capacity){
			if (!hm.containsKey(key)){
		    	Node node = new Node(key, value);
			    addTail(node);
			    hm.put(key, node);
			    return;
		    }else{
		        Node node = hm.get(key);
		        delete(node);
		        Node newNode = new Node(key, value);
		        addTail(newNode);
		        hm.put(key,newNode);
		        return;
		        
		    }
		}
		if (hm.size() == this.capacity){
			if (!hm.containsKey(key)){
				Node node = head.next;
				delete(node);
				hm.remove(node.key);
				Node newNode = new Node(key, value);
				addTail(newNode);
				hm.put(key, newNode);
			}else{
				Node node = hm.get(key);
				delete(node);
				hm.remove(key);
				Node newNode = new Node(key, value);
				addTail(newNode);
				hm.put(key, newNode);
			}
		}
	}
	public static void main(String[] args) {
		LRUCache9 c = new LRUCache9(2);
		c.set(2, 1);
		c.set(1, 1);
		System.out.println(c.get(2));
		c.set(4, 1);
		System.out.println(c.get(1));
		
	}
}
