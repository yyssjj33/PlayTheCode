package tree;

public class InvertTree {
	
	public static void invertTree(TreeNode<Integer> node){
		if (node == null)
			return;
		
		invertTree(node.leftChild);
		invertTree(node.rightChild);
		TreeNode<Integer> temp = node.leftChild;
		node.leftChild = node.rightChild;
		node.rightChild = temp;
		
	}

	protected static void inOrder(TreeNode<Integer> root) {
		if (root == null)
			return;
		inOrder(root.leftChild);
		System.out.print(root.element + " ");
		inOrder(root.rightChild);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> t1 = new TreeNode<Integer>(1);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.leftChild.leftChild = new TreeNode<Integer>(3);
		inOrder(t1);
		invertTree(t1);
		inOrder(t1);

	}

}
