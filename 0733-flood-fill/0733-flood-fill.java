class Solution {
    int[] DIRS = {0, 1, 0, -1, 0};
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image; // same color -> no need to replace
        m = image.length; n = image[0].length;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r == m || c < 0 || c == n || image[r][c] != oldColor) return;
        image[r][c] = newColor; // also mean we marked it as visited!
        for (int i = 0; i < 4; i++)
            dfs(image, r + DIRS[i], c + DIRS[i+1], oldColor, newColor);
    }
}