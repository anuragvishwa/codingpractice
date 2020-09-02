/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 *
 * https://leetcode.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (33.61%)
 * Likes:    1769
 * Dislikes: 188
 * Total Accepted:    262.7K
 * Total Submissions: 780.5K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with
 * [3,5],[6,7],[8,10].
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        return insertInterval(intervals,newInterval);
    }

     int[][] insertInterval(int[][] intervals, int[] newInterval) {

		ArrayList<int[]> list = new ArrayList<int[]>();

		if (intervals.length == 0) {
			return new int[][] { newInterval };
		}

		int i = 0;

		// add all intervals before the new interval starts
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			list.add(intervals[i]);
			i++;
		}

		// // now current interval's end time is equal to or greater than newInterval's
		// start time
		// update the newInterval's start time
		if (i < intervals.length) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
		}

		// Start merging:
		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}

		// add new Interval to result set
		list.add(newInterval);

		// add rest to the list:
		while (i < intervals.length) {
			list.add(intervals[i]);
			i++;
		}

		return list.toArray(new int[list.size()][2]);

	}
}
// @lc code=end

