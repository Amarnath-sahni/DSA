class Solution {
    static class Node{
        int src;
        int dest;
        public Node(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

   public static boolean dfs(ArrayList<Node>[] graph1, int curr, boolean[] vis, boolean[] rec, PriorityQueue<Integer> pq) {
        vis[curr] = true;
        rec[curr] = true;

        for (Node e : graph1[curr]) {
            if (!vis[e.dest]) {
                if (dfs(graph1, e.dest, vis, rec, pq)) {
                    return true;  // cycle detected in recursion
                }
            } else if (rec[e.dest]) {
                // Back edge found, cycle detected
                return true;
            }
        }

        rec[curr] = false;   // Remove from recursion stack
        pq.add(curr);        // This node is safe, add to priority queue
        return false;        // No cycle detected from this node
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap to store safe nodes in ascending order

        // Build graph as adjacency list of Node objects
        ArrayList<Node>[] graph1 = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph1[i] = new ArrayList<>();
        }

        // Convert input adjacency list (int[][]) to graph1 representation
        for (int src = 0; src < n; src++) {
            for (int dest : graph[src]) {
                graph1[src].add(new Node(src, dest));
            }
        }

        boolean[] vis = new boolean[n];
        boolean[] rec = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph1, i, vis, rec, pq);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        return ans;
    }
}