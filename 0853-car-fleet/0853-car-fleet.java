class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> hm = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0;i<position.length;i++){
            hm.put(position[i],speed[i]);
        }
        
        int groups = 0;
        double time = 0;
        
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int pos = entry.getKey();
            int sp = entry.getValue();
            
            int dist = target - pos;
            double ctime = dist*1.0/sp;
            
            if(ctime>time){
                time = ctime;
                groups++;
            }
        }
        return groups;
    }
}