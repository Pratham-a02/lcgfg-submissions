class Solution {
    int[] parent;
    int[] rank;

    public int removeStones(int[][] stones) {
        int m = 10001;
        
        parent = new int[m * 2];
        rank = new int[m * 2];
        
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] stone : stones) {
            int u = stone[0];
            int v = stone[1] + m;
            
            int ul = find(u);
            int vl = find(v);
            if(ul != vl){
                union(ul,vl);   
            }
        }
        
        Set<Integer> uniqueParents = new HashSet<>();
        
        for (int[] stone : stones) {
            int u = stone[0];
            int v = stone[1] + m;
            uniqueParents.add(find(u));
            uniqueParents.add(find(v));
        }

        return stones.length - uniqueParents.size();
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  
        }
        return parent[x];
    }

   public void union(int x,int y){
        if(rank[x]>rank[y]){
            parent[y] = x;
            rank[x]++;
        }
        else if(rank[x]<rank[y]){
            parent[x] = y;
            rank[y]++;
        }
        else{
            parent[y] = x;
            rank[x]++;
        }
    }
}
