class Solution {
    List<List<Integer>> l=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        recurse(0,nums,target,new ArrayList<>(),0);
        return l;
    }
    public void recurse(int i,int[] nums,int target,List<Integer> temp,int sum){
        if(i==nums.length){
            if(sum==target && !l.contains(temp)) l.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target) return;
        temp.add(nums[i]);
        recurse(i,nums,target,temp,sum+nums[i]);
        recurse(i+1,nums,target,temp,sum+nums[i]);
        temp.remove(temp.size()-1);
        recurse(i+1,nums,target,temp,sum);
    }
}
