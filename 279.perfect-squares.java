/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (47.49%)
 * Likes:    3243
 * Dislikes: 196
 * Total Accepted:    326.7K
 * Total Submissions: 687.2K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

// @lc code=start
import java.util.*;
class Solution {
    public int numSquares(int n) {
      //  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      //  return perfectSquare(n,map);

      return perfectSquare(n);
    }

    static int perfectSquare(int n) {

        if(n < 4) return n;

		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for (int i = 4; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}

		return dp[n];

    }
    

    static int perfectSquare(int n, Map<Integer, Integer> map) {

		if (map.containsKey(n)) {
			return map.get(n);
		}
		if (n < 4) {
			return n;
		}
		int ways = n;

		for (int i = 1; i * i <= n; i++) {
			int amount = n - i * i;
			ways = Math.min(ways, perfectSquare(amount, map) + 1);
		}

		map.put(n, ways);
		return ways;

	}

}
// @lc code=end

