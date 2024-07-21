class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int left = 0;
        int max = 0;
        
        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            
            if(hm.containsKey(ch)){
                if(hm.get(ch)>=left){
                    left = hm.get(ch)+1;   
                }
            }
            hm.put(ch,right);
            
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}