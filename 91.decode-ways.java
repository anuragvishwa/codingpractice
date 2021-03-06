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
    public int numDecodings(String s) {
       // int[] memo = new int[s.length()+1];
       // Arrays.fill(memo,-1);
       // return decode(s,0,memo);
       return decodeDP(s);
    }
 

    static int decodeDP(String s){

        int lookup[] = new int[s.length() + 1];
        //dp[0] means an empty string will have 1 way to decode, 
        //dp[1] means the way to decode a string of size 1
        lookup[0] = 1;
        lookup[1] = s.charAt(0) == '0'? 0:1;
        
        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if (oneDigit >= 1) {
                lookup[i] += lookup[i-1];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                lookup[i] += lookup[i-2];
            }
        }
        
        return lookup[s.length()];

        
    }

    //DFS approach:
    static int decode(String s,int i,int[] memo){
        
        if(memo[i]!=-1){
            return memo[i];
        }

        if(s.length()==i){
            return 1;
        }      

        if(s.charAt(i)=='0'){
            return 0;
        }

        int ways = 0;
        
        ways = ways + decode(s,i+1,memo);

        if(i<s.length()-1 && (Integer.parseInt(s.substring(i,i+2))<=26)){
            ways = ways + decode(s,i+2,memo);
        }

        memo[i] = ways; 
        return ways;
    }
}
// @lc code=end

