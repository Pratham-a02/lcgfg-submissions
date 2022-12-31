class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int li = 0;
        int ri = people.length - 1;
        
        while(li<=ri){
            int val = people[li] + people[ri];
            
            if(val<=limit){
                count++;
                li++;
                ri--;
            }
            else{
                count++;
                ri--;
            }
        }
        
        return count;
    }
}