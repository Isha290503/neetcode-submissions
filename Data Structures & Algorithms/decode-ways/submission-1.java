class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return recurse(s,0,dp);
    }
    public int recurse(String s,int i,int[] dp){
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int res=recurse(s,i+1,dp);
        if(i<s.length()-1){   
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                res+=recurse(s,i+2,dp);
            }}
        return dp[i]=res;
    }
}
