class Solution {
    static class Node {
        int dest, price;
        public Node(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }
    }

    static class Pair {
        int city, cost, stops;
        public Pair(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build graph
        ArrayList<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] f : flights) {
            graph[f[0]].add(new Node(f[1], f[2])); 
        }

        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;


        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0, 0));//src, cost, stops

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (curr.stops > k) continue; 

            for (int i = 0; i < graph[curr.city].size(); i++) { //curr.city == src
                 Node nei = graph[curr.city].get(i);
                int newCost = curr.cost + nei.price; //neighbour cost srcCosr + nei.cost == dest


                 if (newCost < dist[nei.dest]) {  // new cost or previous cost then update 
                       dist[nei.dest] = newCost;
                        q.add(new Pair(nei.dest, newCost, curr.stops + 1)); //e.dest , newCost, stop+1
                   }
           }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}