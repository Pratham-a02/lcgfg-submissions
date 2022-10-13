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
    public int pathSum(TreeNode root, int targetSum){
        
        HashMap<Long,Integer> hm = new HashMap<>();
        hm.put(0L,1);
        int[] count = new int[1];
        totalCount(root,targetSum,0,count,hm);
        return count[0];
    }
    
    public void totalCount(TreeNode root,int k,long ps,int[] count,HashMap<Long,Integer>hm){
        if(root == null){
            return;
        }
        ps += (long)root.val;
        if(hm.containsKey(ps-k)){
            count[0]+= hm.get(ps-k);
        }
        
        hm.put(ps,hm.getOrDefault(ps,0)+1);
        
        totalCount(root.left,k,ps,count,hm);
        totalCount(root.right,k,ps,count,hm);
        
        if(hm.get(ps) == 1){
            hm.remove(ps);
        }
        else{
            hm.put(ps,hm.get(ps)-1);
        }
    }
}