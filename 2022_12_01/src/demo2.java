import java.util.Arrays;

public class demo2 {
    /**
     * Hoare版快速排序
     * 设定数组中第一个数是key，即我们的标准
     * 然后设定了两个指针，左指针找到大于key的数，右指针找到小于key的数，然后交换，重复以上步骤，直到左右指针相遇这时再与key
     * 值交换。
     * 再往后递归
     */
    public static void QuickSort(int[] array) {
        QuickSortHoare(array,0,array.length-1);
    }

    public static void QuickSortHoare(int[] array,int L,int R) {
        // 递归的结束条件
        if(R <= L) {
            return;
        }
        int key = L;
        int left = L;
        int right = R;
        // 确保key左边的都小于等于key，右边的都大于等于key
        while(left < right) {
            while (left < right && array[right] >= array[key]) { // 注意这里的等号要加 否则陷入死循环
                right--;
            }
            while(left < right && array[left] <= array[key]) {
                left++;
            }
            swap(array,left,right);
        }
        swap(array,key,left);
        QuickSortHoare(array,0,left-1);
        QuickSortHoare(array,left+1,R);
    }

    public static void swap(int[] array, int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 对数器
    public static void main(String[] args) {
        int testTime = 10000; // 测试的次数
        int MaxValue = 100; // 随机生成数的取值范围是[-100,100]
        int MaxLength = 30; // 随机产生的数组的长度 [0, 200]
        for (int i = 0; i < testTime; i++) {
            int ArrayLength = (int)(Math.random() * MaxLength + 1); // 随机产生的数组的长度[1,200]
            int[] arr = new int[ArrayLength];
            for (int j = 0; j < ArrayLength; j++) {
                int value = (int)(Math.random() * MaxValue + 1) - (int)(Math.random() * MaxValue + 1); // 随机生成数的取值范围是[-100,100]
                arr[j] = value;
            }
            int[] arr2 = Arrays.copyOf(arr,arr.length);
            QuickSort(arr);
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
