class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        
        for(int i = 0;i<time.length;i++){
            int val1 = (time[i]%60);
            int val2 = (60-val1);
            
            if(hm.containsKey(val2)){
                ans += hm.get(val2);
            }
            
            if(val1 == 0){
                if(hm.containsKey(0)){
                    ans += hm.get(0);
                }
            }
            hm.put(val1,hm.getOrDefault(val1,0)+1);
        }
        return ans;
    }
}