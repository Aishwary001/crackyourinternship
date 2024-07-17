// https://leetcode.com/u/aishwarylifeline/
class Solution {
    public static int count;

    public static void Conquer(int nums[], int start, int mid, int end) {
        int index = 0;
        int merge[] = new int[end - start + 1];
        int idx1 = start;
        int idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            if (nums[idx1] <= nums[idx2]) {
                merge[index] = nums[idx1];
                index++;
                idx1++;
            } else {
                merge[index] = nums[idx2];
                index++;
                idx2++;
            }
        }
        while (idx1 <= mid) {
            merge[index] = nums[idx1];
            index++;
            idx1++;
        }
        while (idx2 <= end) {
            merge[index] = nums[idx2];
            index++;
            idx2++;
        }

        // Copy the merged array back to nums
        System.arraycopy(merge, 0, nums, start, merge.length);
    }

    public static void countM(int nums[], int start, int mid, int end) {
        int right = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (right <= end && nums[i] > 2L * nums[right]) {
                right++;
            }
            count += right - (mid + 1);
        }
    }

    public static void merge(int nums[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge(nums, start, mid);
            merge(nums, mid + 1, end);
            countM(nums, start, mid, end);
            Conquer(nums, start, mid, end);
        }
    }

    public int reversePairs(int[] nums) {
        merge(nums, 0, nums.length - 1);
        int result = count;
        count = 0; // Reset count for subsequent calls
        return result;
    }
}

