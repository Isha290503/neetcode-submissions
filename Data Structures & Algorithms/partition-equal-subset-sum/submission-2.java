class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            for(int j=target;j>=nums[i];j--){
                if(dp[j]) continue;
                if(dp[j-nums[i]]) dp[j]=true;
                if(dp[target]) return true;
            }
        }
        return dp[target];
    }
}
