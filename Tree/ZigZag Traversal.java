class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode a = root;
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(a == null) return ans;
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        s1.push(root);
        
        // 2 while loops for adding nodes into the stack into alternate levels.
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> cur= new ArrayList<Integer>();
            while(!s1.isEmpty()){
                a = s1.pop();
                cur.add(a.val);
                if(a.left != null) s2.push(a.left);
                if(a.right != null) s2.push(a.right);
            }
            // adding the list to the final answer.
            
            ans.add(cur);
            
            // creating a new arraylist.
            cur = new ArrayList<Integer>();
            
            
            while(!s2.isEmpty()){
                a = s2.pop();
                cur.add(a.val);
                
                if(a.right != null) s1.push(a.right);
                if(a.left != null) s1.push(a.left);
            }
            
            if(!cur.isEmpty()) ans.add(cur);
        }
        return ans;
    }
}
