class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = minCost(cost,0,new HashMap<Integer,Integer>());
        int b = minCost(cost,1,new HashMap<Integer,Integer>());
        return Math.min(a,b);
    }
    
    private int minCost(int[] cost,int currIdx,HashMap<Integer,Integer> hm){
        if(currIdx == cost.length){
            return 0;
        }
        if(currIdx > cost.length){
            return (int)1e9;
        }
        
        int currKey = currIdx;
        if(hm.containsKey(currKey)){
            return hm.get(currKey);
        }
        
        int oneStep = cost[currIdx] + minCost(cost,currIdx+1,hm);
        int twoStep = cost[currIdx] + minCost(cost,currIdx+2,hm);
        
        hm.put(currIdx,Math.min(oneStep,twoStep));
        
        return Math.min(oneStep,twoStep);
    }
    
}