class Solution {
    int[] par;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        par = new int[n+1];
        rank = new int[n+1];

        for(int i=1; i<=n; i++){
            par[i] = i;
            rank[i] =0;
        }


      for(int[] e : edges){
        int u = e[0];
        int v = e[1];

        if(find(u) == find(v)){
            return e;
        }else{
             union(u, v);
        }
      }

      return new int[0];
    }

    public int find(int x) {
        if (par[x] != x) {
            par[x] = find(par[x]); // path compression
        }
        return par[x];
    }

    // Union by rank
    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return; // already connected

        if (rank[pa] < rank[pb]) {
            par[pa] = pb;
        } else if (rank[pb] < rank[pa]) {
            par[pb] = pa;
        } else {
            par[pb] = pa;
            rank[pa]++;
        }
    }
}