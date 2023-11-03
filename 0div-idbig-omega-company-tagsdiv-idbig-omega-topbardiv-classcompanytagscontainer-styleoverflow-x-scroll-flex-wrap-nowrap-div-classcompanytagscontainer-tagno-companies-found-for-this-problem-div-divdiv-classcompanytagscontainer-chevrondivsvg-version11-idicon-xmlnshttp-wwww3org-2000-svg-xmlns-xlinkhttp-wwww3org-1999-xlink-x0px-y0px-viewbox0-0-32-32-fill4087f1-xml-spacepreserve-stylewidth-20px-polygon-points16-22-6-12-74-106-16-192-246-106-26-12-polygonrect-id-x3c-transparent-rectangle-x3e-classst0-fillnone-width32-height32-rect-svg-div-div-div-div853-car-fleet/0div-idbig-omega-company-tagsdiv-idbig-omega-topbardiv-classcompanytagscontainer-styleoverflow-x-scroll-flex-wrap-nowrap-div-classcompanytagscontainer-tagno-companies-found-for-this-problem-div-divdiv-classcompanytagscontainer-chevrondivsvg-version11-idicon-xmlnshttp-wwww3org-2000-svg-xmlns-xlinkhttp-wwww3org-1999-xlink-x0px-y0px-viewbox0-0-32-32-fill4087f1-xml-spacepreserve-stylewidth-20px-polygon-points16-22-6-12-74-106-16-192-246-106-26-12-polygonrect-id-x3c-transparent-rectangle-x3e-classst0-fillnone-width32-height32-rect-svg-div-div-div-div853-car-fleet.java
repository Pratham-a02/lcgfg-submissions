class Solution{
    public int carFleet(int target,int[] position,int[] speed){
        TreeMap<Integer,Integer> hm = new TreeMap<>(Collections.reverseOrder());
        
        for(int i = 0;i<position.length;i++){
            hm.put(position[i],speed[i]);
        }
        
        int groups = 0;
        double time = 0;
        for(int car:hm.keySet()){
            int sp = hm.get(car);
            int dist = target - car;
            
            double ctime = (dist*1.0)/sp;
            if(ctime>time){
                time = ctime;
                groups++;
            }
        }
        
        return groups;
    }
}