//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        int[][] dp = new int[n][m];
    dp[0][0] = grid[0][0] == 1 ? 1 : 0;
    for (int i = 1; i < n; i++) {
        dp[i][0] = grid[i][0] == 1 ? dp[i-1][0] : 0;
    }
    for (int j = 1; j < m; j++) {
        dp[0][j] = grid[0][j] == 1 ? dp[0][j-1] : 0;
    }
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (grid[i][j] == 1) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
    }
    return dp[n-1][m-1];
    }
};