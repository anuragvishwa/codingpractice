/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (29.51%)
 * Likes:    7658
 * Dislikes: 563
 * Total Accepted:    1M
 * Total Submissions: 3.4M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
		int end = 0;
		//Checking through the midpoint of any character
		for(int i = 0; i<s.length();i++){
			char c = s.charAt(i);
			int left = i;
			int right = i;
			
			
			//if letters are same left and right keep moving until they differ
			while(left>=0 && s.charAt(left)==c){
				left--;
			}
			
			while(right<s.length() && s.charAt(right)== c){
				right++;
			}
			
			//now we have reached the point of different chacters, it's time to compare left and right
			
			while(left>=0 && right < s.length()){
				if(s.charAt(left)!=s.charAt(right)){
					break;
				}
				left--;
				right++;
			}
			
			left = left+1; //since substring doesn't include this character:left
			
			if(end-start<right-left){
				start = left;
				end = right;
			}
		}
		
		return s.substring(start,end);
		 
    }
}
// @lc code=end

