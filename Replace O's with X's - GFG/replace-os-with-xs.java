//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        int[][] vis = new int[n][m];
        int[][] temp = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1 ){
                    if(a[i][j] == 'O' && vis[i][j] == 0){
                        temp[i][j] = 1;
                        dfs(i,j,vis,a,n,m,temp);
                    }
                }
               
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j] == 'O' && temp[i][j] == 0) a[i][j] = 'X';
            }
        }
        return a;
        
    }
    
    public static void dfs(int i, int j, int[][] vis, char a[][],int n,int m,int[][] temp){
        if(i<0 || i>=n || j<0 || j>=m || a[i][j] == 'X' || vis[i][j] == 1) return;
        
        vis[i][j] = 1;
        temp[i][j] = 1;
        dfs(i+1,j,vis,a,n,m,temp);
        dfs(i-1,j,vis,a,n,m,temp);
        dfs(i,j+1,vis,a,n,m,temp);
        dfs(i,j-1,vis,a,n,m,temp);

    }
}