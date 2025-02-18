class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(nums.length == 0) return 0;
        for(int num : nums) {
            set.add(num);
        }
        int maxSeq = 0;
        for(int num : set) {
            if(set.contains(num - 1)) {
                int nextNum = num + 1;
                int seq = 1;
                while(set.contains(nextNum)) {
                    seq++;
                    nextNum++;
                }
                maxSeq = Math.max(seq, maxSeq);
            }
        }

        return maxSeq+1;
    }
}