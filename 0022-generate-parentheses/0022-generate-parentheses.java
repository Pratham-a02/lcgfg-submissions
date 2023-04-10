class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n,n,"",ans);
        return ans;
    }
    
    public void solve(int open,int close,String str,List<String> ans){
        if(open == 0 && close == 0){
            ans.add(str);
            return;
        }
        
        if(open != 0){
            String op1 = str;
            op1 += "(";
            solve(open-1,close,op1,ans);
        }
        if(close > open){
            String op1 = str;
            op1 += ")";
            solve(open,close-1,op1,ans);
        }
        
        return;
    }
}