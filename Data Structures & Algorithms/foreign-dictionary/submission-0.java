class Solution {
    public String foreignDictionary(String[] words) {
      HashMap<Character,Integer> mpp=new HashMap<>();
      List<List<Character>> l=new ArrayList<>();
      Queue<Character> q=new LinkedList<>();
      for(String word:words){
            for(char c:word.toCharArray()){
                mpp.putIfAbsent(c,0);
            }
        }
      for(int i=0;i<26;i++) l.add(new ArrayList<>());
      for(int i=0;i<words.length-1;i++){
        String s1=words[i];
        String s2=words[i+1];
        if(s1.equals(s2)) continue;
        if(s1.length()>s2.length() && isPrefix(s2,s1)) return "";
        int j=0,k=0;
        while(j<s1.length()){
            if(s1.charAt(j)!=s2.charAt(k)) break;
            j++;
            k++;
        }
         if (j < s1.length()) {
            char u = s1.charAt(j);
            char v = s2.charAt(k);
            if (!l.get(u - 'a').contains(v)) {
                l.get(u - 'a').add(v);
                mpp.put(v, mpp.get(v) + 1);
            }
        }
      }
      for(Map.Entry<Character,Integer> entry:mpp.entrySet()){
        if(entry.getValue()==0){
            q.offer(entry.getKey());
        }
      }
      StringBuilder sb=new StringBuilder();
      while(!q.isEmpty()){
        char node=q.poll();
        sb.append(node);
        for(char c:l.get(node-'a')){
            mpp.put(c,mpp.get(c)-1);
            if(mpp.get(c)==0){
                q.offer(c);
            }
        }
      }
      if(sb.length()!=mpp.size()) return "";
      return sb.toString();
    }
    public boolean isPrefix(String b,String a){
        return a.startsWith(b);
    }
}
