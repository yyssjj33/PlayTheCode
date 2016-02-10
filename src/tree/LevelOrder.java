package tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;


public class LevelOrder {
	public static List<List<Integer>> levelOrder(TreeNode<Integer> root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
		q.add(root);
		while(q.size() > 0){
			List<Integer> list = new ArrayList<Integer>();
			int size = q.size();
			for (int i = 0; i < size; i++){
				TreeNode<Integer> cur = q.poll();
				if (cur != null)
					list.add(cur.element);
				else {list.add(null); continue;}
				if (cur.leftChild != null) q.add(cur.leftChild);
				else q.add(null);
				if (cur.rightChild != null) q.add(cur.rightChild);
				else q.add(null);
				
			}
			result.add(list);
			
		}
//		ListIterator<Integer> iter = result.listIterator(result.size());
//		while(iter.hasPrevious()){
//			if(iter.previous() == null)
//				iter.remove();
//			else
//				break;
//		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> t1 = new TreeNode<Integer>(1);
		t1.leftChild = new TreeNode<Integer>(2);
		t1.rightChild = new TreeNode<Integer>(3);
		t1.rightChild.rightChild = new TreeNode<Integer>(5);
		t1.rightChild.leftChild = new TreeNode<Integer>(4);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = levelOrder(t1);
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i).toString());
		}
		
	}
}
