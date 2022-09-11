// String[] strArray = null;  
// strArray = text.split(",");  


class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        text+= " ";
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<brokenLetters.length();i++){
            hm.put(brokenLetters.charAt(i),hm.getOrDefault(brokenLetters.charAt(i),0)+1);
        }
        int count = 0;
        int ans = 0;
        for(int i = 0;i<text.length();i++){
            char ch = text.charAt(i);
            if(hm.containsKey(ch)){
                count++;
            }
            if((ch == ' ' && count == 0) ||(text.charAt(i) == ' ') && (count == 0)){
                ans+= 1;
            }
            if(ch == ' ' && count!=0){
                count = 0;
            }
        }
        return ans;
    }
}