package tree;

public class IsSymmetricTree {
	public static boolean isSymmetric(TreeNode<Integer> root){
		if (root == null)
			return true;
		return isSymmetric(root.leftChild, root.rightChild);
		
	}
	
	public static boolean isSymmetric(TreeNode<Integer> l, TreeNode<Integer> r){
		
		if (l == null || r == null) return l == null && r == null;
		
		return l.element == r.element && isSymmetric(l.leftChild, r.rightChild) && isSymmetric(l.rightChild, r.leftChild);
		
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> t1 = new TreeNode<Integer>(1);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.rightChild = new TreeNode<Integer>(2);
		System.out.println(isSymmetric(t1));
	}
}
