class Solution {
    // List<Integer> color = new ArrayList<>(Arrays.asList(1,2,3,4));
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            al.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[n];
        for(int[] path:paths){
            int u = path[0];
            int v = path[1];
            
            al.get(u).add(v);
            al.get(v).add(u);
        }
        int[] ans = new int[n];
        for(int i = 1;i<=n;i++){
            List<Integer> color = Arrays.asList(new Integer[5]);
            Collections.fill(color,0);
            for(int x:al.get(i)){
                color.set(ans[x-1],1);
            }
            for(int j = 1;j<=4;j++){
                if(color.get(j) == 0){
                    ans[i-1] = j;
                }
            }
        }
        return ans;
    }
}