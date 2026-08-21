class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0;
        int remaining=0;
        int ind=0;
        for(int i=0;i<gas.length;i++){
            int diff=gas[i]-cost[i];
            total+=diff;
            remaining+=diff;
            if(remaining<0){
                remaining=0;
                ind=i+1;
            }
        }
        if(total<0) return -1;
        return ind;
    }
}
