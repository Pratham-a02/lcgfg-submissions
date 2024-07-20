class Solution {
    int[] parent;
    int[] rank;
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0;i<parent.length;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i != j){
                    if(isConnected[i][j] == 1){
                        int iLead = find(i);
                        int jLead = find(j);
                        
                        if(iLead != jLead){
                            union(iLead,jLead);
                        }
                    }
                }
            }
        }
        
        int ans = 0;
        for(int i = 0;i<parent.length;i++){
            if(parent[i] == i){
                ans++;
            }
        }
        
        return ans;
        //  0 1 2
        //0 1 1 0
        //1 1 1 0
        //2 0 0 1
        
        
        /*
         0 1 2  
     0   0 1 2     r*n + c
     1   3 4 5
     2   6 7 8
        a
        /\
        b c
       
        0 1 2 3 4 5 6 7 8
        */
    }
    
    public int find(int x){
        if(parent[x] == x){
            return parent[x];
        }
        else{
            int cp = parent[x];
            int myPar = find(cp);
            return parent[x] = myPar;
        }
    }
    
    public void union(int x,int y){
        if(rank[x] > rank[y]){
            parent[y] = x;
            rank[x]++;
        }
        else if(rank[y]>rank[x]){
            parent[x] = y;
            rank[y]++;
        }
        else{
            parent[y] = x;
            rank[x]++;
        }
    }
}