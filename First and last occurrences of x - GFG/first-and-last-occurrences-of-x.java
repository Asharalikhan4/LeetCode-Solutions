//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer> lis = new ArrayList<>();
        int start=0, end=0;
        int rev=n-1;
        int flag=0,flag1=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==x && flag!=1)
            {
                start=i;
                flag=1;
                lis.add(start);
                
            }
            
            if(arr[rev]==x && flag1!=1)
            {
                end=rev;
                flag1=1;
                lis.add(end);
            }
            rev--;
        }
        if(flag==0 && flag1==0)
        {
            lis.add(-1);
            lis.add(-1);
        }

        Collections.sort(lis);
        return lis;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends