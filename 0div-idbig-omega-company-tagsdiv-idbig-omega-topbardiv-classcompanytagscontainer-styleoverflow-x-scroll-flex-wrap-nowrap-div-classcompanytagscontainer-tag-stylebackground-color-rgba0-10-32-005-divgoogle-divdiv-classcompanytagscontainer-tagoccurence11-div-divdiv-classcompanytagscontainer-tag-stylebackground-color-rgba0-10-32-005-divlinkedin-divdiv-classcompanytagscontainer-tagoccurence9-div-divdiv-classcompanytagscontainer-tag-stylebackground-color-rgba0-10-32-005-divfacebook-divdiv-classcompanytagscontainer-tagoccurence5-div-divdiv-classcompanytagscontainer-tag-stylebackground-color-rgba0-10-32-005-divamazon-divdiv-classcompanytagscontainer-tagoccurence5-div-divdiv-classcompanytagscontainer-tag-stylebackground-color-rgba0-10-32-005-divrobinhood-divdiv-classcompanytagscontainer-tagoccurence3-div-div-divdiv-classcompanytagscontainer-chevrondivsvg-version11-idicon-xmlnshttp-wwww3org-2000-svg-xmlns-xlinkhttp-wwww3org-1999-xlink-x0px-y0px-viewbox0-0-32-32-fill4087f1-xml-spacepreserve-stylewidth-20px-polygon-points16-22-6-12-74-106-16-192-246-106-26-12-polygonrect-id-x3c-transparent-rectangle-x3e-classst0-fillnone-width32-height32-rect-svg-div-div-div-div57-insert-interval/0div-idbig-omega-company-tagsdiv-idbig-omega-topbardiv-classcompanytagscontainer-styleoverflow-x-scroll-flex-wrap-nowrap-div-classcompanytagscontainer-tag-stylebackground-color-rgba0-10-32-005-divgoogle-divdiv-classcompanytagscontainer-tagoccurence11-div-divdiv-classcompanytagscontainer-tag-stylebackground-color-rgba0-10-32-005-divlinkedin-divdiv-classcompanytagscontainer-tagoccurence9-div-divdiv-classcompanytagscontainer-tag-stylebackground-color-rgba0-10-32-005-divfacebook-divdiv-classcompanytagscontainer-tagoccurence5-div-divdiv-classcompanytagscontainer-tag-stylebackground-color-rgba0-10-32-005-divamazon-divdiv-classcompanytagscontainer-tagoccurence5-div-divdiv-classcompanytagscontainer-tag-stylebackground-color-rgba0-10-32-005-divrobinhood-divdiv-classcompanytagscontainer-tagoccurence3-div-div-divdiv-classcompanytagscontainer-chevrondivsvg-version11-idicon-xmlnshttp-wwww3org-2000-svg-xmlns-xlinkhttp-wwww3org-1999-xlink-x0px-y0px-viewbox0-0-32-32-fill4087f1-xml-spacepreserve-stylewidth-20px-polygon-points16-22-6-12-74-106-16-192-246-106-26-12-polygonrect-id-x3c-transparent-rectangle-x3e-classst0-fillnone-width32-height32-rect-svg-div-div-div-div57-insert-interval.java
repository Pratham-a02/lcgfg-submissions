class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> al = new ArrayList<>();
        for(int[] interval:intervals){
            al.add(interval);
        }
        al.add(newInterval);
        List<int[]> ans = solve(al.toArray(new int[0][]));
        
        return ans.toArray(new int[0][]);
    }
    
    public List<int[]> solve(int[][] arr){
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(arr,(a,b)->{
           return a[0]-b[0]; 
        });
        
        int st = arr[0][0];
        int ed = arr[0][1];
        
        int i = 1;
        while(i<arr.length){
            if(arr[i][0]<=ed){
                ed = Math.max(ed,arr[i][1]);
            }
            else{
                int[] curr = new int[2];
                curr[0] = st;
                curr[1] = ed;
                ans.add(curr);
                st = arr[i][0];
                ed = arr[i][1];
            }
            i++;
        }
        ans.add(new int[]{st,ed});
        return ans;
    }
}