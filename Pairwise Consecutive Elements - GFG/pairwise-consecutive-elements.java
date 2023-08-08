//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;

class elements
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            Stack<Integer> st = new Stack<Integer>();
            int n = sc.nextInt();
            int temp = 0;
            for(int i = 0; i < n; i++)
            {
                temp = sc.nextInt();
                st.push(temp);
            }
            GFG gfg = new GFG();
            if(gfg.pairWiseConsecutive(st) == true)
            System.out.println("Yes");
            else
            System.out.println("No");
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// your task is to complete the function
// function should return true/false or 1/0
class GFG
{
    public static boolean pairWiseConsecutive(Stack<Integer> st)
    {
        // Your code here
       int temp = -1;
        while(!st.empty()){
            int stackEle = st.pop();
            if(temp == -1) temp= stackEle;
            else{
                int diff = temp - stackEle;
                if(diff != 1) return false;
                temp = stackEle;
            }
        } 
        return true;
	}
}