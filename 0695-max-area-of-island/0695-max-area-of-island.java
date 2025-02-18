class Solution {
    int n;
    int m;
    public int dfs(int[][] grid, int i, int j) {
        int area = 1;
        if(i < 0 || j < 0 || i == n || j == m) {
            return 0;
        }
        if(grid[i][j] == 0) return 0;

        grid[i][j] = 0;

        area += dfs(grid, i+1, j);
        area += dfs(grid, i-1, j);
        area += dfs(grid, i, j+1);
        area += dfs(grid, i, j-1);

        return area;
    }

    public boolean isValid(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == n || j == m) {
            return false;
        }
        if(grid[i][j] == 0) return false;

        return true;
    }

    public int bfs(int[][] grid, int currI, int currJ) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {currI, currJ});
        int area = 1;
        grid[currI][currJ] = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int idx = 0; idx < size; idx++) {
                int[] pos = queue.poll();
                int i = pos[0];
                int j = pos[1];
                if(isValid(grid, i+1, j)) {
                    area++;
                    queue.add(new int[] {i+1, j});
                    grid[i+1][j] = 0;
                }
                if(isValid(grid, i-1, j)) {
                    area++;
                    queue.add(new int[] {i-1, j});
                    grid[i-1][j] = 0;
                }
                if(isValid(grid, i, j+1)) {
                    area++;
                    queue.add(new int[] {i, j+1});
                    grid[i][j+1] = 0;
                }
                if(isValid(grid, i, j-1)) {
                    area++;
                    queue.add(new int[] {i, j-1});
                    grid[i][j-1] = 0;
                }
            }
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }
}