package tree;

import java.util.ArrayList;
import java.util.List;
public class CreateTreeFromArrayLevelOrder {
	public static TreeNode<Integer> create(int[] array){
		return create(array, 0);
	}

	private static TreeNode<Integer> create(int[] array, int start){
		if(start >= array.length || array[start] == -1) return null;
		TreeNode<Integer> root = new TreeNode<>(array[start]);
		root.leftChild = create(array, start*2+1);
		root.rightChild = create(array, start*2+2);
		return root;
	}
	
	private static void inOrder(TreeNode<Integer> root){
		if (root == null)
			return;
		inOrder(root.leftChild);
		System.out.print(root.element+" ");
		inOrder(root.rightChild);
	}
	
	public static void main(String[] args) {
		int[] list = {1,2,3,-1,-1,4,5};
		TreeNode<Integer> root = create(list);
		inOrder(root);
		System.out.println();
		LevelOrder lo = new LevelOrder();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = LevelOrder.levelOrder(root);
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i).toString());
		}
		
		
	}
	
}
