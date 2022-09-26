class Solution {
    public char repeatedCharacter(String s){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
            if(hm.get(s.charAt(i)) == 2){
                return s.charAt(i);
            }
        }
        return 'x';
    }
}