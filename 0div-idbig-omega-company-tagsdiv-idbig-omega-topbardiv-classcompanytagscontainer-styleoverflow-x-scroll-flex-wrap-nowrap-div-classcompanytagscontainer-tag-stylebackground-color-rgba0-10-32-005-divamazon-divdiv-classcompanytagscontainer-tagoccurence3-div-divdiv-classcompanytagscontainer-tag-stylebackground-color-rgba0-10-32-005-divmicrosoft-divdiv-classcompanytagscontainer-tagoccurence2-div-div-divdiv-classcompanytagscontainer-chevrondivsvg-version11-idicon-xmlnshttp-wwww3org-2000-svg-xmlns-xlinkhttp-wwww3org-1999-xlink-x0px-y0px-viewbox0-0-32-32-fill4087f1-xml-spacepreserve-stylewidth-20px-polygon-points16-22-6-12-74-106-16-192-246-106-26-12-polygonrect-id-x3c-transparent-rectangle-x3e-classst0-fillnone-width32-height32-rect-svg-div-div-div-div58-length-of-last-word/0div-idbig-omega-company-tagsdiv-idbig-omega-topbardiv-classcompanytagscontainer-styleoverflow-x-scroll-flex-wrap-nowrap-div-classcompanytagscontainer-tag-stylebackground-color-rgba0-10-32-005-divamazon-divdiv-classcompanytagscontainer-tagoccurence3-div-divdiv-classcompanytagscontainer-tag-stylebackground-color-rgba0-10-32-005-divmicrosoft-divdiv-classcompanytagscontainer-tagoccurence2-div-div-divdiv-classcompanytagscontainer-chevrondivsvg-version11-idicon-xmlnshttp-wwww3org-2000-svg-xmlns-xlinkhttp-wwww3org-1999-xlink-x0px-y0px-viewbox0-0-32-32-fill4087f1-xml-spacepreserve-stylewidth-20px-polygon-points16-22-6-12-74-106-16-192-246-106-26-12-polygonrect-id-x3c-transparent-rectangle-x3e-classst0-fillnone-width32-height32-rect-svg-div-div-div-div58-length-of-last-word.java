class Solution{
    public int lengthOfLastWord(String s){
        int idx = s.length()-1;
        while(s.charAt(idx) == ' '){
            idx--;
        }
        int j = -1;
        if(idx>=0){
            j = idx;
        }
        int count = 0;
        while(j>=0 && s.charAt(j) != ' '){
            count++;
            j--;
        }
        return count;
    }
}