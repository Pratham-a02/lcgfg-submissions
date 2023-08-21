class Pair{
    int node;
    int time;
    
    Pair(int node,int time){
        this.node = node;
        this.time = time;
    }
}

class Solution{
    public int numOfMinutes(int n,int headID,int[] manager,int[] informTime){
        if(n == 1) return 0;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i<n;i++){
            int mang = manager[i];
            int emp = i;
            
            if(mang != -1){
                adj.get(mang).add(emp);
            }
        }
        
        return solve(adj,informTime,headID);
    }
    int max = 0;
    public int solve(List<List<Integer>> adj,int[] informTime,int headID){
        
        ArrayDeque<Pair> qu = new ArrayDeque();
        qu.add(new Pair(headID,0));
        
        while(qu.size()>0){
            Pair rem = qu.remove();
            int currEmp = rem.node;
            int currTime = rem.time;
            max = Math.max(max,currTime);
            
            for(int nbr:adj.get(currEmp)){
                qu.add(new Pair(nbr,currTime + informTime[currEmp]));
            }
        }
        
        return max;
    }
}