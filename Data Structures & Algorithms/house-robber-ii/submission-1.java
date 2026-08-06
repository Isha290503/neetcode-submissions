class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(solve(nums,0,n-2),solve(nums,1,n-1));
    }
    public int solve(int[] nums,int i,int j){
        int n=j-i+1;
        int[] dp=new int[n];
        dp[0]=nums[i];
        if(n==1) return nums[i];
        dp[1]=Math.max(nums[i],nums[i+1]);
        for(int k=i+2;k<=j;k++){
            dp[k-i]=Math.max(dp[k-i-1],dp[k-i-2]+nums[k]);
        }
        return dp[n-1];
    }
}
