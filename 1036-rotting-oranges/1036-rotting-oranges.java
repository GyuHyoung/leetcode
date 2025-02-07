class Solution {
    int n;
    int m;
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) queue.add(new int[] {i, j});
            }
        }

        int cnt = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for(int s = 0; s < size; s++) {
                int[] pos = queue.poll();
                int i = pos[0];
                int j = pos[1];
                if(isValid(grid, i-1, j)) {
                    queue.add(new int[]{i-1, j});
                    grid[i-1][j] = 2;
                }
                if(isValid(grid, i+1, j)){ 
                    queue.add(new int[]{i+1, j});
                    grid[i+1][j] = 2;
                }
                if(isValid(grid, i, j-1)) {
                    queue.add(new int[]{i, j-1});
                    grid[i][j-1] = 2;
                }
                if(isValid(grid, i, j+1)) {
                    queue.add(new int[]{i, j+1});
                    grid[i][j+1] = 2;
                }
            } 
            
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        if(cnt == 0) return 0;
        return cnt -1;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        if(i < 0 || i == n || j < 0 || j == m) return false;

        if(grid[i][j] == 1) return true;
        
        return false;
    } 
}