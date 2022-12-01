import java.util.Arrays;

/**
 * 快速排序 挖坑法
 */
public class demo3 {
    public static void QuickSort(int[] array) {
        QuickSortHoare(array,0, array.length-1);
    }
    public static void QuickSortHoare(int[] array,int L,int R) {
        // 递归的结束条件
        if(R <= L) {
            return;
        }
        int key = array[L];
        int left = L;
        int right = R;
        // 确保key左边的都小于等于key，右边的都大于等于key
        while(left < right) {
            while (left < right && array[right] >= key) { // 注意这里的等号要加 否则陷入死循环
                right--;
            }
            swap(array,left,right);
            while(left < right && array[left] <= key) {
                left++;
            }
            swap(array,left,right);
        }
        array[left] = key;
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
