/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (43.84%)
 * Likes:    5372
 * Dislikes: 173
 * Total Accepted:    360.2K
 * Total Submissions: 822.7K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 * 
 * 
 */

// @lc code=start
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
		
		/*If anyone is confused why the count was increased by myMap[ curr - k ] instead of just count+=1 . It was because prefix sum can be same because of some negative values in the array. so out next occuring k will also pair  with those negative values also . 


consider this case A : [3 4  7    2   -3   1   4   2   1 ]  
                       preSum : [3 7 14 16 13 14 18 20 21]


you can see 14 occured twice  because of the subsequence [2 -3 1] their sum is 0. so When you are at the final index with value 1 . you have curr - k = 21 - 7 = 14 . you check for 14 it has occured twice . so you need to consider subsequences [2 -3 1 4 2 1] and [4 2 1] . Hope this helps
*/
int count = 0, sum = 0;
HashMap < Integer, Integer > map = new HashMap < > ();
map.put(0, 1);
for (int i = 0; i < nums.length; i++) {
	sum += nums[i];
	if (map.containsKey(sum - k))
		count += map.get(sum - k);
	map.put(sum, map.getOrDefault(sum, 0) + 1);
}
return count;
	}
            }
    
    

// @lc code=end

