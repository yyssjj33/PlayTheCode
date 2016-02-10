package queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MedianFinder {
	PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer i, Integer j){
				return j - i;
			}
		});
	PriorityQueue<Integer> minq = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer i, Integer j){
				return i - j;
			}
		});
	Integer med = null;
    // Adds a number into the data structure.
    
    public void addNum(int num) {
        if(maxq.isEmpty()&&minq.isEmpty()&&med==null){
           	med = num;
        }
        else{
            if (num < med){
                maxq.add(num);
            }else{
                minq.add(num);
            }
        }
        
		if (minq.size() > maxq.size() + 1){
			maxq.add(med);
			med = minq.poll();
			
		}if (minq.size()  < maxq.size()){
			minq.add(med);
			med = maxq.poll();
		}
        
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxq.size()==minq.size()){
            return med;
        }else{
        	return (med + minq.peek())/2.0;
        }
    }
    
    public static void main(String[] args) {
    	MedianFinder mf = new MedianFinder();
    	mf.addNum(2);
    	System.out.println(mf.findMedian());
    	mf.addNum(3);
    	System.out.println(mf.findMedian());
    	
	}
}


