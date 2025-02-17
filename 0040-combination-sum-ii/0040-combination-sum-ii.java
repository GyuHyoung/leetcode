class Solution {
    List<List<Integer>> result;
    public void dfs(int[] candidates, int idx, int sum, int target, List<Integer> list) {
        if(idx == candidates.length) return;

        if(sum + candidates[idx] == target) {
            list.add(candidates[idx]);
            result.add(new ArrayList(list));
            list.remove(list.size() - 1);
            return;
        }
        if(sum + candidates[idx] > target) return;

        
        list.add(candidates[idx]);
        dfs(candidates, idx+1, sum + candidates[idx], target, list);

        list.remove(list.size() - 1);
        while(idx < candidates.length - 1 && candidates[idx] == candidates[idx+1]) {
            idx++;
        }
                
        dfs(candidates, idx+1, sum, target, list);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        dfs(candidates, 0, 0, target, new ArrayList<>());

        return result;
    }
}