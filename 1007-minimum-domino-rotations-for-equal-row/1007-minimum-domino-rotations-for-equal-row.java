class Solution{
    public int minDominoRotations(int[] tops, int[] bottoms){
        if(tops.length != bottoms.length){
            return -1;
        }
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        for(int ele : tops){
            hm1.put(ele,hm1.getOrDefault(ele,0)+1);
        }
        
        for(int ele : bottoms){
            hm2.put(ele,hm2.getOrDefault(ele,0)+1);
        }
        int max = Collections.max(hm1.values());
        for(Map.Entry<Integer,Integer> entry:hm1.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(val == max){
                max1 = key;
                break;
            }
        }
        
        max = Collections.max(hm2.values());
        
        for(Map.Entry<Integer,Integer> entry:hm2.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(val == max){
                max2 = key;
                break;
            }
        }
        
        int count1 = 0;
        for(int i = 0;i<tops.length;i++){
            if(tops[i] != max1){
                if(bottoms[i] == max1){
                    count1++;
                }
            }
        }
        
        int count2 = 0;
        for(int i = 0;i<bottoms.length;i++){
            if(bottoms[i] != max2){
                if(tops[i] == max2){
                    count2++;
                }
            }
        }
        
        if((hm1.get(max1) + count1 != tops.length) && (hm2.get(max2) + count2 != bottoms.length)){
            return -1;
        }
        
        if((hm1.get(max1) + count1 != tops.length)){  
            return count2;
        }
        if(hm2.get(max2) + count2 != bottoms.length){
            return count1;
        }
        
        if(count1 == 0 && count2 != 0){
            return count2;
        }
        else if(count2 == 0 && count1 != 0){
            return count1;
        }
        
        if(count1<count2){
            return count1;
        }
        else{
            return count2;
        }
    }
}