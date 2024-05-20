class Solution {
    public String reverseWords(String s) {
        int i = s.length()-1;
        String ans = "";
        while(i>=0){
            if(s.charAt(i) != ' '){
                int j = i;
                StringBuilder temp = new StringBuilder();
                while(j>=0 && s.charAt(j) != ' '){
                    temp.append(s.charAt(j));
                    j--;
                }
                ans += (temp.reverse().toString()) + " ";
                i = j;
            }
            i--;
        }
        return ans.trim();
    }
}