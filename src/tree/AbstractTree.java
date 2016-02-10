package tree;

public abstract class AbstractTree<E> implements Tree<E> {
	@Override
	public void inOrder(){}
	@Override
	public void postOrder(){}
	@Override
	public void preOrder(){}
	@Override
	public boolean isEmpty(){
		return getSize()==0;
	}
	
}
