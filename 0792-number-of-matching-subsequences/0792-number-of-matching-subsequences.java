class Solution{
    public int numMatchingSubseq(String s,String[] words){
        HashMap<Character,ArrayDeque<String>> hm = new HashMap<>();
        int count = 0;
        
        for(char c:s.toCharArray()){
            if(!hm.containsKey(c)){
                hm.put(c,new ArrayDeque<>());
            }
        }
        
        for(String word:words){
            char c = word.charAt(0);
            if(hm.containsKey(c)){
                hm.get(c).add(word);
            }
        }
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            ArrayDeque<String> qu = hm.get(ch);
            int size = qu.size();
            
            for(int k = 0;k<size;k++){
                String curr = qu.remove();
                if(curr.substring(1).length() == 0){
                    count++;
                }
                else{
                    char c = curr.charAt(1);
                    if(hm.containsKey(c)){
                        hm.get(c).add(curr.substring(1));
                    }
                }
            }
        }
        return count;
    }
}