class Pair{
    int val;
    int idx;
    
    Pair(int val,int idx){
        this.val = val;
        this.idx = idx;
    }
}
class Solution{
    public int timeRequiredToBuy(int[] tickets,int k){
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        for(int i = 0;i<tickets.length;i++){
            qu.add(new Pair(tickets[i],i));
        }
        
        int ans = 0;
        
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            rem.val--;
            ans++;
            if(rem.val == 0 && rem.idx == k){
                return ans;
            }
            
            if(rem.val != 0){
                Pair p = new Pair(rem.val,rem.idx);
                qu.add(p);
            }
        }
        return ans;
    }
}