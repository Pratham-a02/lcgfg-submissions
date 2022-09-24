/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        List<Integer> ans = new ArrayList<>();
        if(root.left == null && root.right == null && k>0){
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null && k==0){
            ans.add(root.val);
            return ans;
        }
        HashSet<TreeNode> hs = new HashSet<>();
        // hs.add(target);
        HashMap<TreeNode,TreeNode> hm = new HashMap<>();
        addChildren(root,null,hm);
        
        
        kDistance(target,hm,hs,ans,k);
        
        return ans;
    }
    
    public void addChildren(TreeNode node,TreeNode parent,HashMap<TreeNode,TreeNode> hm){
        if(node == null){
            return;
        }
        hm.put(node,parent);
        addChildren(node.left,node,hm);
        addChildren(node.right,node,hm);
        
        return;
    }
    
    public void kDistance(TreeNode root,HashMap<TreeNode,TreeNode> hm,HashSet<TreeNode> hs,List<Integer> ans,int k){
        if(root == null || hs.contains(root)){
            return;
        }
        
        if(k == 0){
            hs.add(root);
            ans.add(root.val);
        }
        hs.add(root);
        kDistance(root.left,hm,hs,ans,k-1);
        kDistance(root.right,hm,hs,ans,k-1);
        kDistance(hm.get(root),hm,hs,ans,k-1);
        
        return;
    }
}