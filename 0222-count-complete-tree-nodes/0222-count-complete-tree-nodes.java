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
    public int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        // if(root.left == null && root.right == null){
        //     return root.val;
        // }
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);
        if(leftHeight==rightHeight){
            int ht = leftHeight+1;
            return (1<<ht) -1;
        }
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
public int findLeftHeight(TreeNode root){
        if(root == null || root.left == null){
            return 0;
        }
        int height = 1 + findLeftHeight(root.left);
        return height;
    }
    
    public int findRightHeight(TreeNode root){
        if(root == null || root.right == null){
            return 0;
        }
        int height = 1 + findRightHeight(root.right);
        return height;
    }
    
}