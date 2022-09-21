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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> al = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        addLeftSubtree(root,st);
        while(st.size()>0){
            TreeNode rem = st.pop();
            al.add(rem.val);
            if(rem.right != null){
                addLeftSubtree(rem.right,st);
            }
        }
        return al;
    }
    private void addLeftSubtree(TreeNode currNode,Stack<TreeNode> st){
        st.push(currNode);
        while(currNode.left != null){
            st.push(currNode.left);
            currNode = currNode.left;
        }
    }
}