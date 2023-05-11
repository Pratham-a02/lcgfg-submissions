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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        ArrayDeque<TreeNode> qu = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        qu.add(root);
        
        while(qu.size()>0){
            List<Integer> curr = new ArrayList<>();
            
            int csize = qu.size();
            
            for(int i = 0;i<csize;i++){
                TreeNode rem = qu.remove();
                curr.add(rem.val);
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            
            ans.add(curr);
        }
        return ans;
    }
}