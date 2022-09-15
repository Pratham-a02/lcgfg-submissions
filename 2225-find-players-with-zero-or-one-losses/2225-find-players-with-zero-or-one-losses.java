class Solution {
    public List<List<Integer>> findWinners(int[][] matches){
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<matches.length;i++){
            hm1.put(matches[i][0],hm1.getOrDefault(matches[i][0],0)+1);
        }
        for(int i = 0;i<matches.length;i++){
            hm2.put(matches[i][1],hm2.getOrDefault(matches[i][1],0)+1);
        }
        
        List<Integer> al2 = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : hm2.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(val == 1){
                al2.add(key);
            }
        }
        Collections.sort(al2);
        // ans.add(al1);
        
        List<Integer> al1 = new ArrayList<>();
        for(int val : hm1.keySet()){
            if(!hm2.containsKey(val)){
                al1.add(val);
            }
        }
        Collections.sort(al1);
        
        ans.add(al1);
        ans.add(al2);
        return ans;
    }
}