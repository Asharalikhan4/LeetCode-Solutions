//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}
// } Driver Code Ends




class Solution
{
     //static final int ASCII_SIZE=256;//declare global size of the array 
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        int count[]=new int[26];//intilize the size of the array is 26
        int idx,n=line.length();
        for(int i=0;i<n;i++)
        {
            idx=line.charAt(i)-'a';
            count[idx]++;
        }
        int max=-1,result=0;
        for(int i=0;i<26;i++)
        {
            if(count[i]>max)
            {
                max=count[i];
                result=i;
            }
        }
       int a= result+'a';
       char c=(char)a;
       return c;
    }
}