class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        solve(0,0,"",s,ans);
        return ans;
    }
    
    public void solve(int idx,int parts,String curr,String s,List<String> ans){
        if(idx == s.length() && parts == 4){
            ans.add(curr.substring(0,curr.length()-1));
        }
        
        if(idx + 1 <= s.length()){
            solve(idx+1,parts+1,curr + s.substring(idx,idx+1) +  ".",s,ans);
        }
        if(idx + 2 <= s.length() && isValid(s.substring(idx,idx+2))){
            solve(idx+2,parts+1,curr + s.substring(idx,idx+2) +  ".",s,ans);
        }
        if(idx + 3 <= s.length() && isValid(s.substring(idx,idx+3))){
            solve(idx+3,parts+1,curr + s.substring(idx,idx+3) +  ".",s,ans);
        }
    }
    
    public boolean isValid(String s){
        if(s.charAt(0) == '0' || Integer.parseInt(s) > 255){
            return false;
        }
        return true;
    }
}