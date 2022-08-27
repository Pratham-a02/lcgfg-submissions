class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int a = 0;
        int left = 0;
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i))>=left){
                    left = hm.get(s.charAt(i)) + 1;
            }
            hm.put(s.charAt(i),i);
            
            a = i-left+1;
            ans = Math.max(ans,a);
        }
        return ans;
    }
             
}