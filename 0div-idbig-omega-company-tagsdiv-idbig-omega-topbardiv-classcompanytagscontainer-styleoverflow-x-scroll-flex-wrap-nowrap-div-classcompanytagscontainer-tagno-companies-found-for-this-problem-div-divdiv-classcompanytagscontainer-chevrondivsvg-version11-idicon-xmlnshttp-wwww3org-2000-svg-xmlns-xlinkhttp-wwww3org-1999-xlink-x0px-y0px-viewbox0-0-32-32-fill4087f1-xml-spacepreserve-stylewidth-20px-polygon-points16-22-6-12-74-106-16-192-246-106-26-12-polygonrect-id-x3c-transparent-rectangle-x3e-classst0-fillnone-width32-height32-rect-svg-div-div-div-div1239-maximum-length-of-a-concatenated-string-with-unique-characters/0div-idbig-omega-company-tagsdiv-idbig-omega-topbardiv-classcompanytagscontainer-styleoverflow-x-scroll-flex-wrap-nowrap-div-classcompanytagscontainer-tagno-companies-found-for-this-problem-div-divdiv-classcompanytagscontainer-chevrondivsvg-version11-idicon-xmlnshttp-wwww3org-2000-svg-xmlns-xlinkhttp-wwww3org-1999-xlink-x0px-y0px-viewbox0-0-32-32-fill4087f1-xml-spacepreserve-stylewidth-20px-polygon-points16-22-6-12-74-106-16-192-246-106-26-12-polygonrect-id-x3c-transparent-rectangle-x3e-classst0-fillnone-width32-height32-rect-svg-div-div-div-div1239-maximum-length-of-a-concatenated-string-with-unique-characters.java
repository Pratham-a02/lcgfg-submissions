class Solution {
    public int maxLength(List<String> arr) {
        return solve(0,arr,"");
    }
    
    public int solve(int idx,List<String> arr,String temp){
        if(idx>=arr.size()){
            return temp.length();
        }
        
        int inc = 0;
        int exc = 0;
        
        if(hasDuplicate(arr.get(idx),temp)){
            exc = solve(idx+1,arr,temp);
        }
        else{
            exc = solve(idx+1,arr,temp);
            inc = solve(idx+1,arr,temp+arr.get(idx));
        }
        
        return Math.max(inc,exc);
    }
    
    public boolean hasDuplicate(String curr,String temp){
        int[] farr = new int[26];
        
        for(char c:curr.toCharArray()){
            if(farr[c-'a']>0){
                return true;
            }
            farr[c-'a']++;
        }
        
        for(char c:temp.toCharArray()){
            if(farr[c-'a']>0){
                return true;
            }
        }
        return false;
    }
}