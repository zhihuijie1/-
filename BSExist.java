package Novice_class;

public class BSExist {

    // arr保证有序，在arr数组中寻找num，二分查找
    public static boolean find(int[] arr, int num) {
        if(arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] == num) {
                return true;
            }else if(arr[mid] < num) {
                L = mid +1;
            }else {
                R = mid - 1;
            }
        }
        return false;
    }

    // 有序数组中找到>=num最左的位置
    // 1 2 2 3 4 5 6 7  数组
    // 0 1 2 3 4 5 6 7 下标
    // num == 2  return 1
    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if(arr == null || arr.length == 1) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        // ans:是用来计数的，用来记录>=num的位置
        int ans = -1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return ans;
    }

    // 有序数组中找到<=num最右的位置
    // 1 2 2 3 4 5 6 7  数组
    // 0 1 2 3 4 5 6 7 下标
    // num <= 2  return 2
    public static int nearestIndex(int[] arr, int value) {
        if(arr == null || arr.length == 1) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        // ans:是用来计数的，用来记录>=num的位置
        int t = -1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] <= value) {
                t = mid;
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return t;
    }


    // arr 相邻的数不相等！ 返回一个局部最小的下标
    public static int oneMinIndex(int[] arr) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        if(arr.length == 1) {
            return 0;
        }
        int L = 0;
        int R = arr.length - 1;
        if(arr[L] < arr[L + 1]) {
            return L;
        }
        if(arr[R] < arr[R - 1]) {
            return R;
        }
        while(L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if(arr[mid] > arr[mid - 1]) {
                R = mid - 1;
                continue;
            }
            if(arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            }

        }
        return -1;
    }

    // arr 相邻的数不相等！ 返回一个局部最小的下标
    public static int oneMinIndex2(int[] arr) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        if(arr.length == 1) {
            return 0;
        }
        int L = 0;
        int R = arr.length - 1;
        if(arr[L] < arr[L + 1]) {
            return L;
        }
        if(arr[R] < arr[R - 1]) {
            return R;
        }
        while(L < R-1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if(arr[mid] > arr[mid - 1]) {
                R = mid - 1;
                continue;
            }
            if(arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            }
        }
        return arr[L] < arr[R] ? L : R;
    }


    // 生成随机数组，且相邻数不相等
    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    // 也用于测试
    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = getLessIndex(arr);
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");
    }

    public static int oneMinIndex3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N == 1) {
            return 0;
        }
        //到这，arr的长度是大于等于2的
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = N - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            //中间位置是否是最小，[mid-1] > [mid] < [mid+1]
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                ans = mid;
                break;

                //不同时小，下面两个判断选一个就行
            } else if (arr[mid] > arr[mid - 1]) {
                R = mid;
            } else {//arr[mid] > arr[mid + 1]
                L = mid;
            }
        }
        return ans;
    }



    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

















