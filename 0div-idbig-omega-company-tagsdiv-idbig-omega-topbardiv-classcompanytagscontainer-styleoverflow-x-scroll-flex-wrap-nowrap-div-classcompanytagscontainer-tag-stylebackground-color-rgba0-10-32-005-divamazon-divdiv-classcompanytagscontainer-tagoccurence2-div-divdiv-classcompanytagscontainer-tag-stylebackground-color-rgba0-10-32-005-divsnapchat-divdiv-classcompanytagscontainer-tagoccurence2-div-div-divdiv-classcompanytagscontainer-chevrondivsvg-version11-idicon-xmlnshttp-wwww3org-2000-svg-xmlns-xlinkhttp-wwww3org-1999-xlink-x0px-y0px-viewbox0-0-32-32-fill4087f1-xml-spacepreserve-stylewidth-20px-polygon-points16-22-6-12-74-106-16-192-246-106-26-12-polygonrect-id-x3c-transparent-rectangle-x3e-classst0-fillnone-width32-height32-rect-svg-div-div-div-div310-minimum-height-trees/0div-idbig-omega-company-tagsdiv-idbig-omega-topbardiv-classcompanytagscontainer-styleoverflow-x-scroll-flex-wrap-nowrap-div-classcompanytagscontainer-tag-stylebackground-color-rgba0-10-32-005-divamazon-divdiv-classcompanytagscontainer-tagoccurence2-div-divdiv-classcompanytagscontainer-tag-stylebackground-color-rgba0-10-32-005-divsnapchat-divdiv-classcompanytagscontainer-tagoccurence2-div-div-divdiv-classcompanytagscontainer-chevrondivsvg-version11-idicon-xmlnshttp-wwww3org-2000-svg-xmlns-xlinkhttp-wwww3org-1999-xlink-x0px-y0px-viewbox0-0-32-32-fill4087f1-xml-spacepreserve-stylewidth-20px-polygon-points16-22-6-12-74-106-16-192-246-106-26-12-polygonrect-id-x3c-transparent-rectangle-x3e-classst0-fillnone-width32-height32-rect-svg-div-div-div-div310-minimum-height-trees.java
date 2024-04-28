class Solution{
    public List<Integer> findMinHeightTrees(int n,int[][] edges){
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            al.add(new ArrayList<>());
        }
        if(edges.length == 0){
            ans.add(0);
            return ans;
        }
        int[] indegree = new int[n];
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            al.get(u).add(v);
            al.get(v).add(u);
        }
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            if(indegree[i] == 1){
                qu.add(i);
            }
        }
        
        while(n>2){
            int size = qu.size();
            
            n -= size;
            
            while(size-- >0){
                int rem = qu.remove();
                for(int nbr:al.get(rem)){
                    indegree[nbr]--;
                    if(indegree[nbr] == 1){
                        qu.add(nbr);
                    }
                }
            }
        }
        
        while(qu.size()>0){
            int rem = qu.remove();
            ans.add(rem);
        }
        return ans;
    }
}                        