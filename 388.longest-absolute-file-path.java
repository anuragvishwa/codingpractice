/*
 * @lc app=leetcode id=388 lang=java
 *
 * [388] Longest Absolute File Path
 *
 * https://leetcode.com/problems/longest-absolute-file-path/description/
 *
 * algorithms
 * Medium (41.80%)
 * Likes:    634
 * Dislikes: 1537
 * Total Accepted:    90.1K
 * Total Submissions: 215K
 * Testcase Example:  '"dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext"'
 *
 * Suppose we have the file system represented in the following picture:
 * 
 * 
 * 
 * We will represent the file system as a string where "\n\t" mean a
 * subdirectory of the main directory, "\n\t\t" means a subdirectory of the
 * subdirectory of the main directory and so on. Each folder will be
 * represented as a string of letters and/or digits. Each file will be in the
 * form "s1.s2" where s1 and s2 are strings of letters and/or digits.
 * 
 * For example, the file system above is represented as
 * "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext".
 * 
 * Given a string input representing the file system in the explained format,
 * return the length of the longest absolute path to a file in the abstracted
 * file system. If there is no file in the system, return 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 * Output: 20
 * Explanation: We have only one file and its path is "dir/subdir2/file.ext" of
 * length 20.
 * The path "dir/subdir1" doesn't contain any files.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: input =
 * "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * Output: 32
 * Explanation: We have two files:
 * "dir/subdir1/file1.ext" of length 21
 * "dir/subdir2/subsubdir2/file2.ext" of length 32.
 * We return 32 since it is the longest path.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: input = "a"
 * Output: 0
 * Explanation: We don't have any files.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= input.length <= 10^4
 * input may contain lower-case or upper-case English letters, a new line
 * character '\n', a tab character '\t', a dot '.', a space ' ' or digits.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthLongestPath(String input) {
        int maxLength=0;
		/*dir is in level 1, not 0. subdir1 is in level 2, so on...
we update the hashMap using hashMap.get(level) + len + 1 because the current level is level+1, previous level is level, we +1 because the additional path separator char \ , if s contains . , we update the current max length
*/
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(0,0);//level--> length
		
		String[] lines = input.split("\n");
		
		for(String line : lines){
			int level = line.lastIndexOf('\t')+1;
			int length = line.length()-level;
			//System.out.println(line+" -> "+map.get(level));
			if(line.contains(".")){
				maxLength = Math.max(maxLength,map.get(level)+length);
			}
			else{
				map.put(level+1,map.get(level)+length+1);
			}
			
			//System.out.println(line +" -> "+ level);
				
		}
		
		return maxLength;
		
    }
}
// @lc code=end

