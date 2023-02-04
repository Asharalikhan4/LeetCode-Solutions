//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        
        // your code here
        int arr[]=new int[n+1];
        if(n==0)return 1;
        if(n==1)return 1;
        arr[0]=1;
        arr[1]=1;
        int mod=(int)(1e9)+7;
        for(int i=2;i<=n;i++){
            arr[i]=(arr[i-1]%mod+arr[i-2]%mod)%mod;
        }

        return arr[n]%mod;
    }
}

