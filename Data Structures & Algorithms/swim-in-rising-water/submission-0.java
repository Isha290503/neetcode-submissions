class Solution {
    public int swimInWater(int[][] grid) {
        int[] dx={0,0,1,-1};
        int[] dy={-1,1,0,0};
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        q.offer(new int[]{0,0,grid[0][0]});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0];
            int c=cur[1];
            int t=cur[2];
            if(vis[r][c]) continue;
            vis[r][c]=true;
            if(r==m-1 && c==n-1) return t;
            for(int k=0;k<4;k++){
                int nr=r+dx[k];
                int nc=c+dy[k];
                if(nr<0 || nc<0 || nr>=m || nc>=n || vis[nr][nc]) continue;
                q.offer(new int[]{nr,nc,Math.max(t,grid[nr][nc])});
            }
        }
        return -1;
    }
}
