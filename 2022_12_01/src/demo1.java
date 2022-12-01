import java.util.Arrays;

/**
 * 冒泡排序
 * 基本思想：两个相邻的数进行比较，较大的往后推，直到将最大的放在尾部，
 * 下一次比较的次数就会少一次
 * 以此往复，直到比较的次数等于1.
 */
public class demo1 {
    /*
    * 最外面的循环是比较的趟数
    * 里面的循环是一趟中比较的次数
    * */
    public static void bubbleSort(int[] array) {
        int count = 0; // 比较的次数
        while(count < array.length-1) { // 比较的趟数
            Boolean flag = true;
            for (int i = 0; i < array.length-1-count; i++) { // 一趟中比较的次数
                if(array[i] > array[i+1]) {
                    swap(array,i,i+1);
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
            count++;
        }
    }
    public static void swap(int[] array, int i,int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i]^ array[j];
    }


    // 对数器
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
            bubbleSort(arr);
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
