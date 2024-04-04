class Solution{
    public List<Integer> pancakeSort(int[] arr){
        int end = arr.length;
        List<Integer> ans = new ArrayList<>();
        
        while(end != 1){
            int idx = find(arr,end);
            flip(arr,idx);
            flip(arr,end-1);
            ans.add(idx+1);
            ans.add(end);
            end--;
        }
        return ans;
    }
    
    public void flip(int[] arr,int end){
        int start = 0;
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public int find(int[] arr,int key){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}