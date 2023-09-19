class Solution {
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for(int i = 0;i<parent.length;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(String eqn : equations){
            if(eqn.charAt(1) == '='){
                int op1 = eqn.charAt(0) - 'a';
                int op2 = eqn.charAt(3) - 'a';
                
                int op1Lead = find(op1);
                int op2Lead = find(op2);
                
                if(op1Lead != op2Lead){
                    union(op1Lead,op2Lead);
                }
            }
        }
        
        for(String eqn:equations){
            if(eqn.charAt(1) == '!'){
                int op1 = eqn.charAt(0) - 'a';
                int op2 = eqn.charAt(3) - 'a';
                
                int op1Lead = find(op1);
                int op2Lead = find(op2);
                
                if(op1Lead == op2Lead){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int find(int x){
        if(parent[x] == x){
            return parent[x];
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int x,int y){
        if(rank[x] > rank[y]){
            parent[y] = x;
        }
        else if(rank[x] < rank[y]){
            parent[x] = y;
        }
        else{
            parent[y] = x;
            rank[x]++;
        }
    }
}