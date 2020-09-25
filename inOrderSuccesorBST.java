public class inOrderSuccesorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if(root==null){
            return null;
        }
        
        TreeNode temp = p;
        
        //Case 1: If right child isn't null:
        //Going by inorder rule, the leftmost child in the right tree must be the successor:
        if(temp.right!=null){
            temp = temp.right;
            
            while(temp.left!=null){
                temp = temp.left;
            }
            
            return temp;
        }
       
        
        //Case 2 :If right child is null:
		//The parent to which the node is left side, is the one, so we keep moving up the parent    //until we find the one to whoe's left is 'p'.
            
        temp = null;
        
        while(root!=p){
            
            if(p.val<root.val){
                temp = root;
                root = root.left;
                
            }
            else{
                root = root.right;
            }
            
        }
        
       
        return temp;
        
    }
}
