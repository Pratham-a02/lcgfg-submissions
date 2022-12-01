class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];
        Arrays.fill(rank,0);
        
        for(int i = 0;i<26;i++){
            parent[i] = i;
        }
        
        for(String equation:equations){
            if(equation.charAt(1) == '='){
            int op1 = equation.charAt(0) - 'a';
            int op2 = equation.charAt(3) - 'a';
            
            int op1Lead = find(op1,parent);
            int op2Lead = find(op2,parent);
            
            if(op1Lead != op2Lead){
            union(op1Lead,op2Lead,parent,rank);
            }
            }
        }
        
        for(String equation:equations){
            if(equation.charAt(1) == '!'){
                int op1 = equation.charAt(0) - 'a';
                int op2 = equation.charAt(3) - 'a';

                int op1Lead = find(op1,parent);
                int op2Lead = find(op2,parent);


                    if(op1Lead == op2Lead){
                        return false;
                    }
            }
        }
        return true;
    }
    
    public void union(int x,int y,int[] parent,int[] rank){
        if(rank[x] < rank[y]){
            parent[x] = y;
        }
        else if(rank[y] < rank[x]){
            parent[y] = x;
        }
        else{
            parent[x] = y;
            rank[y]++;
        }
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
}