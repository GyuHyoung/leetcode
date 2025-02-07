class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(int num: nums) {
            int cnt = map.getOrDefault(num, 0);
            map.put(num, cnt+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(entry);
        }

        int[] result = new int[k]; 
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;

    }
}