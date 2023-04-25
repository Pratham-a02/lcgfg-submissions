class Solution {
    public boolean stoneGame(int[] piles) {
        return willWin(0,0,0,piles.length-1,true,piles,new HashMap<>());
    }
    
    public boolean willWin(int aScore,int bScore,int start,int end,boolean canBuy,int[] piles,HashMap<String,Boolean> hm){
        if(start>end){
            return aScore>bScore?true:false;
        }
        
        String currKey = start + "_" + end;
        
        if(hm.containsKey(currKey)){
            return hm.get(currKey);
        }
        
        if(canBuy){
            boolean st = willWin(aScore+piles[start],bScore,start+1,end,false,piles,hm);
            boolean ed = willWin(aScore+piles[end],bScore,start,end-1,false,piles,hm);
            
            hm.put(currKey,(st || ed));
            return (st || ed);
        }
        else{
            boolean st = willWin(aScore,bScore+piles[start],start+1,end,true,piles,hm);
            boolean ed = willWin(aScore,bScore+piles[end],start,end-1,true,piles,hm);
            
            hm.put(currKey,(st || ed));
            return (st || ed);
        }
    }
}