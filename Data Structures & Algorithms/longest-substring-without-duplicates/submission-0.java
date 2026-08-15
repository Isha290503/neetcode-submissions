class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mpp=new HashMap<>();
        int left=0,maxi=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            mpp.put(c,mpp.getOrDefault(c,0)+1);
            if(mpp.get(c)>1){
                while(mpp.get(c)>1){
                    mpp.put(s.charAt(left),mpp.get(s.charAt(left))-1);
                    left++;
                }
            }
            maxi=Math.max(maxi,i-left+1);
        }
        return maxi;
    }
}
