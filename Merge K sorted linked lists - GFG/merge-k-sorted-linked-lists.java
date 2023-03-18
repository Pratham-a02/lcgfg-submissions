//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends
/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/
class Solution{
    Node mergeKList(Node[]arr,int K){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
           return a.data-b.data;
        });
        
        for(Node node:arr){
            if(node != null){
                pq.add(node);
            }
        }
        
        Node dummy = new Node(-1);
        Node prev = dummy;
        while(pq.size()>0){
            Node node = pq.remove();
            
            prev.next = node;
            prev = prev.next;
            node = node.next;
            if(node != null){
                pq.add(node);
            }
        }
        
        return dummy.next;
    }
}
