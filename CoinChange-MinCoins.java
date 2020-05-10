//https://leetcode.com/problems/coin-change/
/*You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        		int x = coinChange1(coins, amount, 0);
		if(x==Integer.MAX_VALUE-1) {
			return -1;
		}
		else return x;
    }
    
    static int coinChange1(int[] coins, int amount, int i) {

		if (amount < 0 || i >= coins.length) {
			return Integer.MAX_VALUE -1;
		}
    
        	if (i >= coins.length && amount != 0) {
			return -1;
		}

        
		if (amount == 0) {
			return 0;
		}

		int taken = 1 + coinChange1(coins, amount - coins[i], i);
		int notTaken = coinChange1(coins, amount, i + 1);
		System.out.println(" take " + taken + " notTake " + notTaken);
		int result = Math.min(taken, notTaken);
		return result;

	}
}