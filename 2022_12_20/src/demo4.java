public class demo4 {
    /**
     * 在一个数组中，任何一个前面的数a，和任何一个后面的数b，如果(a,b)是降序的，就称为降序对
     * 给定一个数组arr，求数组的降序对总数量
     */
    // 问题转化成右面有几个数比当前的数小。
    public static int reverPairNumber(int[] arr) {
        if(arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length-1);
    }

    public static int process(int[] arr, int L , int R) {
        if(L == R) {
            return 0;
        }
        int mid = L + (R - L) / 2;
        return process(arr, L, mid) +
        process(arr, mid+1, R) +
        merge(arr, L, mid, R);
    }

    public static  int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R- L + 1];
        int left = L;
        int right = mid+1;
        int i = 0;
        int count = 0;
        while(right <= R && left <= mid) {
            if(arr[left] > arr[right]) {
                count += (mid - left +1);
                help[i++] = arr[right++];
            }else {
                help[i++] = arr[left++];
            }
        }
        while(right <= R) {
            help[i++] = arr[right++];
        }
        while(left <= mid) {
            help[i++] = arr[left++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L+j] = help[j];
        }
        return count;
    }

    // for test
    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
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
            if (reverPairNumber(arr1) != comparator(arr2)) {
                System.out.println("Oops!");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }

}










