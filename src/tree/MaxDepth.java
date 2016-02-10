package tree;

public class MaxDepth {
	public static int maxDepth(TreeNode<Integer> node){
		if(node == null)
			return 0;
		
		return 1+Math.max(maxDepth(node.leftChild),maxDepth(node.rightChild));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> t1 = new TreeNode<Integer>(1);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.rightChild = new TreeNode<Integer>(3);
		t1.leftChild.rightChild = new TreeNode<Integer>(4);
		t1.leftChild.leftChild = new TreeNode<Integer>(5);
		
		System.out.println(maxDepth(t1));
	}
}
