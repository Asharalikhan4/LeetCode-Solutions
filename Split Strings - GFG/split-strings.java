//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t-- > 0){
            String S = sc.nextLine();
            Solution ob = new Solution();
            List<String> ans = ob.splitString(S);
            for (String val: ans) 
                if(val == "")
                    System.out.println(-1); 
                else    
                    System.out.println(val); 
        }
    } 
} 


// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static List<String> splitString(String S) 
    { 
        // code here
        ArrayList<String> list = new ArrayList<>();
        String S1="";
        String S2="";
        String S3="";
        for(int i=0;i<S.length();i++){
            if(Character.isLetter(S.charAt(i))){
                S1 += S.charAt(i);
            }
            else if(Character.isDigit(S.charAt(i))){
                S2 += S.charAt(i);
            }
            else{
                S3 +=S.charAt(i);
            }
        }
        list.add(S1);
        list.add(S2);
        list.add(S3);
        return list;
    }
} 
