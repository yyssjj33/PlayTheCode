package tree;

public class HasPathSum {
	public static boolean hasPathSum(TreeNode<Integer> node, int sum) {
		if (node == null)
			return sum == 0;

		return hasPathSum(node.leftChild, sum - node.element) || hasPathSum(node.rightChild, sum - node.element);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> t1 = new TreeNode<Integer>(1);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.rightChild = new TreeNode<Integer>(3);
		t1.leftChild.rightChild = new TreeNode<Integer>(4);
		t1.leftChild.leftChild = new TreeNode<Integer>(5);
		System.out.println(hasPathSum(t1, 8));
	}
}
