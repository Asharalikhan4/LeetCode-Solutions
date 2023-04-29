class Solution {
    public int find(int[] parent, int u) {
		if (parent[u] != u) {
			parent[u] = find(parent, parent[u]);
		}
		return parent[u];
	}

	public void union(int[] parent, int[] rank, int u, int v) {
		int parentU = find(parent, u);
		int parentV = find(parent, v);
		if (parentU == parentV) {
			return;
		}
		if (rank[parentU] > rank[parentV]) {
			parent[parentV] = parentU;
		} else if (rank[parentU] < rank[parentV]) {
			parent[parentU] = parentV;
		} else {
			parent[parentU] = parentV;
			rank[parentV] += 1;
		}
	}

	public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
		Integer[] queryOrder = new Integer[queries.length];
		for (int i = 0; i < queries.length; ++i) {
			queryOrder[i] = i;
		}
		Arrays.sort(queryOrder, (o1, o2) -> queries[o1][2] - queries[o2][2]);
		Arrays.sort(edgeList, (el1, el2) -> el1[2] - el2[2]);
		int[] parent = new int[n];
		int[] rank = new int[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
		}
		boolean[] ans = new boolean[queries.length];
		int edgeIndex = 0;
		for (int i = 0; i < queries.length; ++i) {
			int[] query = queries[queryOrder[i]];
			while (edgeIndex < edgeList.length && query[2] > edgeList[edgeIndex][2]) {
				union(parent, rank, edgeList[edgeIndex][0], edgeList[edgeIndex][1]);
				edgeIndex++;
			}
			ans[queryOrder[i]] = find(parent, query[0]) == find(parent, query[1]);
		}
		return ans;
	}
}