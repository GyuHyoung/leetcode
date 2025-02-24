// 0 0 0 
// 1 1 0
// 1 1 1

class Solution {
    int n;

    public boolean isValid(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == n || j == n) {
            return false;
        }
        if(grid[i][j] != 0) return false;
        return true;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        n = grid.length;
        if(grid[n-1][n-1] == 1) return -1;
        int path = 0;
        int[] dirX = new int[] {0, 0, 1, -1, 1, -1, 1, -1};
        int[] dirY = new int[] {1, -1, 0, 0, 1, -1, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] currPos = queue.poll();
                int x = currPos[0];
                int y = currPos[1];
                if(x == n - 1 && y == n - 1) return grid[x][y] + 1;
                for(int dir = 0; dir < 8; dir++) {
                    if(isValid(grid, x + dirX[dir], y + dirY[dir])) {
                        queue.add(new int[]{x + dirX[dir], y + dirY[dir]});
                        grid[x + dirX[dir]][y + dirY[dir]] = grid[x][y] + 1;
                    }
                }

            }

        }

        return -1;

    }
}