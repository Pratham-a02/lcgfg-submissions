class Solution{
    public List<Integer> goodDaysToRobBank(int[] security,int time){
        List<Integer> ans = new ArrayList<>();
        int n = security.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        for(int i = 1;i<n;i++){
            if(security[i]>security[i-1]){
                arr1[i] = 0;
            }
            else{
                arr1[i] = arr1[i-1]+1;
            }
        }
        
        for(int i = n-2;i>=0;i--){
            if(security[i]>security[i+1]){
                arr2[i] = 0;
            }
            else{
                arr2[i] = arr2[i+1]+1;
            }
        }
        
        for(int i = time;i<n-time;i++){
            if(arr1[i]>= time && arr2[i]>=time){
                ans.add(i);
            }
        }
        return ans;
    }
}