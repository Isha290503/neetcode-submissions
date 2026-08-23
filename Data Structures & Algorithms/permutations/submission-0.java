class Solution {
    List<List<Integer>> l=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        recurse(nums,new ArrayList<>());
        return l;
    }
    public void recurse(int[] nums,List<Integer> temp){
        if(temp.size()==nums.length) l.add(new ArrayList<>(temp));
        for(int i=0;i<nums.length;i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                recurse(nums,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
