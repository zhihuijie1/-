public class demo1 {
    public static void mergeSort(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        sort(array, 0, array.length-1);
        // 范围给传过去，最后直接传回一个排好序的数组
    }

    public static void sort(int[] array, int L, int R) {
        if(L == R) {
            return;
        }
        // 递归的截止条件
        int mid = L + ((R - L) / 2);
        sort(array, L, mid); // 注意：范围是【L，mid】而不是【L，mid-1】
        sort(array, mid+1, R);
        // 到这里都分成单个的了
        merge(array, L, mid, R);
        // 进行一个整合,穿的参数都是一些指定两个数组的范围
    }

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


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            mergesort2(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }


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
            gap *= 2;
        }
    }

    // 递归方法实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // 请把arr[L..R]排有序
    // l...r N
    // T(N) = 2 * T(N / 2) + O(N)
    // O(N * logN)
    public static void process(int[] arr, int L, int R) {
        if (L == R) { // base case
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
}
