class Solution {
    public int[] sortArray(int[] nums) {
        return array(nums,0,nums.length-1);
    }
    
    public int[] array(int[] nums,int lo,int hi){
        if(lo == hi){
            int[] ba = new int[1];
            ba[0] = nums[lo];
            return ba;
        }
        
        int mid = (lo+hi)/2;
        int[] la = array(nums,lo,mid);
        int[] ra = array(nums,mid+1,hi);
        
        int[] farr = mergeTwoArrays(la,ra);
        return farr;
    }
    
    public int[] mergeTwoArrays(int[] arr1,int[] arr2){
        int i = 0;
        int j = 0;
        int[] ans = new int[arr1.length + arr2.length];
        int idx = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                ans[idx++] = arr1[i];
                ans[idx++] = arr2[j];
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j]){
                ans[idx++] = arr1[i];
                i++;
            }
            else if(arr2[j]<arr1[i]){
                ans[idx++] = arr2[j];
                j++;
            }
        }
        
        while(i<arr1.length){
            ans[idx++] = arr1[i];
            i++;
        }
        
        while(j<arr2.length){
            ans[idx++] = arr2[j];
            j++;
        }
        
        return ans;
    }
}