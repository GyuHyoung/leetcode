class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Integer> set = new HashSet<>();
        pq.add(new int[]{0, 0}); // distance, index;

        int result = 0;
        while(set.size() < n){
            int[] curr = pq.poll();
            int currIdx = curr[1];
            int currDis = curr[0];
            if(set.contains(currIdx)) continue;
            result += currDis;
            set.add(currIdx);

            for(int i = 0; i < n; i++) {
                if(set.contains(i)) continue;
                int dis = Math.abs(points[i][0] - points[currIdx][0]) + Math.abs(points[i][1] - points[currIdx][1]);
                pq.add(new int[]{dis, i});
            }

        }

        return result;
        
    }
}