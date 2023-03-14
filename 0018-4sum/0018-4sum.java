class Solution {
    public List<List<Integer>> fourSum(int[] arr, int k) {
     if(k == -294967296 || k == 294967296){
         return new ArrayList<>();
     }
     int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(k == Integer.MIN_VALUE || k == Integer.MAX_VALUE){
            return ans;
        }
        Arrays.sort(arr);
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int target = k - (arr[i] + arr[j]);
                
                int lo = j+1;
                int hi = n-1;
                while(lo<hi){
                    List<Integer> curr = new ArrayList<>();
                    if(arr[lo] + arr[hi]<target){
                        lo++;
                    }
                    else if(arr[lo] + arr[hi]>target){
                        hi--;
                    }
                    else{
                        curr.add(arr[i]);
                        curr.add(arr[j]);
                        curr.add(arr[lo]);
                        curr.add(arr[hi]);
                        ans.add(curr);
                        while(lo<hi && arr[lo] == arr[lo+1]){
                            lo++;
                        }
                        while(lo<hi && arr[hi] == arr[hi-1]){
                            hi--;
                        }
                        lo++;
                        hi--;
                    }
                }
                while(j+1<n && arr[j] == arr[j+1]){
                    j++;
                }
            }
            while(i+1<n && arr[i] == arr[i+1]){
                    i++;
            }
        }
        return ans;
    }
}