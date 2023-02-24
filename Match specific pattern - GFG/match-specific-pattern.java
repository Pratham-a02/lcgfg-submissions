//{ Driver Code Starts
import java.util.*;
public class MSP
{	
    public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-- != 0)
		{
			int n=sc.nextInt();
			ArrayList<String> s = new ArrayList<String>(n);
			for (int i=0;i<n;i++)
			    s.add(sc.next());
			String tt;
			tt=sc.next();
			GfG g=new GfG();
			ArrayList<String> res =g.findMatchedWords(s, tt);
			Collections.sort(res);
			for (int i = 0;i < res.size();i++)
			    System.out.print(res.get(i)+" ");
			System.out.println();

		}
	}
}
// } Driver Code Ends


/*Complete the provided function*/

class GfG{

public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern){
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0;i<dict.size();i++){
            String word = dict.get(i);
            boolean flag = areIsomorphic(word,pattern);
            if(flag == true){
                ans.add(word);
            }
        }
        return ans;
	}
	
	public static boolean areIsomorphic(String word1,String word2){
	    if(word1.length() != word2.length()){
	        return false;
	    }
	    HashMap<Character,Character> hm1 = new HashMap<>();
	    HashMap<Character,Character> hm2 = new HashMap<>();
	    
	    for(int i = 0;i<word1.length();i++){
	        char ch = word1.charAt(i);
	        char sch = word2.charAt(i);
	        
	        if(hm1.containsKey(ch)){
	            if(hm1.get(ch) != sch){
	                return false;
	            }
	        }
	        if(hm2.containsKey(sch)){
	            if(hm2.get(sch) != ch){
	                return false;
	            }
	        }
	        else{
	            hm1.put(ch,sch);
	            hm2.put(sch,ch);
	        }
	    }
	    return true;
	}
}