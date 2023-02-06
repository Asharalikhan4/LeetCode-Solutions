//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        Long[][] dp = new Long[N + 1][sum + 1];
        return solve(0,sum,N,coins,dp);
    }
    public long solve(int i, int sum, int N, int[] coins, Long[][] dp){
        if(i >= N){
            return 0;
        }
        if(sum == 0){
            return 1;
        }
        if(sum < 0){
            return 0;
        }
        if(dp[i][sum] != null){
            return dp[i][sum];
        }
        long not_pick = solve(i + 1, sum, N, coins, dp);
        long pick = 0;
        if(coins[i] <= sum){
            pick = solve(i, sum - coins[i], N, coins, dp);
        }
        
        return  dp[i][sum] = pick + not_pick;
    }
}