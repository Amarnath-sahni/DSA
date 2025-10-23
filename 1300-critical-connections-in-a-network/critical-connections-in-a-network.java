class Solution {
    static int time =0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int dt[] = new int[n];
        int low[] = new int[n];

        boolean vis[] = new boolean[n];
        List<List<Integer>>ans = new ArrayList<>();

        //make graph
        List<Integer>graph[] = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=0; i<n; i++){
            dfs(graph, n, i , dt,  low, vis, -1, ans);
        }

        return ans;
    }

    private static void dfs(List<Integer>graph[],int n, int curr, int[] dt,int[] low, boolean[] vis, int par, List<List<Integer>> ans){
        vis[curr] = true;
        dt[curr] = low[curr] = time++;
        
        for(int dest : graph[curr]){
            //case 1
           
            if(par == dest){
                continue;
            }
            if(!vis[dest]){
                dfs(graph,n, dest, dt,  low, vis, curr, ans);
                low[curr] = Math.min(low[curr], low[dest]);
                if(dt[curr] < low[dest]){
                   ans.add(Arrays.asList(curr, dest));
                }

            }else{
                 low[curr] = Math.min(low[curr], dt[dest]);
            }

        }
    }
}