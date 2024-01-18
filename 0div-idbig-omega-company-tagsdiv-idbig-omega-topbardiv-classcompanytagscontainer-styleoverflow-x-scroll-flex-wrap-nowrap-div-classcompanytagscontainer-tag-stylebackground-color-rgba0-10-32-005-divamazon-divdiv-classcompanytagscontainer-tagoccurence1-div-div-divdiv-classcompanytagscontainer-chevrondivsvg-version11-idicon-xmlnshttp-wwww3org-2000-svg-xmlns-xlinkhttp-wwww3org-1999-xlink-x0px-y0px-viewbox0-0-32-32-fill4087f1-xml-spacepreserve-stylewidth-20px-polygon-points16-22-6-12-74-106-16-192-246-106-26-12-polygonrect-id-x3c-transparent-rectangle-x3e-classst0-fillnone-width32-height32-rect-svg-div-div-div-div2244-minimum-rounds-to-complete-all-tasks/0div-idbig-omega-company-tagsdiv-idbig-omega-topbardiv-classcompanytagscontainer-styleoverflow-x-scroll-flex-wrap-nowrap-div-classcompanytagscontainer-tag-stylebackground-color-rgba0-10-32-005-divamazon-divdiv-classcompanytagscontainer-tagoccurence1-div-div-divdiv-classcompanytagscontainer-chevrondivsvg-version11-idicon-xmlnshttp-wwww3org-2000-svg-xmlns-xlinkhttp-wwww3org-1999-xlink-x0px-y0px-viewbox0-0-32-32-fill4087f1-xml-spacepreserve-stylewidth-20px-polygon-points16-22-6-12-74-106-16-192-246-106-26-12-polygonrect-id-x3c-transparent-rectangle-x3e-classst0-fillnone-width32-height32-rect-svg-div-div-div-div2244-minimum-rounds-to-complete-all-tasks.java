class Solution{
    public int minimumRounds(int[] tasks){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int task:tasks){
            hm.put(task,hm.getOrDefault(task,0)+1);
        }
        
        int count = 0;
        for(int val:hm.values()){
            while(val>4 || val == 3){
                val -= 3;
                count++;
            }
            while(val >= 2){
                val -= 2;
                count++;
            }
            if(val == 1){
                return -1;
            }
        }
        return count;
    }
}