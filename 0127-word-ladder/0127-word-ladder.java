class Solution{
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord)){
            return 0;
        }
        
        ArrayDeque<String> qu = new ArrayDeque<>();
        HashMap<String,Boolean> hm = new HashMap<>();
        for(int i = 0;i<wordList.size();i++){
            hm.put(wordList.get(i),false);
        }
        
        qu.add(beginWord);
        hm.put(beginWord,true);
        int length = 1;
        
        while(qu.size()>0){
            int csize = qu.size();
            
            for(int i = 0;i<csize;i++){
                String currWord = qu.remove();
                
                if(currWord.equals(endWord)){
                    return length;
                }
                
                addWord(currWord,hm,qu);
            }
            length++;
        }
        return 0;
    }
    
    public void addWord(String currWord,HashMap<String,Boolean>hm,ArrayDeque<String> qu){
        for(int i = 0;i<currWord.length();i++){
            char[] arr = currWord.toCharArray();
            
            for(int j = 0;j<26;j++){
                char c = (char)('a' + j);
                
                arr[i] = c;
                
                String s = String.valueOf(arr);
                
                if(hm.containsKey(s) && hm.get(s) == false){
                    qu.add(s);
                    hm.put(s,true);
                }
            }
        }
    }
}