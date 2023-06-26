//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        if(r>n)
            return 0;
       int mod = 1000000007;
       int[][] dp = new int[n+1][n+1];
       for(int i = 0;i<=n;i++)
       {
           for(int j = 0;j<=n;j++)
           {
               if(i == j || j == 0)
               {
                   dp[i][j] = 1;
               }
           }
       }
       for(int i = 1;i<=n;i++)
       {
           for(int j = 1;j<i;j++)
           {
              dp[i][j] = (dp[i-1][j-1]+dp[i-1][j])%mod;
           }
       }
       return (dp[n][r])%mod;
    }
}