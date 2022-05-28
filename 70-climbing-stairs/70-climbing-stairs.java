class Solution {
    public int climbStairs(int n) {
        return totalWays(0,n,new HashMap<Integer,Integer>());
    }
    
    private int totalWays(int currStair,int targetStair,HashMap<Integer,Integer> hm){
        if(currStair>targetStair){
            return 0;
        }
        if(currStair == targetStair){
            return 1;
        }
        int currentKey = currStair;
        if(hm.containsKey(currentKey))
            return hm.get(currentKey);
        
        int oneStep = totalWays(currStair+1,targetStair,hm);
        int twoStep = totalWays(currStair+2,targetStair,hm);
        hm.put(currStair,oneStep + twoStep);
        return oneStep + twoStep;
    }
}