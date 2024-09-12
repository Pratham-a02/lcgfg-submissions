class Solution {
    public int countConsistentStrings(String allowed,String[] words) {
        HashSet<Character> hs = new HashSet<>();
        for(char ch:allowed.toCharArray()){
            hs.add(ch);
        }
        int ans = 0;
        for(String word:words){
            boolean found = false;
            for(char ch:word.toCharArray()){
                if(!hs.contains(ch)){
                    found = true;
                }
            }
            if(found == false){
                ans++;
            }
        }
        return ans;
    }
}