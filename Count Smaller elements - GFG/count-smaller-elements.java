//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Pair{
    int first=0;
    int second=0; // to store original index
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    int[] count;
    int[] constructLowerArray(int[] arr, int n) {
        count=new int[n];
        Pair[] m=new Pair[n];
        for(int i=0;i<n;i++){
            m[i]=new Pair(arr[i],i);
        }
        merge(m,0,n);
        return count;
    }
    public void merge(Pair[] m,int start,int end){
        if(end-start<2){
            return;
        }
        int p=(start+end)/2;
        merge(m,start,p);
        merge(m,p,end);
        mergeSort(m,start,p,end);
        return;
    }
    public void mergeSort(Pair[] m,int start,int p,int end){
        Pair[] temp=new Pair[end-start]; int s=0;
        int i=start; int j=p;
        int cnt=0;
        while(i<p && j<end){
            if(m[i].first<=m[j].first){
                count[m[i].second]=count[m[i].second]+cnt; 
                //update count in original indices                                            
                temp[s++]=m[i];
                i++;
            }
            else if(m[j].first<m[i].first){
                cnt++;
                temp[s++]=m[j];
                j++;
            }
        }
        while(i<p){
            count[m[i].second]=count[m[i].second]+cnt;
            temp[s++]=m[i];
            i++;
        }
        while(j<end){
            temp[s++]=m[j];
            j++;
        }
        System.arraycopy(temp,0,m,start,temp.length);
        return;
    }
}