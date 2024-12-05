class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] array = new List[nums.length + 1];
        int[] ans = new int[k];
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        map.forEach((num, freq) -> {
            if(array[freq] == null) {
                array[freq] = new ArrayList<>();
            }
            array[freq].add(num);
        });

        int j = 0;
        for(int i = nums.length; i >= 0; i--) {
            if(j == k) break;
            if(array[i] != null) {
                List<Integer> l = array[i];
                for(int n = 0; n < l.size(); n++) {
                    ans[j] = l.get(n);
                    j++;
                }
            }
        }

        return ans;
    }
}