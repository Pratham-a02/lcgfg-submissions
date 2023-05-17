class Pair{
    int bus;
    int csf;
    
    Pair(int bus,int csf){
        this.bus = bus;
        this.csf = csf;
    }
}

class Solution{
    public int numBusesToDestination(int[][] routes,int source,int target){
        if(source == target){
            return 0;
        }
        HashMap<Integer,HashSet<Integer>> hm = new HashMap<>();
        
        for(int bus = 0;bus<routes.length;bus++){
            for(int stop:routes[bus]){
                if(!hm.containsKey(stop)){
                    hm.put(stop,new HashSet<>());
                }
                hm.get(stop).add(bus);
            }
        }
        
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        for(int bus:hm.get(source)){
            qu.add(new Pair(bus,1));
        }
        
        boolean[] vis = new boolean[routes.length];
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(vis[rem.bus] == true){
                continue;
            }
            vis[rem.bus] = true;
            
            for(int dest:routes[rem.bus]){
                if(dest == target){
                    return rem.csf;
                }
            }
            
            for(int rstop : routes[rem.bus]){
                for(int buses : hm.get(rstop)){
                    if(vis[buses] == false){
                        qu.add(new Pair(buses,rem.csf+1));
                    }
                }
            }
        }
        return -1;
    }
}