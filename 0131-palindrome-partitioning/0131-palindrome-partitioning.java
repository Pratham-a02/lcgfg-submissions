class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        palinPart(s,curr);
        return ans;
    }
    
    public void palinPart(String s,List<String> curr){
        if(s.length() == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0;i<s.length();i++){
            String substr = s.substring(0,i+1);
            if(Possible(substr)){
                curr.add(substr);
                palinPart(s.substring(i+1),curr);
                curr.remove(curr.size()-1);
            }
        }
        return;
    }
    
    public boolean Possible(String s){
        int i = 0;
        int j = s.length()-1;
        
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}