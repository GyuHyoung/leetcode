// 0,1,0,0,0,0
// 0,1,0,1,1,0
// 0,1,1,0,1,0
// 0,0,0,0,1,0
// 1,1,1,1,1,0
// 1,1,1,1,1,0

class Solution {
    int n;
    int m;
    int[][] visited; 
    public boolean isValid(int i, int j, int[][] grid) {
        if(i < 0 || j < 0 || i == n || j == m || visited[i][j] == 1) return false;
        if(grid[i][j] != 0) return false;

        return true;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;
        int cnt = 0;

        while(!queue.isEmpty()) {
            int num = queue.size();
            for(int idx = 0; idx < num; idx++) {
                int[] pos = queue.poll();
                int i = pos[0];
                int j = pos[1];
                grid[i][j] = cnt+1;
                if(i == n-1 && j == m-1) {return grid[i][j];}
                
                if(isValid(i+1, j+1, grid)) {
                    queue.add(new int[]{i+1, j+1});
                    visited[i+1][j+1] = 1;
                    }
                if(isValid(i, j+1, grid)){ 
                    queue.add(new int[]{i, j+1});
                    visited[i][j+1] = 1;
                }
                if(isValid(i+1, j, grid)) {
                    queue.add(new int[]{i+1, j});
                    visited[i+1][j] = 1;
                }
                if(isValid(i-1, j, grid)){ 
                    queue.add(new int[]{i-1, j});
                    visited[i-1][j] = 1;
                }
                if(isValid(i, j-1, grid)) {
                    queue.add(new int[]{i, j-1});
                    visited[i][j-1] = 1;
                    }
                if(isValid(i-1, j-1, grid)){ 
                    queue.add(new int[]{i-1, j-1});
                    visited[i-1][j-1] = 1;
                }
                if(isValid(i-1, j+1, grid)) {
                    queue.add(new int[]{i-1, j+1});
                    visited[i-1][j+1] = 1;
                }
                if(isValid(i+1, j-1, grid)) {
                    queue.add(new int[]{i+1, j-1});
                    visited[i+1][j-1] = 1;
                }
            }

            cnt++;
        }

        return -1;
    }

}