class Solution {
    int n;
    int m;
    private void findRegions(char[][] board, int i, int j, int[][] visited) {
        if(i < 0 || i == n || j < 0 || j == m) {
            return;
        }
        if(visited[i][j] == 1) return;
        if(board[i][j] == 'O') {
            visited[i][j] = 1;
            findRegions(board, i-1, j, visited);    
            findRegions(board, i+1, j, visited);    
            findRegions(board, i, j-1, visited);    
            findRegions(board, i, j+1, visited);    
        }

    }
    public void solve(char[][] board) { 
        n = board.length;
        m = board[0].length;
        int[][] visited = new int[n][m];

        for(int i = 0 ; i < n; i++) {
            if(board[i][0] == 'O') {
                visited[i][0] = 1;
                findRegions(board, i, 1, visited);
            } 
            if(board[i][m - 1] == 'O') {
                visited[i][m-1] = 1;
                findRegions(board, i, m - 2, visited);
            }
        }    

        for(int j = 0 ; j < m; j++) {
            if(board[0][j] == 'O') {
                visited[0][j] = 1;
                findRegions(board, 1, j, visited);
            } 
            if(board[n - 1][j] == 'O') {
                visited[n-1][j] = 1;
                findRegions(board, n - 2, j, visited);
            }
        }    

        // iterate the board and if it's not visited and still 0 convert it to x
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}