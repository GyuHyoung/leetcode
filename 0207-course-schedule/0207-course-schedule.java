// 0 -> null
// 1 -> 0
// 2 -> 1, 0

// 0, 1, 2
// 1, 0, 0

class Solution {
    public boolean dfs(Map<Integer, List<Integer>> map, int pre, Set<Integer> visited) {
        boolean ret = true;
        if(map.get(pre).size() == 0) {
            return true;
        }

        if(visited.contains(pre)) return false; 
        
        visited.add(pre);
        List<Integer> list = map.get(pre);
        for(int prer: list) {
            if(!dfs(map, prer, visited)) return false;
        }
        
        visited.remove(pre);
        map.put(pre, new ArrayList<>());
        return true;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] courses: prerequisites) {
            List<Integer> dep = map.get(courses[0]);
            dep.add(courses[1]);
            map.put(courses[0], dep);
        }
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(map, i, visited)) return false;
        }

        return true;
    }
}