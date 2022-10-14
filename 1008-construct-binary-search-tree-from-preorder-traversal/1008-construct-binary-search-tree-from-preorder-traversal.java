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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode construct(int[] preorder,int min,int max){
        if(index == preorder.length){
            return null;
        }
        else if(preorder[index]>min && preorder[index]<max){
            TreeNode node = new TreeNode(preorder[index]);
            index++;
            
            node.left = construct(preorder,min,node.val);
            node.right = construct(preorder,node.val,max);
            
            return node;
        }
        else{
            return null;
        }
    }
}