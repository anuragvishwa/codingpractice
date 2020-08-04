
public class HouseRobber {

	public static void main(String[] args) {
		int nums[] = { 2, 7, 9, 3, 1 };
		;
		System.out.println(hr(nums));
	}

	static int hr(int[] nums) {

		if (nums.length == 0 || nums == null) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int first = nums[0];

		int second = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {

			int temp = second;

			second = Math.max(second, nums[i] + first);

			first = temp;

		}

		return second;

	}

}
