class Solution {
    public boolean dfs(int course, Map<Integer, List<Integer>> map, Set<Integer> visiting, List<Integer> order, Set<Integer> added) {
        if(visiting.contains(course)) return false;
        if(added.contains(course)) return true;

        List<Integer> depList = map.get(course);
        visiting.add(course);

        for(int dep: depList) {
            if(!dfs(dep, map, visiting, order, added)) return false;
        }

        visiting.remove(course);
        order.add(course);
        added.add(course);
        return true;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] req: prerequisites) {
            map.get(req[0]).add(req[1]);
        }
        List<Integer> order = new ArrayList<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> added = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, map, visiting, order, added)) return new int[]{};
            
        }
        
        int[] result = new int[order.size()];
        for(int i = 0; i < order.size(); i++) {
            result[i] = order.get(i);
        } 

        return result;
    }
}