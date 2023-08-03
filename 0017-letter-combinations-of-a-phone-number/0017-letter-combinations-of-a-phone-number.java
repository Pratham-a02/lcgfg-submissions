class Solution{
    String[] letters = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        solve(0,"",digits,ans);
        return ans;
    }
    
    public void solve(int idx,String asf,String digits,List<String> ans){
        if(idx == digits.length()){
            ans.add(asf);
            return;
        }
        
        int val = digits.charAt(idx) - '0';
        int j = val-1;
        String str = letters[j];
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            solve(idx+1,asf+ch,digits,ans);
        }
    }
}