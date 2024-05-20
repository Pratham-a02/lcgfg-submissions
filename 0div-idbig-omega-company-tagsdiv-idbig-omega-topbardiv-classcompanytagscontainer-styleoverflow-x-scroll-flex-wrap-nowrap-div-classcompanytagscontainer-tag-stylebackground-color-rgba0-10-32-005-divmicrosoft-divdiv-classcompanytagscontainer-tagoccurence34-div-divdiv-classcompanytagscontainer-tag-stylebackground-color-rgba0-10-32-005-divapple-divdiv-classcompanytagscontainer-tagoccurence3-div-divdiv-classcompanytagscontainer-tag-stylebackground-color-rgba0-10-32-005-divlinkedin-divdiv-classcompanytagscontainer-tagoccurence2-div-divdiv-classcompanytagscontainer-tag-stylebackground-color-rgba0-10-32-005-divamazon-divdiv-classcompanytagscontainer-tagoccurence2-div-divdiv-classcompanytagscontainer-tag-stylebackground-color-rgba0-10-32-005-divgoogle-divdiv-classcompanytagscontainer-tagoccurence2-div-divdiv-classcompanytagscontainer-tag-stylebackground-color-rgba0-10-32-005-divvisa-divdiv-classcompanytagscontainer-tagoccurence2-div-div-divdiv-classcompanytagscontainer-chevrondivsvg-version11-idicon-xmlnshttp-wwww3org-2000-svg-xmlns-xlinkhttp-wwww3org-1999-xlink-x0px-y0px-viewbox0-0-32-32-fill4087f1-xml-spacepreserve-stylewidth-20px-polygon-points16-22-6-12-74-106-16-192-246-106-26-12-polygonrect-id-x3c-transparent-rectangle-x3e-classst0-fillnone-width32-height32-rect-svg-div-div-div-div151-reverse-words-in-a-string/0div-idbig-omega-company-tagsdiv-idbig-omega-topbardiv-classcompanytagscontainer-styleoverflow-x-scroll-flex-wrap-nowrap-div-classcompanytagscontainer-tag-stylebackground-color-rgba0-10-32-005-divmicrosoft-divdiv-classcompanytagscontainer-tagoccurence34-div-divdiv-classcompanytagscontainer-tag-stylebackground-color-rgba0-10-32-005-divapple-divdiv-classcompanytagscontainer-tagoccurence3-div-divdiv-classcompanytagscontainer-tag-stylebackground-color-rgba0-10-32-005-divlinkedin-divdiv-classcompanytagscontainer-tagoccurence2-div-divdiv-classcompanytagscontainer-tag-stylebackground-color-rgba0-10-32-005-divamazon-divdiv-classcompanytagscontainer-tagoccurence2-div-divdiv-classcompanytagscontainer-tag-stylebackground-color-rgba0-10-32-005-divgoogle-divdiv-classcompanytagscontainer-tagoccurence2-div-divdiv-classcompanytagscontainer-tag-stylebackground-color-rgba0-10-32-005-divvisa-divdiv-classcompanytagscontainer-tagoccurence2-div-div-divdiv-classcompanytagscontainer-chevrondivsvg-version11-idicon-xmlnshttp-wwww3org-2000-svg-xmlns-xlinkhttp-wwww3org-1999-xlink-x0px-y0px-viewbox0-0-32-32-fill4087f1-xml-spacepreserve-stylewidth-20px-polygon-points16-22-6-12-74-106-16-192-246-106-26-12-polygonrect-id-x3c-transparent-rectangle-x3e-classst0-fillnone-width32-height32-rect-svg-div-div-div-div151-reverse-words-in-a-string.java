class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        s = s.trim();
        String[] arr = s.split(" ");
        
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i].length()>0){
                ans.append(arr[i]);
                ans.append(" ");
            }
        }
        return ans.toString().trim();
    }
}