class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int jump=nums[0];
        for(int i=1;i<nums.length;i++){
            if(i>jump) return false;
            jump=Math.max(jump,nums[i]+i);
            if(jump>=nums.length-1) return true;
        }
        return false;
    }
}
