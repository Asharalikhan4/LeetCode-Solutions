//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static boolean possible(int mid,int arr[], int m){
    int no_of_stu=1;
    int pages=0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]>mid) return false;
        if(pages+arr[i]>mid){
            no_of_stu++;
            pages=arr[i];
        }else{
            pages+=arr[i];
        }
    }
    if(no_of_stu>m) return false;
    return true;
}
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(N<M) return -1;
        int res=-1;
        int mx=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            mx=Math.max(mx,A[i]);
        }
        int start=mx;
        int end=sum;
        while(start<=end){
            int mid=(start+end)/2;
            if(possible(mid,A,M)){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
    }
};