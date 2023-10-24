class Solution {
    public int minOperations(String[] logs) {
        int operations = 0;
        
        for(String log : logs){
            if(log.equals("../")){
                operations -= operations == 0?0:1;
            }
            else if(!log.equals("./")){
                operations++;
            }
        }
        return Math.max(operations,0);
    }
}