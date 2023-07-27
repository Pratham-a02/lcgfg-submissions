class Solution{
    public int lengthOfLongestSubstring(String s){
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = s.length();
        int i = -1;
        int max = 0;
        for(int j = 0;j<n;j++){
            char ch = s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            if(hm.get(ch)>1){
                while(hm.get(ch)>1){
                    i++;
                    char ch2 = s.charAt(i);
                    hm.put(ch2,hm.get(ch2)-1);
                    if(hm.get(ch2) == 0){
                        hm.remove(ch2);
                    }
                }
            }
            
            max = Math.max(max,j-i);
        }
        return max;
    }
}