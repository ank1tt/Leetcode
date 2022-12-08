class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        
        int level = 0;
        int prev;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(q.size() != 0){
            int n = q.size();
            prev = 0;
            
            for(int i = 0; i < n; i++){
                TreeNode temp = q.poll();
                
                if(level % 2 == 0){
                    if(temp.val % 2 == 0) return false;
                    
                    if(prev != 0 && temp.val <= prev) return false; 
                    
                    if(temp.left != null) q.add(temp.left);
                    
                    if(temp.right != null) q.add(temp.right);
                }else{
                    
                    if(temp.val % 2 != 0) return false;
                    
                    if(prev != 0 && temp.val >= prev) return false;
                    
                    if(temp.left != null) q.add(temp.left);
                    
                    if(temp.right != null ) q.add(temp.right);
                }

                prev = temp.val;                   
            }
            level++;
        }
        return true;
    }
    
}

         // when the level is even check if the root value is odd. if not return false.
                // at even level the current node will be greater than the prev node. if not return false. 
                    // at odd level check if the current node is even. if not return false.
                    // the current node at odd level will be less than the prev node. if not return false.
