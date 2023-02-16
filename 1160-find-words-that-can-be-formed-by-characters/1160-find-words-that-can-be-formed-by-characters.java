class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> hm= new HashMap<>();
        for(int i=0; i<chars.length(); i++){
            hm.put(chars.charAt(i), hm.getOrDefault(chars.charAt(i), 0)+1);
        }

        int ans= 0;
        for(String s: words){
            HashMap<Character, Integer> temp= new HashMap<>(hm);
            boolean strAvailable = true;
            for(int i=0; i<s.length(); i++){
                char c= s.charAt(i);
                if( temp.containsKey(c) ){
                    if(temp.get(c) == 1){
                        temp.remove(c);
                    }
                    else{
                        temp.put(c, temp.get(c)-1);
                    }
                }
                else{
                    strAvailable= false;
                    break; 
                }
            }

            if(strAvailable){
                ans+= s.length();
            }
        }

        return ans;
    }
}