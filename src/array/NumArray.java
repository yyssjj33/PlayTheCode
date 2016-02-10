package array;

public class NumArray {

    private int[][] result;
    public NumArray(int[] nums) {
        this.result = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j< nums.length; j++){
                result[i][j]=sum+nums[j];
                sum+=nums[j];
            }
        }
    }

    public int sumRange(int i, int j) {

        return this.result[i][j];
    }
    public static void main(String[] args) {
    	int[] nums = {-2,0,3,-5,2,-1};
		NumArray m = new NumArray(nums);
		System.out.println(m.sumRange(0, 2));
	}
}

