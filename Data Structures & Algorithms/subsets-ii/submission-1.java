class Solution {
    List<List<Integer>> l=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recurse(0,nums,new ArrayList<>());
        return l;
    }
    public void recurse(int start,int[] nums,List<Integer> temp){
        l.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            recurse(i+1,nums,temp);
            temp.remove(temp.size()-1);
        }
    }
}
