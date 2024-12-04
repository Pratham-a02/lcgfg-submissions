class Solution{
    public String addSpaces(String s,int[] spaces){
        StringBuilder sb =  new StringBuilder();
        int idx = 0;
        int i = 0;
        for(i = 0;i<s.length();i++){
            if(idx == spaces.length){
                break;
            }
            if(i == spaces[idx]){
                sb.append(" ");
                idx++;
            }
            sb.append(s.charAt(i));
        }
        while(i<s.length()){
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}