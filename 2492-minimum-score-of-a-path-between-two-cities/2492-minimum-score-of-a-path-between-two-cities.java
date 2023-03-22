class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for(int[] road:roads){
            int u = road[0];
            int v = road[1];
            int weight= road[2];
            graph.computeIfAbsent(u, a->new HashMap<Integer, Integer>()).put(v,weight);
            graph.computeIfAbsent(v, a->new HashMap<Integer, Integer>()).put(u,weight);
        }
        int result = Integer.MAX_VALUE;
        Set<Integer> visited = new HashSet();
        Queue<Integer> queue = new LinkedList();
        queue.offer(1);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Map.Entry<Integer, Integer> entry: graph.get(node).entrySet()){
                int neighbor = entry.getKey();
                int weight= entry.getValue();
                if (!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
                result = Math.min(result, weight);
            }
        }
        return result;
    }
}