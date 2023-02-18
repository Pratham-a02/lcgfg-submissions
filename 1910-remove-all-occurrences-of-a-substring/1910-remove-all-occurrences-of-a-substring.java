class Solution {
    public String removeOccurrences(String s, String part) {
        int len = part.length();
        while(true){
            int idx = s.indexOf(part);
            if(idx>-1){
                s = s.substring(0,idx) + s.substring(idx+len);
            }
            else{
                break;
            }
        }
        return s;
    }
}