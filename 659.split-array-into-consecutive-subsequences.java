/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 *
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
 *
 * algorithms
 * Medium (43.92%)
 * Likes:    1346
 * Dislikes: 442
 * Total Accepted:    51.8K
 * Total Submissions: 117.8K
 * Testcase Example:  '[1,2,3,3,4,5]'
 *
 * Given an array nums sorted in ascending order, return true if and only if
 * you can split it into 1 or more subsequences such that each subsequence
 * consists of consecutive integers and has length at least 3.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3
 * 3, 4, 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,2,3,4,4,5]
 * Output: False
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10000
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
		
		Map<Integer,Integer> mp = new HashMap<>();
		
		for(int num : nums){
			map.put(num,map.getOrDefault(num,0)+1);
		}		
		
		for(int i: nums){
			if(map.get(i) == 0)
				continue;
			else if(mp.getOrDefault(i,0)>0){
				mp.put(i,mp.get(i)-1);
				mp.put(i+1,mp.getOrDefault(i+1,0)+1);
			}
			else if(map.getOrDefault(i+1,0)>0 && map.getOrDefault(i+2,0)>0){
				map.put(i+1,map.get(i+1)-1);
				map.put(i+2,map.get(i+2)-1);
				mp.put(i+3,mp.getOrDefault(i+3,0)+1);
			}	
			else{
				return false;
			}
			map.put(i,map.get(i)-1);
		}
		
		return true;

	
    }
}
// @lc code=end

