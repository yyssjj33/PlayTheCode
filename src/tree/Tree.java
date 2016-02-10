package tree;

import java.util.Iterator;

public interface Tree<E>{
	public boolean search(E e);
	public boolean insert(E e);
	public boolean delete(E e);
	public void inOrder();
	public void postOrder();
	public void preOrder();
	public int getSize();
	public boolean isEmpty();
	Iterator<E> iterator();
}
