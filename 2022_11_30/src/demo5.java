import java.sql.DataTruncation;
import java.util.Arrays;

public class demo5 {
    /**
     * 堆排序
     */
    public static void heapSort(int[] array) {
        // 创建一个大根堆
        createHeap(array);
        // 交换
        int index = array.length - 1;
        while(index > 0) {
            swap(array,0,index);
            shiftDown(array, 0, index);
            index--;
        }
    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    public static void createHeap(int[] array) {
        int end = array.length;
        int child = (end - 1) / 2;
        while(child >= 0) {
            shiftDown(array, child, end);
            child--;
        }
    }
    public static void shiftDown(int[] array,int parent ,int end) {
        int child = parent * 2 + 1; // 要是有节点一定有左节点

        while(child < end) {
            if(child + 1 < end) {
                child = array[child] > array[child+1] ? child : child + 1;
            }
            if(array[child] > array[parent]) {
                swap(array,child,parent);
            }else {

            }
            parent = child; // parent一定要去交换的child上面
            child = parent * 2 + 1;
        }
    }
    public static void main(String[] args) {
        int testTime = 10000; // 测试的次数
        int MaxValue = 100; // 随机生成数的取值范围是[-100,100]
        int MaxLength = 500; // 随机产生的数组的长度 [0, 200]
        for (int i = 0; i < testTime; i++) {
            int ArrayLength = (int)(Math.random() * MaxLength + 1); // 随机产生的数组的长度[1,200]
            int[] arr = new int[ArrayLength];
            for (int j = 0; j < ArrayLength; j++) {
                int value = (int)(Math.random() * MaxValue + 1) - (int)(Math.random() * MaxValue + 1); // 随机生成数的取值范围是[-100,100]
                arr[j] = value;
            }
            int[] arr2 = Arrays.copyOf(arr,arr.length);
            heapSort(arr);
            Arrays.sort(arr2);
            if(!Arrays.equals(arr,arr2)) {
                System.out.println("数据有误");
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println("测试成功");
    }
}




















