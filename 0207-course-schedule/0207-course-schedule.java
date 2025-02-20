// 0 -> 10
// 3 -> 18
// 5
class Solution {
    public boolean dfs(Map<Integer, List<Integer>> map, int course, Set<Integer> visiting) {
        if(map.get(course).size() == 0) return true;
        if(visiting.contains(course)) return false;

        visiting.add(course);
        List<Integer> depList = map.get(course);
        for(int dep: depList) {
            if(!dfs(map, dep, visiting)) {
                return false;
            }
        }
        map.put(course, new ArrayList<>());

        visiting.remove(course);
        return true;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int n = 0; n < numCourses; n++) {
            map.put(n, new ArrayList<>());
        }
        for(int[] req : prerequisites) {
            map.get(req[0]).add(req[1]);
        }

        boolean canFinish = true;
        for(int i = 0; i < numCourses; i++) {
            if(map.get(i).size() > 0) {
                if(!dfs(map, i, new HashSet<>())) 
                    return false;
            }
        }
        return true;
    }
}