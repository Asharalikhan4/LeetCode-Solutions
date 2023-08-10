//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
    int n = s1.length();
    int m = s2.length();
    int prev[] = new int[m + 1];
    int curr[] = new int[m + 1];
    
    for (int idx1 = 1; idx1 <= n; idx1++) {
        for (int idx2 = 1; idx2 <= m; idx2++) {
            if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
                curr[idx2] = 1 + prev[idx2 - 1];
            } else {
                curr[idx2] = Math.max(prev[idx2], curr[idx2 - 1]);
            }
        }
        
        // Swap curr and prev arrays
        int[] temp = prev;
        prev = curr;
        curr = temp;
    }
    
    return prev[m];
    }
    
}