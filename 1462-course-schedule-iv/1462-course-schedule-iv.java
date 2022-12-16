class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries){
        List<Boolean> ans = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]prerequisite:prerequisites){
            int u = prerequisite[0];
            int v = prerequisite[1];
            graph.get(u).add(v);
        }
        
        for(int[]query:queries){
            int src = query[0];
            int dest = query[1];
             boolean[] vis = new boolean[numCourses];
            dfs(src,vis,graph);
            ans.add(vis[dest]);
         }
        if(prerequisites.length == 0){
            List<Boolean> bAns = new ArrayList<>();
            for(int i = 0;i<queries.length;i++){
                bAns.add(false);
            }
            return bAns;
        }
        return ans;
    }
    
    public void dfs(int src,boolean[] vis,List<List<Integer>> graph){
        
        vis[src] = true;
        
        for(int nbr:graph.get(src)){
            if(!vis[nbr]){
               dfs(nbr,vis,graph);
            }
            }
        }
        
    }
        
    
