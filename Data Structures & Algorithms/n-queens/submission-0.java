class Solution {
    List<List<String>> l=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        recurse(0,n,board);
        return l;
    }
    public void recurse(int r,int n,char[][] board){
        if(r==n){
            List<String> temp=new ArrayList<>();
            for(char[] row:board){
                temp.add(new String(row));
            }
            l.add(temp);
            return;
        }
        for(int c=0;c<n;c++){
            if(isSafe(n,r,c,board)){
                board[r][c]='Q';
                recurse(r+1,n,board);
                board[r][c]='.';
            }
        }
    }
    public boolean isSafe(int n,int row,int col,char[][] board){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q') return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}
