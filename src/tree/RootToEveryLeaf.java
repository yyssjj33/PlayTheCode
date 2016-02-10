package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class RootToEveryLeaf {
	// use preOrder
	public static void traverse(TreeNode<Integer> node) {
		String s = "";
		helper(node, s);

	}

	private static void helper(TreeNode<Integer> node, String s) {
		if (node.leftChild != null || node.rightChild !=null)
			s += node.element + "->";
		else
			s += node.element;
		if (node.leftChild != null)
			helper(node.leftChild, s);
		if (node.rightChild != null)
			helper(node.rightChild, s);
		if (node.rightChild == null && node.leftChild == null)
			System.out.println(s);
	}

	public static void traverse2(TreeNode<Integer> node) {
		// ArrayList<ArrayList<Integer>> list = new
		// ArrayList<ArrayList<Integer>>();
		int[] list = new int[5];
		ArrayList<Integer> sub = new ArrayList<Integer>();
		helper2(node, list, 0);

	}

	// private static void helper2(TreeNode<Integer> node, ArrayList<Integer>
	// sub) {
	private static void helper2(TreeNode<Integer> node, int[] sub, int len) {
		if (node == null)
			return;
		sub[len]=(node.element);
		len++;
		if (node.rightChild == null && node.leftChild == null) {
			for (int i = 0; i < len; i++) {
				System.out.print(sub[i]+" ");
			}
			System.out.println();
		}
		else{
			helper2(node.leftChild, sub, len);
			helper2(node.rightChild, sub, len);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> t1 = new TreeNode<Integer>(1);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.rightChild = new TreeNode<Integer>(3);
		t1.leftChild.rightChild = new TreeNode<Integer>(4);
		t1.leftChild.leftChild = new TreeNode<Integer>(5);
		t1.leftChild.leftChild.leftChild = new TreeNode<Integer>(6);
		traverse(t1);
		traverse2(t1);
		// for(int i = 0 ; i < list.size(); i++){
		// for(int j = 0; j<list.get(1).size(); j++){
		// System.out.print(list.get(i).get(j)+" ");
		// }
		// System.out.println();
		// }
	}

}
