class Solution {
    
    public int maximumDetonation(int[][] bombs){
        // int n = bombs.length;
        // List<List<Integer>> al = new ArrayList<>();
        // for(int i = 0;i<n;i++){
        //     al.add(new ArrayList<>());
        // }
        
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int n=bombs.length;
        for(int i=0;i<n;i++){
             adj.add(new ArrayList<>());
            long x=bombs[i][0];
            long y=bombs[i][1];
            long r=bombs[i][2];
            for(int j=0;j<n;j++){
                long x2=bombs[j][0];
                long y2=bombs[j][1];
                if(i!=j){
                    long range=(x-x2)*(x-x2)+(y-y2)*(y-y2);
                    if(range<=r*r){
                       
                        adj.get(i).add(j);
                    }
                }
            }
        }
        int maxCount=0;
        for(int startbomb=0;startbomb<n;startbomb++){//number of bombs i will detonate if start bomb is startbomb
        HashSet<Integer>set=new HashSet<>();
        int count=dfs(startbomb,adj,set);
        if(count==n)
            return count;//bhayankar optimization
        maxCount=Math.max(maxCount,count);

        }
        return maxCount;

    }
    int dfs(int start,ArrayList<ArrayList<Integer>>adj,HashSet<Integer>set){
        set.add(start);
        for(int x :adj.get(start)){
            if(!set.contains(x))
                dfs(x,adj,set);
        }
        return set.size();
    }
}

