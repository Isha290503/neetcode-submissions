class Solution {
    List<List<String>> l=new ArrayList<>();
    public List<List<String>> partition(String s) {
        recurse(0,s,new ArrayList<>());
        return l;
    }
    public void recurse(int i,String s,List<String> temp){
        if(i>=s.length()){
            l.add(new ArrayList<>(temp));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s,i,j)){
                temp.add(s.substring(i,j+1));
                recurse(j+1,s,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
