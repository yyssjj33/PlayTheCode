package tree;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
	protected TreeNode<E> root;
	protected int size;

	public BST() {

	}
	
	public BST(TreeNode<E> root){
		this.root = root;
	}

	public BST(E[] objects) {
		for (E e : objects)
			insert(e);
	}

	@Override
	public boolean search(E e) {
		TreeNode<E> current = root;
		while (current != null) {
			if (e.compareTo(current.element) < 0)
				current = current.leftChild;
			if (e.compareTo(current.element) > 0)
				current = current.rightChild;
			else
				return true;
		}
		return false;
	}

	@Override
	public boolean insert(E e) {
		if (root == null)
			root = new TreeNode<E>(e);
		TreeNode<E> current = root;
		TreeNode<E> parent = null;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.leftChild;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.rightChild;
			} else
				return false;// duplicated find, not allowed
		}

		if (e.compareTo(parent.element) > 0)
			parent.rightChild = new TreeNode<E>(e);
		else
			parent.leftChild = new TreeNode<E>(e);

		size++;
		return true;
	}

	
	public void inOrder() {
		inOrder(root);
	}

	protected void inOrder(TreeNode<E> root) {
		if (root == null)
			return;
		inOrder(root.leftChild);
		System.out.print(root.element + " ");
		inOrder(root.rightChild);
		
	}

	public void postOrder() {
		postOrder(root);
	}

	protected void postOrder(TreeNode<E> root) {
		if (root == null)
			return;
		postOrder(root.leftChild);
		postOrder(root.rightChild);
		System.out.print(root.element + " ");
	}

	public void preOrder() {
		preOrder(root);
	}

	protected void preOrder(TreeNode<E> root) {
		if (root == null)
			return;
		System.out.print(root.element + " ");
		preOrder(root.leftChild);
		preOrder(root.rightChild);
	}

	@Override
	public boolean delete(E e) {
		TreeNode<E> current = root;
		TreeNode<E> parent = null;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.leftChild;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.rightChild;
			} else
				break;
		}
		if (current == null)
			return false;
		// case 1: current has no left
		if (current.leftChild == null) {
			if (parent == null)
				root = current.rightChild;
			else {
				if (e.compareTo(parent.element) < 0)
					parent.leftChild = current.rightChild;
				else
					parent.rightChild = current.rightChild;
			}
		} else {
			// case 2: current has left child
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.leftChild;

			while (rightMost.rightChild != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.rightChild;
			}
			current.element = rightMost.element;
			if (parentOfRightMost.rightChild == rightMost)
				parentOfRightMost.rightChild = rightMost.leftChild;
			else
				parentOfRightMost.leftChild = rightMost.leftChild;
		}
		size--;

		return false;
	}

	@Override
	public int getSize() {
		return size;
	}
	
	public int calcSize(){
		return calcSize(root);
	}
	private int calcSize(TreeNode<E> root){
		if(root == null)
			return 0;
		
		return calcSize(root.leftChild)+calcSize(root.rightChild)+1;
	}
	
	public TreeNode<E> getRoot() {
		return root;
	}

	// return a path from root to some node
	public java.util.ArrayList<TreeNode<E>> path(E e) {
		java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
		TreeNode<E> current = root;
		while (current != null) {
			list.add(current);
			if (e.compareTo(current.element) < 0)
				current = current.leftChild;
			else if (e.compareTo(current.element) > 0)
				current = current.rightChild;
			else
				break;
		}
		return list;
	}

	@Override /** Obtain an iterator. Use inorder. */
	public java.util.Iterator<E> iterator() {
		return new InorderIterator();
	}
	
	public class InorderIterator implements java.util.Iterator<E>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	


}
