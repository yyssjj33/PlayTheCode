package array;

public class LongestIncreasingSubseq {
	public int LIS(int[] nums) {
		int max = Integer.MIN_VALUE;
		int[] opt = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			opt[i] = 1;
		}

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && opt[i] <= opt[j]) {
					opt[i] = opt[j] + 1;
					max = Math.max(opt[i], max);
				}
			}
		}
		return max;
	}
}
