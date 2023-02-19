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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<TreeNode> qu = new ArrayDeque<>();
        if(root == null){
            return new ArrayList<>();
        }
        qu.add(root);
        int level = 0;
        while(qu.size()>0){
            List<Integer> pAns = new ArrayList<>();
            int csize = qu.size();
            for(int i = 0;i<csize;i++){
                TreeNode rem = qu.remove();
                pAns.add(rem.val);
                if(rem.left!=null){
                    qu.add(rem.left);
                }
                if(rem.right!=null){
                    qu.add(rem.right);
                }
            }
            if(level%2 == 0){
                ans.add(pAns);
            }
            else{
                Collections.reverse(pAns);
                ans.add(pAns);
            }
            level++;
        }
        return ans;
    }
}