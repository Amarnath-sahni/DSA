class Solution {

    public int[] findRedundantConnection(int[][] edges) {
       int n = edges.length; // number of edges
        ArrayList<Integer>[] graph = new ArrayList[n + 1]; // graph

        // initialize graph
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // try to add each edge one by one
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            boolean[] visited = new boolean[n + 1];
            // check if path already exists between u and v
            if (dfs(graph, u, v, visited)) {
                return e; // this edge makes cycle
            }

            // if no cycle then add edge to graph
            graph[u].add(v);
            graph[v].add(u);
        }

        return new int[0];
    }

     public boolean dfs(ArrayList<Integer>[] graph, int src, int target, boolean[] visited) {
        if (src == target) return true; // path found
        visited[src] = true;

        for (int neigh : graph[src]) {
            if (!visited[neigh]) {
                if (dfs(graph, neigh, target, visited)) {
                    return true;
                }
            }
        }
        return false; // no path found
    }
}