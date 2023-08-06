//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class ThirdLargestElement
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n =sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			Solution g = new Solution();
			System.out.println(g.thirdLargest(arr,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int thirdLargest(int a[], int n)
    {
	    // Your code here
	    int largest = a[0];
         int sec_largest = Integer.MIN_VALUE;
         int third_largest = Integer.MIN_VALUE;
         
         for(int i = 1;i<n;i++){
             if(largest < a[i]){
                 third_largest = sec_largest;
                 sec_largest = largest;
                 largest = a[i];
             }
             else if(largest > a[i] && sec_largest < a[i]){
                 third_largest = sec_largest;
                 sec_largest = a[i];
             }
             else if(sec_largest > a[i] && third_largest < a[i]){
                 third_largest = a[i];
             }
         }
         return third_largest;
    }
}
