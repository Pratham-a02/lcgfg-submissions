class Solution{
    public static void nextPermutation(int[] arr){
        int N = arr.length;
        int i = N-2;
        while(i>= 0 && arr[i]>=arr[i+1]){
            i--;
        }
        
        if(i>=0){
            int j = N-1;
            while(j>= 0 && arr[j]<=arr[i]){
                j--;
            }
            
            swap(i,j,arr);
        }
        reverse(i+1,N-1,arr);
        // List<Integer> ans = new ArrayList<>();
        // for(int val:arr){
        //     ans.add(val);
        // }
        // return ans;
    }
    
    public static void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void reverse(int i,int j,int[] arr){
        while(i<j){
            swap(i,j,arr);
            i++;
            j--;
        }
    }
}