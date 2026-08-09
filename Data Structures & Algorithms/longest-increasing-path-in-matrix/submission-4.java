class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public int longestIncreasingPath(int[][] matrix) {
        int ans=0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans=Math.max(ans,recurse(matrix,i,j,dp));
            }
        }
        return ans;
    }
    public int recurse(int[][] mat,int r,int c,int[][] dp){
        if(dp[r][c]!=-1) return dp[r][c];
        int res=1;
        for(int k=0;k<4;k++){
            int nr = r + dx[k];
            int nc = c + dy[k];

            if(nr >= 0 && nc >= 0 &&
               nr < mat.length && nc < mat[0].length &&
               mat[nr][nc] > mat[r][c]) {

                res = Math.max(
                    res,
                    1 + recurse(mat, nr, nc,dp)
                );
        }
        }
        return dp[r][c]=res;
    }
}
