
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
