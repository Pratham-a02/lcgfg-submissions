class Solution {
    
    public int maxProfit(int[] prices) {
        return bestTime(prices,0,1,new HashMap<String,Integer>());
    }
    
    public int bestTime(int[] prices,int currDay,int canBuy,HashMap<String,Integer>hm){
        if(currDay>=prices.length)
            return 0;

        
        String currKey = currDay + "_" + canBuy;
        
        if(hm.containsKey(currKey))
            return hm.get(currKey);
        
        if(canBuy == 1){
            int idle = bestTime(prices,currDay+1,canBuy,hm);
            int buy =  bestTime(prices,currDay+1,0,hm)-prices[currDay];    
            
            hm.put(currKey,Math.max(idle,buy));
            return hm.get(currKey);
        }
        else{
            int idle = bestTime(prices,currDay+1,canBuy,hm);
            int sell = prices[currDay] + bestTime(prices,currDay+2,1,hm);
            hm.put(currKey,Math.max(idle,sell));
            return hm.get(currKey);
        }
    }
}