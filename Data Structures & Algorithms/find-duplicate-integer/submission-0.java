class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int n:nums){
            mpp.put(n,mpp.getOrDefault(n,0)+1);
            if(mpp.get(n)>1) return n;
        }
        return -1;
    }
}
