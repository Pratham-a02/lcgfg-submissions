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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        int[] preIndex = {0};
        return treeBuild(preorder,inorder,0,inorder.length-1,preIndex,hm);
    }
    
    private TreeNode treeBuild(int[] preorder,int[] inorder,int start,int end,int[] preIndex,HashMap<Integer,Integer> hm){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        int currIdx = hm.get(preorder[preIndex[0]]);
        preIndex[0] += 1;
        root.left = treeBuild(preorder,inorder,start,currIdx-1,preIndex,hm);
        root.right = treeBuild(preorder,inorder,currIdx+1,end,preIndex,hm);
        
        return root;
    }
}