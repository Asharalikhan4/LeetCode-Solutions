class Solution {
    public int strangePrinter(String s) {
    
    int[][] dp = new int[s.length()+1][s.length()+1];
    for( int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
    return find(0, s.length(), s, dp);
}

private int find(int l, int r, String s, int[][] dp){
    
    if( l == r-1 ) return 1;
    
    if( dp[l][r] != -1 ) return dp[l][r];
    
    int result = Integer.MAX_VALUE;
    
    for( int i = l; i < r-1; i++ ){
        
        int left = find(l, i+1, s, dp);
        int right = find(i+1, r, s, dp);
        
        if( s.charAt(l) == s.charAt(r-1) ) {
            result = Math.min( left + right -1, result);
        }else{
            result = Math.min( left + right, result);
        }
    }
    
    return dp[l][r] = result;
}
}