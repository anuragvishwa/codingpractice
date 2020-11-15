/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (44.04%)
 * Likes:    3616
 * Dislikes: 188
 * Total Accepted:    313.5K
 * Total Submissions: 708.9K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        
        int start=0,end=0;
		
        List<Integer> result = new ArrayList<>();
        
        if(p.length()> s.length()) return result;
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		
		for(char ch : p.toCharArray()){
			map.put(ch,map.getOrDefault(ch,0)+1);
		}
		
		int counter = map.size();
		
		while(end<s.length()){
			char cEnd = s.charAt(end);
			
			if(map.containsKey(cEnd)){
				map.put(cEnd,map.get(cEnd)-1);
				
				if(map.get(cEnd)==0){
					counter--;
				}
			}
			
			end++;
			
			while(counter==0){
				char cStart = s.charAt(start);
				
				if(map.containsKey(cStart)){
					map.put(cStart,map.get(cStart)+1);
					if(map.get(cStart)>0){
					counter++;
					}
				}
				
				
				
				if(end-start == p.length()){
					result.add(start);
				}
				start++;
			}
				
			
					
		}
		
		return result;
    }
}
// @lc code=end

