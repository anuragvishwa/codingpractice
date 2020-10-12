/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (39.42%)
 * Likes:    5228
 * Dislikes: 323
 * Total Accepted:    684.5K
 * Total Submissions: 1.7M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 * 
 * Constraints:
 * 
 * 
 * intervals[i][0] <= intervals[i][1]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
    //     if(intervals.length < 2)
    //     return intervals;
    // Arrays.sort(intervals,new Comparator<int[]>(){
    //     public int compare(int[] a1,int[] a2){
    //         return a1[0]-a2[0];
    //     }
    // });
    
    // ArrayList<int[]> result = new ArrayList<>();
    
    // int s1 = intervals[0][0];
    // int e1 = intervals[0][1];
    
    // for(int i=1;i<intervals.length;i++){
    //     int s2 = intervals[i][0];
    //     int e2 = intervals[i][1];
        
    //     if(s2>e1){
    //         result.add(new int[]{s1,e1});
    //         s1=s2;
    //         e1=e2;
    //     }
    //     else{
    //         e1 = Math.max(e1,e2);
    //     }
    // }
    
    // result.add(new int[]{s1,e1});
    
    // int[][] r = new int[result.size()][];
    
    // for(int i=0 ; i<result.size();i++){
    //     r[i] = result.get(i);
    // }
    // return r;
    if (intervals.length <= 1)
    return intervals;
    Arrays.sort(intervals,new Comparator<int[]>(){
        public int compare(int[] a1,int[] a2){
            return a1[0]-a2[0];
        }
    });
    
    ArrayList<int[]> result = new ArrayList<>();
    
    int[] newInterval = intervals[0];
    result.add(newInterval);
    
    for(int[] interval : intervals){
        if(interval[0]<=newInterval[1]){//Overlapping interval move the end:
            newInterval[1] = Math.max(interval[1],newInterval[1]);
        }
        else{
            newInterval = interval;
            result.add(newInterval);
        }

        
    }

    return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

