
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
