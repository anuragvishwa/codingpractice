/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (50.18%)
 * Likes:    3506
 * Dislikes: 177
 * Total Accepted:    227.7K
 * Total Submissions: 452.6K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * 
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 * 
 */

// @lc code=start
class Solution {
    int i=0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder("");
        int count = 0;
        String temp_string = "";

        while(i<s.length()){
            char ch = s.charAt(i);
            i++;
            if(ch=='['){
                temp_string = decodeString(s);
                for(int j=0;j<count;j++){
                    sb.append(temp_string);
                }
                count=0;
            }
            else if(ch ==']'){
                break;
            }
            else if(Character.isAlphabetic(ch)){
                sb.append(ch);
            }
            else{
                count = count*10 +ch -'0';
            }
        }

        return sb.toString();
    }
}
// @lc code=end

