class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        HashMap<int[],Integer> hm = new HashMap<>();
        
        for(int[]cost:costs){
            int a = cost[0];
            int b = cost[1];
            
            int diff = a-b;
            hm.put(cost,diff);
        }
        
        LinkedHashMap<int[],Integer> sortedMap = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (Map.Entry<int[],Integer> entry : hm.entrySet()) {
            list.add(entry.getValue());
        }
        
        // Collections.sort(list, new Comparator<Integer>(){
        //     public int compare(int str, int str1) {
        //         return str-str1;
        //     }
        // });
        
        Collections.sort(list, (d1, d2) ->{
            return d1-d2;
        });
        
        for (int str : list) {
            for (Map.Entry<int[], Integer> entry : hm.entrySet()) {
                if (entry.getValue().equals(str)) {
                    sortedMap.put(entry.getKey(), str);
                }
            }
        }
        
        int ans = 0;
        int count = 0;
        for(int[] arr:sortedMap.keySet()){
            if(count<n/2){
                ans+=arr[0];
            }
            else{
                ans += arr[1];
            }
            count++;
        }
        
        return ans;
    }
}