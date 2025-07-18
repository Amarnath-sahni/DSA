class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
         // Build graph: a/b = k  -->  a -> (b, k),  b -> (a, 1/k)
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            double k = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, k);
            graph.get(b).put(a, 1.0 / k);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String src = q.get(0);
            String dst = q.get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                ans[i] = -1.0;
            } else if (src.equals(dst)) {
                ans[i] = 1.0;  // same variable, exists in graph
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(src, dst, 1.0, visited, graph);
            }
        }

        return ans;
    }

    private double dfs(String cur, String target, double acc, Set<String> visited,
                       Map<String, Map<String, Double>> graph) {

        if (cur.equals(target)) {
            return acc;
        }

        visited.add(cur);

        Map<String, Double> neighbors = graph.get(cur);
        for (Map.Entry<String, Double> e : neighbors.entrySet()) {
            String next = e.getKey();
            if (visited.contains(next)) continue;
            double weight = e.getValue();
            double res = dfs(next, target, acc * weight, visited, graph);
            if (res != -1.0) {
                return res;
            }
        }

        return -1.0;
    }
}