function maxPalindromes(s: string, k: number): number {
    const n = s.length;
    const isPal: boolean[][] = Array.from({length: n}, () => Array(n).fill(false));
    
    for (let i = 0; i < n; ++i)
        isPal[i][i] = true;
    
    for (let i = 0; i + 1 < n; ++i)
        if (s[i] === s[i + 1])
            isPal[i][i + 1] = true;
    
    for (let len = 3; len <= n; ++len)
        for (let i = 0; i + len - 1 < n; ++i) {
            const j = i + len - 1;
            if (s[i] === s[j] && isPal[i + 1][j - 1])
                isPal[i][j] = true;
        }
    
    const dp: number[] = new Array(n + 1).fill(0);
    for (let i = 1; i <= n; ++i) {
        dp[i] = dp[i - 1];
        for (let j = 0; j <= i - k; ++j)
            if (isPal[j][i - 1])
                dp[i] = Math.max(dp[i], dp[j] + 1);
    }
    return dp[n];
};