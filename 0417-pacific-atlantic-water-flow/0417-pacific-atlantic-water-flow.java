class Solution {
    int m;
    int n;

    private void searchOcean(int[][] heights, int i, int j, int[][] ocean, int prevHeight) {
        if(i == -1 || i == n || j == -1 || j == m) return;
        if(ocean[i][j] == 1) return;

        if(heights[i][j] >= prevHeight) {
            ocean[i][j] = 1;
            searchOcean(heights, i+1, j, ocean, heights[i][j]);
            searchOcean(heights, i-1, j, ocean, heights[i][j]);
            searchOcean(heights, i, j+1, ocean, heights[i][j]);
            searchOcean(heights, i, j-1, ocean, heights[i][j]);
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int height = heights[i][j];
                if(i == 0) {
                    pacific[i][j] = 1;
                    searchOcean(heights, i+1, j, pacific, height);
                }
                if(j == 0) {
                    pacific[i][j] = 1;
                    searchOcean(heights, i, j+1, pacific, height);
                }
                if(i == n - 1) {
                    atlantic[i][j] = 1;
                    searchOcean(heights, i-1, j, atlantic, height);
                }
                if(j == m - 1){
                    atlantic[i][j] = 1;
                    searchOcean(heights, i, j-1, atlantic, height);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1)
                    result.add(List.of(i, j));
            }
        }

        return result;
        
    }
}