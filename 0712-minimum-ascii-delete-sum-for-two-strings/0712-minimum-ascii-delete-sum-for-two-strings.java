class Solution {
    int sumStringASCII(String str){
        int sum = 0;
        for(char ch: str.toCharArray()) sum += ch;
        return sum;
    }

    public int minimumDeleteSum(String s1, String s2) {
        
        if(s1.equals(s2)) return 0;

        int m = s1.length();
        int n = s2.length();

        int[][] memo = new int[m + 1][n + 1];

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    memo[i][j] = s1.charAt(i - 1) + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        int totalASCIISum = sumStringASCII(s1) + sumStringASCII(s2);

        int sumOfLCSASCII = memo[m][n];

        return (totalASCIISum - 2 * sumOfLCSASCII);
    }
}