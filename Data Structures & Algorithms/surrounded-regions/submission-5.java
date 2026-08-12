class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                board[i][0]='E';
                q.offer(new int[]{i,0});
            }
            if(board[i][n-1]=='O'){
                board[i][n-1]='E';
                q.offer(new int[]{i,n-1});
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                board[0][j]='E';
                q.offer(new int[]{0,j});
            }
            if(board[m-1][j]=='O'){
                board[m-1][j]='E';
                q.offer(new int[]{m-1,j});
            }
        }
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0];
            int c=cur[1];
            for(int k=0;k<4;k++){
                int nr=r+dx[k];
                int nc=c+dy[k];
                if(nr<0 || nc<0 || nr>=m || nc>=n || board[nr][nc]!='O') continue;
                board[nr][nc]='E';
                q.offer(new int[]{nr,nc});
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='E') board[i][j]='O';
            }
        }
    }
}
