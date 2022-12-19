class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        for(int i = 0;i<degree.length;i++){
            if(degree[i] == 1){
                qu.add(i);
            }
        }
        
        while(n>2){
            int size = qu.size();
            n -= size;
            
            while(size-->0){
                int rem = qu.remove();
                
                for(int nbr:adj.get(rem)){
                    degree[nbr]--;
                    if(degree[nbr] == 1){
                        qu.add(nbr);
                    }
                }
            }
        }
        ans.addAll(qu);
        return ans;
    }
}