//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)
    {
        // your code here
        StringBuilder ans = new StringBuilder();
    StringBuilder temp = new StringBuilder();

    for (int i = S.length() - 1; i >= 0; i--) {
        if (Character.isDigit(S.charAt(i))) {
            temp.append(S.charAt(i));
        } else {
            ans.append(temp.reverse()).append(S.charAt(i));
            temp.setLength(0);
        }
    }

    ans.append(temp.reverse());
    return ans.toString();
    }
}