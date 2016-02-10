package tree;

public class IsTreeIdentical {

	public static boolean isIdentical(TreeNode<Integer> t1, TreeNode<Integer> t2){
		if(t1 == null && t2 == null)
			return true;
		if(t1 != null && t2 != null){
			
			return (t1.element == t2.element && 
					isIdentical(t1.leftChild,t2.leftChild)&&
					isIdentical(t1.rightChild,t2.rightChild));
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> t1 = new TreeNode<Integer>(1);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.rightChild = new TreeNode<Integer>(3);
		t1.leftChild.rightChild = new TreeNode<Integer>(4);
		t1.leftChild.leftChild = new TreeNode<Integer>(5);
		
		TreeNode<Integer> t2 = new TreeNode<Integer>(1);
		t2.leftChild = new TreeNode<Integer>(2);
		t2.rightChild = new TreeNode<Integer>(3);
		t2.leftChild.rightChild = new TreeNode<Integer>(4);
		t2.leftChild.leftChild = new TreeNode<Integer>(5);
		
		System.out.println(isIdentical(t1, t2));
	}

}
