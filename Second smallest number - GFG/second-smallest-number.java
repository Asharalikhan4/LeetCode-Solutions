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
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
        // code here
        String ans="";

        int last=0;
        int index=D-1;
        for(int i=D-1;i>=0;i--){
            if(S>9){
                ans="9"+ans;
                S-=9;
            }
            else if(S>0){
                ans=Integer.toString(S)+ans;
                last=i;
                S=0;
                
            }
            else{
                ans="0"+ans;
            }
        }
        
        char []num=ans.toCharArray();
        int arr[]=new int[num.length];
        for(int i=0;i<num.length;i++){
            arr[i]=num[i]-'0';
        }
        
        arr[last]=arr[last]-1;
        arr[0]=arr[0]+1;
        
        for(int i=D-1;i>=0;i--){
            if(arr[i]!=9)break;
            else{
                index=i;
            }
        }
        //second Number
        if(index==0) return "-1";
        arr[index]=arr[index]-1;
        arr[index-1]=arr[index-1]+1;
        StringBuffer res = new StringBuffer("");
        for(int i:arr){
            res.append(i);
        }
    
        return res.toString();
    }
}