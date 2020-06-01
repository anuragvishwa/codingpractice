//https://leetcode.com/problems/target-sum/

/* You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/
//Recursive solution
class Solution {
     int count = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        getTargetSum(nums, S, 0, 0);
        return count;
        
    }
    	void getTargetSum(int[] nums, int sum, int i, int currentSum) {

	

		if (i == nums.length) {
			if (currentSum == sum) {
				
				count++;
			}
			return;
		}

		getTargetSum(nums, sum, i + 1, currentSum + nums[i]);
		getTargetSum(nums, sum, i + 1, currentSum - nums[i]);

	}
}

//Memoization
