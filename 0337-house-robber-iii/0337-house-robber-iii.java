/*public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;*}*}*/

class Solution{
    public int rob(TreeNode root){
        HashMap<TreeNode,Integer> hm = new HashMap<>();
        return solve(root,hm);
    }
    
    public int solve(TreeNode root,HashMap<TreeNode,Integer> hm){
        if(root == null) return 0;
        
        if(hm.containsKey(root)){
            return hm.get(root);
        }
        
        int inc = root.val;
        if(root.left != null){
            inc += solve(root.left.left,hm);
            inc += solve(root.left.right,hm);
        }
        if(root.right != null){
            inc += solve(root.right.left,hm);
            inc += solve(root.right.right,hm);
        }
        
        int exc = solve(root.left,hm) + solve(root.right,hm);
        
        hm.put(root,Math.max(inc,exc));
        
        return Math.max(inc,exc);
    }
}