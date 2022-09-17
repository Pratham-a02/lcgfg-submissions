class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int ans = 0;
        
        ans += hm.get(s.charAt(0));
        
        for(int i = 1;i<s.length();i++){
            
            ans += hm.get(s.charAt(i));
            if(hm.get(s.charAt(i)) > hm.get(s.charAt(i-1))){
                ans -= 2*hm.get(s.charAt(i-1));
            }
        }
        return ans;
    }
}