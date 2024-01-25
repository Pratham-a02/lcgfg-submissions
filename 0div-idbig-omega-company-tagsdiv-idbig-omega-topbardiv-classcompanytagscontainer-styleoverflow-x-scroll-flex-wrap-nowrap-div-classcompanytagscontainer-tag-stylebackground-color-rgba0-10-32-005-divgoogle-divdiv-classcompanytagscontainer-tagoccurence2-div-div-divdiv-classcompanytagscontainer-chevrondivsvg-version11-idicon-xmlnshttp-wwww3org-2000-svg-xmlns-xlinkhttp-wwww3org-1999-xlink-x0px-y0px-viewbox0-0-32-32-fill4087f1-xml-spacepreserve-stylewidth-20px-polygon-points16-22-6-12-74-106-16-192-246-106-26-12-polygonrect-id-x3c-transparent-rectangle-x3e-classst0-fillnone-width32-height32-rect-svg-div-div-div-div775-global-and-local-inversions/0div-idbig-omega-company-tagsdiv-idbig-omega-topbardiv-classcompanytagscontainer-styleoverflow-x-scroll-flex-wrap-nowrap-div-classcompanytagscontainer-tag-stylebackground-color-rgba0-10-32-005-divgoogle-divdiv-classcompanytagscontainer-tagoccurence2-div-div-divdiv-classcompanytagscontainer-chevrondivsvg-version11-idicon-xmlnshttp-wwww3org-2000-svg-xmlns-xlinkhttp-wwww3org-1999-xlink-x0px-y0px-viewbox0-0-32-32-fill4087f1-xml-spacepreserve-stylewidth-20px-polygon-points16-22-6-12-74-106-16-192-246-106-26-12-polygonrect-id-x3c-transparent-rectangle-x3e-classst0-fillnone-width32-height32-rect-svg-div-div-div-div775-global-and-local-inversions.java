class Solution{
    int gi;
    public boolean isIdealPermutation(int[] nums){
        return localInversion(nums) == globalInversion(nums);
    }
    
    public int localInversion(int[] nums){
        int count = 0;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                count++;
            }
        }
        return count;
    }
    
    public int globalInversion(int[] nums){
        gi = 0;
        solve(0,nums.length-1,nums);
        return gi;
    }
    
    public int[] solve(int lo,int hi,int[] nums){
        if(lo == hi){
            int[] ba = new int[1];
            ba[0] = nums[lo];
            return ba;
        }
        
        int mid = (lo+hi)/2;
        
        int[] la = solve(lo,mid,nums);
        int[] ra = solve(mid+1,hi,nums);
        
        int[] fa = mergeSort(la,ra);
        return fa;
    }
    
    public int[] mergeSort(int[] a1,int[] a2){
        int[] arr = new int[a1.length+a2.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<a1.length && j<a2.length){
            if(a1[i]<a2[j]){
                arr[k] = a1[i];
                i++;
                k++;
            }
            else if(a1[i]>a2[j]){
                gi+=(a1.length-i);
                arr[k] = a2[j];
                k++;
                j++;
            }
        }
        
        while(i<a1.length){
            arr[k] = a1[i];
            i++;
            k++;
        }
        while(j<a2.length){
            arr[k] = a2[j];
            j++;
            k++;
        }
        
        return arr;
    }
}