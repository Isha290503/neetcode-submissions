class Solution {
    int m;
    int n;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    boolean[][] vis;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        m = heights.length;
        n = heights[0].length;

        List<List<Integer>> l = new ArrayList<>();

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                // Pacific
                if(i == 0 || j == 0) {
                    pacific[i][j] = true;
                }
                else {
                    vis = new boolean[m][n];
                    pacific[i][j] = p(heights, i, j);
                }

                // Atlantic
                if(i == m-1 || j == n-1) {
                    atlantic[i][j] = true;
                }
                else {
                    vis = new boolean[m][n];
                    atlantic[i][j] = a(heights, i, j);
                }

                if(pacific[i][j] && atlantic[i][j]) {
                    l.add(Arrays.asList(i, j));
                }
            }
        }

        return l;
    }

    public boolean p(int[][] grid, int i, int j) {

        if(i == 0 || j == 0)
            return true;

        if(vis[i][j])
            return false;

        vis[i][j] = true;

        for(int k = 0; k < 4; k++) {

            int nr = i + dx[k];
            int nc = j + dy[k];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n)
                continue;

            if(grid[nr][nc] <= grid[i][j]) {

                if(p(grid, nr, nc))
                    return true;
            }
        }

        return false;
    }

    public boolean a(int[][] grid, int i, int j) {

        if(i == m-1 || j == n-1)
            return true;

        if(vis[i][j])
            return false;

        vis[i][j] = true;

        for(int k = 0; k < 4; k++) {

            int nr = i + dx[k];
            int nc = j + dy[k];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n)
                continue;

            if(grid[nr][nc] <= grid[i][j]) {

                if(a(grid, nr, nc))
                    return true;
            }
        }

        return false;
    }
}