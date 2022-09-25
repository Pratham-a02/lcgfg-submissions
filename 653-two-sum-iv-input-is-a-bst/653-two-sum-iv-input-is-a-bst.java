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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> al = new ArrayList<>();
        preOrder(root,al);
        int sum = 0;
        int i = 0;
        int j = al.size()-1;
        while(i<j){
            sum = al.get(i) + al.get(j);
            if(sum <k){
                i++;
            }
            else if(sum>k){
                j--;
            }
            else if(sum == k){
                return true;
            }
        }
        return false;
    }
    
    private void preOrder(TreeNode root,List<Integer> al){
        if(root == null){
            return;
        }

        preOrder(root.left,al);
        al.add(root.val);
        preOrder(root.right,al);
        
        return;
    }
}