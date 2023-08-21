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
    public List<List<Integer>> pathSum(TreeNode root,int targetSum){
        List<List<Integer>> ans = new ArrayList<>();
        solve(root,0,new ArrayList<>(),targetSum,ans);
        return ans;
    }
    
    public void solve(TreeNode root,int sum,List<Integer> al,int target,List<List<Integer>> ans){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            sum += root.val;
            if(sum == target){
                List<Integer> curr = new ArrayList<>(al);
                curr.add(root.val);
                ans.add(curr);
            }
        }
        
        sum += root.val;
        al.add(root.val);
        
        solve(root.left,sum,al,target,ans);
        solve(root.right,sum,al,target,ans);
        al.remove(al.size()-1);
        return;
    }
}