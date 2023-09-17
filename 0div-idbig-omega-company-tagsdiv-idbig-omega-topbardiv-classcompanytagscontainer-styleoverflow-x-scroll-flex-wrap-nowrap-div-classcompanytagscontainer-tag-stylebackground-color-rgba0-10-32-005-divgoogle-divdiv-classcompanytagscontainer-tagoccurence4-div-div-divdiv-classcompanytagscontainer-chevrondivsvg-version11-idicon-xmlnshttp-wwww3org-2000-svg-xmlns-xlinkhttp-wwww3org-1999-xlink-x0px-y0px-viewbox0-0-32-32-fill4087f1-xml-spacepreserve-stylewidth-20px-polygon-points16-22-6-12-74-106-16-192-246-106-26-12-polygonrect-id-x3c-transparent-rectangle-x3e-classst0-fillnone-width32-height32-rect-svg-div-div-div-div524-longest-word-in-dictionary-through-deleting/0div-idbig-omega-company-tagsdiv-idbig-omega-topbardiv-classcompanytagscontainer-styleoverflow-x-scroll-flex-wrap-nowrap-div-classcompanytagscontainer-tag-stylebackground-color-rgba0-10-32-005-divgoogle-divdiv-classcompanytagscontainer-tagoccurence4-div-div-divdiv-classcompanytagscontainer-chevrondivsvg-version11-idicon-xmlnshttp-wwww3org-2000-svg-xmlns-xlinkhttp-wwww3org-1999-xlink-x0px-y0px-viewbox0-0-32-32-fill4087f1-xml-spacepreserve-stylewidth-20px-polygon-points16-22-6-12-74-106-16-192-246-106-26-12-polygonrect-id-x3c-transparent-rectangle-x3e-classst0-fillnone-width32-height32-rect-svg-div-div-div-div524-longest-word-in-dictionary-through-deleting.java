class Solution{
    public String findLongestWord(String s, List<String> dictionary){
        String ans = "";
        
        for(String str : dictionary){
            int i = 0;
            int j = 0;
            while(i<s.length() && j<str.length()){
                if(s.charAt(i) == str.charAt(j)){
                    i++;
                    j++;
                }
                else{
                    i++;
                }
            }
            if(j == str.length()){
                if(str.length() > ans.length()){
                    ans = str;
                }
                else if(str.length() == ans.length()){
                    if(str.compareTo(ans)<0){
                        ans = str;
                    }
                }
            }
        }
        return ans;
    }
}