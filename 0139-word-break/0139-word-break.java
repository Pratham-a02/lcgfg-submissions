class Solution{
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s,wordDict,new HashMap<>());
    }
    
    public boolean solve(String s,List<String> wordDict,HashMap<String,Boolean> hm){
        if(s.length() == 0){
            return true;
        }
        
        if(hm.containsKey(s)){
            return hm.get(s);
        }
        
        for(int i = 0;i<s.length();i++){
            String substr = s.substring(0,i+1);
            if(wordDict.contains(substr)){
                String next = s.substring(i+1);
                boolean res = solve(next,wordDict,hm);
                hm.put(next,res);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }
}