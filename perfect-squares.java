/*
https://leetcode.com/problems/perfect-squares/

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/

//Solution Recursive: Bottom Up

class Solution {
    public int numSquares(int n) {
        return numSquare(n);
    }
    
    static Boolean perfectNo(int num) {

		double sq = Math.sqrt(num);
		return ((sq - Math.floor(sq)) == 0);
	}
    
    static int numSquare(int n) {

		if (perfectNo(n)) {
			return 1;
		}

		int minWays = Integer.MAX_VALUE;

		for (int i = 1; i < n; i++) {
			int ways = 0;
			if (perfectNo(i)) {
				ways = 1 + numSquare(n - i);
				if (ways < minWays) {
					minWays = ways;
				}
			}

		}

		return minWays;
	}
}
