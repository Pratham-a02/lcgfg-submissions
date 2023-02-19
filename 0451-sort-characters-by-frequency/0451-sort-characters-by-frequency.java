class Solution {
    public String frequencySort(String s) {
        List<Character>[] arr = new List[s.length()+1];
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(Map.Entry<Character,Integer> entry:hm.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            if(arr[freq] == null){
                arr[freq] = new ArrayList<>();
            }
            arr[freq].add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i]!= null){
                for(char ch : arr[i]){
                    for(int j = 0;j<i;j++){
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}