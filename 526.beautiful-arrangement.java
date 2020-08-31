/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 *
 * https://leetcode.com/problems/beautiful-arrangement/description/
 *
 * algorithms
 * Medium (57.95%)
 * Likes:    702
 * Dislikes: 151
 * Total Accepted:    52.4K
 * Total Submissions: 90.3K
 * Testcase Example:  '2'
 *
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement
 * as an array that is constructed by these N numbers successfully if one of
 * the following is true for the ith position (1 <= i <= N) in this
 * array:
 * 
 * 
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * 
 * 
 * 
 * 
 * Now given N, how many beautiful arrangements can you construct?
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: 
 * 
 * The first beautiful arrangement is [1, 2]:
 * 
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * 
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * 
 * The second beautiful arrangement is [2, 1]:
 * 
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * 
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * N is a positive integer and will not exceed 15.
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    private int res;
    public int countArrangement(int N) {
        res = 0;
        boolean[] used = new boolean[N + 1];
        backtrack(1, N, used);  
        return res;
    }
    private void backtrack(int pos, int n, boolean[] used){
        if(pos == n + 1) {
            res++;
            return;
        }
        for(int num = 1; num <= n; num++){ //try all possible numbers for the current state
            if(!used[num] && (pos % num == 0 || num % pos == 0)){
                used[num] = true; //for current state
                backtrack(pos + 1, n, used);
                used[num] = false;
            }
        }
    }
}
// @lc code=end

