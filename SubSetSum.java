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
