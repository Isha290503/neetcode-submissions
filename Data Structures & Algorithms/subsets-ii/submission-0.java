class Solution {
    List<List<Integer>> l=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recurse(0,nums,new ArrayList<>());
        return l;
    }
    public void recurse(int i,int[] nums,List<Integer> temp){
        if(i==nums.length){
            if(!l.contains(temp)) l.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        recurse(i+1,nums,temp);
        temp.remove(temp.size()-1);
        recurse(i+1,nums,temp);
    }
}
