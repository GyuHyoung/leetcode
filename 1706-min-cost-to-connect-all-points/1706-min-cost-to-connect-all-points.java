class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, 0}); // distance, point idx
        int cost = 0;
        while(set.size() < n) {
            int[] currPos = pq.poll();
            
            if(set.contains(currPos[1])) continue;
            
            cost += currPos[0];            
            set.add(currPos[1]);
            
            int[] point = points[currPos[1]];
            
            for(int i = 0; i < n; i++) {
                if(set.contains(i)) continue;
                int distance = Math.abs(points[i][0] - point[0]) + Math.abs(points[i][1] - point[1]);
                pq.add(new int[] {distance, i});
            }
        }

        return cost;
        
    }
}