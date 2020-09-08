/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 *
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 *
 * algorithms
 * Medium (24.62%)
 * Likes:    1465
 * Dislikes: 2049
 * Total Accepted:    143.4K
 * Total Submissions: 582.5K
 * Testcase Example:  '[23,2,4,6,7]\n6'
 *
 * Given a list of non-negative numbers and a target integer k, write a
 * function to check if the array has a continuous subarray of size at least 2
 * that sums up to a multiple of k, that is, sums up to n*k where n is also an
 * integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up
 * to 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5
 * and sums up to 42.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit
 * integer.
 * 
 * 
 */

// @lc code=start
class Solution {
    // public boolean checkSubarraySum(int[] nums, int k) {
    //     if(nums.length==0)
    //         return true;

	// 	int length = 0 ;
	// 	int sum = 0;
		
	// 	for(int i=0;i<nums.length;i++){
	// 		sum = nums[i];
	// 		length=1;
	// 		for(int j=i+1;j<nums.length;j++){
	// 			sum = sum + nums[j];
	// 			length++;
    //             //System.out.println(sum + " "+length);
              
    //             if(sum==0 && k==0 && length>=2){
    //                 return true;
    //             }
    //             else
	// 			if(k!=0 && length>=2 && sum % k == 0){
	// 				return true;
	// 			}
	// 		}
	// 	}
		
	// 	return false;
		
    // }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, sum = 0; i < nums.length; ++i) {
            sum += nums[i];
            int rem = k == 0 ? sum : sum % k;
            if (map.containsKey(rem)) {
                if (map.get(rem) <= i - 2) return true;
            } else map.put(rem, i);
        }
        return false;
    }

}
// @lc code=end

