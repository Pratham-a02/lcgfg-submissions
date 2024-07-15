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
class Solution{
    public TreeNode createBinaryTree(int[][] descriptions){
        HashMap<Integer,int[]> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        int parent = -1;
        for(int[] desc:descriptions){
            int par = desc[0];
            int child = desc[1];
            int isLeft = desc[2];
            
            if(hm.containsKey(par)){
                if(isLeft == 1){
                    hm.get(par)[0] = child;
                }
                else{
                    hm.get(par)[1] = child;
                }
            }
            else{
                hm.put(par,new int[2]);
                if(isLeft == 1){
                    hm.get(par)[0] = child;
                }
                else{
                    hm.get(par)[1] = child;
                }
            }
        }
        
        for(int[] desc:descriptions){
            int child = desc[1];
            hs.add(child);
        }
        
        for(int[] desc:descriptions){
            int par = desc[0];
            if(!hs.contains(par)){
                parent = par;
            }
        }
        
        TreeNode node = solve(parent,hm);
        return node;
    }
    
    public TreeNode solve(int parent,HashMap<Integer,int[]> hm){
        if(parent == 0){
            return null;
        }
        if(!hm.containsKey(parent)){
            return new TreeNode(parent);
        }
        TreeNode node = new TreeNode(parent);
        int[] arr = hm.get(parent);
        
        if(arr[0] != 0){
            node.left = solve(arr[0],hm);
        }
        if(arr[1] != 0){
            node.right = solve(arr[1],hm);
        }
        
        return node;
    }
}