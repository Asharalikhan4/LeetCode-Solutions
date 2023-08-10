//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S1 = sc.next();
                    String S2 = sc.next();
                    Sol obj = new Sol();
                    System.out.println(obj.conCat(S1,S2));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Sol
{
   String conCat(String s1 , String s2)
   {
       //code here.
       return s1+s2;
   }
}