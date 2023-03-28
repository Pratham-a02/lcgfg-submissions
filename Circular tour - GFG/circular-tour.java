//{ Driver Code Starts
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		}
	}
}
// } Driver Code Ends
class Solution{
    int tour(int petrol[], int distance[]){
		int csum = 0;
		int osum = 0;
		int si = 0;
		
		for(int i = 0;i<petrol.length;i++){
		    osum += (petrol[i] - distance[i]);
		    csum += (petrol[i] - distance[i]);
		    
		    if(csum<0){
		        si = i+1;
		        csum = 0;
		    }
		}
		
		
		if(osum >= 0){
		    return si;
		}
		else{
		    return -1;
		}
    }
}