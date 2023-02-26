/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int num;
    int freq;
    
    Pair(int num,int freq){
        this.num = num;
        this.freq = freq;
    }
    
    public int compareTo(Pair o){
        if(this.freq == o.freq){
            return this.num-o.num;
        }
        else{
            return o.freq - this.freq;
        }
    }
}


class GFG {
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0){
		    int n = scn.nextInt();
		    int[] nums = new int[n];
		    for(int i = 0;i<n;i++){
		        nums[i] = scn.nextInt();
		    }
		    
		    
		    PriorityQueue<Pair> pq = new PriorityQueue<>();
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int val:nums){
                hm.put(val,hm.getOrDefault(val,0)+1);
            }
            
            for(int key:hm.keySet()){
                Pair p = new Pair(key,hm.get(key));
                pq.add(p);
            }
            
            int[] ans = new int[nums.length];
            int idx = 0;
            while(pq.size()>0){
                Pair p = pq.remove();
                int val = p.num;
                int fre = p.freq;
                for(int i = 0;i<fre;i++){
                    ans[idx++] = val;
                }
            }
            
            for(int i = 0;i<ans.length;i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
		}
	}
}