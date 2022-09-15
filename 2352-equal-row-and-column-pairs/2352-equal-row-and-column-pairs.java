class Solution {
    //public int equalPairs(int[][] grid) {
//         HashMap<Integer[],Integer> hm = new HashMap<>();
//         int count = 0;
        
//         int m = grid.length;
//         int n = grid[0].length;
        
//         for(int i = 0;i<m;i++){
//             Integer[]arr = new Integer[n];
//             for(int j = 0;j<n;j++){
//                 arr[j] = grid[i][j];
//             }
//             hm.put(arr,hm.getOrDefault(arr,0)+1);
//         }
        
//         for(int i = 0;i<m;i++){
//             Integer[] arr = new Integer[n];
//             for(int j = 0;j<n;j++){
//                 arr[j] = grid[j][i];
//             }
//             if(hm.containsKey(arr)){
//                 count += hm.get(arr);
//             }
//         }
        
//         return count;
    
    public int equalPairs(int[][] grid){
        HashMap<String,Integer> hm = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i = 0;i<m;i++){
            String s = "";
            for(int j = 0;j<n;j++){
                s += grid[i][j] + "_";
            }
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        
        for(int i = 0;i<m;i++){
            String s = "";
            for(int j = 0;j<n;j++){
                s += grid[j][i] + "_";
            }
            if(hm.containsKey(s)){
                count += hm.get(s);
            }
        }
        return count;
    }
}