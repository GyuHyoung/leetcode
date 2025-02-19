class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            if(!union(edge[0], edge[1])) return edge;
        }

        return edges[n - 1];
    }

    public int find(int node) {
        if(node == parent[node]) return node;

        parent[node] = find(parent[node]);

        return parent[node];
    }

    public boolean union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);

        if(p1 == p2) return false;

        if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;


    }
}