class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++) Arrays.fill(dp[i],-1);
        if(prices.length==1) return 0;
        return recurse(prices,0,1,dp);
    }
    public int recurse(int[] prices,int i,int state,int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][state]!=-1) return dp[i][state];
        if(state==1){
        int buyStock = recurse(prices, i + 1, 0,dp) - prices[i];
        int skip = recurse(prices, i + 1, 1,dp);
        return dp[i][state]=Math.max(buyStock, skip);
        }else{
            int sellStock = prices[i] + recurse(prices, i + 2, 1,dp);
            int skip = recurse(prices, i + 1, 0,dp);
            return dp[i][state]=Math.max(sellStock, skip);
        }
    }
}
