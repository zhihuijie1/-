public class demo3 {
    /**
     * 归并排序的非递归实现方法
     */
    public static void mergeSort2(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int N = array.length;
        int step = 1;
        while(step < N) {
            int left = 0;
            while(left < N) {
                int mid = Math.min(left + step -1 , N - 1);
                int right = Math.min(mid + step , N-1);
                if(mid != right) {
                    merge(array , left , mid , right);
                }else {
                    break;
                }
                left = right + 1;
            }

            if(step  > N / 2) {
                break;
            }
            step <<= 1;
        }
    }
    public static void merge(int[] array, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int left = L;
        int right = mid+1;
        int i = 0;
        while(left <= mid && right <= R) {
            if(array[left] > array[right]) {
                help[i] = array[right];
                i++;
                right++;
            }else {
                help[i] = array[left];
                i++;
                left++;
            }
        }
        while(left <= mid) {
            help[i] = array[left];
            i++;
            left++;
        }
        while(right <= R) {
            help[i] = array[right];
            i++;
            right++;
        }
        int p = L;
        for (int j = 0; j < help.length; j++) {
            array[p] = help[j];
            p++;
        }
    }
}
