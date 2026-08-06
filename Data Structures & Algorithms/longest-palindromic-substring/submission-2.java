class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String[][] dp=new String[n][n];
        return recurse(s,0,s.length()-1,dp);
    }
    public String recurse(String s,int i,int j,String[][] dp){
        if(i>j) return "";
        if(dp[i][j]!=null) return dp[i][j];
        if(isPalindrome(s,i,j)){
            return dp[i][j]=s.substring(i,j+1);
        }
        String s1=recurse(s,i+1,j,dp);
        String s2=recurse(s,i,j-1,dp);
        if(s1.length()>=s2.length()) return dp[i][j]=s1;
        return dp[i][j]=s2;
    }
    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
