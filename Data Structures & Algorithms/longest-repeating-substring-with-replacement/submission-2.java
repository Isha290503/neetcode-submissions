class Solution {
    public int characterReplacement(String s, int k) {
        int res=0;
        int i=0;
            Map<Character,Integer> mpp=new HashMap<>();
            int maxf=0;
            for(int j=0;j<s.length();j++){
                mpp.put(s.charAt(j),mpp.getOrDefault(s.charAt(j),0)+1);
                maxf=Math.max(maxf,mpp.get(s.charAt(j)));
                while((j-i+1)-maxf>k){
                    mpp.put(s.charAt(i),mpp.get(s.charAt(i))-1);
                    i++;
                }
                res=Math.max(res,j-i+1);
            }
        return res;
    }
}
