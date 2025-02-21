class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> queue = new LinkedList<>();

        for(char task: tasks) {
            count[task - 'A']++;
        }
        for(int i : count) {
            if(i > 0) pq.add(i);
        }

        int time = 0;
        while(!pq.isEmpty()) {
            int currTask = pq.poll();
            time++;
            if(currTask > 1) queue.add(new int[]{currTask-1, time + n});

            if(!queue.isEmpty() && queue.peek()[1] == time) {
                // add max heap;
                int[] idle = queue.poll();
                pq.add(idle[0]);
            }
            if(pq.isEmpty() && !queue.isEmpty()) {
                int[] idle = queue.poll();
                pq.add(idle[0]);
                time = idle[1];

            }

        }

        return time;
    }
}