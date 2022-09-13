class Solution {
    public int countGoodSubstrings(String s) {
        // int k = 3;
        int count = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int left = 0;
        
        for(int right = 0;right<s.length();right++){
            hm.put(s.charAt(right),hm.getOrDefault(s.charAt(right),0)+1);
            
            while((left<=right && hm.size()>3) || right-left+1>3){
                char dchar = s.charAt(left);
                hm.put(dchar,hm.get(dchar)-1);
                if(hm.get(dchar) == 0){
                    hm.remove(dchar);
                }
                left++;
            }
            
            if((right-left+1 == 3) && hm.size() == 3){
                count+=1;
            }
            
        }
        return count;
    }
}