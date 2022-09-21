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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        String currAns = "";
        if(root.left == null && root.right == null){
            currAns += root.val;
            ans.add(currAns);
            return ans;
        }
        treePath(root,ans,currAns);
        return ans;
    }
    
    private void treePath(TreeNode root,List<String> ans,String currAns){
        if(root.left == null && root.right == null){
            currAns += root.val;
            ans.add(currAns);
        }
        currAns += root.val + "-" + ">";
        
        if(root.left != null){
        treePath(root.left,ans,currAns);}
        if(root.right != null){
        treePath(root.right,ans,currAns);}
        
        return;
    }
}