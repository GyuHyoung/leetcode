class Entry {
    int node;
    int weight;

    Entry(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Entry>> map = new HashMap<>();
        for(int[] time : times) {
            int source = time[0];
            List<Entry> childList = map.getOrDefault(source, new ArrayList<>());
            childList.add(new Entry(time[1], time[2]));
            map.put(source, childList);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0 ,k});
        int time = 0;

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            if(set.contains(node[1])) continue;
            set.add(node[1]);
            time = node[0];
            List<Entry> list = map.get(node[1]);
            if(list == null) continue;
            for(Entry entry: list) {
                pq.add(new int[]{node[0] + entry.weight, entry.node});
            }
        }
        
        if(set.size() == n) return time;

        return -1;
    }
}