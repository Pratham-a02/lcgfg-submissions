class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] ans = new int[quiet.length];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<quiet.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i<richer.length;i++){
            graph.get(richer[i][1]).add(richer[i][0]);
        }
        Arrays.fill(ans,-1);
        for(int i = 0;i<graph.size();i++){
            if(graph.get(i).size() == 0){
                ans[i] = i;
            }
        }
        for(int i = 0;i<ans.length;i++){
            if(ans[i] == -1){
                ans[i] = dfs(i,graph,ans,quiet);
            }
        }
        return ans;
    }
    
    public int dfs(int src,List<List<Integer>> graph,int[] ans,int[] quiet){
        if(ans[src] != -1){
            return ans[src];
        }
        
        int minPos = src;
        int min = quiet[src];
        
        if(graph.get(src) != null){
            for(int i = 0;i<graph.get(src).size();i++){
                int ind = dfs(graph.get(src).get(i),graph,ans,quiet);
                if(quiet[ind]<min){
                    min = quiet[ind];
                    minPos = ind;
                }
            }
        }
        ans[src] = minPos;
        return ans[src];
    }
}