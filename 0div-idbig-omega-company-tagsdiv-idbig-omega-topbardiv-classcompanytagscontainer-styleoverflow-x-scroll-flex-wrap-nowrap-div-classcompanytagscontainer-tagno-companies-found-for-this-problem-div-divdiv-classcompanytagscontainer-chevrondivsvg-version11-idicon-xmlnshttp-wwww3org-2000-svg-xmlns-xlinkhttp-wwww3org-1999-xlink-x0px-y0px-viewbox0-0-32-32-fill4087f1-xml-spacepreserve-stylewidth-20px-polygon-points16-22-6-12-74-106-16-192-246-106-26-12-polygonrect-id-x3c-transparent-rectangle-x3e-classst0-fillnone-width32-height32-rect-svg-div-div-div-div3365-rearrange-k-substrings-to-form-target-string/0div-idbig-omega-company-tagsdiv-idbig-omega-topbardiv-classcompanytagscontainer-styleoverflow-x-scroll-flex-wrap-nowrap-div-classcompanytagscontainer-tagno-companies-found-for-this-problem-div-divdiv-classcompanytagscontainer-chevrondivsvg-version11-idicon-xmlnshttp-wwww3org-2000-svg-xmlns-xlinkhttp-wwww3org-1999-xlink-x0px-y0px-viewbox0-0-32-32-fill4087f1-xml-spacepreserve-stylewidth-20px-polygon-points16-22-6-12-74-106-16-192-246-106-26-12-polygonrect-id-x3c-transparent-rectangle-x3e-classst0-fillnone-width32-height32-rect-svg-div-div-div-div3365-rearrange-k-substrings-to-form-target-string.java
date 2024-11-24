class Solution{
    public boolean isPossibleToRearrange(String s,String t,int k){
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<s.length();i += s.length()/k){
            hm.put(s.substring(i,i+s.length()/k),hm.getOrDefault(s.substring(i,i+s.length()/k),0)+1);
        }
        
        for(int i = 0;i<t.length();i+= s.length()/k){
             if (hm.getOrDefault(t.substring(i, i + s.length()/k), 0) == 0) {
                return false;
            }
            
            hm.put(t.substring(i,i+s.length()/k),hm.get(t.substring(i,i+s.length()/k))-1);
        }
        
        return true;
    }
}