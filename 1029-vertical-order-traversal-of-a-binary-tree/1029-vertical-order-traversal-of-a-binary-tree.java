/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Map<Integer, List<Integer>>> map;
    int minColumn = 10000;
    
    public void dfs(TreeNode currNode, int column, int row) {
        if(currNode == null) return;
        
        minColumn = Math.min(minColumn, column);

        Map<Integer, List<Integer>> rowMap = map.getOrDefault(column, new HashMap());

        List<Integer> list = rowMap.getOrDefault(row, new ArrayList<>());
        
        list.add(currNode.val);
        rowMap.put(row, list);
        
        map.put(column, rowMap);

        dfs(currNode.left, column - 1, row+1);
        dfs(currNode.right, column + 1, row+1);

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>(); // {column idx -> {rowIdx -> list of node}}
        dfs(root, 0, 0);
        // System.out.println(map);

        int size = map.keySet().size();
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            result.add(new ArrayList<>());
        }


        for(Map.Entry<Integer, Map<Integer, List<Integer>>> entry: map.entrySet()) {
            int columnIdx = entry.getKey() - minColumn;
            Map<Integer, List<Integer>> entryMap = entry.getValue();
            TreeMap<Integer, List<Integer>> valueMap = new TreeMap(entryMap);

            List<Integer> rowList = new ArrayList<>();
    
            // 0 -> 2, 2 -> 6, 5
            // 0 -> 3, 2 -> 2, 2
            //       X
            //   X      X
            // X           X

            for(Map.Entry<Integer, List<Integer>> valueEntry: valueMap.entrySet()) {
                List<Integer> valueList = valueEntry.getValue();

                Collections.sort(valueList);
                rowList.addAll(valueList);
            }       
            result.get(columnIdx).addAll(rowList);     

        }

        return result;

        
    }
}