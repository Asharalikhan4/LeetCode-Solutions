//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void backtrack(List<String> list,String str,int open,int close,int max){
        if(str.length()==max*2){
            list.add(str);
            return;
        }
        if(open<max){
            backtrack(list,str+"(",open+1,close,max);
        }
        if(close<open){
            backtrack(list,str+")",open,close+1,max);
        }
    }
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> list=new ArrayList<>();
        backtrack(list,"",0,0,n);
        return list;
    }
}