class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length();
        int n=s2.length();
        if(m+n!=s3.length()) return false;
        int[][]dp=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return recurse(s1,s2,s3,0,0,dp)==1;
    }
    public int recurse(String s1, String s2, String s3,int i,int j,int[][] dp){
        if(i==s1.length() && j==s2.length()) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int k=i+j;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            if(recurse(s1,s2,s3,i+1,j,dp)==1){
                
                return dp[i][j]=1;
            }
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            if(recurse(s1,s2,s3,i,j+1,dp)==1){
                
                return dp[i][j]=1;
            }
        }
        
        return dp[i][j]=0;
    }
}
