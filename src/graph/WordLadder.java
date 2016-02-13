package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> set = new HashSet<String>();
		String[] s = {"hot","dot","dog","lot","log"};
		for (String i: s){
			set.add(i);
		}

		
		System.out.println(getLevel(start, set));
		
 	}
	
	public static List<List<String>> getLevel(String start, Set<String> dict){
		if (dict == null) return null;
		dict.add(start);
		
		Queue<String> queue = new LinkedList<String>();
		Set<String> set = new HashSet<String>();
		List<List<String>> res = new ArrayList<List<String>>();
		queue.offer(start);
		set.add(start);
		

		while (!queue.isEmpty()){
			int size = queue.size();
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < size; i++){
				String cur = queue.poll();
				
				for(String neighbor : neighbors(cur, dict)){
					if (set.contains(neighbor)){
						continue;
					}

					set.add(neighbor);
					queue.offer(neighbor);
				}
				list.add(cur);
			}
			res.add(list);
			
		}
		

		return res;
	}

	public static int getLength(String start, String end, Set<String> dict){
		if (dict == null) return 0;
		dict.add(start);
		dict.add(end);
		Queue<String> queue = new LinkedList<String>();
		Set<String> set = new HashSet<String>();
		queue.offer(start);
		set.add(start);
		
		int len = 1;
		while (!queue.isEmpty()){
			int size = queue.size();
			len++;
			for (int i = 0; i < size; i++){
				String cur = queue.poll();
				
				for(String neighbor : neighbors(cur, dict)){
					if (set.contains(neighbor)){
						continue;
					}
					if (neighbor.equals(end)){
						return len;
					}
					set.add(neighbor);
					queue.offer(neighbor);
				}
			}
			
		}
		

		return 0;
	}

	private static ArrayList<String> neighbors(String word, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < word.length(); i++) {
			char[] wordarr = word.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				wordarr[i] = c;
				String newWord = new String(wordarr);
				if (dict.contains(newWord)) {
					res.add(newWord);
				}
			}

		}

		return res;

	}
}
