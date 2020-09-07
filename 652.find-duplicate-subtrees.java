/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (50.24%)
 * Likes:    1428
 * Dislikes: 211
 * Total Accepted:    67.5K
 * Total Submissions: 133.9K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * Given the root of a binary tree, return all duplicate subtrees.
 * 
 * For each kind of duplicate subtrees, you only need to return the root node
 * of any one of them.
 * 
 * Two trees are duplicate if they have the same structure with the same node
 * values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [2,1,1]
 * Output: [[1]]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of the nodes in the tree will be in the range [1, 10^4]
 * -200 <= Node.val <= 200
 * 
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
    Map<String,Integer> map;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        result = new ArrayList<>();
        preOrder(root);
        return result;

    }

    String preOrder(TreeNode node){
        if(node == null){
            return "X"; 
        }

        String s = node.val + "," + preOrder(node.left) + preOrder(node.right);
        map.put(s,map.getOrDefault(s,0)+1);

        if(map.get(s)==2){
            result.add(node);
        }

        return s;
    }



}
// @lc code=end

