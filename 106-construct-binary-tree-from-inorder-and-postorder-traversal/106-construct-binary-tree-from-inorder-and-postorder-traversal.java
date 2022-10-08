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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        int[] preIndex = {postorder.length-1};
        return treeBuild(postorder,inorder,0,inorder.length-1,preIndex,hm);
    }
    
    private TreeNode treeBuild(int[] postorder,int[] inorder,int start,int end,int[] preIndex,HashMap<Integer,Integer> hm){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(postorder[preIndex[0]]);
        int currIdx = hm.get(postorder[preIndex[0]]);
        preIndex[0] -= 1;
        root.right = treeBuild(postorder,inorder,currIdx+1,end,preIndex,hm);
        root.left = treeBuild(postorder,inorder,start,currIdx-1,preIndex,hm);
       
        
        return root;
    }
}
    
