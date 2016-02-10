package tree;

public class TreeNode<E extends Comparable<E>> {
	protected E element;
	protected TreeNode<E> leftChild;
	protected TreeNode<E> rightChild;
	public TreeNode(E e){
		element = e;
	}
}
