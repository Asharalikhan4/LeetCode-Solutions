class Solution {
    private int memoizationUtil(String seq1, String seq2, int m, int n, int[][] memoization) {
		if (m < 0 || n < 0) {
			return 0;
		}
		if (memoization[m][n] != -1) {
			return memoization[m][n];
		}
		if (seq1.charAt(m) == seq2.charAt(n)) {
			return memoization[m][n] = 1 + memoizationUtil(seq1, seq2, m - 1, n - 1, memoization);
		} else {
			return memoization[m][n] = Math.max(memoizationUtil(seq1, seq2, m - 1, n, memoization),
					memoizationUtil(seq1, seq2, m, n - 1, memoization));
		}
	}

	private int memoization(String seq) {
		int n = seq.length();
		int[][] memoization = new int[n][n];
		for (int[] row : memoization) {
			Arrays.fill(row, -1);
		}
		String reverse = new StringBuilder(seq).reverse().toString();
		return memoizationUtil(seq, reverse, n - 1, n - 1, memoization);
	}

	private int tabulation(char[] a, char[] b, int m, int n) {
		int[][] lcs = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		return lcs[m][n];
	}
    public int longestPalindromeSubseq(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        // return tabulation(s.toCharArray(), reverse.toCharArray(), s.length(), s.length());
        return memoization(s);
    }
}
