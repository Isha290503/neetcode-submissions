class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums) set.add(n);
        int maxi=0;
        for(int n:nums){
            if(!set.contains(n-1)){
                int length=1;
                while(set.contains(n+length)){
                    length++;
                }
                maxi=Math.max(length,maxi);
            }
        }
        return maxi;
    }
}
