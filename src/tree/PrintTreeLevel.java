package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTreeLevel {
	
	public static void print(TreeNode<Integer> root, int cur, int level){
		if (root == null || cur > level)
			return;
		if (cur == level)
			System.out.print(root.element + " " );
		else{
			print(root.leftChild, cur+1, level);
			print(root.rightChild, cur+1, level);
		}
	}
	public static void print(TreeNode<Integer> root, int level) {
		Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
		q.add(root);
		int levelCount = 0;
		while (!q.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode<Integer> temp = q.poll();
				if (temp != null)
					list.add(temp.element);
				if (temp.leftChild != null)
					q.add(temp.leftChild);
				if (temp.rightChild != null)
					q.add(temp.rightChild);
			}
			
			if (levelCount==level){
				System.out.println(list);
				return;
			}
			levelCount++;
				
		}
	}
	public static void main(String[] args) {
		TreeNode<Integer> t1 = new TreeNode<Integer>(1);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.rightChild = new TreeNode<Integer>(3);
		t1.rightChild.rightChild = new TreeNode<Integer>(5);
		t1.rightChild.leftChild = new TreeNode<Integer>(4);
		print(t1, 0, 2);
	}
}
