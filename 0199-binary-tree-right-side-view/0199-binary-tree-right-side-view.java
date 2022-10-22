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
      ArrayList<Integer> ans = new ArrayList<>();
      HashSet<Integer> hs = new HashSet<>();
      leftSide(root,1,ans,hs);
      return ans;
    }
    public static void leftSide(TreeNode root,int level,List<Integer> ans,HashSet<Integer> hs){
        if(root == null){
            return;
        }
        if(hs.contains(level)){
            leftSide(root.right,level+1,ans,hs);
            leftSide(root.left,level+1,ans,hs);
            return;
        }
        else{
            hs.add(level);
            ans.add(root.val);
            leftSide(root.right,level+1,ans,hs);
            leftSide(root.left,level+1,ans,hs);
            return;
        }
        // return;
    }
}