class Solution{
    public char findTheDifference(String s,String t){
       // if(s.length() == 0) return t;
       HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char ch:t.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.get(ch)-1);
            if(hm.get(ch) == 0){
                hm.remove(ch);
            }
        }
        
        for(char key:hm.keySet()){
            return key;
        }
        return ' ';
    }
}