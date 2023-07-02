//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line[] = in.readLine().trim().split("\\s+");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int l = Integer.parseInt(line[2]);
            int r = Integer.parseInt(line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.setSetBit(x, y, l, r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int setSetBit(int x, int y, int l, int r){
        // code here
        int xa[]=new int[32];
        int ya[]=new int[32];
        int pos=31;
        while(y>0){
            int rem=y%2;
            if(rem==1){
                ya[pos]=1;
            }
            y=y/2;
            pos--;
        }
        pos=31;
        while(x>0){
            int rem=x%2;
            if(rem==1){
                xa[pos]=1;
            }
            x=x/2;
            pos--;
        }
        int range=r-l+1;
        for(int i=l;i<=r;i++){
            if(ya[32-i]==1){
                xa[32-i]=1;
            }
        }
        StringBuffer str=new StringBuffer("");
        for(int i=0;i<32;i++){
            str.append(xa[i]);
        }
        String s=str.toString();
        return Integer.parseInt(s,2);
    }
}