public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        return findLongestPath(root,1);
    }
    
    int findLongestPath(TreeNode root,int length){

        int left = 0;
        int right = 0;
        
        if(root.left!=null){
            left = findLongestPath(root.left,root.left.val == root.val + 1 ?length+1:1);
        }
        
          if(root.right !=null){
            right = findLongestPath(root.right,root.right.val == root.val + 1 ?length+1:1);
        }
        
        return Math.max(length, Math.max(left, right));
                
    }
}
