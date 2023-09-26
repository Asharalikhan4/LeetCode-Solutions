//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            String reciprocal = ob.reciprocalString(S);
            System.out.println(reciprocal);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static String reciprocalString(String S){
        // code here
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char temp = S.charAt(i);
            if (temp >= 'A' && temp <= 'Z') {
				int index = 'Z' - temp + 'A';
				ans.append((char) index);
			} else if (temp >= 'a' && temp <= 'z') {
				int index = 'z' - temp + 'a';
				ans.append((char) index);
			} else {
				ans.append(temp);
			}
        }
        return ans.toString();
    }
}