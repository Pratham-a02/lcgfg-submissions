class Solution {
    
    public int maxProfit(int k,int[] prices) {
        return bestTime(prices,0,1,k,new HashMap<String,Integer>());
    }
    
    public int bestTime(int[] prices,int currDay,int canBuy,int transCount,HashMap<String,Integer>hm){
        if(currDay>=prices.length || transCount<=0)
            return 0;

        
        String currKey = currDay + "_" + canBuy + "_" + transCount;
        
        if(hm.containsKey(currKey))
            return hm.get(currKey);
        
        if(canBuy == 1){
            int idle = bestTime(prices,currDay+1,canBuy,transCount,hm);
            int buy =  bestTime(prices,currDay+1,0,transCount,hm)-prices[currDay];    
            
            hm.put(currKey,Math.max(idle,buy));
            return hm.get(currKey);
        }
        else{
            int idle = bestTime(prices,currDay+1,canBuy,transCount,hm);
            int sell = prices[currDay] + bestTime(prices,currDay+1,1,transCount-1,hm);
            hm.put(currKey,Math.max(idle,sell));
            return hm.get(currKey);
        }
    }
}