package tree;

public class inOrderSuccesser {
	
	static class TreeNode {
	    int val;
	   TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		 TreeNode successor = null;
	        while (root != null && root.val != p.val) {
	            if (root.val > p.val) {
	                successor = root;
	                root = root.left;
	            } else {
	                root = root.right;
	            }
	        }
	        
	        if (root == null) {
	            return null;
	        }
	        
	        if (root.right == null) {
	            return successor;
	        }
	        
	        root = root.right;
	        while (root.left != null) {
	            root = root.left;
	        }
	        
	        return root;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		TreeNode result = inorderSuccessor(root, new TreeNode(1));
		System.out.println(result.val);
	}
}
