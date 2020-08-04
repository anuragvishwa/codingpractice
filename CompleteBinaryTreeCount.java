//Iterative:
class Solution {
    public int countNodes(TreeNode root) {
     
        
        int leftCount = getLeftCount(root);
        int rightCount = getRightCount(root);
        
        if(leftCount==rightCount){
            return (1<<leftCount)-1;
        }
        
        return 1+countNodes(root.left) + countNodes(root.right);
}
    static int getLeftCount(TreeNode root){
        int depth = 0;
        while(root!=null){
            depth++;
            root= root.left;
        
        }
        
        return depth;
    }
        
        static int getRightCount(TreeNode root){
        int depth = 0;
        while(root!=null){
            depth++;
            root= root.right;
        }
            
            return depth;
    }
}
