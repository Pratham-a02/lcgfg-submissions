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
    public int sumNumbers(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        int sum = 0;
        List<String> al = new ArrayList<>();
        helper(root,"",al);
        for(int i = 0;i<al.size();i++){
            sum += Integer.parseInt(al.get(i));
        }
        return sum;
    }
    public void helper(TreeNode root,String curr,List<String> al){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            curr += root.val;
            al.add(curr);
            return;
        }
        curr+= root.val;
        
        helper(root.left,curr,al);
        helper(root.right,curr,al);
        
        return;
    }
}