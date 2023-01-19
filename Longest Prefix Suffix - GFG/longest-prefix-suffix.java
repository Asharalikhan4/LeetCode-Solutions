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
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        // code here
        //storing the count of matching elements
        int store[] = new int[s.length()];
        
        int start = 0;
        int end = 1;
        
        while( end < s.length()){
            
            //we have to compare the prefix and suffix
            //Note : if there is suffix it should end on last index
            
            //we can move only both character are matching
            if(s.charAt(start) == s.charAt(end)){

                store[end] = start+1;
                start++;
                end++;
            }else{
                //if start on 0 and still we haven't match the single character then we have to move end
                //to reach at suffix start point
                if(start == 0){
                    store[end] = 0;
                    end++;
                }else{
                    //if start and end are not matching
                    //and start are not matching
                    //then we compare wrong character
                    //we have to go back to again to match with the suffix
                    start = store[start-1];
                }
            }
            
        }
        return store[s.length()-1];
    }
}