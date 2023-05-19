//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            int range[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                range[i][0]=Integer.parseInt(s[0]);
                range[i][1]=Integer.parseInt(s[1]);
            }
            int q=Integer.parseInt(in.readLine().trim());
            int Q[]=new int[q];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<q;i++){
                Q[i]=Integer.parseInt(s[i]);
            }

            Solution ob=new Solution();
            ArrayList<Integer> ans=ob.kthSmallestNum(n, range, q, Q);

            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    } 
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] rangel, int qn, int[] queries) {
        // code here
        Arrays.sort(rangel, (a,b) ->a[0]-b[0]);
        // for(int i=0;i<n;i++)
        // System.out.println(range[i][0]+"-"+range[i][1]);
        ArrayList<Integer> ans= new ArrayList<>();
        ArrayList<int[]> range=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            range.add(new int[]{rangel[i][0],rangel[i][1]});
        }
        int rem=0;
        for(int i=1;i<n-rem;i++)
        {
            if(range.get(i)[0]<range.get(i-1)[1])
            {
                range.get(i-1)[1]=Math.max(range.get(i)[1],range.get(i-1)[1]);
                range.remove(i);
                i--;
                rem++;
            }
        }
        int max=0;
        for(int q:queries)
        {
            int k=0;
            boolean flag=false;
            for(int i=0;i<range.size();i++)
            {
                int start=range.get(i)[0];
                if(i>0)
                {
                    if(range.get(i)[0]<=range.get(i)[1] && range.get(i)[1]<=range.get(i-1)[1])
                    continue;
                    if(range.get(i)[0]<=range.get(i-1)[1])
                    start=range.get(i-1)[1]+1;
                }
                int rlen=range.get(i)[1]-start+1;
                if(k+rlen<q)
                {
                    k=k+rlen;
                    continue;
                }
                else
                {
                    int cans=start+(q-k)-1;
                    ans.add(cans<=range.get(i)[1]?cans:-1);
                    flag=true;
                    break;
                }
            }
            if(flag==false)
            ans.add(-1);
            
        }
        
        return ans;
    }
}
        
