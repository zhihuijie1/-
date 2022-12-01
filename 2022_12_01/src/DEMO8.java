import java.util.Arrays;

/**
 * 归并排序的非递归实现
 */
public class DEMO8 {
    public static void mergeSort(int[] array) {
        int gap = 1; //gap:一组有几个数字
        while(gap < array.length) {
            int i = 0;
            while(i < array.length) {
                int left = i; //i不会越界但是mid与right可能会越界
                int mid = left+gap-1;
                if(mid >= array.length) { // 越界了就调整一下
                    mid = array.length -1;
                }
                int right = mid + gap;
                if(right >= array.length) { // 越界了就调整一下
                    right = array.length - 1;
                }
                combine(array,left,mid,right);
                i = i + gap * 2;
            }
            gap = gap * 2;
        }
    }

    public static void combine(int[] array, int left, int mid, int right) {
        int[] arr = new int[right - left +1];
        int L = left;
        int R = mid+1;
        int k = 0;
        while(L <= mid && R <= right) {
            if(array[L] < array[R]) {
                arr[k] = array[L];
                k++;
                L++;
            }else {
                arr[k] = array[R];
                k++;
                R++;
            }
        }
        while(L <= mid) {
            arr[k] = array[L];
            k++;
            L++;
        }
        while(R <= right) {
            arr[k] = array[R];
            R++;
            k++;
        }
        for (int i = left; i <= right; i++) {
            array[i] = arr[i-left];
        }
    }
    // 对数器
    public static void main(String[] args) {
        int testTime = 10000; // 测试的次数
        int MaxValue = 100; // 随机生成数的取值范围是[-100,100]
        int MaxLength = 5; // 随机产生的数组的长度 [0, 200]
        for (int i = 0; i < testTime; i++) {
            int ArrayLength = (int)(Math.random() * MaxLength + 1); // 随机产生的数组的长度[1,200]
            int[] arr = new int[ArrayLength];
            for (int j = 0; j < ArrayLength; j++) {
                int value = (int)(Math.random() * MaxValue + 1) - (int)(Math.random() * MaxValue + 1); // 随机生成数的取值范围是[-100,100]
                arr[j] = value;
            }
            int[] arr2 = Arrays.copyOf(arr,arr.length);
            mergeSort(arr);
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
