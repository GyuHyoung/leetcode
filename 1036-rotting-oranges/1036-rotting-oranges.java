class Solution {
    int n;
    int m;

    public boolean isValid(int i, int j, int[][] grid) {
        if(i < 0 || j < 0 || i == n || j == m) return false;
        if(grid[i][j] != 1) return false;

        return true;
    }
    
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for(int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                if(isValid(x+1, y, grid)) {
                    grid[x+1][y] = 2;
                    queue.add(new int[]{ x+1, y });
                }
                if(isValid(x-1, y, grid)) {
                    grid[x-1][y] = 2;
                    queue.add(new int[]{ x-1, y });
                }
                if(isValid(x, y+1, grid)) {
                    grid[x][y+1] = 2;
                    queue.add(new int[]{x, y+1});
                }
                if(isValid(x, y-1, grid)) {
                    grid[x][y-1] = 2;
                    queue.add(new int[]{x, y-1});
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return (time-1) == -1 ? 0 : time -1;
    }
}