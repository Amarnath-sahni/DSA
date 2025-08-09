class Solution {
     static class Node{
        int src;
        int dest;
        public Node(int src, int dest){
            this.src=src;
            this.dest = dest;
        }
    }
    public static boolean Cycle_In_directed_Graph(ArrayList<Node>[] graph, int curr, boolean[] vis, boolean[] rec) {
    vis[curr] = true;
    rec[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
        Node e = graph[curr].get(i);

        if (rec[e.dest]) {
            return true; // cycle found
        } else if (!vis[e.dest]) {
            if (Cycle_In_directed_Graph(graph, e.dest, vis, rec)) {
                return true;
            }
        }
    }

    rec[curr] = false; // remove from recursion stack
    return false;
}

    public boolean canFinish(int numCourses, int[][] prerequisites) {
       // Step 1: Build graph
    ArrayList<Node>[] graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
        graph[i] = new ArrayList<>();
    }
    for (int[] pre : prerequisites) {
        int course = pre[0];
        int prereq = pre[1];
        graph[prereq].add(new Node(prereq, course));
    }

    // Step 2: DFS cycle detection
    boolean[] vis = new boolean[numCourses];
    boolean[] rec = new boolean[numCourses];

    for (int i = 0; i < numCourses; i++) {
        if (!vis[i]) {
            if (Cycle_In_directed_Graph(graph, i, vis, rec)) {
                return false; // cycle detected
            }
        }
    }
    return true; // no cycles → can finish
    }
}