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
    HashMap<String,Integer> hm;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        hm = new HashMap<>();
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }
    
    public String dfs(TreeNode root){
        if(root == null){
            return "$";
        }
        
        String path = root.val + "#" + dfs(root.left) + "#" + dfs(root.right);
        hm.put(path,hm.getOrDefault(path,0)+1);
        if(hm.get(path) ==2){
            ans.add(root);
        }
        return path;
    }
}