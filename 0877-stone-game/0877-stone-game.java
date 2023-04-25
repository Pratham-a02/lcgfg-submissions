class Solution {
    public boolean stoneGame(int[] piles){
        if(piles.length == 0)
            return true;
        int n = piles.length;
        return findWinner(0,n-1,true,0,0,piles,new HashMap<String,Boolean>());
    }
    public boolean findWinner(int start,int end,boolean isAlice,int aliceScore,int bobScore,int[]piles,HashMap<String,Boolean>hm){
        if(start > end){
            return aliceScore>bobScore?true:false;
        }
        
        String currKey = start + "_" + end;
        
        if(hm.containsKey(currKey))
            return hm.get(currKey);
        if(isAlice){
            boolean s = findWinner(start+1,end,false,aliceScore+piles[start],bobScore,piles,hm);
            boolean e = findWinner(start,end-1,false,aliceScore+piles[end],bobScore,piles,hm);
            hm.put(currKey,s||e);
            return s||e;
        }
        else{
            boolean s = findWinner(start+1,end,true,aliceScore,bobScore+piles[start],piles,hm);
            boolean e = findWinner(start,end-1,true,aliceScore,bobScore+piles[end],piles,hm);
            hm.put(currKey,s||e);
            return s||e;
        }
    }
}