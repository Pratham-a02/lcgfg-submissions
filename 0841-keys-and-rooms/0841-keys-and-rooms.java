class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(0,rooms,vis);
        for(int i = 0;i<vis.length;i++){
            if(vis[i] == false){
                return false;
            }
        }
        return true;
    }
    
    public void dfs(int src,List<List<Integer>> rooms,boolean[] vis){
        vis[src] = true;
        
        for(int nbr:rooms.get(src)){
            if(!vis[nbr]){
                dfs(nbr,rooms,vis);
            }
        }
        return;
    }
}