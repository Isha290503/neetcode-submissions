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
        int prev1=nums[i];
        if(n==1) return nums[i];
        int prev=Math.max(nums[i],nums[i+1]);
        for(int k=i+2;k<=j;k++){
            int temp=prev1;
            prev1=prev;
            prev=Math.max(prev,temp+nums[k]);
        }
        return prev;
    }
}
