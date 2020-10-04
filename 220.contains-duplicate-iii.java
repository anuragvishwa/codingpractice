/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 *
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (20.93%)
 * Likes:    1358
 * Dislikes: 1451
 * Total Accepted:    156.4K
 * Total Submissions: 736K
 * Testcase Example:  '[1,2,3,1]\n3\n0'
 *
 * Given an array of integers, find out whether there are two distinct indices
 * i and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^4
 * 0 <= t <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
		
		TreeSet<Long> set = new TreeSet<Long>();
		
		for(int i=0;i<n;i++){
			
			Long floor = set.floor ((long)nums[i]);
			
			if(floor!=null && nums[i]-floor <=t){
				
				return true;
			}
			
			Long ceiling = set.ceiling((long) nums[i]);
			
			if(ceiling !=null && ceiling-nums[i]<=t){
				System.out.println(true);
				return true;
			}
			
			set.add((long)nums[i]);
			
			if(set.size()>k){
				set.remove((long)nums[i-k]);
			} 	
			
        }
        
        return false;
		
    }
}
// @lc code=end

