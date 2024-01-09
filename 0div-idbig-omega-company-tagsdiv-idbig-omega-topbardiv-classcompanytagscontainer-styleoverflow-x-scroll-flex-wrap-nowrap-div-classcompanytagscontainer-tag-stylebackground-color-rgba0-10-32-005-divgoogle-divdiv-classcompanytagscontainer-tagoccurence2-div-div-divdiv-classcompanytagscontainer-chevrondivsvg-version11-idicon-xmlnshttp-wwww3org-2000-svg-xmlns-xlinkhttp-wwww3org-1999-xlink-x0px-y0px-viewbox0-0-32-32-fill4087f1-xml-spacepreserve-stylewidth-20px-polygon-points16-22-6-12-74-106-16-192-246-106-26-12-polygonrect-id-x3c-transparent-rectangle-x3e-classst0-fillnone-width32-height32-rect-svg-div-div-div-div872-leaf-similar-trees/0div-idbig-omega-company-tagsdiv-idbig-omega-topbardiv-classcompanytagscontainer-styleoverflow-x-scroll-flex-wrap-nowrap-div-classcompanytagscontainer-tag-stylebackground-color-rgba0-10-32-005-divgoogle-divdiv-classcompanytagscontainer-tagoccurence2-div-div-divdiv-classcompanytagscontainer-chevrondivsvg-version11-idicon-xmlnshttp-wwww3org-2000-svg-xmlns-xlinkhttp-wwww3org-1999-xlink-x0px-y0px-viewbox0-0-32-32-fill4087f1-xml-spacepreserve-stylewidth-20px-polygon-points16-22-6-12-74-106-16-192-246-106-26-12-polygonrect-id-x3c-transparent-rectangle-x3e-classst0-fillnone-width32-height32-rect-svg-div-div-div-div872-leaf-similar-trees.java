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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        leftTree(root1,al1);
        rightTree(root2,al2);
        
        return al1.equals(al2);
    }
    
    private void leftTree(TreeNode root1,List<Integer> al1){
        if(root1.left == null && root1.right == null){
            al1.add(root1.val);
            return;
        }
        if(root1.left != null){
        leftTree(root1.left,al1);}
        if(root1.right != null){
        leftTree(root1.right,al1);}
    }
    
    private void rightTree(TreeNode root2,List<Integer> al2){
        if(root2.left == null && root2.right == null){
            al2.add(root2.val);
            return;
        }
        if(root2.left != null){
        rightTree(root2.left,al2);}
        if(root2.right != null){
        rightTree(root2.right,al2);}
    }
}