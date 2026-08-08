class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return recurse(word1,word2,0,0,dp);
    }
    public int recurse(String s,String s1,int i,int j,int[][] dp){
        if(i==s.length()) return s1.length()-j;
        if(j==s1.length()) return s.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s1.charAt(j)){
            return recurse(s, s1, i + 1, j + 1,dp);
        }
        return dp[i][j]=Math.min(recurse(s,s1,i,j+1,dp),
        Math.min(recurse(s,s1,i+1,j+1,dp),recurse(s,s1,i+1,j,dp)))+1;
    }
}
