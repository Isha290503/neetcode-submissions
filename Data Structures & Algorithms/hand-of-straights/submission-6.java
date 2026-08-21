class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int h:hand){
            mpp.put(h,mpp.getOrDefault(h,0)+1);
        }
        Arrays.sort(hand);
        for(int i=0;i<hand.length;i++){
            if(mpp.get(hand[i])==0) continue;
            int count=1;
            mpp.put(hand[i],mpp.get(hand[i])-1);
            int cur=hand[i];
            while(count<groupSize){
                if(!mpp.containsKey(cur+1) || mpp.get(cur+1)==0) return false;
                mpp.put(cur+1,mpp.get(cur+1)-1);
                cur=cur+1;
                count++;
            }
        }
        for(int val:mpp.values()){
            if(val!=0) return false;
        }
        return true;
    }
}
