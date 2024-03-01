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
class Solution{
    public boolean isEvenOddTree(TreeNode root){
        ArrayDeque<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        int level = 0;
        
        while(qu.size()>0){
            int size = qu.size();
            List<Integer> curr = new ArrayList<>();
            
            for(int i = 0;i<size;i++){
                TreeNode rem = qu.remove();
                if(level%2 == 0 && (rem.val)%2 != 1){
                    return false;
                }
                else if(level%2 == 1 && (rem.val)%2 != 0){
                    return false;
                }
                curr.add(rem.val);
                if(rem.left != null){
                    qu.add(rem.left);
                }
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            
            if(curr.size() == 1){
                level++;
                continue;
            } 
            
            if(level % 2 == 0){
                for(int i = 1;i<curr.size();i++){
                    if(curr.get(i)<=curr.get(i-1)){
                        return false;
                    }
                }
            }
            else{
                for(int i = 1;i<curr.size();i++){
                    if(curr.get(i)>=curr.get(i-1)){
                        return false;
                    }
                }
            }
            level++;
        }
        return true;
    }
}