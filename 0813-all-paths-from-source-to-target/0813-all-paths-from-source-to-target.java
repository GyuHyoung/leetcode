class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int lastIndex = graph.length - 1;
        Queue<List<Integer>> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        // put a node to a queue
        List<Integer> list = new ArrayList<>();
        list.add(0);
        queue.add(list);
        
        // poll from the queue, find the next node
        while(!queue.isEmpty()) {
            List<Integer> subList = queue.poll(); // [0]
            int currIndex = subList.get(subList.size() - 1); // 0
            
            int[] nextIndexArr = graph[currIndex]; // [1, 2]
            for(int nextIndex: nextIndexArr) {
                List<Integer> currList = new ArrayList<>(subList);
                currList.add(nextIndex);
                if(nextIndex == lastIndex) {
                    result.add(currList);
                } else {
                    queue.add(currList);
                }
            }
        }
        // queue: 0 -> [0,1],[0,2] -> [0,1,3], [0,2,3] -> [] 
        return result; 
    }
}