/*
 * @lc app=leetcode id=1438 lang=java
 *
 * [1438] Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 *
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
 *
 * algorithms
 * Medium (43.44%)
 * Likes:    902
 * Dislikes: 37
 * Total Accepted:    36.6K
 * Total Submissions: 84.2K
 * Testcase Example:  '[8,2,4,7]\n4'
 *
 * Given an array of integers nums and an integer limit, return the size of the
 * longest non-empty subarray such that the absolute difference between any two
 * elements of this subarray is less than or equal to limit.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2 
 * Explanation: All subarrays are: 
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4. 
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4. 
 * Therefore, the size of the longest subarray is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4 
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum
 * absolute diff is |2-7| = 5 <= 5.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd = new ArrayDeque<Integer>();
		Deque<Integer> mind = new ArrayDeque<Integer>();
		
		int i=0,j;
		
		for(j=0;j<nums.length;j++){
			while(!maxd.isEmpty() && nums[j] > maxd.peekLast())
				maxd.pollLast();
			while(!mind.isEmpty() && nums[j] < mind.peekLast())
				mind.pollLast();
				
				maxd.add(nums[j]);
				mind.add(nums[j]);
				
			if(maxd.peek()-mind.peek()>limit){
				if(maxd.peek() == nums[i])
					maxd.poll();
				if(mind.peek() == nums[i])
					mind.poll();
				++i;
			}
		}
		
		return j-i;
    }
}
// @lc code=end

