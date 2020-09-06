/*
 * @lc app=leetcode id=1049 lang=java
 *
 * [1049] Last Stone Weight II
 *
 * https://leetcode.com/problems/last-stone-weight-ii/description/
 *
 * algorithms
 * Medium (44.27%)
 * Likes:    771
 * Dislikes: 30
 * Total Accepted:    20.3K
 * Total Submissions: 45.8K
 * Testcase Example:  '[2,7,4,1,8,1]'
 *
 * We have a collection of rocks, each rock has a positive integer weight.
 * 
 * Each turn, we choose any two rocks and smash them together.  Suppose the
 * stones have weights x and y with x <= y.  The result of this smash is:
 * 
 * 
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of
 * weight y has new weight y-x.
 * 
 * 
 * At the end, there is at most 1 stone left.  Return the smallest possible
 * weight of this stone (the weight is 0 if there are no stones left.)
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation: 
 * We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0 so the array converts to [1] then that's the
 * optimal value.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = Arrays.stream(stones).sum();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        return minStone(stones,total,0,total,map);
    }
     int minStone(int arr[],int sum,int i,int total,HashMap<Integer,Integer> map){
	
		if(i==arr.length){
			return Math.abs((total-sum*2));
        }
        
        if(map.containsKey(sum)){
            return map.get(sum);
        }
		               	
		int select = minStone(arr,sum - arr[i],i+1,total,map);
		
		int notSelect = minStone(arr,sum,i+1,total,map);
        int min = Math.min(select,notSelect);
        map.put(sum,min);
		return min;
		
		
	}
}
// @lc code=end

