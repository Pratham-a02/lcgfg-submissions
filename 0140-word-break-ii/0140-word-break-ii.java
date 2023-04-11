class Solution {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        wordbreak(s,"",wordDict);
        Collections.reverse(ans);
        return ans;
    }
    
    public void wordbreak(String s,String asf,List<String> dict){
        if(s.length() == 0){
            ans.add(asf.trim());
            return;
        }
        
        for(int i =0;i<s.length();i++){
            String str = s.substring(0,i+1);
            if(dict.contains(str)){
                wordbreak(s.substring(i+1),asf+str+" ",dict);
            }
        }
        return;
    }
}