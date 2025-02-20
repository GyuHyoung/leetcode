// [[1]]
// 2
// [[2, 1], [1, 2]]
// [2, 1]
class Solution {
    public void dfs(int idx, int[] nums, Queue<List<Integer>> queue) {
        if(idx == nums.length -1) {
            queue.add(Arrays.asList(nums[idx]));
            return;
        }
                dfs(idx+1, nums, queue);
        int n = queue.size();
        for(int nn= 0; nn < n; nn++) {
            List<Integer> perm = queue.poll();
            int num = nums[idx];
            int size = perm.size();
            for(int i = 0; i <= size; i++) {
                List<Integer> subList = new ArrayList(perm);
                subList.add(i, num);
                queue.add(subList);
            }
        }


    }
    public List<List<Integer>> permute(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        dfs(0, nums, queue);

        return (List)queue;
    }
}