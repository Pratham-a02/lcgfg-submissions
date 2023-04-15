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
class Pair{
    TreeNode root;
    int state;
    
    Pair(TreeNode root,int state){
        this.root = root;
        this.state = state;
    }
}
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<Pair> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(new Pair(root,1));
        while(st.size()>0){
            if(st.peek().state == 1){
                ans.add(st.peek().root.val);
                st.peek().state++;
                if(st.peek().root.left != null){
                    st.push(new Pair(st.peek().root.left,1));
                }
            }
            else if(st.peek().state == 2){
                st.peek().state++;
                if(st.peek().root.right != null){
                    st.push(new Pair(st.peek().root.right,1));
                }
            }
            else{
                st.pop();
            }
        }
        return ans;
    }
}