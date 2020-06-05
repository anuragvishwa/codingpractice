//Bottom Up- Recursive
public class SubSetSum{
    public static void main(String[] args){
        int[] arr = {3,34,4,12,5,2};
        System.out.println(getSum(arr,0,0,89789)); 
    
    }

    public static Boolean getSum(int[] arr,int i,int currentSum,int sum){

        if(i==arr.length-1 && currentSum + arr[i] == sum){
            return true;
        }

        if(i<arr.length){
            if(currentSum==sum){
                return true;
            }        
        if(getSum(arr,i+1,currentSum + arr[i],sum) || getSum(arr, i+1, currentSum, sum)){
            return true;
        }    
    }
        return false;
    }

}

//Top Down Recursive
public static boolean getSum(int[] nums, int i, int sum) {
		if (sum < 0 || i >= nums.length) {
			return false;
		}

		if (sum == 0) {
			return true;
		}

		Boolean taken = getSum(nums, i + 1, sum - nums[i]);
		Boolean notTaken = getSum(nums, i + 1, sum);

		return (taken || notTaken);

	}

//DP solution:
public class EqualSubSetDP {

	public static void main(String[] args) {

		int nums[] = { 1, 5, 11, 5 };
		int sum = Arrays.stream(nums).sum();
		if (sum % 2 != 0) {
			System.out.println(false);
		}

		System.out.println(canPartition1(nums, sum / 2));

	}

	static boolean canPartition1(int[] nums, int sum) {

		Boolean[][] result = new Boolean[nums.length + 1][sum + 1];

		// row initialization
		for (int i = 0; i < result[0].length; i++) {
			result[0][i] = false;
		}
		// column initialization
		for (int i = 0; i < result.length; i++) {
			result[i][0] = true;
		}

		for (int i = 1; i < result.length; i++) {
			for (int j = 1; j < result[0].length; j++) {
				result[i][j] = result[i - 1][j];
				if (j >= nums[i - 1])
					result[i][j] = result[i][j] || result[i - 1][j - nums[i - 1]];
			}
		}

		return result[nums.length][sum];

	}

}

