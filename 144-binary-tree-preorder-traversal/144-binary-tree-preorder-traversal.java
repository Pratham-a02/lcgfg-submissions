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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
            
        }
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(st.size()>0){
            TreeNode rem = st.pop();
            ans.add(rem.val);
            if(rem.right != null){
                st.push(rem.right);
            }
            if(rem.left!= null){
                st.push(rem.left);
            }
        }
        return ans;
    }
}