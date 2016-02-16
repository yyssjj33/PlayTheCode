package bit;

public class SingleNumberII {
	public static int singleNumber(int[] nums){
		int res = 0;
		int[] bit = new int[32];
		for (int i = 0; i < 32; i++){
			for (int j = 0; j < nums.length; j++){
				bit[i]+=(nums[j]>>i)&1;
			}
			
			res |= bit[i]%3<<i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,2,3,3,3,4};
		System.out.println(singleNumber(nums));
	}
}
