/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (35.62%)
 * Likes:    5002
 * Dislikes: 151
 * Total Accepted:    474K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: coins = [1], amount = 0
 * Output: 0
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: coins = [1], amount = 1
 * Output: 1
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: coins = [1], amount = 2
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        
            int max = amount + 1;

            int[] dp = new int[amount + 1];

            Arrays.fill(dp, max);

            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {

              for (int j = 0; j < coins.length; j++) {

                if (coins[j] <= i) {

                  dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                  
                }
              }
            }
            return dp[amount] > amount ? -1 : dp[amount];
          
    }
}
// @lc code=end

