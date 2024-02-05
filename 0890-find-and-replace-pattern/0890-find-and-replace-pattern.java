class Solution{
    public List<String> findAndReplacePattern(String[] words,String pattern){
        List<String> ans = new ArrayList<>();
        
        for(String word:words){
            HashMap<Character,Character> hm1 = new HashMap<>();
            HashMap<Character,Character> hm2 = new HashMap<>();
            boolean flag = true;
            for(int i = 0;i<word.length();i++){
                char ch1 = word.charAt(i);
                char ch2 = pattern.charAt(i);
                
                if(hm1.containsKey(ch1) && hm2.containsKey(ch2)){
                    if(hm1.get(ch1) != ch2 && hm2.get(ch2) != ch1){
                        flag = false;
                    }
                }
                else if(hm1.containsKey(ch1)){
                    flag = false;
                }
                else if(hm2.containsKey(ch2)){
                    flag = false;
                }
                else{
                    hm1.put(ch1,ch2);
                    hm2.put(ch2,ch1);
                }
            }
            if(flag == true){
                ans.add(word);
            }
        }
        return ans;
    }
}