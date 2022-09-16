class Solution {
    public int numberOfSubstrings(String s){
        HashMap<Character,Integer> hm = new HashMap<>();
        int left = 0;
        int count = 0;
        
        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            while(hm.size() == 3){
                count += s.length() - right;
                char nch = s.charAt(left);
                hm.put(nch,hm.get(nch)-1);
                if(hm.get(nch) == 0){
                    hm.remove(nch);
                }
                left++;
            }
        }
        return count;
    }
}