class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> hm = new HashMap<>();
        return wordbreak(s,wordDict,hm);
    }
    
    public boolean wordbreak(String s,List<String> dict,HashMap<String,Boolean> hm){
        if(s.length() == 0){
            return true;
        }
        
        if(hm.containsKey(s)){
            return hm.get(s);
        }
        
        for(int i = 0;i<s.length();i++){
            String str = s.substring(0,i+1);
            if(dict.contains(str)){
                String next = s.substring(i+1);
                boolean res = wordbreak(next,dict,hm);
                hm.put(next,res);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }
}