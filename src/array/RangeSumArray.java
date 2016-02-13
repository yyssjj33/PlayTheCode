package array;

public class RangeSumArray {
    int[] nums;
    int[] records;
    public RangeSumArray(int[] nums) {
        
        if (nums.length > 0){
        	this.nums = new int[nums.length];
	        this.nums[0] = nums[0];
	        this.records = nums;
	        for(int i = 1; i < nums.length; i++){
	            this.nums[i] = nums[i]+this.nums[i-1];
	        }
	    }else{
	    	this.nums = nums;
	    	this.records = nums;
	    }
    }

    void update(int i, int val) {
    	if (this.nums.length == 0)
    		return;
        if (i >= this.nums.length || i < 0)
            return;
        int temp = records[i];
        for (; i < this.nums.length; i++)
        	this.nums[i] = this.nums[i]+(val-temp);
    }

    public int sumRange(int i, int j) {
    	if (this.nums.length == 0)
    		return -1;
        if(i == 0)
            return this.nums[j];
        else{
            return this.nums[j] - this.nums[i-1];
        }
    }
    
    public static void main(String[] args) {
		RangeSumArray rsm = new RangeSumArray(new int[] {});
		System.out.println(rsm.sumRange(0, 3));
		rsm.update(0, 2);
		System.out.println(rsm.sumRange(0, 3));
	}
}
