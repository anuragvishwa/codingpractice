//Recursive Approach:
public class LISrecursion {
	
	public static void main(String[] args) {
		int[] nums = {50,3,10,7,40,80};
		System.out.println(LIS(nums,-1,0));
	}

	public static int LIS(int[] nums,int prev,int current) {
				
		if(current==nums.length-1) {
			return 1;
		}
		
		int taken= 0;
		int notTaken = 0;		
		if(nums[current]>=prev) {
			taken =1+ LIS(nums,nums[current],current+1);
		}				
		notTaken = LIS(nums,prev,current+1);				
		return Math.max(taken, notTaken);
	
		
		
	}
	
}
//Dp Approach:
import java.util.Arrays;

public class NoLIS {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 4, 7 };
		System.out.println(getLIS(nums));

	}

	static int getLIS(int[] nums) {
		int n = nums.length;
		int len[] = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			len[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (len[i] < len[j] + 1) {
						len[i] = len[j] + 1;
					}
				}
			}
		}

		System.out.println(Arrays.toString(len));

		for (int i = 0; i < n; i++) {
			if (max < len[i]) {
				max = len[i];
			}
		}

		return max;

	}

}
