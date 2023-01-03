public class demo7 {
    /**
     * 在一个数组中，对于任何一个数num，求有多少个(后面的数*2)依然<num，返回总个数
     * 比如：[3,1,7,0,2]
     * 3的后面有：1，0
     * 1的后面有：0
     * 7的后面有：0，2
     * 0的后面没有
     * 2的后面没有
     * 所以总共有5个
     */
    public static int reversePairs(int[] arr) {
        if(arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length-1);
    }

    public static int process(int[] arr, int L, int R) {
        if(L == R) {
            return 0;
        }
        int mid = L + (R - L) >> 2;
        return process(arr, L , mid) +
                process(arr, mid +1, R)+
                merge(arr, L , mid , R);
    }

    public static int merge(int[] arr , int L, int mid, int R) {
        int right = mid+1;
        int left = L;
        int count = 0;
        while(left <= mid) {
            while(right <= R && arr[right] * 2 < arr[left]) {
                right++;
            }
            count += (right - mid - 1);
            left++;
        }
        int[] help = new int[R - L + 1];
        right = mid + 1;
        left = L;
        int i = 0;
        while(left <= mid && right <= R) {
            if(arr[left] > arr[right]){
                help[i++] = arr[right++];
            }else {
                help[i++] = arr[left++];
            }
        }
        while(left <= mid) {
            help[i++] = arr[left++];
        }
        while(right <= R) {
            help[i++] = arr[right++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[j+L] = help[j];
        }
        return count;
    }
}
