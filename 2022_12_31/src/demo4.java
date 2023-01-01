public class demo4 {
    /**
     * 给定一个数组arr，求数组小和
     *  转化成右侧有几个比它大的
     */
    public static int arrayMinSum(int[] array) {
        if(array == null || array.length < 2) {
            return 0;
        }
        return sort(array, 0, array.length-1);
    }

    /**
     * 利用归并排序来比较，进而求数组的小和
     */
    public static int sort(int[] array, int L, int R) {
        if(L == R) {
            return 0;
        }
        int mid = L + (R - L) / 2;
        return sort(array, L, mid) +
        sort(array, mid+1, R) +
        merge(array, L, mid, R);
    }

    /**
     * merge：合并两个有序的数组
     */
    public static int merge(int[] array, int L , int mid, int R) {
        int[] help = new int[R - L + 1];
        int left = L;
        int right = mid+1;
        int i = 0; // 创建三个指针
        int count = 0; // 记录数组的小和
        while(left <= mid && right <= R) {
            if(array[left] < array[right]) {
                count += (R - right + 1) * array[left]; // 体现出有序的方便性
                help[i++] = array[left++];
            }else {
                help[i++] = array[right++];
            }
        }
        while(right <= R) {
            help[i++] = array[right++];
        }
        while(left <= mid) {
            help[i++] = array[left++];
        }
        for (int j = 0; j < help.length; j++) {
            array[L+j] = help[j];
        }
        return count;
    }


    /**
     * 改一下这个merge
     */
    public static int merge2(int[] array, int L , int mid, int R) {

        int left = L;
        int right = mid+1;
        int count = 0; // 记录数组的小和
        while() {
            
        }
        int[] help = new int[R - L + 1];
        int i = 0; // 创建三个指针
        while(left <= mid && right <= R) {
            if(array[left] < array[right]) {
                help[i++] = array[left++];
            }else {
                help[i++] = array[right++];
            }
        }
        while(right <= R) {
            help[i++] = array[right++];
        }
        while(left <= mid) {
            help[i++] = array[left++];
        }
        for (int j = 0; j < help.length; j++) {
            array[L+j] = help[j];
        }
        return count;
    }








    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
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
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (arrayMinSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}























