class Solution {
    int total=0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int n:nums) sum+=n;
        total=sum;
        int[][] dp=new int[nums.length][2*sum+1];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],-1);
        return recurse(nums,target,0,sum,dp);
    }
    public int recurse(int[] nums,int target,int i,int sum,int[][] dp){
        if (i == nums.length)
            return sum == target ? 1 : 0;
        if(dp[i][total-sum]!=-1) return dp[i][total-sum];
        int take=0,notake=0;
        take+=recurse(nums,target,i+1,sum-2*nums[i],dp);
        notake+=recurse(nums,target,i+1,sum,dp);
        return dp[i][total-sum]=take+notake;
    }
}
