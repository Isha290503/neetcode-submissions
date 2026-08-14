class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
            if(mpp.get(nums[i])>1) return true;
        }
        return false;
    }
}