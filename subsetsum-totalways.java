
//Bottom Up recursive
public class SubsetsSum {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		int target = 4;
		System.out.println(getSubsetSum(nums, target));

	}

	static int getSubsetSum(int[] nums, int target) {

		if (target == 0) {
			return 1;
		}

		int result = 0;

		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i])
				result = result + getSubsetSum(nums, target - nums[i]);
		}

		return result;

	}

}

//DP solution:
class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        return getSubsetSum(nums,target);
    }
    
     int getSubsetSum(int[] nums, int target) {

		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i - nums[j] >= 0) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}

		return dp[target];

	}
}
