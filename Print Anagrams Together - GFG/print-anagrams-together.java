//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}

// } Driver Code Ends

class Solution{
    public List<List<String>> Anagrams(String[] strs){
        HashMap<HashMap<Character,Integer>,List<String>> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for(String str : strs){
            HashMap<Character,Integer> curr = new HashMap<>();
            
            for(char ch : str.toCharArray()){
                curr.put(ch,curr.getOrDefault(ch,0)+1);
            }
            
            if(hm.containsKey(curr)){
                List<String> al = hm.get(curr);
                al.add(str);
            }
            else{
                List<String> al =  new ArrayList<>();
                al.add(str);
                hm.put(curr,al);
            }
        }
        
        for(List<String> al : hm.values()){
            ans.add(al);
        }
        return ans;
    }
}
