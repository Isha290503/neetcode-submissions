class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k=s1.length();
        char[] c1=s1.toCharArray();
        Arrays.sort(c1);
        String temp=Arrays.toString(c1);
        int left=0;
        while(left<=s2.length()-k){
            char[] c2=s2.substring(left,left+k).toCharArray();
            Arrays.sort(c2);
            String cur=Arrays.toString(c2);
            if(cur.equals(temp)) return true;
            left++;
        }
        return false;
    }
}
