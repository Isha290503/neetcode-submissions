class Solution {
    int m;
    int n;
    boolean ans=false;
    int[] dx={0,0,1,-1};
    int[] dy={1,-1,0,0};
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int r = 0; r < m; r++){
            for(int c = 0; c <n; c++){
                recurse(board,r,c,word,new StringBuilder(), vis);
            }
        }
        return ans;
    }
    public void recurse(char[][] board,int r,int c,String word,StringBuilder sb,boolean[][] vis){
        if(sb.length()==word.length()){
            if(sb.toString().equals(word)) ans=true;
            return;
        }
        if(r<0 || r>=m || c>=n || c<0 || vis[r][c]){
            return;
        }
        sb.append(board[r][c]);
        vis[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+dx[i];
            int nc=c+dy[i];
            recurse(board,nr,nc,word,sb,vis);
        }
        sb.deleteCharAt(sb.length()-1);
        vis[r][c]=false;
    }
}
