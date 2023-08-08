//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int helper(int[] nums, int k, int i, Integer[] mem) {
        if(i == nums.length)
            return -1;
        if(mem[i] != null)
            return mem[i];
        int lineLen = 0;
        int ans = Integer.MAX_VALUE;
        for(int j = i;j<nums.length;j++) {
            lineLen += nums[j];
            int totalLen = lineLen+j-i;
            if(totalLen > k)
                break;
            int remaining = k-totalLen;
            int res = helper(nums, k, j+1, mem);
            if(res == -1)
                res = -remaining*remaining;
            ans = Math.min(ans, remaining*remaining+res);
        }
        return mem[i] = ans;
    }
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here 
        return helper(nums, k, 0, new Integer[nums.length]);
    }
}