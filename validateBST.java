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
