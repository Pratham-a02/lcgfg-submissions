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
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<al.size();i++){
            if(hm.containsKey(k-al.get(i))){
                return true;
            }
            hm.put(al.get(i),hm.getOrDefault(al.get(i),0)+1);
        }
        return false;
    }
    
    private void preOrder(TreeNode root,List<Integer> al){
        if(root == null){
            return;
        }
        al.add(root.val);
        preOrder(root.left,al);
        preOrder(root.right,al);
        
        return;
    }
}