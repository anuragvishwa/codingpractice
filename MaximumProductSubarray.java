//https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {
       return maxProd(nums);
    }
     int maxProd(int arr[]) {
        
         if(arr.length==1){
             return arr[0];
         }
		int max = Integer.MIN_VALUE;
		int next = arr[0];

		for (int i = 0; i < arr.length; i++) {
			next = arr[i];
			for (int j = i + 1; j <= arr.length - 1; j++) {

				next = next * arr[j];
				if (arr[i] > max) {
					max = arr[i];
				}

				if (next > max) {
					max = next;
				}
				if (arr[j] > max) {
					max = arr[j];
				}

				//System.out.println(" i " + arr[i] + " j " + arr[j] + " max " + max + " next " + next);
			}
		}
		return max;

	}
}
