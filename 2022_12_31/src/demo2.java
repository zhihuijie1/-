public class demo2 {
    // 非递归实现归并排序
    public static void mergesort2(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int gap = 1;
        while(gap < array.length) {
            int left = 0;
            while(left < array.length) {
                int mid = left + gap - 1;
                if(mid >= array.length) {
                    mid = array.length-1;
                }
                // 确定好mid
                int right = mid + gap;
                if(right >= array.length) {
                    right = array.length-1;
                }
                // 确定好right
                if(right != mid) {
                    merge(array,left,mid,right);
                }else {
                    break;
                }
                left = right + 1;
            }
            if(gap > array.length/2) {
                break;
            }
            // 防溢出设计，也让排序排好就停
            gap *= 2;
        }
    }


    // merge：将指定范围内的数组合并成一个有序数组
    public static void merge(int[] array, int L, int mid, int R) {
        int[] help = new int[R - L + 1]; // 创建一个临时数组
        int left = L;
        int right = mid+1;
        int i = 0;
        // 创建三个指针
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
        // help临时数组中的数据都是有序的了
        int p = L;
        for (int j = 0; j < help.length; j++) {
            array[p] = help[j];
            p++;
        }
    }
}
