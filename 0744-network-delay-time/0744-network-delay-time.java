// 1 -> [2, 1]. [3,4]
// 2 -> [1. 2]. [3.7]
//
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<int[]>> sourceToDest = new HashMap<>();
        for(int[] time: times) {
            List<int[]> dest = sourceToDest.getOrDefault(time[0], new ArrayList<>());
            dest.add(new int[]{time[1], time[2]});  // node, time
            sourceToDest.put(time[0], dest);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        queue.add(new int[]{k, 0});

        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] nodeInfo = queue.poll();
                int node = nodeInfo[0];
                if(set.contains(node)) continue;
                
                set.add(node);
                time = nodeInfo[1];
                
                List<int[]> destList = sourceToDest.get(node);
                if(destList == null) continue;
                for(int[] dest: destList) {
                    queue.add(new int[] {dest[0], dest[1] + nodeInfo[1]});
                }
            }        
        }

        if(set.size() != n) return -1;

        return time;
    }
}