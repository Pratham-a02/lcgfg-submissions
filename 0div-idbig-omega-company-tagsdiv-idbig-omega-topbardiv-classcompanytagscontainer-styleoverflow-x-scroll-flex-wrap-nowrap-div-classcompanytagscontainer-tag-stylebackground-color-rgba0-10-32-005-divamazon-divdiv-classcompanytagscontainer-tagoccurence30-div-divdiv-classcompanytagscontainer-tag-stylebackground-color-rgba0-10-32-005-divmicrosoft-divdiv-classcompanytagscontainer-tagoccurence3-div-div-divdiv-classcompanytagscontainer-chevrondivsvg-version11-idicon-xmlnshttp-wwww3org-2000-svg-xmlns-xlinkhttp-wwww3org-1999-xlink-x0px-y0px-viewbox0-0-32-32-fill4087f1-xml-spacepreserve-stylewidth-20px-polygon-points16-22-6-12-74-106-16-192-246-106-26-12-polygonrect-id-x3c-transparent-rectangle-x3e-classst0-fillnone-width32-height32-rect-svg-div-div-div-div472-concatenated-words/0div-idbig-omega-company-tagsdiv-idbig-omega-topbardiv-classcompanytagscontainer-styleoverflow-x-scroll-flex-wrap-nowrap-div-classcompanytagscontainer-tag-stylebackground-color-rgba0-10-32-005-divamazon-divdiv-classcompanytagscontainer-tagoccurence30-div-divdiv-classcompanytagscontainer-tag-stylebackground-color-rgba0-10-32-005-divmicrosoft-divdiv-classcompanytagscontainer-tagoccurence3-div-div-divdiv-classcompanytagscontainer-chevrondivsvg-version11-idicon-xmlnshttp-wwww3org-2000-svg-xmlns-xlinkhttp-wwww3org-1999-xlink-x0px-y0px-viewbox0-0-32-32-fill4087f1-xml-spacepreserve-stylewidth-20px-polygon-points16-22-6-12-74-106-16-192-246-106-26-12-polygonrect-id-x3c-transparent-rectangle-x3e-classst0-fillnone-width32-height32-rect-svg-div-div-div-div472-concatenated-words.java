class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for(String word:words){
            hs.add(word);
        }
        for(int i = 0;i<words.length;i++){
            String word = words[i];
            
            if(isConcatenated(word,hs,new HashMap<>())){
                ans.add(word);
            }
        }
        return ans;
    }
    
    public boolean isConcatenated(String s,HashSet<String> hs,HashMap<String,Boolean> hm){
        for(int i = 0;i<s.length();i++){
            
            if(hm.containsKey(s)){
                return hm.get(s);
            }
            
            String prefix = s.substring(0,i+1);
            String suffix = s.substring(i+1);
            
            if(hs.contains(prefix) && isConcatenated(suffix,hs,hm) || (hs.contains(prefix) && hs.contains(suffix))){
                hm.put(s,true);
                return true;
            }
        }
        
        hm.put(s,false);
        return false;
    }
}