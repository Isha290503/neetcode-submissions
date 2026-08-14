class Solution {
    List<int[]> part=new ArrayList<>();
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        int prev=0;
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i));
            part.add(new int[]{prev,prev+strs.get(i).length()});
            prev=prev+strs.get(i).length();
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> l=new ArrayList<>();
        for(int i=0;i<part.size();i++){
            int left=part.get(i)[0];
            int right=part.get(i)[1];
            l.add(str.substring(left,right));
        }
        return l;
    }
}
