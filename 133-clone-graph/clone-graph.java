/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;

        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node>q = new LinkedList<>();
        visited.put(node, new Node(node.val, new ArrayList<>())); //store deep node parallel
        q.add(node);

        while(!q.isEmpty()){
            Node t = q.remove();

            for(Node n : t.neighbors){
                if(!visited.containsKey(n)){  // if neighbour not exist then add as deep copy of neeighbor
                    visited.put(n, new Node(n.val, new ArrayList<>()));
                    q.add(n);
                   
                }
                visited.get(t).neighbors.add(visited.get(n)); //currNode.add(neighbour);
            }

        }
        return visited.get(node);
    }
}