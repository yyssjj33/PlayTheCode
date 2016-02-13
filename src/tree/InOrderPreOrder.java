package tree;
import java.util.*;
public class InOrderPreOrder {
	public static void inOrder(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		TreeNode<Integer> cur = root;
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				stack.push(cur);
				cur = cur.leftChild;
			}
			cur = stack.pop();
			System.out.print( cur.element + " ");
			cur = cur.rightChild;
		}
	}

	public static void preOrder(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode<Integer> cur = stack.pop();
			System.out.print(cur.element+ " ");
			if (cur.rightChild != null)
				stack.push(cur.rightChild);
			if (cur.leftChild != null)
				stack.push(cur.leftChild);
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
		preOrder(t1);
	}
}
