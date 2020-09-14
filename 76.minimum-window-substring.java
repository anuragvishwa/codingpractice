/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (34.75%)
 * Likes:    5026
 * Dislikes: 342
 * Total Accepted:    428.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int windowStart = 0;
        int subStringStart = 0;
        int minLength = s.length() + 1;
        int matched = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int i=0; i<s.length(); i++) {
            char rightChar = s.charAt(i);
            
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                
                if (map.get(rightChar) >= 0) {
                    matched++;
                }
            }
            
            while (matched == t.length()) {
                if (minLength > i - windowStart + 1) {
                    minLength = i - windowStart + 1;
                    subStringStart = windowStart;
                }
                
                char leftChar = s.charAt(windowStart);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }
                    
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                
                windowStart++;
            }
        }
        
        return minLength > s.length() ? "" : s.substring(subStringStart, subStringStart + minLength);
    }
}
// @lc code=end

