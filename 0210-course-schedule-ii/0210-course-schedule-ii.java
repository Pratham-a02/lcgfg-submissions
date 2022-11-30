class Solution {
    public List<List<Integer>> createGraph(int n,int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[]edge:edges){
            int u = edge[1];
            int v = edge[0];
            
            graph.get(v).add(u);
        }
        
        return graph;
    }
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = createGraph(numCourses,prerequisites);
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        
        for(int v = 0;v<numCourses;v++){
            for(int nbr:graph.get(v)){
                indegree[nbr]++;
            }
        }
        
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i] == 0){
                qu.add(i);
            }
        }
        
        int idx = ans.length-1;
        while(qu.size()>0){
            int rem = qu.remove();
            ans[idx--] = rem;
            
            for(int nbr:graph.get(rem)){
                indegree[nbr]--;
                
                if(indegree[nbr] == 0){
                    qu.add(nbr);
                }
            } 
        }
        if(idx<0){
            return ans;
        }
        else{
            return new int[]{};
        }
        
    }
}