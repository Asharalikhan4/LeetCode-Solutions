class Solution {
    class Graph {
		private int v;
		private String colors;
        private int indegree[];
		private List<ArrayList<Integer>> adj;

		public Graph(int v, String colors) {
			this.v = v;
			this.colors = colors;
			this.indegree = new int[v];
			this.adj = new ArrayList<ArrayList<Integer>>(this.v);
			for (int i = 0; i < this.v; i++) {
				this.adj.add(new ArrayList<Integer>());
			}
		}

		public void addEdge(int u, int v) {
			adj.get(u).add(v);
            this.indegree[v]++;
		}

		public int bfs() {
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < indegree.length; i++) {
				if (indegree[i] == 0) {
					queue.add(i);
				}
			}
			int visited = 0;
            int dp[][] = new int[this.v][26];
			while (!queue.isEmpty()) {
				int u = queue.poll();
				int uColor = colors.charAt(u) - 'a';
				dp[u][uColor] = dp[u][uColor] + 1;
				for (int v : adj.get(u)) {
					indegree[v]--;
					if (indegree[v] == 0) {
						queue.add(v);
					}
					for (int i = 0; i < 26; i++) {
						dp[v][i] = Math.max(dp[v][i], dp[u][i]);
					}
				}
				visited++;
			}
			if (visited != this.v) {
				return -1;
			}
			int maxColor = 0;
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < 26; j++) {
					maxColor = Math.max(maxColor, dp[i][j]);
				}
			}
			return maxColor;
		}
	}

	public int largestPathValue(String colors, int[][] edges) {
		Graph graph = new Graph(colors.length(), colors);
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			graph.addEdge(u, v);
		}
		return graph.bfs();
	}
}