class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mpp=new HashMap<>();
        for(String s:strs){
            int[] count=new int[26];
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }
            String cur=Arrays.toString(count);
            mpp.putIfAbsent(cur,new ArrayList<>());
            mpp.get(cur).add(s);
        }
        return new ArrayList<>(mpp.values());
    }
}
