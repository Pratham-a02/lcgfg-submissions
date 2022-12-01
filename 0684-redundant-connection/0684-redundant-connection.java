class Solution {
    public int[] findRedundantConnection(int[][] edges){
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        
        Arrays.fill(rank,0);
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        
        for(int[]edge:edges){
            int x = edge[0];
            int y = edge[1];
            
            int xLead = find(x,parent);
            int yLead = find(y,parent);
            
            if(xLead != yLead){
                union(xLead,yLead,parent,rank);
            }
            else if(xLead == yLead){
                return new int[]{x,y};
            }
        }
        return new int[]{};
    }
    
    public int find(int x,int[] parent){
        if(parent[x] == x){
            return x;
        }
        else{
            parent[x] = find(parent[x],parent);
            return parent[x];
        }
    }
    
    public void union(int x,int y,int[] parent,int[] rank){
        if(rank[x]<rank[y]){
            parent[x] = y;
        }
        else if(rank[y]<rank[x]){
            parent[y] = x;
        }
        else{
            parent[y] = x;
            rank[x]++;
        }
    }
}