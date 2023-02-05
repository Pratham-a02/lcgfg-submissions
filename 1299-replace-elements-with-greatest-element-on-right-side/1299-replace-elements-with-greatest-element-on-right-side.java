class Solution {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        for(int i = 0;i<ans.length;i++){
            int max = getMax(arr,i+1);
            ans[i] = max;
        }
        ans[ans.length-1] = -1;
        return ans;
    }
    
    public int getMax(int[] arr,int j){
        int max = Integer.MIN_VALUE;
        
        for(int i = j;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}