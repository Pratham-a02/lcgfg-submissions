class Solution {
    List<String> ans;
    int n;
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        if(s.length()<4 || s.length()>12){
            return new ArrayList<>();
        }
        ans = new ArrayList<>();
        solve(0,0,"",s);
        return ans;
    }
    
    public void solve(int idx,int parts,String curr,String s){
        if(idx == n && parts == 4){
            curr = curr.substring(0,curr.length()-1);
            ans.add(curr);
        }
        
        if(idx+1<=s.length()){
            solve(idx+1,parts+1,curr + s.substring(idx,idx+1) + ".",s);
        }
        if(idx+2<=s.length() && isValid(s.substring(idx,idx+2))){
            solve(idx+2,parts+1,curr + s.substring(idx,idx+2) + ".",s);
        }
        if(idx+3<=s.length() && isValid(s.substring(idx,idx+3))){
            solve(idx+3,parts+1,curr + s.substring(idx,idx+3) + ".",s);
        }
    }
    
    public boolean isValid(String s){
        if(s.charAt(0) == '0' || Integer.valueOf(s)>255){
            return false;
        }
        return true;
    }
}