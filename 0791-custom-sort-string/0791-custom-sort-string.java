class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<order.length();i++){
            char ch = order.charAt(i);
            
            if(!hm.containsKey(ch)){
                continue;
            }
            
            int freq = hm.get(ch);
            for(int j = 0;j<freq;j++){
                sb.append(ch);
            }
            hm.remove(ch);
        }
        
        for(char ch :hm.keySet()){
            int freq = hm.get(ch);
            
            for(int i = 0;i<freq;i++){
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}