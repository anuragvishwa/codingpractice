/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 *
 * algorithms
 * Medium (56.84%)
 * Likes:    2716
 * Dislikes: 276
 * Total Accepted:    326.4K
 * Total Submissions: 573.3K
 * Testcase Example:  '["BSTIterator","next","next","hasNext","next","hasNext","next","hasNext","next","hasNext"]\n[[[7,3,15,null,null,9,20]],[null],[null],[null],[null],[null],[null],[null],[null],[null]]'
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * 
 * 
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree.
 * You may assume that next() call will always be valid, that is, there will be
 * at least a next smallest number in the BST when next() is called.
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

class BSTIterator {

    // public class TreeNode {
    //          int val;
    //     TreeNode left;
    //      TreeNode right;
    //      TreeNode() {}
    //    TreeNode(int val) { this.val = val; }
    //     TreeNode(int val, TreeNode left, TreeNode right) {
    //        this.left = left;
    //          this.right = right;
    //       }
    // }

    
    Stack<TreeNode> stack; 

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();  
        TreeNode visit = root;       
       while(visit!=null){
            stack.push(visit);
            if(visit.left!=null){
                visit = visit.left;
            }
            else
                break;
       }       
    }
    
    /** @return the next smallest number */
    public int next() { 
               
          TreeNode node = stack.pop();
          int val = node.val;
 
          if(node.right!=null){
                node = node.right;
                while(node!=null){
                  stack.push(node);
                  if(node.left!=null){
                      node = node.left;
                  }
                  else
                    break;
              }
          }

          return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!stack.isEmpty()){
            return true;
        }
        return false;
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

