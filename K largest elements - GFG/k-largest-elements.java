//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;


class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> list = ob.kLargest(arr, n, k);
            for(int i = 0; i<list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        // code here 
        //Function to return k largest elements from an array.
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
        {
            minHeap.add(arr[i]);
            if(minHeap.size()>k)
                minHeap.remove();
        }
        for(int i=0;i<k;i++)
        {
            ans.add(minHeap.peek());
            minHeap.remove();
        }
        Collections.reverse(ans);
        return ans;
    }
}