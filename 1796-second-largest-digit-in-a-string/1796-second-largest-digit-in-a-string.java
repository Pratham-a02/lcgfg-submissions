class Solution {
    public int secondHighest(String s) {
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                hm.put(ch-'0',hm.getOrDefault(ch-'0',0)+1);
            }
        }
        int[] arr = new int[hm.size()];
        int idx = 0;
        for(int key:hm.keySet()){
            arr[idx++] = key;
        }
        
        if(arr.length<2){
            return -1;
        }
        else{
            return arr[arr.length-2];
        }
    }
}