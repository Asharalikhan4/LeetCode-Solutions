//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[] visited=new boolean[V+1];   

        Queue<Integer> que=new LinkedList<>();

        int values=1;

        que.offer(0);

       visited[1]=true;

     for(int k=1;k<visited.length;k++){

            if(visited[k]==false){

                 visited[k]=true;

                que.offer(k-1);

                values++;

               

            }

             while(!que.isEmpty()){

                Integer val=que.poll();

            for(int i=0;i<adj.get(val).size();i++){

              int inList=adj.get(val).get(i);

                if(inList==1&&visited[i+1]==false){

                     

                    visited[i+1]=true;

                    que.offer(i);

                }

            }

               }

        }

           return values;   

    }
};