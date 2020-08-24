/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (24.75%)
 * Likes:    2874
 * Dislikes: 2964
 * Total Accepted:    418.7K
 * Total Submissions: 1.7M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */

// @lc code=start
import java.util.Arrays;
class Solution {
    //Bottom up solution
    public int numDecodings(String s) {
        return decode(s);
    }
 
    //DFS approach:
    static int decode(String s){
    
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
   

    }
}
// @lc code=end

