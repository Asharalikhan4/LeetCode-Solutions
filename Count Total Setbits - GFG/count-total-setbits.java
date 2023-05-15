//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.countBits(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxpowerOftwo(long N){
        int x=0;
        while((1<<x) <= N) x++;
        return x-1;
    }
    public static long countBits(long N) {
        if(N ==0) return 0;
        long ans=0;
        int x = maxpowerOftwo(N);
        ans = x* (1<<(x-1)) + (N-(1<<x) +1 )+ countBits(N-(1<<x));
        return ans;
    }
}
        
