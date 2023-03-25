class Solution {
     public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] weight = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int[] e: edges) {
            union(parent, weight, e[0], e[1]);
        }
        int[] count = new int[n];
        for(int i = 0; i < n; i++) {
            int pa = find(parent, i);
            count[pa]++;
        }
        long result = 0;
        long prevTotal = 0;
        for(int i = 0; i < n; i++) {
            if(count[i] == 0) continue;
            result += prevTotal * count[i];
            prevTotal += count[i];
        }
        return result;
    }

    private void union(int[] parent, int[] weight, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if(weight[pa] > weight[pb]) {
            parent[pb] = parent[pa];
        } else if(weight[pb] > weight[pa]) {
            parent[pa] = parent[pb];
        } else {
            weight[pa]++;
            parent[pb] = parent[pa];
        }
    }

    private int find(int[] parent, int a) {
        if(a != parent[a]) {
            parent[a] = find(parent, parent[a]);
        }
        return parent[a];
    }
}