class Solution{
    public int maxDistance(List<List<Integer>> arrays){
        int ans = 0;
        int n = arrays.size();
        
        int prevMax = Integer.MIN_VALUE;
        int forwMax = Integer.MIN_VALUE;
        int prevIdx = 0;
        int forwIdx = 0;
        for(int i = 0;i<n;i++){
            List<Integer> al = arrays.get(i);
            int curr = Integer.MIN_VALUE;
            for(int j = 0;j<al.size();j++){
                if(al.get(j) > curr){
                    curr = al.get(j);
                }
            }
            if(curr>prevMax){
                prevMax = curr;
                prevIdx = i;
            }
        }
        
        for(int i = n-1;i>=0;i--){
            List<Integer> al = arrays.get(i);
            int curr = Integer.MIN_VALUE;
            
            if(i != prevIdx){
                for(int j = 0;j<al.size();j++){
                    if(al.get(j) > curr){
                        curr = al.get(j);
                    }
                }
                if(curr>forwMax){
                    forwMax = curr;
                    forwIdx = i;
                }   
            }
        }
        
        for(int i = 0;i<arrays.size();i++){
            List<Integer> al = arrays.get(i);
            
            if(i != prevIdx){
                for(int j = 0;j<al.size();j++){
                    ans = Math.max(ans,Math.abs(prevMax - al.get(j)));
                }
            }
        }
        
        for(int i = 0;i<arrays.size();i++){
            List<Integer> al = arrays.get(i);
            
            if(i != forwIdx){
                for(int j = 0;j<al.size();j++){
                    ans = Math.max(ans,Math.abs(forwMax - al.get(j)));
                }
            }
        }
        
        return ans;
    }
}