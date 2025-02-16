class Entry {
    int distance;
    int[] point;

    Entry(int distance, int[] point) {
        this.distance = distance;
        this.point = point;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        for(int[] point : points) {
            int x = point[0];
            int y = point[1];
            pq.add(new Entry((x * x + y * y), point));
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] point = pq.poll().point;
            result[i][0] = point[0];
            result[i][1] = point[1];
        }

        return result;
    }
}