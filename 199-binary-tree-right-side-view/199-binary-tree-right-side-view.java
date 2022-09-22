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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<>();
        List<Integer> ans = new ArrayList<>();
        rightView(root,1,hm,ans);
        for(int val:hm.values()){
            ans.add(val);
        }
        return ans;
    }
    
    private void rightView(TreeNode root,int level,HashMap<Integer,Integer> hm,List<Integer> ans){
        if(root == null){
            return;
        }
        hm.put(level,root.val);
        rightView(root.left,level+1,hm,ans);
        rightView(root.right,level+1,hm,ans);
        return;
    }
}