//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        //code here
        ArrayList<String> ans = new ArrayList<>();
        
        for (String word : Dictionary) {
            if (isPatternMatch(word, Pattern)) {
                ans.add(word);
            }
        }
        
        Collections.sort(ans);
        
        if (ans.isEmpty()) {
            ans.add("-1");
        }
        
        return ans;
    }
    
    boolean isPatternMatch(String word, String Pattern) {
        if (word.length() < Pattern.length()) {
            return false;
        }
        
        int i = 0, j = 0;
        
        while (i < word.length() && j < Pattern.length()) {
            if (Character.isUpperCase(word.charAt(i))) {
                if (word.charAt(i) != Pattern.charAt(j)) {
                    return false;
                }
                j++;
            }
            i++;
        }
        
        return j == Pattern.length();
    }
}