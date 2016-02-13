package tree;

import java.util.Stack;

public class ClosestValueInBST {
	public static int find(TreeNode<Integer> root, int target){
		int res = 0;
		int min = Integer.MAX_VALUE;
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		TreeNode<Integer> cur = root;
		while(cur != null || !stack.isEmpty()){
			while(cur!=null){
				stack.push(cur);
				cur = cur.leftChild;
			}
			
			cur = stack.pop();
			System.out.print(cur.element+" ");
			if (min > Math.abs(cur.element - target)){
				min = Math.abs(cur.element - target);
				res = cur.element;
			}
			cur = cur.rightChild;
		}
		return res;
	}
	public static int findRec(TreeNode<Integer> root, int target){
		if (root == null){
			return Integer.MAX_VALUE;
		}
		if (target > root.element){
			return  Math.min(Math.abs(root.element - target),Math.abs(root.rightChild.element - target));
		}else{
			return  Math.min(Math.abs(root.element - target),Math.abs(root.leftChild.element - target));
		}
	}
	public static void main(String[] args) {
		TreeNode<Integer> t1 = new TreeNode<Integer>(4);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.rightChild = new TreeNode<Integer>(6);
		t1.leftChild.rightChild = new TreeNode<Integer>(3);
		t1.leftChild.leftChild = new TreeNode<Integer>(1);
		t1.rightChild.rightChild = new TreeNode<Integer>(7);
		t1.rightChild.leftChild = new TreeNode<Integer>(5);
		int res = findRec(t1, 4);
		System.out.println(res);
	}
}	
