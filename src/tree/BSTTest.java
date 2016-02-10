package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class BSTTest {

	public static void main(String[] args) {
		Integer[] nums = {1,2,3,4,5,6};
		BST<Integer> bst = new BST<Integer>(nums);
		ArrayList<TreeNode<Integer>> list = bst.path(4);
		
		bst.inOrder();
		System.out.println(bst.calcSize());
//		for(TreeNode<Integer> tn:list){System.out.print(tn.element+" ");}
//		System.out.println(bst.search(10));
		
	}

}
