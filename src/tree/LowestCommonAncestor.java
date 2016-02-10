package tree;

public class LowestCommonAncestor {

	public static TreeNode<Integer> lca(TreeNode<Integer> root, TreeNode<Integer> node1, TreeNode<Integer> node2) {

		while (root != null) {

			if (root.element < node1.element && root.element < node2.element) {
				root = root.rightChild;
			}
			if (root.element > node1.element && root.element > node2.element) {
				root = root.leftChild;
			}
			else
				break;
		}

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> t1 = new TreeNode<Integer>(4);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.rightChild = new TreeNode<Integer>(5);
		t1.leftChild.rightChild = new TreeNode<Integer>(3);
		t1.leftChild.leftChild = new TreeNode<Integer>(1);
		TreeNode<Integer> out = lca(t1, new TreeNode<Integer>(1), new TreeNode<Integer>(2));
		System.out.println(out.element);
	}

}
