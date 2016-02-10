package tre;

public class BinarySearchTree {
	private TreeNode root;
	
	BinarySearchTree(int data){
		root = new TreeNode(data);
	}
	
	public void insert(int data){
		if (root == null)
			this.root = new TreeNode(data);
		else
			this.root.insert(data);
	}
	
	public TreeNode find(int data){
		if (root != null)
			return root.find(data);
		return null;
	}
	
	public Integer smallest(){
		if(root != null)
			return root.smallest();
		return null;
	}
	public Integer largest(){
		if(root != null)
			return root.largest();
		return null;
	}
	
	public void inOrder(){
		if (root == null)
			return;
		
		
	}
	
	public void softDelete(int data){
		TreeNode toDel = find(data);
		toDel.delete();
	}
	

	public void delete(int data){
		TreeNode current = this.root;
		TreeNode parent = this.root;
		boolean isLeftChild = false;
		
		if (current == null)
			return;
		while (current != null && current.getData() != data){
			parent =current;
			if(data < current.getData()){
				current = current.getLeftChild();
				isLeftChild = true;
			}else{
				current = current.getRightChild();
				isLeftChild = false;
			}
		}
		
		if (current == null)
			return;
		
		if (current.getLeftChild() == null && current.getRightChild() == null){//leaf node
			if (current == root){
				root = null;
			}else{
				if (isLeftChild)
					parent.setLeftChild(null);
				else
					parent.setRightChild(null);
			}
		}else if (current.getRightChild() == null){
			if (current == root){
				current = current.getLeftChild();
			}else if (isLeftChild){
				parent.setLeftChild(current.getLeftChild());
			}else{
				parent.setRightChild(current.getLeftChild());
			}
		}
		else if (current.getLeftChild() == null){
			if (current == root){
				current = current.getRightChild();
			}else if (isLeftChild){
				parent.setLeftChild(current.getRightChild());
			}else{
				parent.setRightChild(current.getRightChild());
			}
		}
	}
}
