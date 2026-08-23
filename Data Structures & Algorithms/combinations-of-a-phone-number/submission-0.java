class Solution {
    String[] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        recurse(0,digits,new StringBuilder());
        return res;
    }
    public void recurse(int i,String digits,StringBuilder sb){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }
        String s=arr[digits.charAt(i)-'0'];
        for(char c:s.toCharArray()){
            sb.append(c);
            recurse(i+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
