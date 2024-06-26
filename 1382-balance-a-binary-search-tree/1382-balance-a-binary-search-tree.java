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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        inorder(root,al);
        return solve(0,al.size()-1,al);
    }
    
    public void inorder(TreeNode root,List<Integer> al){
        if(root == null){
            return;
        }
        
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
        
        return;
    }
    
    public TreeNode solve(int l,int r,List<Integer> al){
        if(l > r){
            return null;
        }
        
        int mid = l + ((r-l)/2);
        
        TreeNode root = new TreeNode(al.get(mid));
        root.left = solve(l,mid-1,al);
        root.right = solve(mid+1,r,al);
        
        return root;
    }
}