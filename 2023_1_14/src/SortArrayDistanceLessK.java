import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 已知一个几乎有序的数组。几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离一定不超过k
 * k相对于数组长度来说是比较小的。请选择一个合适的排序策略，对这个数组进行排序。
 */
public class SortArrayDistanceLessK {
    public static void sortedArrDistanceLessK(int[] arr, int k) {
        for (int i = 0; i < arr.length-1; i++) {
            int j = i;
            int scope = j + k  < arr.length ? j + k  : arr.length - 1;
            int[] help = new int[scope - j + 1];
            int h = 0;
            while(j <= scope) {
                help[h] = arr[j];
                createHeap(help, h); // 建立起一个小根堆
                j++;
                h++;
            }
            for (int l = 0; l < help.length; l++) {
                arr[i+l] = help[l];
            }
        }
    }
    // 建一个小根堆 / 向上调整
    public static void createHeap(int[] arr, int index) {
        int father = (index - 1) / 2;
        while(arr[index] < arr[father]) {
            swap(arr, index, father);
            index = father;
            father = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int index, int father) {
        arr[index] = arr[index] ^ arr[father];
        arr[father] = arr[index] ^ arr[father];
        arr[index] = arr[index] ^ arr[father];
    }


    public static void sort(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length-1; i++) {
            int j = i;
            int scope = j + k < arr.length ? j + k : arr.length - 1;
            while(j <= scope) {
                priorityQueue.add(arr[j]);
                j++;
            }
            j = i;
            while(j <= scope) {
                arr[j] = priorityQueue.poll();
                j++;
            }
        }
    }

    // for test
    public static void comparator(int[] arr, int k) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] randomArrayNoMoveMoreK(int maxSize, int maxValue, int K) {
        int[] arr = new int[(int) ((maxSize + 30) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        // 先排个序
        Arrays.sort(arr);
        // 然后开始随意交换，但是保证每个数距离不超过K
        // swap[i] == true, 表示i位置已经参与过交换
        // swap[i] == false, 表示i位置没有参与过交换
        boolean[] isSwap = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = Math.min(i + (int) (Math.random() * (K + 1)), arr.length - 1);
            if (!isSwap[i] && !isSwap[j]) {
                isSwap[i] = true;
                isSwap[j] = true;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
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
        System.out.println("test begin");
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int k = (int) (Math.random() * maxSize) + 1;
            int[] arr = randomArrayNoMoveMoreK(maxSize, maxValue, k);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            sortedArrDistanceLessK(arr1, k);
            comparator(arr2, k);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println("K : " + k);
                printArray(arr);
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }


}
