class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    private int dfsHeight(TreeNode root){
        if(root == null) return 0;
        
        // calculating right height.
        int leftH = dfsHeight(root.left);
        if(leftH == -1) return -1;
        
        //calculating left height
        
        int rightH = dfsHeight(root.right);
        if(rightH == -1) return -1;
        
        // checking if tree is balanced.
        if(Math.abs(leftH - rightH) > 1) return -1;
        
        
        // if it is balanced we go on to the upper tree.
        return 1 + Math.max(leftH , rightH);
    }
}
