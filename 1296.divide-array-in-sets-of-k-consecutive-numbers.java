/*
 * @lc app=leetcode id=1296 lang=java
 *
 * [1296] Divide Array in Sets of K Consecutive Numbers
 *
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/description/
 *
 * algorithms
 * Medium (54.00%)
 * Likes:    483
 * Dislikes: 46
 * Total Accepted:    30.6K
 * Total Submissions: 55.7K
 * Testcase Example:  '[1,2,3,3,4,4,5,6]\n4'
 *
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into sets of k consecutive numbers
 * Return True if its possible otherwise return False.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4
 * Output: true
 * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * Output: true
 * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and
 * [9,10,11].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [3,3,2,2,1,1], k = 3
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * Explanation: Each array should be divided in subarrays of size 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 * 
 * Note: This question is the same as 846:
 * https://leetcode.com/problems/hand-of-straights/
 */

// @lc code=start
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        Map<Integer,Integer> map = new TreeMap();
        for(int num : nums){
	    	map.put(num,map.getOrDefault(num,0)+1);
	    }		
		
		
		//Iterate through the map:
		
		for(int n: map.keySet()){
            int curr = map.get(n);
            
            if(curr == 0) continue;
        	
        	//System.out.println(curr);
        	    
            for(int i = n; i < k + n; i++){
                if(!map.containsKey(i) || map.get(i) <= 0)
                    return false;
                  //  System.out.println(i);
                map.put(i,map.get(i) - curr);
                
            }
        }
        
        return true;
    }
}
// @lc code=end

