/*
 * @lc app=leetcode id=1146 lang=java
 *
 * [1146] Snapshot Array
 *
 * https://leetcode.com/problems/snapshot-array/description/
 *
 * algorithms
 * Medium (37.08%)
 * Likes:    573
 * Dislikes: 111
 * Total Accepted:    36K
 * Total Submissions: 97.5K
 * Testcase Example:  '["SnapshotArray","set","snap","set","get"]\n[[3],[0,5],[],[0,6],[0,0]]'
 *
 * Implement a SnapshotArray that supports the following interface:
 * 
 * 
 * SnapshotArray(int length) initializes an array-like data structure with the
 * given length.  Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to
 * val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total
 * number of times we called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we
 * took the snapshot with the given snap_id
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5]
 * Explanation: 
 * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 * snapshotArr.set(0,5);  // Set array[0] = 5
 * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return
 * 5
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= length <= 50000
 * At most 50000 calls will be made to set, snap, and get.
 * 0 <= index < length
 * 0 <= snap_id < (the total number of times we call snap())
 * 0 <= val <= 10^9
 * 
 * 
 */

// @lc code=start
import java.util.*;

class SnapshotArray {

    int snap_id=0;
    TreeMap<Integer,Integer> map[];

    public SnapshotArray(int length) {
        map = new TreeMap[length];

        for(int i=0;i<length;i++){
            map[i] = new TreeMap<Integer,Integer>();
            map[i].put(0,0);
        }
    }
    
    public void set(int index, int val) {
        map[index].put(snap_id,val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
       return map[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// @lc code=end

