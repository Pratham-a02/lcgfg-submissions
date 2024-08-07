class Solution {
    public int minimumPushes(String word) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        int cnt = 2;
        for(char c:word.toCharArray()){
            if(cnt>9){
                cnt = 2;
            }
            hm.put(cnt,hm.getOrDefault(cnt,0)+1);
            ans += hm.get(cnt);
            cnt++;
            
        }
        
        return ans;
    }
}