/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (40.18%)
 * Likes:    5029
 * Dislikes: 250
 * Total Accepted:    608K
 * Total Submissions: 1.5M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
		Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		
		
		for(String word: wordDict){
			set.add(word);
		}
		
		return canBreak(s,set,0,map);
		

	}
	
	 Boolean canBreak(String s,Set<String> words,int idx,Map<Integer,Boolean> map){
		
		if( idx == s.length()){
			return true;
		}
		
		if(map.containsKey(idx))
			return map.get(idx);
		//System.out.println(map.toString());
		for(int i=idx+1;i<=s.length();i++){
			if(words.contains(s.substring(idx,i))){
				//System.out.println(s.substring(idx,i));
				if(canBreak(s,words,i,map)){
					map.put(idx,true);
					
					return true;
				}
			}
		}
		
		map.put(idx,false);
		return false;
		
		
		
    }
}
// @lc code=end

