class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m*n;
        parent = new int[600];
        rank = new int[600];
        for(int i = 0;i<parent.length;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    union(i,j+252);
                }
            }
        }
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    hm.put(find(i),hm.getOrDefault(find(i),0)+1);
                }
            }
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(entry.getValue()>1){
                ans += entry.getValue();
            }
        }
        return ans;
    }
    int[] parent;
    int[] rank;
    
    public int find(int x){
        if(parent[x] == x){
            return parent[x];
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    void union(int i, int j){
        int I = find(i);
        int J = find(j);
        if(I == J) return;
        if(rank[I] > rank[J]) {
            parent[J] = I;
            rank[I] += rank[J];
        } else {
            parent[I] = J;
            rank[J] += rank[I];
        }
    }
}