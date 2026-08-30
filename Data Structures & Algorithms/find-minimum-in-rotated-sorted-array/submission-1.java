class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int res = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            // Entire range is sorted
            if(nums[low] <= nums[high]) {
                res = Math.min(res, nums[low]);
                break;
            }

            // Left half is sorted
            if(nums[low] <= nums[mid]) {
                res = Math.min(res, nums[low]);
                low = mid + 1;
            }

            // Right half is sorted
            else {
                res = Math.min(res, nums[mid]);
                high = mid - 1;
            }
        }

        return res;
    }
}