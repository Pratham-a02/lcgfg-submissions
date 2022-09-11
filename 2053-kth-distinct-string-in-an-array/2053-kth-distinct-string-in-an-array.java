class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String,Integer> hm = new LinkedHashMap<>();
        String ans = "";
        for(int i = 0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int counter = 1;
        for(Map.Entry<String,Integer> entry:hm.entrySet()){
            if(entry.getValue() == 1 && counter == k){
                ans = entry.getKey();
                break;
            }
            else if(entry.getValue() == 1){
                counter++;
            }
        }
        return ans;
    }
}