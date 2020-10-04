/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 *
 * https://leetcode.com/problems/delete-nodes-and-return-forest/description/
 *
 * algorithms
 * Medium (67.13%)
 * Likes:    1314
 * Dislikes: 47
 * Total Accepted:    72.6K
 * Total Submissions: 107.8K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n[3,5]'
 *
 * Given the root of a binary tree, each node in the tree has a distinct
 * value.
 * 
 * After deleting all nodes with a value in to_delete, we are left with a
 * forest (a disjoint union of trees).
 * 
 * Return the roots of the trees in the remaining forest.  You may return the
 * result in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Set<Integer> set = new HashSet<Integer>();

        for(Integer i : to_delete){
            set.add(i);
        }

        getList(root,list,set,true);
       
        return list;

    }

    static TreeNode getList(TreeNode root,List<TreeNode> result,Set<Integer> set,boolean isRoot){

        if(root==null){
            return null;
        }

        boolean deleted = set.contains(root.val);

        if(isRoot && !deleted){
            result.add(root);
        }

        root.left = getList(root.left,result,set,deleted);
        root.right = getList(root.right,result,set,deleted);

        if(deleted){
            return null;
        }
        else
            return root;
               
    }
}
// @lc code=end

