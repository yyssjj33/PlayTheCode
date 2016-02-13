package tree;
import tree.InOrderPreOrder;
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public static TreeNode<Integer> construct(int[] inorder, int[] preorder){
		if (inorder.length == 0 || preorder.length == 0)
			return null;
		return construct(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
	}
	
	public static TreeNode<Integer> construct(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd){
        // 	       0,1,2,3,4,5,6
		//inorder [1,2,3,4,5,6,7]
        //preorder[4,2,1,3,6,5,7]
		if (inStart > inEnd && preStart > preEnd)
			return null;
		TreeNode<Integer> root = new TreeNode<Integer>(preorder[preStart]);
		int inRootIndex = 0;
		for (int i = inStart; i <= inEnd; i++){
			if (preorder[preStart] == inorder[i]){
				inRootIndex = i;
				break;
			}
		}
		int leftRemain = inRootIndex - inStart;

		//left
		root.leftChild = construct(inorder, preorder,inStart, inRootIndex-1,preStart+1,preStart+leftRemain);
		root.rightChild = construct(inorder, preorder,inRootIndex+1, inEnd, preStart+leftRemain+1 ,preEnd);
		return root;
	}
	public static void main(String[] args) {
		TreeNode<Integer> t1;
		int[] in = {1,2,3,4,5,6,7};
		int[] pre = {4,2,1,3,6,5,7};
		t1=construct(in, pre);
		System.out.println(t1.element);
		System.out.println(t1.leftChild.element);
		System.out.println(t1.rightChild.element);
		System.out.println(t1.leftChild.leftChild.element);
	}
}
