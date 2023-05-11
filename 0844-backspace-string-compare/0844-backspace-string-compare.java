class Solution{
    public boolean backspaceCompare(String s,String t){
        String s1 = "";
        String s2 = "";
        int count = 0;
        
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == '#'){
                count++;
            }
            else{
                if(count>0){
                    count--;
                }
                else{
                    s1 += s.charAt(i);
                }
            }
        }
        count = 0;
        
        for(int i = t.length()-1;i>=0;i--){
            if(t.charAt(i) == '#'){
                count++;
            }
            else{
                if(count>0){
                    count--;
                }
                else{
                    s2 += t.charAt(i);
                }
            }
        }
        
        return (s1.equals(s2));
    }
}