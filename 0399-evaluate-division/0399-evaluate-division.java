class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final int n = queries.size();
        final double[] result = new double[n];

        final Map<String, Map<String, Double>> map = new HashMap<>();

        for(int i = 0; i < values.length; i++) {
            final List<String> equation = equations.get(i);
            final String first = equation.get(0);
            final String second = equation.get(1);

            map.putIfAbsent(first, new HashMap<>());
            map.putIfAbsent(second, new HashMap<>());

            map.get(first).put(second, values[i]);
            map.get(second).put(first, 1 / values[i]);
        }

        int index = 0;
        for(List<String> q: queries) {
            final String from = q.get(0);
            final String target = q.get(1);
            if(!map.containsKey(from) || !map.containsKey(target)) {
                result[index++] = -1;
                continue;
            }
            result[index++] = dfs(map, from, target, new HashSet<>());
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> map, String from, String target, Set<String> isVisited) {
        if(from.equals(target)) return 1;

        final Map<String, Double> next = map.get(from);
        for(Map.Entry<String, Double> e: next.entrySet()) {
            final String to = e.getKey();
            if(isVisited.contains(to)) continue;
            isVisited.add(to);
            final double value = e.getValue();
            final double result = dfs(map, to, target, isVisited);
            if(result >= 0) return value * result;
        }

        return -1;
    }
}