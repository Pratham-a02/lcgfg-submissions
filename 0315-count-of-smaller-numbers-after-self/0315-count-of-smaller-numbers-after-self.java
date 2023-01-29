class Solution {
    int[] res;
    class Pair{
        int idx;
        int val;
        
        Pair(int idx,int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Pair[] pairs = new Pair[nums.length];
        for(int i = 0;i<nums.length;i++){
            pairs[i] = new Pair(i,nums[i]);
        }
        
        res = new int[nums.length];
        mergeSort(pairs,0,pairs.length-1);
        
        List<Integer> ans = new ArrayList<>();
        for(int val:res){
            ans.add(val);
        }
        return ans;
    }
    
    public Pair[] mergeSort(Pair[] pairs,int lo,int hi){
        if(lo == hi){
            Pair[] barr = new Pair[1];
            barr[0] = new Pair(lo,pairs[lo].val);
            return barr;
        }
        
        int mid = (lo+hi)/2;
        
        Pair[] ls = mergeSort(pairs,lo,mid);
        Pair[] rs = mergeSort(pairs,mid+1,hi);
        
        Pair[] farr = mergeArray(ls,rs);
        return farr;
    }
    
    public Pair[] mergeArray(Pair[] arr1, Pair[] arr2){
        Pair[] ret = new Pair[arr1.length + arr2.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<arr1.length && j<arr2.length){
            if(arr1[i].val > arr2[j].val){
                ret[k] = arr1[i];
                res[arr1[i].idx] += (arr2.length-j);
                i++;
                k++;
            }
            else{
                ret[k] = arr2[j];
                j++;
                k++;
            }
        }
        
        while(i<arr1.length){
            ret[k] = arr1[i];
            i++;
            k++;
        }
        while(j<arr2.length){
            ret[k] = arr2[j];
            j++;
            k++;
        }
        return ret;
    }
}