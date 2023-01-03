public class demo8 {
    /**
     * 降序对问题：
     * 在一个数组中，任何一个前面的数a，和任何一个后面的数b，如果(a,b)是降序的，就称为降序对
     * 给定一个数组arr，求数组的降序对总数量
     *
     * -> 当前数的右边有几个比当前数小的
     */
    public static int reverPairNumber(int[] arr) {
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

    /*
        merge: left与right指针都指向前面，从前面入手计算的。
     */
    public static int merge(int[] arr, int L, int mid, int R) {
        int right = mid+1;
        int left = L;
        int count = 0;
        while(left <= mid) {
            while(right <= R && arr[left] > arr[right]) {
                right++;
            }
            count += (right - mid -1);
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
