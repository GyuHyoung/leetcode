class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        // -1  0  0  1  

        for(int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            if(i != 0 && nums[i] == nums[i-1]) continue;
            while(l < r) {
                int sum = num + nums[l] + nums[r];
                if(sum == 0) {
                    list.add(List.of(num, nums[l], nums[r]));
                    while(l < nums.length - 1 && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                    r--;
                    
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return list;
    }
}