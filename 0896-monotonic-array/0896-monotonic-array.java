class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length==1) return true;
        int n=A.length;
        boolean up= (A[n-1]-A[0])>0;
        for (int i=0; i<n-1; i++)
            if (A[i+1]!=A[i] && (A[i+1]-A[i]>0)!=up) 
                return false;
        return true;
    }
}