class Solution {
    public int minSteps(String s, String t) {
        int ans = 0;
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        
        for(int i = 0;i<s.length();i++){
            hm1.put(s.charAt(i),hm1.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(int i = 0;i<t.length();i++){
            hm2.put(t.charAt(i),hm2.getOrDefault(t.charAt(i),0)+1);
        }
        
        for(int i = 0;i<s.length();i++){
            if(hm2.containsKey(s.charAt(i))){
                hm2.put(s.charAt(i),hm2.get(s.charAt(i))-1);
                if(hm2.get(s.charAt(i)) == 0){
                    hm2.remove(s.charAt(i));
                }
            }
        }
        
        for(int i = 0;i<t.length();i++){
            if(hm1.containsKey(t.charAt(i))){
                hm1.put(t.charAt(i),hm1.get(t.charAt(i))-1);
                if(hm1.get(t.charAt(i)) == 0){
                    hm1.remove(t.charAt(i));
                }
            }
        }
        
        for(int val:hm1.values()){
            ans += val;
        }
        
        for(int val:hm2.values()){
            ans += val;
        }
        
        return ans;
    }
}