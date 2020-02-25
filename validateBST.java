//Inefficient solution : Time Complexity : O(n^2)

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
    if( validateBSTL(root.left,root.val) &&  validateBSTR(root.right,root.val) && isValidBST(root.left) && isValidBST(root.right))
        return true;
        
        return false;
    }
    
    Boolean validateBSTL(TreeNode root,int val){
        if (root==null)
            return true;
        if(root.val<val && validateBSTL(root.left,val) && validateBSTL(root.right,val))
            return true;
        
        return false;
    }
    
      Boolean validateBSTR(TreeNode root,int val){
        if (root==null)
            return true;
        if(root.val>val && validateBSTR(root.left,val) && validateBSTR(root.right,val))
            return true;
        
        return false;
    }
    
    //Efficient solution : Time Complexity : O(n)
    class Solution {
    public boolean isValidBST(TreeNode root) {
     return isValid(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    
    public boolean isValid(TreeNode root,long upper,long lower){
        if(root==null)
            return true;
        if(root.val>lower && root.val < upper 
          && isValid(root.left,root.val,lower) && isValid(root.right,upper,root.val))
            return true;
        
        return false;
    }
}
