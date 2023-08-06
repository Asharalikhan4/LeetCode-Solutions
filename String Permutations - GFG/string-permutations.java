//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    ArrayList<String> res;
    public ArrayList<String> permutation(String S)
    {
        res=new ArrayList<>();
        fun(S.toCharArray(),new char[S.length()],0);
        Collections.sort(res);
        return res;
    }
    public void fun(char[] s, char[] temp, int x){
        if(x>=s.length){
            res.add(new String(temp));
            return;
        }
        for(int i=0;i<s.length;i++){
            if(s[i]!='-'){
                temp[x]=s[i];
                char prev=s[i];
                s[i]='-';
                fun(s,temp,x+1);
                s[i]=prev;
            }
        }
    }
	   
}
