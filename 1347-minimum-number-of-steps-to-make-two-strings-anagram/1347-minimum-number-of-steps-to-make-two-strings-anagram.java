class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        
        int ans = 0;
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch) == 0){
                    hm.remove(ch);
                }
            }
        }
        
        for(int val:hm.values()){
            ans += val;
        }
        return ans;
    }
}