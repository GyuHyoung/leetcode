class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void dfs(int[] nums, int i, List<Integer> list) {
        if(i == nums.length) {
            result.add(list);
            return;
        }
    
        list.add(nums[i]);
        dfs(nums, i+1, new ArrayList(list));
        list.remove(list.size() - 1);
        while(i < nums.length - 1 && nums[i] == nums[i+1] ) {
            i++;
        }
        dfs(nums, i+1, new ArrayList(list));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());

        return result;
    }
}