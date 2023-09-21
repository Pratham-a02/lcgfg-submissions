//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> st){
		if(st.size() == 0){
		    return st;
		}
		
		int val = st.pop();
		sort(st);
		insert(st,val);
		
		return st;
	}
	
	public void insert(Stack<Integer> st,int val){
	    if(st.size() == 0 || val > st.peek()){
	        st.push(val);
	        return;
	    }
	    
	    int curr = st.pop();
	    insert(st,val);
	    st.push(curr);
	    
	    return;
	}
}