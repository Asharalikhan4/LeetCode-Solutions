class Solution {
    public double myPow(double x, int n) {
    if (n == Integer.MAX_VALUE) return x;
        else if (n == Integer.MIN_VALUE) return (x == 1 || x == -1) ? 1 : 0;
        if(n<0) {
            x=1/x;
            n*=-1;
        }
        double ans = 1;
        for(int i=0;i<n;i++)
            ans = ans*x;
        return ans;
    }
}