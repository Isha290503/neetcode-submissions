class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rem=target-nums[i];
            if(mpp.containsKey(rem)) return new int[]{mpp.get(rem),i};
            mpp.put(nums[i],i);
        }
        return new int[]{};
    }
}
