//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean isWord(char[][] grid, String word, int row, int col, int n, int m) {
        int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        boolean flag = true;
        for(int[] dir: dirs) {
            int idx = 1;
            int drow = dir[0];
            int dcol = dir[1];
            int nrow = row;
            int ncol = col;
            for(int k = idx; k < word.length(); k++) {
                nrow += drow;
                ncol += dcol;
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == word.charAt(idx)) {
                    idx++;
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag) return flag;
        }
        return flag;
    }
    
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(); 
        int n = grid.length;
        int m = grid[0].length;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            idx = 0;
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != word.charAt(idx)) continue;
                if(isWord(grid, word, i, j, n, m)) { // check word in all direction
                    ArrayList<Integer> coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    res.add(coord);
                }
            }
        }
        if(res.size() > 0) { // conver ArrayList to Array
            int[][] ans = new int[res.size()][2];
            for(int i = 0; i < res.size(); i++) {
                ans[i][0] = res.get(i).get(0);
                ans[i][1] = res.get(i).get(1);
            }
            return ans;
        }
        return new int[0][0];
    }
}