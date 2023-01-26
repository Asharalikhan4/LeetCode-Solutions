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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        char t[] = s.toCharArray();
        Arrays.sort(t);
        List<String> ans = new ArrayList<>();
        for(int i = 1; i<Math.pow(2,t.length); i++){
            String st = "";
            for(int j = 0; j<t.length; j++){
                if(check(i, j)){
                    st += s.charAt(j);
                }
            }
            ans.add(st);
        }
        Collections.sort(ans);
        return ans;
    }
    public boolean check(int A, int B) {
        if((A&(1<<B)) == 0){
            return false;
        }
        else {
            return true;
        }
    }
}