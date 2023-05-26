class Solution{
    public boolean hasGroupsSizeX(int[] deck){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<deck.length;i++){
            hm.put(deck[i],hm.getOrDefault(deck[i],0)+1);
        }
        
        int ans = 0;
        for(int val : hm.values()){
            ans = gcd(ans,val);
        }
        
        if(ans >= 2){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        
        return gcd(b,a%b);
    }
}