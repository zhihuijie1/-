import java.util.Arrays;

public class demo3 {
    /**
     * 希尔排序
     */
    public static void shellSort(int[] array) {
        /*
        * 对数据进行分组
        * */
        int gap = array.length / 2;
        while(gap > 1) {
            insertSort(array,gap);
            gap = gap / 2;
        }
        insertSort(array,1);
    }
    public static void insertSort(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int j = i - gap;
            while(j >= 0 && arr[j] > arr[j+1]) {
                swap(arr,j,j+1);
                j = j - gap;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    public static void main(String[] args) {
        int testTime = 100000; // 测试的次数
        int MaxValue = 100; // 随机生成数的取值范围是[-100,100]
        int MaxLength = 200; // 随机产生的数组的长度 [0, 200]
        for (int i = 0; i < testTime; i++) {
            int ArrayLength = (int)(Math.random() * MaxLength + 1); // 随机产生的数组的长度[1,200]
            int[] arr = new int[ArrayLength];
            for (int j = 0; j < ArrayLength; j++) {
                int value = (int)(Math.random() * MaxValue + 1) - (int)(Math.random() * MaxValue + 1); // 随机生成数的取值范围是[-100,100]
                arr[j] = value;
            }
            int[] arr2 = Arrays.copyOf(arr,arr.length);
            shellSort(arr);
            Arrays.sort(arr2);
            if(!Arrays.equals(arr,arr2)) {
                System.out.println("数据有误");
                break;
            }
        }
        System.out.println("测试成功");
    }
}
