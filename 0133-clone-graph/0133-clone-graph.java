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
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        if(node == null) return null;
        map.put(node, new Node(node.val)); // 1 [1]
        queue.add(node); // 1

        while(!queue.isEmpty()) {
            Node currNode = queue.poll(); // 1
            Node copyNode = map.get(currNode); // [1]
            List<Node> neighbors = currNode.neighbors; // 2, 4
            for(Node nei: neighbors) {
                if(map.get(nei) == null) {
                    map.put(nei, new Node(nei.val));
                    queue.add(nei);
                }
                Node copyNei = map.get(nei); //[2]
                copyNode.neighbors.add(copyNei); // [1. [2]]
                map.put(nei, copyNei); //2 [2]
            }
        }

        return map.get(node);
    }
}