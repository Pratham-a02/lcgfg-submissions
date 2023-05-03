class Solution{
    public int numRescueBoats(int[] people,int limit){
        Arrays.sort(people);
        int li = 0;
        int ri = people.length-1;
        int count = 0;
        
        while(li<=ri){
            int val = people[li] + people[ri];
            
            if(val<=limit){
                li++;
                ri--;
                count++;
            }
            else{
                count++;
                ri--;
            }
        }
        return count;
    }
}