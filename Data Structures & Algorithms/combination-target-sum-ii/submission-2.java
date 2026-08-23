class Solution {
    List<List<Integer>> l=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recurse(0,candidates,target,new ArrayList<>(),0);
        return l;
    }
    public void recurse(int start,int[] nums,int target,List<Integer> temp,int sum){
        if(sum==target && !l.contains(temp)) l.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            if(target<sum+nums[i]) break;
            temp.add(nums[i]);
            recurse(i+1,nums,target,temp,sum+nums[i]);
            temp.remove(temp.size()-1);
        }
    }
}
