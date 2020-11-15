/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (30.46%)
 * Likes:    10636
 * Dislikes: 606
 * Total Accepted:    1.7M
 * Total Submissions: 5.6M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = ""
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

// @lc code=start
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int start =0,end=0,maxLength=0,counter=0;
        
        Map<Character,Integer> map = new HashMap<>();
        
        while(end<s.length()){
            char cEnd = s.charAt(end);
            
            map.put(cEnd,map.getOrDefault(cEnd,0)+1);
            
            if(map.get(cEnd)>1){
                counter++;
            }
            
            end++;
            
            while(counter>0){
                char cStart = s.charAt(start);
                
                if(map.get(cStart)>1){
                    counter--;
                }
                
                map.put(cStart,map.get(cStart)-1);
                start++;
            }
            
            maxLength = Math.max(maxLength,end-start);
        }

        return maxLength;
        
    }
}
// @lc code=end

