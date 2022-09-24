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
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer> pAns= new ArrayList<>();
            int currSize = q.size();
            while(currSize>0){
            TreeNode rem = q.remove();
            pAns.add(rem.val);
            if(rem.left!=null){
                q.add(rem.left);
            }
            if(rem.right!=null){
                q.add(rem.right);
            }
            currSize--;
        }
            ans.add(pAns);
        }
        return ans;
    }
}