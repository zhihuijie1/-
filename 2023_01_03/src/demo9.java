public class demo9 {
    /**
     * 给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，
     * 值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null) {
            return 0;
        }
        // 创建一个前缀和数组
        int[] presum = new int[nums.length];
        presum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            presum[i] = presum[i-1] + nums[i];
        }
        return process(presum, 0, presum.length-1,lower, upper);
    }

    public static int process(int[] arr, int L, int R, int lower, int upper) {
        if(L == R) {
            return (arr[L] >= lower && arr[L] <= upper) ?  1 :  0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid, lower, upper) +
        process(arr, mid+1, R, lower, upper) +
        merge(arr, L, mid, R, lower, upper);
    }

    public static int merge(int[] arr, int L, int mid, int R, int lower, int upper) {
        int left = L;
        int right = mid + 1;
        int count = 0;
        int windowsL = L;
        int windowsR = L;
        while(right <= R) {
            int min = arr[right] - upper;
            int max = arr[right] - lower;
            while (windowsL <= mid && arr[windowsL] < min) {
                windowsL++;
            }
            while (windowsR <= mid && arr[windowsR] <= max) {
                windowsR++;
            }
            count += (windowsR - windowsL);
            right++;
        }
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return count;
    }

}
