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
    static class Pair implements Comparable<Pair>{
        TreeNode node;
        int vert;
        int horiz;
        
        Pair(TreeNode node,int vert,int horiz){
            this.node = node;
            this.vert = vert;
            this.horiz = horiz;
        }
        public int compareTo(Pair other){
            if(this.horiz == other.horiz){
                return this.node.val - other.node.val;
            }
            else{
                return this.horiz - other.horiz;
            }
        }
    }
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> qu = new LinkedList<>();
        HashMap<Integer,List<Pair>> hm = new HashMap<>();
        qu.add(new Pair(root,0,1));
        
        int lmv = 0;
        int rmv = 0;
        
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(rem.vert<lmv){
                lmv = rem.vert;
            }
            if(rem.vert>rmv){
                rmv = rem.vert;
            }
            if(!hm.containsKey(rem.vert)){
                hm.put(rem.vert,new ArrayList<>());
                hm.get(rem.vert).add(rem);
            }
            else{
                hm.get(rem.vert).add(rem);
            }
            if(rem.node.left!= null){
                qu.add(new Pair(rem.node.left,rem.vert-1,rem.horiz+1));
            }
            if(rem.node.right!= null){
                qu.add(new Pair(rem.node.right,rem.vert+1,rem.horiz+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = lmv;i<=rmv;i++){
            List<Integer> pAns = new ArrayList<>();
            List<Pair> unsortedList = hm.get(i);
            Collections.sort(unsortedList);
            for(Pair temp:unsortedList){
                pAns.add(temp.node.val);
            }
            ans.add(pAns);
        }
        return ans;
    }
}