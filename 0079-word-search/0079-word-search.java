// A B C E
// S F E S
// A D E E

class Solution {
    int n;
    int m;

    public boolean dfs(char[][] board, int i, int j, char[] charArr, int idx, int[][] visited) {
        if(idx == charArr.length) return true;
      
        if(i < 0 || i == n || j < 0 || j == m) return false;
        if(visited[i][j] == 1) return false;

        boolean result = false;
        if(board[i][j] == charArr[idx]) {
            visited[i][j] = 1;
            // System.out.println(i+ " " + j + " " + board[i][j]);
            result = result || dfs(board, i+1, j, charArr, idx+1, visited);
            result = result || dfs(board, i-1, j, charArr, idx+1, visited);
            result = result || dfs(board, i, j+1, charArr, idx+1, visited);
            result = result || dfs(board, i, j-1, charArr, idx+1, visited);
        }
        visited[i][j] = 0;
        return result;
    }

    public boolean exist(char[][] board, String word) {
        char[] charArr = word.toCharArray();
        n = board.length;
        m = board[0].length;

        // visit if character matches
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == charArr[0]) {
                    int[][] visited = new int[n][m];
                    visited[i][j] = 1;
                    // System.out.println(i+ " " + j);
                    boolean result = false;
                    result = result || dfs(board, i+1, j, charArr, 1, visited);
                    result = result || dfs(board, i-1, j, charArr, 1, visited);
                    result = result || dfs(board, i, j+1, charArr, 1, visited);
                    result = result || dfs(board, i, j-1, charArr, 1, visited);

                    if(result == true) return true;
                }
            }
        } 

        return false;     
    }
}