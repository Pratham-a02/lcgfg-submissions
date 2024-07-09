class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        
        int left = 0;
        int max = 0;
        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            if(hm.get(ch)>1){
                while(hm.get(ch)>1){
                    char c = s.charAt(left);
                    hm.put(c,hm.get(c)-1);
                    if(hm.get(c) == 0){
                        hm.remove(c);
                    }
                    left++;
                }
            }
            
            max = Math.max(max,right-left+1);
        }
        
        return max;
    }
}