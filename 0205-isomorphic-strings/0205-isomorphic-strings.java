class Solution {
    //public boolean isIsomorphic(String s, String t) {
    //     if(s.length() != t.length()){
    //         return false;
    //     }
    //     int n = s.length();
    //     HashMap<Character,Character> hm = new HashMap<>();
    //     for(int i = 0;i<n;i++){
    //     char ch = s.charAt(i);
    //     char sch = t.charAt(i);
    //     if(hm.containsKey(ch) && sch != hm.get(ch)){
    //        return false;
    //        // break;
    //     }
    //     else{
    //         hm.put(ch,sch);
    //     }
    //     }
    //     return true;
    // }
    public boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()){
            return false;
         }
        HashMap<Character,Character> hm1 = new HashMap<>();
        HashMap<Character,Character> hm2 = new HashMap<>();
        int n = s.length();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            char sch = t.charAt(i);
            if(hm1.containsKey(ch)){
                if(hm1.get(ch) != sch){
                    return false;
                }
            }
            if(hm2.containsKey(sch)){
                if(hm2.get(sch) != ch){
                    return false;
                }
            }
            else{
                hm1.put(ch,sch);
                hm2.put(sch,ch);
            }   
         }
        return true;
     }
  }
