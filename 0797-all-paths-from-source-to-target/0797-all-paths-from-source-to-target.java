class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>(); 
        boolean[] vis = new boolean[n];
        dfs(0,n-1,graph,vis,ans,currAns);
        return ans;
    }
    
    public void dfs(int src,int dest,int[][] graph,boolean[] vis,List<List<Integer>> ans,List<Integer> currAns){
        if(src == dest){
            List<Integer> bAns = new ArrayList<>(currAns);
            bAns.add(src);
            ans.add(bAns);
        }
        
        vis[src] = true;
        currAns.add(src);
        
        for(Integer nbr:graph[src]){
            if(!vis[nbr]){
                dfs(nbr,dest,graph,vis,ans,currAns);
            }
        }
        
        vis[src] = false;
        currAns.remove(currAns.size()-1);
    }
}