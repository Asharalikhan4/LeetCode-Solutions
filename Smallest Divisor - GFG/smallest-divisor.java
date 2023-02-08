//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int K) {
        // Code here
        int low=0,mid=0;
        int high=Integer.MAX_VALUE;
        int n=nums.length;
        while(low<=high){
             mid=low+(high-low)/2;
             int h=0;
             for(int i=0;i<n;i++){
              h+=Math.ceil(1.0*nums[i]/mid);   
             }
             if(h>K){low=mid+1;}
             else high=mid-1;
        }
        return low;
    }
}