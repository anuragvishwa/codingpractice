/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 *
 * https://leetcode.com/problems/integer-replacement/description/
 *
 * algorithms
 * Medium (33.09%)
 * Likes:    458
 * Dislikes: 348
 * Total Accepted:    61.4K
 * Total Submissions: 184.2K
 * Testcase Example:  '8'
 *
 * Given a positive integer n, you can apply one of the following
 * operations:
 * 
 * 
 * If n is even, replace n with n / 2.
 * If n is odd, replace n with either n + 1 or n - 1.
 * 
 * 
 * Return the minimum number of operations needed for n to become 1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 8
 * Output: 3
 * Explanation: 8 -> 4 -> 2 -> 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 7
 * Output: 4
 * Explanation: 7 -> 8 -> 4 -> 2 -> 1
 * or 7 -> 6 -> 3 -> 2 -> 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 4
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
public class Solution {
    Map<Long,Integer> dp;
    public int integerReplacement(int n) {
      dp = new HashMap();
      return helper(n,0);
    }
    
    private int helper(long n, int steps) {
        if(dp.containsKey(n)){
            return steps+dp.get(n);
        }
        if(n==1){
            return steps;
        }
        if(n<=0){
            return Integer.MAX_VALUE;
        }
        int minS;
        if(n%2 ==0){
            minS =  helper(n/2, steps+1);
        } else {
             minS= Math.min(helper(n+1, steps+1), helper(n-1,steps+1));
        }
        dp.put(n , minS-steps);
        return minS;
    }
}
// @lc code=end

