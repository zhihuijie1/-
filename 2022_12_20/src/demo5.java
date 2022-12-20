import java.util.Arrays;

public class demo5 {
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
        int mid = L + ((R - L) / 2);
        return process(arr, L, mid) +
        process(arr, mid+1, R) +
        merge(arr,L ,mid, R);
    }

    public static int merge(int[] arr, int L , int mid , int R) {
        int count = 0;
        // 容器
        int windowsR = mid+1;
        // 目前囊括进来的数，是从[M+1, windowR)
        for (int left = L; left <= mid; left++) {
            while(windowsR <= R) {
                if(arr[left] <= 2 * arr[windowsR]) {
                      break;
                }else {
                      windowsR++;
                }
            }
            count += (windowsR-mid-1);
        }

        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= R) {
            if(arr[p1] > arr[p2]) {
                help[i++] = arr[p2++];
            }else {
                help[i++] = arr[p1++];
            }
        }
        while(p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while(p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L+j] = help[j];
        }
        return count;
    }
//---------------------------------------  for test  -----------------------------------------------------------

    public static int comparater(int[] arr) {
        int count = 0;
        // 容器
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            while(j < arr.length) {
                if(arr[j] * 2 < arr[i]) {
                    count++;
                }
                j++;
            }
        }
        return count;
    }

    public static int[] ArrayCopy(int[] array) {
        if(array == null) {
            return null;
        }
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }


    public static int[] createArray(int MMaxArrayLength, int MaxValue) {
        int[] array = new int[(int)((MMaxArrayLength+1) * Math.random())];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)((MaxValue+1) * Math.random()) - (int)((MaxValue+1) * Math.random());
        }
        return array;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 10000;
        int MaxArrayLength = 100;
        int MaxValue = 100;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = createArray(MaxArrayLength, MaxValue);
            int[] arr2 = ArrayCopy(arr1);

            if(reversePairs(arr1) != comparater(arr2)) {
                System.out.println("有问题");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}


/**
 * for (int left = L; left <= mid; left++) {
 *             while(windowsR <= R) {
 *                 if(arr[left] >= 2 * arr[windowsR]) {
 *                     break;
 *                 }else {
 *                     windowsR++;
 *                 }
 *             }
 *             count += (windowsR-mid-1);
 *         }
 */


/**
 * for (int left = L; left <= mid; left++) {
 *             while(windowsR <= R && arr[left] > 2 * arr[windowsR]) {
 *                 windowsR++;
 *             }
 *             count += (windowsR-mid-1);
 *         }
 */













