package tree;

import java.util.Stack;

public class CheckIsBST {

	public static boolean isBSTSlow(TreeNode<Integer> node) {

		if (node == null)
			return true;
		if (node.leftChild != null && maxValue(node.leftChild) > node.element)
			return false;
		if (node.rightChild != null && minValue(node.rightChild) < node.element)
			return false;
		return isBSTSlow(node.leftChild) && isBSTSlow(node.rightChild);
	}

	public static int maxValue(TreeNode<Integer> node) {

		if (node.leftChild == null && node.rightChild == null)
			return node.element;
		else {
			return Math.max(maxValue(node.leftChild), maxValue(node.rightChild));
		}
	}

	public static int minValue(TreeNode<Integer> node) {

		if (node.leftChild == null && node.rightChild == null)
			return node.element;
		else {
			return Math.min(minValue(node.leftChild), minValue(node.rightChild));
		}
	}

	public static boolean isBSTFast(TreeNode<Integer> node) {
		return isBSTFastHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBSTFastHelper(TreeNode<Integer> node, int min, int max) {

		if (node == null)
			return true;
		
		if (node.element > min && node.element < max)
			return isBSTFastHelper(node.rightChild, node.element , max) && 
					isBSTFastHelper(node.leftChild, min, node.element);

		
		return false;

	}

	public static boolean isBSTInOrder(TreeNode<Integer> node) {
		PrevVal p = new PrevVal(Integer.MIN_VALUE);
		return isBSTInOrderHelper(node, p);
	}

	public static boolean isBSTInOrderHelper(TreeNode<Integer> node, PrevVal p) {
		if (node == null)
			return true;

			if (!isBSTInOrderHelper(node.leftChild, p))
				return false;
			if (p.val >= node.element)
				return false;
			p.val = node.element;
			if (!isBSTInOrderHelper(node.rightChild, p))
				return false;

		
		return true;
	}
	
	public static boolean isBSTIter(TreeNode<Integer> node) {
		Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();
		PrevVal p = new PrevVal(Integer.MIN_VALUE);
		TreeNode<Integer> cur = node;
		while (cur!=null || !s.isEmpty()){
			while(cur!=null){
				s.push(cur);
				cur = cur.leftChild;
			}
			cur = s.pop();
			if(cur.element<p.val) return false;
			p.val = cur.element;
			cur = cur.rightChild;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode<Integer> t1 = new TreeNode<Integer>(4);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.rightChild = new TreeNode<Integer>(5);
		t1.leftChild.rightChild = new TreeNode<Integer>(3);
		t1.leftChild.leftChild = new TreeNode<Integer>(1);
		System.out.println(isBSTIter(t1));
	}
}
class PrevVal{
	int val;
	PrevVal(int num){
		this.val = num;
	}
}