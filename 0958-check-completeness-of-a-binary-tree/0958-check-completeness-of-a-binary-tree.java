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
    public boolean isCompleteTree(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int level = 0;
        boolean nullFound = false;
        while(qu.size()>0){
            TreeNode rem = qu.element();
            qu.remove();
            if(rem == null){
                nullFound = true;
            }
            else{
                if(nullFound == true){
                    return false;
                }
                qu.add(rem.left);
                qu.add(rem.right);
            }
        }
        return true;
    }
}