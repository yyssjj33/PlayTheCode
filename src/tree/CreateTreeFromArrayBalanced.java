package tree;

import java.util.ArrayList;
import java.util.List;

public class CreateTreeFromArrayBalanced {
	public static TreeNode<Integer> createTree(int[] array){

		return createTree(array, 0, array.length-1);
	}
	public static TreeNode<Integer> createTree(int[] array, int start, int end){
		if (start > end) return null;
		int mid = (start + end)/2;
		TreeNode<Integer> root = new TreeNode<Integer>(array[mid]);
		root.leftChild = createTree(array, start, mid - 1);
		root.rightChild = createTree(array, mid + 1, end);
		return root;
	}
	
	public static void main(String[] args) {
		int[] list = {1,2,3,4,5,6,7};
		TreeNode<Integer> root = createTree(list);
		BST bst = new BST(root);
		bst.inOrder();
		System.out.println();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = LevelOrder.levelOrder(root);
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i).toString());
		}
	}
}
