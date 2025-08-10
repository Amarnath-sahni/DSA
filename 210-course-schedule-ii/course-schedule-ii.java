class Solution {
     static class Node{
        int src;
        int dest;
        public Node(int src, int dest){
            this.src=src;
            this.dest = dest;
        }
    }

public static boolean Cycle_In_directed_Graph(ArrayList<Node> graph[], int curr, boolean vis[], boolean rec[], Stack<Integer>stack){
    vis[curr] = true;
    rec[curr] = true;

    for(int i=0; i<graph[curr].size(); i++){
        Node e = graph[curr].get(i);

        if(!vis[e.dest]){
           if(Cycle_In_directed_Graph(graph, e.dest, vis, rec, stack)){
            return true;
           }
        }else if(rec[e.dest]){ //cycle is detected
            return true;
           }  
    }
    rec[curr] = false;
    stack.push(curr);
    return false;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Node> graph[] = new ArrayList[numCourses];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            int src = pre[0];
            int dest = pre[1];
            graph[dest].add(new Node(dest, src));
        }

        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(Cycle_In_directed_Graph(graph, i, vis, rec , stack)){
                    return new int[0];
                }
            }
        }
        int[] ans = new int[numCourses];
       int idx =0;
       while(!stack.isEmpty()){
        ans[idx++] = stack.pop();
       }
       return ans;
      
    }
}