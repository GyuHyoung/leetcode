class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if(!union(node1, node2)) {
                return edge;
            }
        } 

        return new int[]{-1, -1};
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 == p2) return false;

        if(rank[p1] < rank[p2]) {
            parent[p2] = parent[p1];
            rank[p2] += rank[p1];
        } else {
            parent[p1] = parent[p2];
            rank[p1] += rank[p2];
        }
        return true;

    }

    public int find(int n) {
        if(n != parent[n]) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }
}